package itsystem.demo.Controller;

import itsystem.demo.Model.Device;
import itsystem.demo.Repository.DeviceRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DeviceController {

    private DeviceRepo dRepo;

    public DeviceController(DeviceRepo dRepo) {
        this.dRepo = dRepo;
    }

    @GetMapping("/deviceStartside")
    public String deviceStartside() {
        return "deviceStartside";
    }

    @GetMapping("/pc")
    public String pc() {
        return "pc";
    }

    @GetMapping("/pc")
    public String pc(Model model) {
        model.addAttribute("device", dRepo.findAll());
        return "pc";
    }



//    @GetMapping("/addPc")
//    public String addPlayer(Model model) {
//        model.addAttribute("pc", new Device());
//        return "addPc";
//    }
//
//    @PostMapping("/addPc")
//    public String addPc(HttpServletRequest request) {
//
//        String name = request.getParameter("Navn");
//        String Status = request.getParameter("Status");
//        String product = request.getParameter("Produkt");
//        String serialNr = request.getParameter("SerialNr");
//        int imeiNr = Integer.parseInt(request.getParameter("Imeinr"));
//
//
//        Device pc = new Device(name, Status, product, serialNr, imeiNr);
//        dRepo.save(pc);
//
//        return "redirect:/deviceStartside";
//    }




}
