package itsystem.demo.Repository.Case;

import itsystem.demo.Model.Case.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaseService {

    @Autowired
    private CaseRepo caseRepo;

    public List<Case> findAllCases(){ return (List<Case>) caseRepo.findAll();}

    public Case findCaseById(Long id){ return caseRepo.findById(id).get();}

    public void saveCase(Case cases){ caseRepo.save(cases);}

    public void deleteCase(Long id){ caseRepo.deleteById(id);}

    public List<Case> findCaseAssigned(String initial){
        return caseRepo.findByAssignedEquals(initial);
    }

}
