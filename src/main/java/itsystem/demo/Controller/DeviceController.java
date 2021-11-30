package itsystem.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DeviceController {

    @GetMapping("/deviceStartside")
    public String deviceStartside() {
        return "deviceStartside";
    }


//    @GetMapping("/pc")
//    public String allPc(Model model) {
//        model.addAttribute("pcs", dRepo.findAll());
//        return "pc";
//    }

//    @ModelAttribute("types")
//    public List<Type> getType(){
//        List<Type> list = new ArrayList<Type>();
//            list.add(new Type("PC"));
//            list.add(new Type("Mobil"));
//            return list;
//    }

//
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
