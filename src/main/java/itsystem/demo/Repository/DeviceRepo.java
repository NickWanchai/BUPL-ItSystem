package itsystem.demo.Repository;

import itsystem.demo.Model.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepo extends CrudRepository<Device, Long> {
}
