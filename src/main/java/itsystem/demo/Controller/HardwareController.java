package itsystem.demo.Controller;
import itsystem.demo.Model.Hardware;
import itsystem.demo.Model.PC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HardwareController {

    @GetMapping("/hardware")
    public String hardware(Model model) {
        PC hardwarePC = new PC();

        List<Hardware> hList = new ArrayList<>();

        hList.add(hardwarePC);
        model.addAttribute("hwList", hList);
        model.addAttribute("hardware", new Hardware());

        return "hardware";
    }


    @PostMapping("/hardware")
    public String hardware(@ModelAttribute("hardware") Hardware hardware){
        System.out.println(hardware.getType());
        return "hardware";
    }

}