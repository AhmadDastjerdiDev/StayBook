package sia.staybook.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sia.staybook.dto.BookingRequestDto;
import sia.staybook.dto.BookingResponseDto;
import sia.staybook.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponseDto createBooking(
            @Valid @RequestBody BookingRequestDto bookingRequestDto){
                return bookingService.createBooking(bookingRequestDto);
    }
}
