package itsystem.demo.Repository.Employee;

import itsystem.demo.Model.Employee.Support;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepo extends CrudRepository <Support, Long>{
}
