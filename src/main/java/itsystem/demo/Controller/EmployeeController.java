package itsystem.demo.Controller;

import itsystem.demo.Model.Employee.Admin;
import itsystem.demo.Model.Employee.Employee;
import itsystem.demo.Model.Employee.ITdep;
import itsystem.demo.Model.Employee.Support;
import itsystem.demo.Repository.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/employeeAdd")
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

        return "employeeAdd";
    }

    @PostMapping("/employeeAdd")
    public String addEmployee(@ModelAttribute("employee") Employee employee){

        switch (employee.getDepartment()){
            case 1:
                employee = new Admin(employee.getDepartment(), employee.getDepartmentName(), employee.getFirstName(), employee.getLastName(), employee.getInitials(), employee.getPhoneNumber(), employee.getAddress(), employee.getSuperior());
                break;
            case 2:
                employee = new Support(employee.getDepartment(), employee.getDepartmentName(), employee.getFirstName(), employee.getLastName(), employee.getInitials(), employee.getPhoneNumber(), employee.getAddress(), employee.getSuperior());
                break;
            case 3:
                employee = new ITdep(employee.getDepartment(), employee.getDepartmentName(), employee.getFirstName(), employee.getLastName(), employee.getInitials(), employee.getPhoneNumber(), employee.getAddress(), employee.getSuperior());
                break;
            default:
                employee = new Employee();
        }

        eService.saveEmp(employee);
        return "redirect:/employees";
    }

    @GetMapping("/supports")
    public String showSupports(Model model){
        model.addAttribute("support", eService.findAllsup());
        return "supports";
    }

    @GetMapping("/employeeEdit")
    public String deleteEmployee(Model model){
        model.addAttribute("employees", eService.findAllemp());
        model.addAttribute("supports", eService.findAllsup());
        model.addAttribute("admins", eService.findAlladmin());
        model.addAttribute("itdeps", eService.findAllit());
        return "employeeEdit";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable(name = "id") Long id){
        eService.deleteEmp(id);
        return "redirect:/employeeEdit";
    }
    @GetMapping("/deleteSup/{id}")
    public String deleteSupport(@PathVariable(name = "id") Long id){
        eService.deleteSupport(id);
        return "redirect:/employeeEdit";
    }
    @GetMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable(name = "id") Long id){
        eService.deleteAdmin(id);
        return "redirect:/employeeEdit";
    }
    @GetMapping("/deleteIT/{id}")
    public String deleteIT(@PathVariable(name = "id") Long id){
        eService.deleteIT(id);
        return "redirect:/employeeEdit";
    }

//    @GetMapping("/editEmp/{id}")
//    public ModelAndView showEditEmp(@PathVariable(name= "id") Long id){
//        ModelAndView editView = new ModelAndView("editEmp");
//        Employee employee = eService.findEmpById(id);
//        editView.addObject("editEmployee", employee);
//        return editView;
//    }

    @GetMapping ("empEdit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Employee employee = eService.findEmpById(id);

        model.addAttribute("employee", employee);
        return "empEdit";

    }


    @PostMapping("/updateEmp/{id}")
    public String updateEmp(@PathVariable("id") long id, @Valid Employee employee, BindingResult result, Model model){
        if(result.hasErrors()){
            employee.setId(id);
            return "empEdit";
        }
        eService.saveEmp(employee);
        return "redirect:/employees";
    }

    @GetMapping ("supEdit/{id}")
    public String showUpdateSupForm(@PathVariable("id") long id, Model model){
        Support support = eService.findSupById(id);

        model.addAttribute("support", support);
        return "supEdit";

    }

    @PostMapping("/updateSup/{id}")
    public String updateSup(@PathVariable("id") long id, @Valid Support support, BindingResult result, Model model){
        if(result.hasErrors()){
            support.setId(id);
            return "supEdit";
        }
        eService.saveEmp(support);
        return "redirect:/employees";
    }

    @GetMapping ("itEdit/{id}")
    public String showUpdateITForm(@PathVariable("id") long id, Model model){
        ITdep iTdep = eService.findItById(id);

        model.addAttribute("itdep", iTdep);
        return "itEdit";

    }

    @PostMapping("/updateIT/{id}")
    public String updateIT(@PathVariable("id") long id, @Valid ITdep iTdep, BindingResult result, Model model){
        if(result.hasErrors()){
            iTdep.setId(id);
            return "itEdit";
        }
        eService.saveEmp(iTdep);
        return "redirect:/employees";
    }

    @GetMapping ("adminEdit/{id}")
    public String showUpdateAdminForm(@PathVariable("id") long id, Model model){
        Admin admin = eService.findAdminById(id);

        model.addAttribute("admin", admin);
        return "adminEdit";

    }

    @PostMapping("/updateAdmin/{id}")
    public String updateAdmin(@PathVariable("id") long id, @Valid Admin admin, BindingResult result, Model model){
        if(result.hasErrors()){
            admin.setId(id);
            return "editAdmin";
        }
        eService.saveEmp(admin);
        return "redirect:/employees";
    }
    @GetMapping("supProfile/{id}")
    public String supProfile(@PathVariable("id")long id, Model model){
        Support support = eService.findSupById(id);

        model.addAttribute("support", support);
        return "supProfile";
    }
}
