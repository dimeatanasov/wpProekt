package project.hotels.service.implementation;

import org.springframework.stereotype.Service;
import project.hotels.model.Worker;
import project.hotels.repository.WorkerRepository;
import project.hotels.service.WorkerService;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerServiceImpl implements WorkerService {

    public final WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public Worker save(Worker worker) {
        return this.workerRepository.save(worker);
    }

    @Override
    public List<Worker> findAllWorkers() {
        return this.workerRepository.findAll();
    }

    @Override
    public List<Worker> searchWorker(String workerName) {
        return this.workerRepository.searchWorker(workerName);
    }

    @Override
    public Optional<Worker> findById(int workerId) {
        return this.workerRepository.findById(workerId);
    }

    @Override
    public void deleteById(int workerId) {
        this.workerRepository.deleteById(workerId);
    }
}
