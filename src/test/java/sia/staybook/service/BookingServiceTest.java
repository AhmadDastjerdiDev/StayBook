package sia.staybook.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sia.staybook.data.entity.Accommodation;
import sia.staybook.data.repository.AccommodationRepository;
import sia.staybook.data.repository.BookingRepository;
import sia.staybook.data.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AccommodationRepository accommodationRepo;

    @Mock
    private BookingRepository bookingRepo;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    void shouldCalculateTotalPriceCorrectly(){

        Accommodation accommodation = new Accommodation();
        accommodation.setPricePerNight(BigDecimal.valueOf(200));

        LocalDate checkIn = LocalDate.of(2026, 5, 1);
        LocalDate checkOut = LocalDate.of(2026, 5, 5);

        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);

        BigDecimal expected = accommodation.getPricePerNight().multiply(BigDecimal.valueOf(nights));

        assertEquals(BigDecimal.valueOf(800), expected);

    }
}

