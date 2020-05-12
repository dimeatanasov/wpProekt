package project.hotels.repository.implementation;

import org.springframework.stereotype.Repository;
import project.hotels.dataHolder.DataHolder;
import project.hotels.model.Worker;
import project.hotels.repository.WorkerRepository;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class WorkerRepositoryImpl implements WorkerRepository {
    @Override
    public Worker save(Worker worker) {
        this.findById(worker.getWorkerId()).ifPresent(DataHolder.workers::remove);
        DataHolder.workers.add(worker);
        return worker;
    }

    @Override
    public List<Worker> findAll() {
        return new ArrayList<>(DataHolder.workers);

    }

    @Override
    public List<Worker> searchWorker(String workerName) {
        return DataHolder.workers.stream()
                .filter(w -> w.getWorkerName().equals(workerName) || w.getWorkerLastName().equals(workerName))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Worker> findById(int workerId) {
        return DataHolder.workers.stream().filter(w -> w.getWorkerId() == workerId).findFirst();
    }

    @Override
    public void deleteById(int workerId) {
        this.findById(workerId).ifPresent(DataHolder.workers::remove);
    }
}
