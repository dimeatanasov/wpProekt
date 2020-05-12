package project.hotels.repository;

import project.hotels.model.Worker;

import java.util.List;
import java.util.Optional;

public interface WorkerRepository {
    Worker save(Worker worker);

    List<Worker> findAll();

    List<Worker> searchWorker(String workerName);

    Optional<Worker> findById(int workerId);

    void deleteById(int workerId);
}
