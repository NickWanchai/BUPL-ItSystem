package itsystem.demo.Repository.Case;

import itsystem.demo.Model.Case.Case;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseRepo extends CrudRepository<Case, Long>{

    //Finder hvilken person casen er assigned til
    List<Case> findByAssignedEquals(String initial);
}
