package itsystem.demo.Controller;

import itsystem.demo.Model.*;
import itsystem.demo.Repository.AdminRepo;
import itsystem.demo.Repository.EmployeeRepo;
import itsystem.demo.Repository.ITdepRepo;
import itsystem.demo.Repository.SupportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService eService;


    @GetMapping("/employees")
    public String showEmployees(Model model){
        model.addAttribute("employees", eService.findAllemp());
        model.addAttribute("supports", eService.findAllsup());
        model.addAttribute("admins", eService.findAlladmin());
        model.addAttribute("itdeps", eService.findAllit());
        return "employees";
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

        eService.saveEmp(employee);
        return "redirect:/employees";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(Model model){
        model.addAttribute("employees", eService.findAllemp());
        model.addAttribute("supports", eService.findAllsup());
        model.addAttribute("admins", eService.findAlladmin());
        model.addAttribute("itdeps", eService.findAllit());
        return "deleteEmployee";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable(name = "id") Long id){
        eService.deleteEmp(id);
        return "redirect:/deleteEmployee";
    }
    @GetMapping("/deleteSup/{id}")
    public String deleteSupport(@PathVariable(name = "id") Long id){
        eService.deleteSupport(id);
        return "redirect:/deleteEmployee";
    }
    @GetMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable(name = "id") Long id){
        eService.deleteAdmin(id);
        return "redirect:/deleteEmployee";
    }
    @GetMapping("/deleteIT/{id}")
    public String deleteIT(@PathVariable(name = "id") Long id){
        eService.deleteIT(id);
        return "redirect:/deleteEmployee";
    }

//    @GetMapping("/editEmp/{id}")
//    public ModelAndView showEditEmp(@PathVariable(name= "id") Long id){
//        ModelAndView editView = new ModelAndView("editEmp");
//        Employee employee = eService.findEmpById(id);
//        editView.addObject("editEmployee", employee);
//        return editView;
//    }

    @GetMapping ("editEmp/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Employee employee = eService.findEmpById(id);

        model.addAttribute("employee", employee);
        return "editEmp";

    }

    @PostMapping("/updateEmp/{id}")
    public String updateEmp(@PathVariable("id") long id, @Valid Employee employee, BindingResult result, Model model){
        if(result.hasErrors()){
            employee.setId(id);
            return "editEmp";
        }

        eService.saveEmp(employee);
        return "redirect:/employees";
    }

    @GetMapping ("editSup/{id}")
    public String showUpdateSupForm(@PathVariable("id") long id, Model model){
        Support support = eService.findSupById(id);

        model.addAttribute("support", support);
        return "editSup";

    }

    @PostMapping("/updateSup/{id}")
    public String updateEmp(@PathVariable("id") long id, @Valid Support support, BindingResult result, Model model){
        if(result.hasErrors()){
            support.setId(id);
            return "editSup";
        }

        eService.saveEmp(support);
        return "redirect:/employees";
    }


}
