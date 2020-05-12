package project.hotels.repository.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hotels.model.Worker;

public interface jpaReservationRepository extends JpaRepository<Worker, String> {
}
