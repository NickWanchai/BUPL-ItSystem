package itsystem.demo.Repository.Hardware;

import itsystem.demo.Model.Hardware.PC;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PCRepo extends CrudRepository<PC, Long> {
}
