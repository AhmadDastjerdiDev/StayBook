package sia.staybook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sia.staybook.data.entity.Accommodation;
import sia.staybook.data.entity.Booking;
import sia.staybook.data.entity.User;
import sia.staybook.data.repository.AccommodationRepository;
import sia.staybook.data.repository.BookingRepository;
import sia.staybook.data.repository.UserRepository;
import sia.staybook.dto.BookingRequestDto;
import sia.staybook.dto.BookingResponseDto;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{

    private final UserRepository userRepo;
    private final AccommodationRepository accommodationRepo;
    private final BookingRepository bookingRepo;

    @Override
    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto) {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User guest = userRepo.findByEmail(email).orElseThrow(()->new RuntimeException("Email not found!"));

        Accommodation accommodation = accommodationRepo.findById(bookingRequestDto.getAccommodationId())
                .orElseThrow(()-> new ResourceNotFoundException("Accommodation not found!"));

        if(bookingRequestDto.getCheckIn()==null || bookingRequestDto.getCheckOut()==null){
            throw new RuntimeException("Check-in and check-out are required!");
        }

        if(bookingRequestDto.getCheckIn().compareTo(bookingRequestDto.getCheckOut()) >= 0){
            throw new RuntimeException("Check-out date must be after check-in date");
        }

        long nights = ChronoUnit.DAYS.between(
                 bookingRequestDto.getCheckIn(), bookingRequestDto.getCheckOut());

        BigDecimal totalPrice = accommodation.getPricePerNight().multiply(BigDecimal.valueOf(nights));

        Booking booking = new Booking(
                bookingRequestDto.getCheckIn(),
                bookingRequestDto.getCheckOut(),
                totalPrice,
                Booking.Status.PENDING,
                guest,
                accommodation
        );

        Booking saved = bookingRepo.save(booking);

        return new BookingResponseDto(
                saved.getId(),
                saved.getCheckIn(),
                saved.getCheckOut(),
                saved.getTotalPrice(),
                saved.getStatus(),
                saved.getGuest().getId(),
                saved.getAccommodation().getId()
        );
    }
}
