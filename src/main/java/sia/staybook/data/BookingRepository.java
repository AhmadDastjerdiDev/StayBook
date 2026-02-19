package sia.staybook.data;

import org.springframework.data.jpa.repository.JpaRepository;
import sia.staybook.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
