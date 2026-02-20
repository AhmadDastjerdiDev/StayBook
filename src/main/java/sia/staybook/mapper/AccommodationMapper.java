package sia.staybook.mapper;

import sia.staybook.data.entity.Accommodation;
import sia.staybook.dto.AccommodationResponseDto;

public class AccommodationMapper {

    private AccommodationMapper(){}

    public static AccommodationResponseDto toDto(Accommodation a){
        AccommodationResponseDto dto = new AccommodationResponseDto();
        dto.setId(a.getId());
        dto.setTitle(a.getTitle());
        dto.setCity(a.getCity());
        dto.setDescription(a.getDescription());
        dto.setPricePerNight(a.getPricePerNight());
        dto.setCapacity(a.getCapacity());
        dto.setCreatedAt(a.getCreatedAt());
        return dto;
    }
}
