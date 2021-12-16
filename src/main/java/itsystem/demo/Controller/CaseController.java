package itsystem.demo.Controller;

import itsystem.demo.Model.Case.Case;
import itsystem.demo.Repository.Case.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CaseController {

    @Autowired
    private CaseService caseService;

    @GetMapping("/cases")
    public String cases(Model model){
        model.addAttribute("cases", caseService.findAllCases());

        System.out.println(caseService.findCaseAssigned("nw"));
        return "cases";
    }

    @GetMapping("/casesAdd")
    public String addCases(Model model){
        Case cases = new Case();

        List<Case> caseList = new ArrayList<>();
        caseList.add(cases);

        model.addAttribute("caseList", caseList);
        model.addAttribute("case", new Case());

        return "casesAdd";
    }

    @PostMapping("/casesAdd")
    public String addCases(@ModelAttribute("cases")Case cases){

        caseService.saveCase(cases);
        return "redirect:/cases";
    }

    @GetMapping("/casesEdit")
    public String editCases(Model model){
        model.addAttribute("cases", caseService.findAllCases());

        return "casesEdit";
    }

    @GetMapping("/caseDelete/{id}")
    public String deleteCase(@PathVariable("id") Long id){
        caseService.deleteCase(id);
        return "redirect:/casesEdit";
    }

    @GetMapping("/caseEdit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model){
        Case cases = caseService.findCaseById(id);

        model.addAttribute("case", cases);
        return "caseEdit";
    }

    @PostMapping("/updateCase/{id}")
    public String updateCase(@PathVariable("id") Long id, @Valid Case cases, BindingResult result, Model model){
        if(result.hasErrors()){
            cases.setId(id);
            return "caseEdit";
        }
        caseService.saveCase(cases);
        return "redirect:/casesEdit";
    }

    @GetMapping("/caseProfile/{id}")
    public String showCase(@PathVariable("id") Long id, Model model){
        Case cases = caseService.findCaseById(id);

        model.addAttribute("case", cases);
        return "caseProfile";
    }


}
