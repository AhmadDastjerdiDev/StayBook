package sia.staybook.service;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import sia.staybook.data.entity.Accommodation;
import sia.staybook.dto.AccommodationResponseDto;

import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.util.List;

public interface AccommodationService {
    public Page<AccommodationResponseDto> getAllAccommodations(Pageable pageable);
    public Page<AccommodationResponseDto> searchAccommodation(
            String city,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            Integer capacity,
            Pageable pageable
    );
    public AccommodationResponseDto getAccommodationById(Long id);
}
