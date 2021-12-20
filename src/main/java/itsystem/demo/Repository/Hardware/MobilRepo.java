package itsystem.demo.Repository.Hardware;

import itsystem.demo.Model.Hardware.Hardware;
import itsystem.demo.Model.Hardware.Mobil;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MobilRepo extends CrudRepository<Mobil, Long> {
    List<Mobil> findByProductuserEquals(String initial);

}
