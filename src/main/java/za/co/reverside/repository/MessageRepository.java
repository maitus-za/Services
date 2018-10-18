package za.co.reverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
