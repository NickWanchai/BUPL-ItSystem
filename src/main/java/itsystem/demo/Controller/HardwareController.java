package itsystem.demo.Controller;
import itsystem.demo.Model.*;
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
        Hardware hardwarePC = new PC();
        Hardware hardwareMobil = new Mobil();
        Hardware hardwareTablet = new Tablet();
        Hardware hardwarePeripheral = new Peripheral();

        List<Hardware> hList = new ArrayList<>();
        hList.add(hardwarePC);
        hList.add(hardwareMobil);
        hList.add(hardwareTablet);
        hList.add(hardwarePeripheral);


        model.addAttribute("hwList", hList);
        model.addAttribute("hardware", new Hardware());

        return "hardware";
    }


    @PostMapping("/hardware")
    public String hardware(@ModelAttribute("hardware") Hardware hardware){


        switch (hardware.getType()){
            case 1:
                hardware = new PC(hardware.getType(), hardware.getName(), hardware.getStatus(), hardware.getProducttype());
                break;
            case 2:
                hardware = new Mobil(hardware.getType(), hardware.getName(), hardware.getStatus(), hardware.getProducttype());
                break;
            case 3:
                hardware = new Tablet(hardware.getType(), hardware.getName(), hardware.getStatus(), hardware.getProducttype());
                break;
            case 4:
                hardware = new Peripheral(hardware.getType(), hardware.getName(), hardware.getStatus(), hardware.getProducttype());

                break;
            default:
                hardware = new Hardware();

        }
        System.out.println(hardware.getName());
        System.out.println(hardware.getStatus());
        System.out.println(hardware.getProducttype());
        System.out.println(hardware.getType());

        System.out.println(hardware.toString());


        return "redirect:/hardware";
    }




}