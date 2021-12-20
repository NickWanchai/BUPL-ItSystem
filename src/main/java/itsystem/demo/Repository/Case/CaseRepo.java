package itsystem.demo.Repository.Case;

import itsystem.demo.Model.Case.Case;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseRepo extends CrudRepository<Case, Long>{

    List<Case> findByAssignedEquals(String initial);
}
