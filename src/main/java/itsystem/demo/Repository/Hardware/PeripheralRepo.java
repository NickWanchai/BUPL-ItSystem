package itsystem.demo.Repository.Hardware;

import itsystem.demo.Model.Hardware.Hardware;
import itsystem.demo.Model.Hardware.Peripheral;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeripheralRepo extends CrudRepository<Peripheral, Long> {
    List<Peripheral> findByProductuserEquals(String initial);
    List<Peripheral> findByStatusEquals(String status);
}
