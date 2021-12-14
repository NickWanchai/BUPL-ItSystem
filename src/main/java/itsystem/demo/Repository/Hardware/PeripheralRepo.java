package itsystem.demo.Repository.Hardware;

import itsystem.demo.Model.Hardware.Peripheral;
import org.springframework.data.repository.CrudRepository;

public interface PeripheralRepo extends CrudRepository<Peripheral, Long> {
}
