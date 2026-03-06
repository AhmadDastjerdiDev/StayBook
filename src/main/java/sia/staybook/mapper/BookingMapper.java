package sia.staybook.mapper;

import sia.staybook.data.entity.Booking;
import sia.staybook.dto.BookingResponseDto;

public class BookingMapper {

    private BookingMapper(){}

    public static BookingResponseDto toDto(Booking b){
        BookingResponseDto dto = new BookingResponseDto();
        dto.setId(b.getId());
        dto.setCheckIn(b.getCheckIn());
        dto.setCheckOut(b.getCheckOut());
        dto.setTotalPrice(b.getTotalPrice());
        dto.setStatus(b.getStatus());
        dto.setGuestId(b.getGuest().getId());
        dto.setAccommodationId(b.getAccommodation().getId());

        return dto;
    }
}
