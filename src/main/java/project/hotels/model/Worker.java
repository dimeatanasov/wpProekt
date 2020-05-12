package project.hotels.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Getter
@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int workerId;
    private String workerName;
    private String workerLastName;
    private int hotelId;
    private int workerShift;

    public Worker(int workerId, String workerName, String workerLastName, int hotelId, int workerShift) {
        this.workerId = workerId;
        this.workerName = workerName;
        this.workerLastName = workerLastName;
        this.hotelId = hotelId;
        this.workerShift = workerShift;
    }

    public Worker() {
    }

    public int getWorkerId() {
        return workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public String getWorkerLastName() {
        return workerLastName;
    }

    public int getHotelId() {
        return hotelId;
    }

    public int getWorkerShift() {
        return workerShift;
    }
}
