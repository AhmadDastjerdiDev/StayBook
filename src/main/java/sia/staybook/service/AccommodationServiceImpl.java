package sia.staybook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sia.staybook.data.entity.Accommodation;
import sia.staybook.data.repository.AccommodationRepository;
import sia.staybook.dto.AccommodationResponseDto;
import sia.staybook.mapper.AccommodationMapper;
import org.springframework.data.domain.Pageable;


import javax.net.ssl.HttpsURLConnection;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationService{

    private final AccommodationRepository accommodationRepo;

    @Override
    public Page<AccommodationResponseDto> getAllAccommodations(Pageable pageable) {
        return accommodationRepo.findAll(pageable).map(AccommodationMapper::toDto);
    }

    @Override
    public Page<AccommodationResponseDto> searchAccommodation(
            String city,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            Integer capacity,
            Pageable pageable) {
        return accommodationRepo.findByCityContainingIgnoreCaseAndPricePerNightBetweenAndCapacityGreaterThanEqual(
                city,
                minPrice,
                maxPrice,
                capacity,
                pageable).map(AccommodationMapper::toDto);
    }

    @Override
    public AccommodationResponseDto getAccommodationById(Long id) {
        Accommodation accommodation = accommodationRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Accommodation not found!"));
        return AccommodationMapper.toDto(accommodation);
    }
}
