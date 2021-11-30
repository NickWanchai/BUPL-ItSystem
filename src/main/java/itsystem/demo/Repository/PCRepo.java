package itsystem.demo.Repository;

import itsystem.demo.Model.PC;
import org.springframework.data.repository.CrudRepository;

public interface PCRepo extends CrudRepository<PC, Long> {
}
