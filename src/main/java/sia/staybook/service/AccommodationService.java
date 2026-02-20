package sia.staybook.service;

import org.springframework.data.domain.Page;
import sia.staybook.dto.AccommodationResponseDto;

import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.util.List;

public interface AccommodationService {
    public Page<AccommodationResponseDto> getAllAccommodations(Pageable pageable);
    public List<AccommodationResponseDto> searchAccommodation(
            String city,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            Integer capacity,
            Pageable pageable
    );
}
