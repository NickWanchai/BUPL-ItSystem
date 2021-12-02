package itsystem.demo.Controller;

import itsystem.demo.Model.*;
import itsystem.demo.Repository.AdminRepo;
import itsystem.demo.Repository.EmployeeRepo;
import itsystem.demo.Repository.ITdepRepo;
import itsystem.demo.Repository.SupportRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeRepo eRepo;
    private SupportRepo sRepo;
    private AdminRepo aRepo;
    private ITdepRepo itRepo;

    public EmployeeController(EmployeeRepo eRepo, SupportRepo sRepo, AdminRepo aRepo, ITdepRepo itRepo){
        this.eRepo = eRepo;
        this.sRepo = sRepo;
        this.aRepo = aRepo;
        this.itRepo = itRepo;
    }


    @GetMapping("/employees")
    public String showEmployees(Model model){
        model.addAttribute("employees", eRepo.findAll());
        model.addAttribute("supports", sRepo.findAll());
        model.addAttribute("admins", aRepo.findAll());
        model.addAttribute("itdeps", itRepo.findAll());
        return "employees";
    }

    @GetMapping("/supports")
    public String showSupports(Model model){
        model.addAttribute("supports", sRepo.findAll());
        return "supports";
    }

    @GetMapping("/admins")
    public String showAdmins(Model model){
        model.addAttribute("admins", aRepo.findAll());
        return "admins";
    }

    @GetMapping("/itdeps")
    public String showITdeps(Model model){
        model.addAttribute("itdeps", itRepo.findAll());
        return "itdeps";
    }


    @GetMapping("/addEmployee")
    public String addEmployee(Model model){
        Employee empAdmin = new Admin();
        Employee empSupport = new Support();
        Employee empITdep = new ITdep();

        List<Employee> empList = new ArrayList<>();
        empList.add(empAdmin);
        empList.add(empSupport);
        empList.add(empITdep);

        model.addAttribute("empList", empList);
        model.addAttribute("employee", new Employee());

        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee){

        switch (employee.getDepartment()){
            case 1:
                employee = new Admin(employee.getDepartment(), employee.getDepartmentName(), employee.getFirstName(), employee.getLastName(), employee.getPhoneNumber(), employee.getAddress(), employee.getSuperior());
                break;
            case 2:
                employee = new Support(employee.getDepartment(), employee.getDepartmentName(), employee.getFirstName(), employee.getLastName(), employee.getPhoneNumber(), employee.getAddress(), employee.getSuperior());
                break;
            case 3:
                employee = new ITdep(employee.getDepartment(), employee.getDepartmentName(), employee.getFirstName(), employee.getLastName(), employee.getPhoneNumber(), employee.getAddress(), employee.getSuperior());
                break;
            default:
                employee = new Employee();
        }


        System.out.println(employee.toString());
        System.out.println(employee.getFirstName());
        System.out.println(employee.getLastName());
        System.out.println(employee.getDepartment());
        System.out.println(employee.getDepartmentName());
        System.out.println(employee.getPhoneNumber());
        System.out.println(employee.getAddress());
        System.out.println(employee.getSuperior());
        eRepo.save(employee);
        return "redirect:/addEmployee";
    }
}
