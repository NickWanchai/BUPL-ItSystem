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

    //Læs
    public List<Case> findAllCases(){ return (List<Case>) caseRepo.findAll();}
    public Case findCaseById(Long id){ return caseRepo.findById(id).get();}

    //Gem
    public void saveCase(Case cases){ caseRepo.save(cases);}

    //Slet
    public void deleteCase(Long id){ caseRepo.deleteById(id);}

    //Finder tildelt person
    public List<Case> findCaseAssigned(String initial){
        return caseRepo.findByAssignedEquals(initial);
    }

    //Finder ud fra status
    public List<Case> findCaseByStatus(String status){
        return caseRepo.findByStatusEquals(status);
    }

}
