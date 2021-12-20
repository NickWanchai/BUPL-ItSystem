package itsystem.demo.Repository.Hardware;

import itsystem.demo.Model.Hardware.Hardware;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HardwareRepo extends CrudRepository<Hardware, Long> {

    List<Hardware> findByProductuserEquals(String initial);

}
