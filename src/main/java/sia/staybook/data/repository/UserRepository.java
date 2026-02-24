package sia.staybook.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sia.staybook.data.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
