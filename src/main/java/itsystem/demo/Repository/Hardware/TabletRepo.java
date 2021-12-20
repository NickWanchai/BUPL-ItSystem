package itsystem.demo.Repository.Hardware;

import itsystem.demo.Model.Hardware.Hardware;
import itsystem.demo.Model.Hardware.Tablet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TabletRepo extends CrudRepository <Tablet, Long>{
    List<Tablet> findByProductuserEquals(String initial);
}
