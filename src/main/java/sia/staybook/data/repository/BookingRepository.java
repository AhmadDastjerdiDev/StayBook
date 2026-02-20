package sia.staybook.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sia.staybook.data.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
