package itsystem.demo.Controller;

import itsystem.demo.Repository.Hardware.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    HardwareService hwService = new HardwareService();

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("mobile", hwService.findPhoneByStatus("I brug"));
        model.addAttribute("pc", hwService.findPcByStatus("I brug"));
        model.addAttribute("peri",hwService.findPeriByStatus("I brug"));
        model.addAttribute("tablet",hwService.findTabByStatus("I brug"));
        return "index";
    }

}
