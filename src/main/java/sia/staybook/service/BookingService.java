package sia.staybook.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sia.staybook.dto.BookingRequestDto;
import sia.staybook.dto.BookingResponseDto;

public interface BookingService {
    public Page<BookingResponseDto> getBookings(Pageable pageable);

    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto);
}
