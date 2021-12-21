package itsystem.demo.Controller;
import itsystem.demo.Model.Hardware.*;
import itsystem.demo.Repository.Hardware.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HardwareController {

    @Autowired
    private HardwareService hardwareService;

    @GetMapping("/hardware")
    public String showHardware(Model model){
        model.addAttribute("hardware", hardwareService.findAllHardware());
        model.addAttribute("pc", hardwareService.findAllPC());
        model.addAttribute("mobil", hardwareService.findAllMobil());
        model.addAttribute("tablet", hardwareService.findAllTablet());
        model.addAttribute("peripheral", hardwareService.findAllPeripheral());
        return "hardware";
    }

    @GetMapping("/hardwareAdd")
    public String addHardware(Model model) {
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

        return "hardwareAdd";
    }


    @PostMapping("/hardwareAdd")
    public String addHardware(@ModelAttribute("hardware") Hardware hardware){


        switch (hardware.getType()){
            case 1:
                hardware = new PC(hardware.getType(), hardware.getName(), hardware.getStatus(), hardware.getProducttype(), hardware.getProductuser());
                break;
            case 2:
                hardware = new Mobil(hardware.getType(), hardware.getName(), hardware.getStatus(), hardware.getProducttype(), hardware.getProductuser());
                break;
            case 3:
                hardware = new Tablet(hardware.getType(), hardware.getName(), hardware.getStatus(), hardware.getProducttype(), hardware.getProductuser());
                break;
            case 4:
                hardware = new Peripheral(hardware.getType(), hardware.getName(), hardware.getStatus(), hardware.getProducttype(), hardware.getProductuser());
                break;
            default:
                hardware = new Hardware();

        }

        System.out.println(hardware.getName());
        System.out.println(hardware.getStatus());
        System.out.println(hardware.getProducttype());
        System.out.println(hardware.getType());

        System.out.println(hardware.toString());

        hardwareService.saveHardware(hardware);

        return "redirect:/hardware";
    }

    @GetMapping("/pcDelete/{id}")
    public String deletePc(@PathVariable("id") Long id){
        hardwareService.deletePC(id);
        return "redirect:/hardware";
    }

    @GetMapping("/mobileDelete/{id}")
    public String deleteMobile(@PathVariable("id") Long id){
        hardwareService.deleteMobil(id);
        return "redirect:/hardware";
    }

    @GetMapping("/periDelete/{id}")
    public String deletePeri(@PathVariable("id") Long id){
        hardwareService.deletePeripheral(id);
        return "redirect:/hardware";
    }

    @GetMapping("/tabletDelete/{id}")
    public String deleteTablet(@PathVariable("id") Long id){
        hardwareService.deleteTablet(id);
        return "redirect:/hardware";
    }






}