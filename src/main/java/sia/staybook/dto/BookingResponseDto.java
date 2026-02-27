package sia.staybook.dto;

import lombok.Getter;
import lombok.Setter;
import sia.staybook.data.entity.Accommodation;
import sia.staybook.data.entity.Booking.Status;
import sia.staybook.data.entity.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
public class BookingResponseDto {

    private Long id;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    private BigDecimal totalPrice;

    private Status status;

    private Long guestId;

    private Long accommodationId;


    public BookingResponseDto(Long id, LocalDateTime checkIn, LocalDateTime checkOut, BigDecimal totalPrice, Status status, Long guestId, Long accommodationId) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
        this.status = status;
        this.guestId = guestId;
        this.accommodationId = accommodationId;
    }
}
