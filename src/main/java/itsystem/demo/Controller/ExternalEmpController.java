package itsystem.demo.Controller;

import itsystem.demo.Model.Employee.Employee;
import itsystem.demo.Model.Employee.External.*;
import itsystem.demo.Repository.Employee.External.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExternalEmpController {

    @Autowired
    private ExternalService exService;

    @GetMapping("/extEmployees")
    public String showExternal(Model model){
        model.addAttribute("extEmployee", exService.findAllExt());
        model.addAttribute("extArhus", exService.findAllArhus());
        model.addAttribute("extForbund", exService.findAllForbund());
        model.addAttribute("extFyn", exService.findAllFyn());
        model.addAttribute("extHoved", exService.findAllHovedstad());
        return "extEmployees";
    }

    @GetMapping("/extEmpAdd")
    public String addExtEmp(Model model){
        ExternalEmp extArhus = new ExtArhus();
        ExternalEmp extForbund = new ExtForbund();
        ExternalEmp extFyn = new ExtFyn();
        ExternalEmp extHoved = new ExtHovedstad();

        List<ExternalEmp> extEmpList = new ArrayList<>();
        extEmpList.add(extArhus);
        extEmpList.add(extFyn);
        extEmpList.add(extForbund);
        extEmpList.add(extHoved);

        model.addAttribute("extEmpList", extEmpList);
        model.addAttribute("extEmp", new ExternalEmp());

        return "extEmpAdd";
    }

    @PostMapping("/extEmpAdd")
    public String addExtEmp(@ModelAttribute("extEmp") ExternalEmp externalEmp){

        switch (externalEmp.getDepartment()){
            case 1:
                externalEmp = new ExtForbund(externalEmp.getDepartment(), externalEmp.getDepartmentName(), externalEmp.getFirstName(), externalEmp.getLastName(), externalEmp.getInitials(), externalEmp.getPhoneNumber(), externalEmp.getAddress(), externalEmp.getSuperior(), externalEmp.getPassword(), externalEmp.getEmail());
                break;
            case 2:
                externalEmp = new ExtHovedstad(externalEmp.getDepartment(), externalEmp.getDepartmentName(), externalEmp.getFirstName(), externalEmp.getLastName(), externalEmp.getInitials(), externalEmp.getPhoneNumber(), externalEmp.getAddress(), externalEmp.getSuperior(), externalEmp.getPassword(), externalEmp.getEmail());
                break;
            case 3:
                externalEmp = new ExtArhus(externalEmp.getDepartment(), externalEmp.getDepartmentName(), externalEmp.getFirstName(), externalEmp.getLastName(), externalEmp.getInitials(), externalEmp.getPhoneNumber(), externalEmp.getAddress(), externalEmp.getSuperior(), externalEmp.getPassword(), externalEmp.getEmail());
                break;
            case 4:
                externalEmp = new ExtFyn(externalEmp.getDepartment(), externalEmp.getDepartmentName(), externalEmp.getFirstName(), externalEmp.getLastName(), externalEmp.getInitials(), externalEmp.getPhoneNumber(), externalEmp.getAddress(), externalEmp.getSuperior(), externalEmp.getPassword(), externalEmp.getEmail());
                break;
            default:
                externalEmp = new ExternalEmp();
        }

        System.out.println(externalEmp.toString());
        exService.saveExtEmp(externalEmp);
        return "redirect:/extEmployees";
    }

}
