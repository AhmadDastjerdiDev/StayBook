package sia.staybook.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sia.staybook.data.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    public Page<Booking> findByGuestEmail(String email, Pageable pageable);

    public Page<Booking> findByAccommodationOwnerEmail(String email, Pageable pageable);
}
