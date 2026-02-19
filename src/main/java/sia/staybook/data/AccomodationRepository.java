package sia.staybook.data;

import org.springframework.data.jpa.repository.JpaRepository;
import sia.staybook.Accommodation;

public interface AccomodationRepository extends JpaRepository<Accommodation, Long> {
}
