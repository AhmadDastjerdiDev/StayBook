package sia.staybook.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sia.staybook.dto.AccommodationRequestDto;
import sia.staybook.dto.AccommodationResponseDto;

import java.math.BigDecimal;

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
    public AccommodationResponseDto saveAccommodation(AccommodationRequestDto accRequestDto);//Todo: Must add User to this service after adding security

}
