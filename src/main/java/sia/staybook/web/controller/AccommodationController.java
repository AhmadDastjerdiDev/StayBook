package sia.staybook.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sia.staybook.dto.AccommodationResponseDto;
import sia.staybook.service.AccommodationService;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accommodations")
public class AccommodationController {

    private final AccommodationService accommodationService;

    @GetMapping
    public Page<AccommodationResponseDto> getAllAccommodations(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC)
            Pageable pageable){
       return accommodationService.getAllAccommodations(pageable);
    }

    @GetMapping("/search")
    public Page<AccommodationResponseDto> searchAccommodation(
            String city,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            Integer capacity,
            Pageable pageable
    ){
        return accommodationService.searchAccommodation(
                city,
                minPrice,
                maxPrice,
                capacity,
                pageable
        );
    }

    @GetMapping("/{id}")
    public AccommodationResponseDto getAccommodationById(@PathVariable Long id){
        return accommodationService.getAccommodationById(id);
    }
}
