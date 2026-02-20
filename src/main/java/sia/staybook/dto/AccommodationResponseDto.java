package sia.staybook.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccommodationResponseDto {
    private Long id;
    private String title;
    private String city;
    private String description;
    private BigDecimal pricePerNight;
    private int capacity;
    private LocalDateTime createdAt;
}
