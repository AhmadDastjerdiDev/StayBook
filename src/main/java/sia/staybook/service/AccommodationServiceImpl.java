package sia.staybook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import sia.staybook.data.repository.AccommodationRepository;
import sia.staybook.dto.AccommodationResponseDto;
import sia.staybook.mapper.AccommodationMapper;
import org.springframework.data.domain.Pageable;


import java.math.BigDecimal;
import java.util.List;


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
}
