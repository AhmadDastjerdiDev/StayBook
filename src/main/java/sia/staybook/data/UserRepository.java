package sia.staybook.data;

import org.springframework.data.jpa.repository.JpaRepository;
import sia.staybook.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
