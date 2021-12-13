package itsystem.demo.Repository.Employee;

import itsystem.demo.Model.Employee.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends CrudRepository<Admin, Long> {
}
