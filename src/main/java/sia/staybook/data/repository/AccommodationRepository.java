package sia.staybook.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sia.staybook.data.entity.Accommodation;
import sia.staybook.dto.AccommodationResponseDto;

import java.math.BigDecimal;
import java.util.List;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    List<AccommodationResponseDto> findByCity(String city);
    Page<Accommodation> findByCityContainingIgnoreCaseAndPricePerNightBetweenAndCapacityGreaterThanEqual(
            String city,
            BigDecimal min,
            BigDecimal max,
            Integer capacity,
            Pageable pageable
    );
}
