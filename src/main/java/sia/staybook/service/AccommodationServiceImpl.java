package sia.staybook.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import sia.staybook.data.entity.Accommodation;
import sia.staybook.data.entity.User;
import sia.staybook.data.repository.AccommodationRepository;
import sia.staybook.data.repository.UserRepository;
import sia.staybook.dto.AccommodationRequestDto;
import sia.staybook.dto.AccommodationResponseDto;
import sia.staybook.mapper.AccommodationMapper;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationService{

    private final AccommodationRepository accommodationRepo;
    private final UserRepository userRepo;

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

    @Override
    public AccommodationResponseDto saveAccommodation(AccommodationRequestDto accRequestDto) {
        User owner = userRepo.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found!"));
        Accommodation accommodation = new Accommodation(
                accRequestDto.getTitle(),
                accRequestDto.getCity(),
                accRequestDto.getDescription(),
                accRequestDto.getPricePerNight(),
                accRequestDto.getCapacity(),
                owner
        );
        Accommodation savedAccommodation = accommodationRepo.save(accommodation);

        return AccommodationMapper.toDto(savedAccommodation);
    }


}
