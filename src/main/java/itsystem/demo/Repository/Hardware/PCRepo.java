package itsystem.demo.Repository.Hardware;

import itsystem.demo.Model.Hardware.Hardware;
import itsystem.demo.Model.Hardware.PC;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PCRepo extends CrudRepository<PC, Long> {
    List<PC> findByProductuserEquals(String initial);
    List<PC> findByStatusEquals(String status);
}
