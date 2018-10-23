package za.co.reverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.domain.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
