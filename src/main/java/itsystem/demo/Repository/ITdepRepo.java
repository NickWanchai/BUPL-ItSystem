package itsystem.demo.Repository;

import itsystem.demo.Model.Employee;
import itsystem.demo.Model.ITdep;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITdepRepo extends CrudRepository<ITdep, Long> {
}
