package sia.staybook.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sia.staybook.data.entity.Accommodation;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
}
