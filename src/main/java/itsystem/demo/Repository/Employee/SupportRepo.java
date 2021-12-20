package itsystem.demo.Repository.Employee;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import itsystem.demo.Model.Employee.Support;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupportRepo extends CrudRepository <Support, Long>{

    //Support findByName(String firstName);
}
