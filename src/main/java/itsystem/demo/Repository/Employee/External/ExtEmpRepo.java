package itsystem.demo.Repository.Employee.External;


import itsystem.demo.Model.Employee.External.ExternalEmp;
import org.springframework.data.repository.CrudRepository;

public interface ExtEmpRepo extends CrudRepository<ExternalEmp, Long> {
}
