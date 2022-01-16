package itsystem.demo.Controller.Login;

import itsystem.demo.Model.Employee.Admin;
import itsystem.demo.Model.Employee.ITdep;
import itsystem.demo.Model.Employee.Support;
import itsystem.demo.Repository.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.GenericArrayType;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private EmployeeService eService;

    @GetMapping("/login")
    public String login(){
        List<ITdep> adminList = eService.findAllit();
        String user = "NWL";
        String password = "nick123";
        for (ITdep iTdep : adminList){
            if(user.equals(iTdep.getInitials())){
                if(password.equals(iTdep.getPassword())){
                    System.out.println("Login!");
                }
            }
        }
        System.out.println("Not login!");
        return "login";
    }

}
