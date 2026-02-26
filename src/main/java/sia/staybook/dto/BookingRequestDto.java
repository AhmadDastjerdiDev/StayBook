package sia.staybook.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class BookingRequestDto {

        private LocalDateTime checkIn;

        private LocalDateTime checkOut;

        private Long accommodationId;

}
