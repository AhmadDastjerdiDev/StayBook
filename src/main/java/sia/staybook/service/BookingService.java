package sia.staybook.service;

import sia.staybook.dto.BookingRequestDto;
import sia.staybook.dto.BookingResponseDto;

public interface BookingService {
    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto);
}
