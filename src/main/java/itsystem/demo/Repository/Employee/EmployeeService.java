package itsystem.demo.Repository.Employee;


import itsystem.demo.Model.Employee.Admin;
import itsystem.demo.Model.Employee.Employee;
import itsystem.demo.Model.Employee.ITdep;
import itsystem.demo.Model.Employee.Support;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo eRepo;
    @Autowired
    private SupportRepo sRepo;
    @Autowired
    private AdminRepo aRepo;
    @Autowired
    private ITdepRepo itRepo;


    public List<Employee> findAllemp(){
        return (List<Employee>) eRepo.findAll();
    }

    public List<Support> findAllsup(){
        return (List<Support>) sRepo.findAll();
    }

    public List<Admin> findAlladmin(){
        return (List<Admin>) aRepo.findAll();
    }

    public List<ITdep> findAllit(){
        return (List<ITdep>) itRepo.findAll();
     }

    public Employee findEmpById(Long id){
        return eRepo.findById(id).get();
    }

    public Support findSupById(Long id){
        return sRepo.findById(id).get();
    }
    //public Support findSupByName(String firstName){return sRepo.findByName(firstName);}

    public Admin findAdminById(Long id){
        return aRepo.findById(id).get();
    }

    public ITdep findItById(Long id){
        return itRepo.findById(id).get();
    }


    public void saveEmp(Employee employee){
        eRepo.save(employee);
    }

    public void deleteEmp(Long id){eRepo.deleteById(id);}

    public void deleteSupport(Long id){
        sRepo.deleteById(id);
    }

    public void deleteAdmin(Long id){
        aRepo.deleteById(id);
    }

    public void deleteIT(Long id){
        itRepo.deleteById(id);
    }

}
