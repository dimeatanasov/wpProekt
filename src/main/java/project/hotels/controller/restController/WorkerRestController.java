package project.hotels.controller.restController;

import org.springframework.web.bind.annotation.*;
import project.hotels.model.Worker;
import project.hotels.service.WorkerService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/worker")
public class WorkerRestController {
    private final WorkerService workerService;


    public WorkerRestController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public List<Worker> findAll(){
        return this.workerService.findAllWorkers();
    }

    @GetMapping("/findByName")
    public List<Worker> findByName1 (@RequestParam String workerName){
        return this.workerService.searchWorker(workerName);
    }

    @GetMapping("/{id}")
    public Optional<Worker> findById(@PathVariable int id){
        return this.workerService.findById(id);
    }

    @PostMapping
    public Worker save(@Valid @RequestBody Worker worker){
        return this.workerService.save(worker);
    }

    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable int id){
        this.workerService.deleteById(id);
    }

}
