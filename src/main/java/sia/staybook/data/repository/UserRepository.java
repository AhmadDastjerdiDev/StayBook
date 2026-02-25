package sia.staybook.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sia.staybook.data.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    User getByEmail(String Email);

    Optional<User> findByEmail(String email);
}
