package project.hotels.service;

import project.hotels.model.Worker;

import java.util.List;
import java.util.Optional;

public interface WorkerService {
    Worker save(Worker worker);

    List<Worker> findAllWorkers();

    List<Worker> searchWorker(String workerName);

    Optional<Worker> findById(int workerId);

    void deleteById(int workerId);
}
