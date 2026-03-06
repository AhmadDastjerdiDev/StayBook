package sia.staybook.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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


    @GetMapping
    public Page<BookingResponseDto> getBookings(
            @PageableDefault(size = 5, sort = "checkIn", direction = Sort.Direction.DESC)
            Pageable pageable) {
        return bookingService.getBookings(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponseDto createBooking(
            @Valid @RequestBody BookingRequestDto bookingRequestDto) {
        return bookingService.createBooking(bookingRequestDto);
    }
}
