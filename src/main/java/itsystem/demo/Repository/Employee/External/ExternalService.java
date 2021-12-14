package itsystem.demo.Repository.Employee.External;

import itsystem.demo.Model.Employee.Employee;
import itsystem.demo.Model.Employee.External.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternalService {

    @Autowired
    private ExtEmpRepo extEmpRepo;
    @Autowired
    private ExtArhusRepo extArhusRepo;
    @Autowired
    private ExtForbundRepo extForbundRepo;
    @Autowired
    private ExtFynRepo extFynRepo;
    @Autowired
    private ExtHovedRepo extHovedRepo;

    public List<ExternalEmp> findAllExt(){ return (List<ExternalEmp>) extEmpRepo.findAll();}
    public List<ExtArhus> findAllArhus(){ return (List<ExtArhus>) extArhusRepo.findAll();}
    public List<ExtForbund> findAllForbund(){ return (List<ExtForbund>) extForbundRepo.findAll();}
    public List<ExtFyn> findAllFyn(){ return (List<ExtFyn>) extFynRepo.findAll();}
    public List<ExtHovedstad> findAllHovedstad(){ return (List<ExtHovedstad>) extHovedRepo.findAll();}

    public ExternalEmp findEmpById(Long id){ return extEmpRepo.findById(id).get();}
    public ExtArhus findArhusById(Long id){ return extArhusRepo.findById(id).get();}
    public ExtForbund findForbundById(Long id){ return extForbundRepo.findById(id).get();}
    public ExtFyn findFynById(Long id){ return extFynRepo.findById(id).get();}
    public ExtHovedstad findHovedById(Long id){ return extHovedRepo.findById(id).get();}

    public void saveExtEmp(ExternalEmp exEmp){ extEmpRepo.save(exEmp);}

    public void deleteExtEmp(Long id){ extEmpRepo.deleteById(id);}
    public void deleteArhus(Long id){ extArhusRepo.deleteById(id);}
    public void deleteForbund(Long id){ extForbundRepo.deleteById(id);}
    public void deleteFyn(Long id){ extFynRepo.deleteById(id);}
    public void deleteHoved(Long id){ extHovedRepo.deleteById(id);}

}
