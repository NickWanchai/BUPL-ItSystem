package itsystem.demo.Repository.Employee;

import itsystem.demo.Model.Employee.ITdep;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITdepRepo extends CrudRepository<ITdep, Long> {
}
