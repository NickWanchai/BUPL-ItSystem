package itsystem.demo.Repository.Employee.External;


import itsystem.demo.Model.Employee.External.ExtHovedstad;
import org.springframework.data.repository.CrudRepository;

public interface ExtHovedRepo extends CrudRepository<ExtHovedstad, Long> {
}
