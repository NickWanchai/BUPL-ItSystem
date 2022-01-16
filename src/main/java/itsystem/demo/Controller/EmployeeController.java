package itsystem.demo.Controller;

import itsystem.demo.Model.Employee.Admin;
import itsystem.demo.Model.Employee.Employee;
import itsystem.demo.Model.Employee.ITdep;
import itsystem.demo.Model.Employee.Support;
import itsystem.demo.Repository.Case.CaseService;
import itsystem.demo.Repository.Employee.EmployeeService;
import itsystem.demo.Repository.Hardware.HardwareService;
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
    @Autowired
    private CaseService caseService;
    @Autowired
    private HardwareService hardwareService;


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
                employee = new Admin(employee.getDepartment(), employee.getDepartmentName(), employee.getFirstName(), employee.getLastName(), employee.getInitials(), employee.getPhoneNumber(), employee.getAddress(), employee.getSuperior(), employee.getPassword(), employee.getEmail(), employee.getImage());
                break;
            case 2:
                employee = new Support(employee.getDepartment(), employee.getDepartmentName(), employee.getFirstName(), employee.getLastName(), employee.getInitials(), employee.getPhoneNumber(), employee.getAddress(), employee.getSuperior(), employee.getPassword(), employee.getEmail(), employee.getImage());
                break;
            case 3:
                employee = new ITdep(employee.getDepartment(), employee.getDepartmentName(), employee.getFirstName(), employee.getLastName(), employee.getInitials(), employee.getPhoneNumber(), employee.getAddress(), employee.getSuperior(), employee.getPassword(), employee.getEmail(), employee.getImage());
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
    public String
    Employee(Model model){
        model.addAttribute("employees", eService.findAllemp());
        model.addAttribute("supports", eService.findAllsup());
        model.addAttribute("admins", eService.findAlladmin());
        model.addAttribute("itdeps", eService.findAllit());
        return "employeeEdit";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable(name = "id") Long id){
        eService.deleteEmp(id);
        return "redirect:/employees";
    }
    @GetMapping("/deleteSup/{id}")
    public String deleteSupport(@PathVariable(name = "id") Long id){
        eService.deleteSupport(id);
        return "redirect:/employees";
    }
    @GetMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable(name = "id") Long id){
        eService.deleteAdmin(id);
        return "redirect:/employees";
    }
    @GetMapping("/deleteIT/{id}")
    public String deleteIT(@PathVariable(name = "id") Long id){
        eService.deleteIT(id);
        return "redirect:/employees";
    }

//    @GetMapping("/editEmp/{id}")
//    public ModelAndView showEditEmp(@PathVariable(name= "id") Long id){
//        ModelAndView editView = new ModelAndView("editEmp");
//        Employee employee = eService.findEmpById(id);
//        editView.addObject("editEmployee", employee);
//        return editView;
//    }

    @GetMapping ("/empEdit/{id}")
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

    @GetMapping ("/supEdit/{id}")
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

    @GetMapping ("/itEdit/{id}")
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

    @GetMapping ("/adminEdit/{id}")
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
    @GetMapping("/empProfile/{id}")
    public String empProfile(@PathVariable("id") long id, Model model){
        Employee employee = eService.findEmpById(id);
        model.addAttribute("cases", caseService.findCaseAssigned(employee.getInitials()));

        //Henter hardware med tildelt initial og gør brug af det i html med Model
        model.addAttribute("mobil", hardwareService.findByMobiluserEquals(employee.getInitials()));
        model.addAttribute("pc", hardwareService.findByPCuserEquals(employee.getInitials()));
        model.addAttribute("peripheral", hardwareService.findByPeripheraluserEquals(employee.getInitials()));
        model.addAttribute("tablet", hardwareService.findByTabletuserEquals(employee.getInitials()));
        model.addAttribute("employee", employee);
        return "empProfile";
    }


    //Lav knap man trykker på (der allerede har value for employee.getInit()) som man trykker på og finder alle cases med den value
    @GetMapping("/itProfile/{id}")
    public String itProfile(@PathVariable("id") long id, String init, Model model){
        ITdep iTdep = eService.findItById(id);

        //Henter case med tildelt initial og gør brug af det i html med Model
        model.addAttribute("cases", caseService.findCaseAssigned(iTdep.getInitials()));

        //Henter hardware med tildelt initial og gør brug af det i html med Model
        model.addAttribute("mobil", hardwareService.findByMobiluserEquals(iTdep.getInitials()));
        model.addAttribute("pc", hardwareService.findByPCuserEquals(iTdep.getInitials()));
        model.addAttribute("peripheral", hardwareService.findByPeripheraluserEquals(iTdep.getInitials()));
        model.addAttribute("tablet", hardwareService.findByTabletuserEquals(iTdep.getInitials()));
        model.addAttribute("itdep", iTdep);
        return "itProfile";
    }

    @GetMapping("/adminProfile/{id}")
    public String adminProfile(@PathVariable("id") long id, Model model){
        Admin admin = eService.findAdminById(id);

        //Henter case med tildelt initial og gør brug af det i html med Model
        model.addAttribute("cases", caseService.findCaseAssigned(admin.getInitials()));

        //Henter hardware med tildelt initial og gør brug af det i html med Model
        model.addAttribute("mobil", hardwareService.findByMobiluserEquals(admin.getInitials()));
        model.addAttribute("pc", hardwareService.findByPCuserEquals(admin.getInitials()));
        model.addAttribute("peripheral", hardwareService.findByPeripheraluserEquals(admin.getInitials()));
        model.addAttribute("tablet", hardwareService.findByTabletuserEquals(admin.getInitials()));

        model.addAttribute("admin", admin);
        return "adminProfile";
    }

    @GetMapping("/supProfile/{id}")
    public String supProfile(@PathVariable("id")long id, Model model){

        Support support = eService.findSupById(id);

        //Henter case med tildelt initial og gør brug af det i html med Model
        model.addAttribute("cases", caseService.findCaseAssigned(support.getInitials()));

        //Henter hardware med tildelt initial og gør brug af det i html med Model
        model.addAttribute("mobil", hardwareService.findByMobiluserEquals(support.getInitials()));
        model.addAttribute("pc", hardwareService.findByPCuserEquals(support.getInitials()));
        model.addAttribute("peripheral", hardwareService.findByPeripheraluserEquals(support.getInitials()));
        model.addAttribute("tablet", hardwareService.findByTabletuserEquals(support.getInitials()));

        model.addAttribute("support", support);
        return "supProfile";
    }
}
