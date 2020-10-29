package com.example.mzord.controllers;

import com.example.mzord.models.CrewList;
import com.example.mzord.models.Rank;
import com.example.mzord.models.Seafarer;
import com.example.mzord.services.DocParser;
import com.example.mzord.services.SeafarerService;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.xmlbeans.XmlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class WebController {

    @Autowired
    private SeafarerService seafarerService;

    @GetMapping("/")
    private String index() {
        return "index";
    }

    @GetMapping("/seafarer/{id}")
    private String seafarer(@PathVariable("id") Long id, Model model) {
        Seafarer seafarer = seafarerService.findById(id).get();
        model.addAttribute("seafarer", seafarer);
        return "seafarer";
    }

    @GetMapping("/seafarer/new")
    private String addSeafarer(Seafarer seafarer) {
        return "addSeafarer";
    }

    @PostMapping("/addseafarer")
    private String addSeafarer(@Validated Seafarer seafarer, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result);
            return "addSeafarer";
        }
        seafarerService.save(seafarer);
        return "redirect:/index";
    }

    @GetMapping("seafarers")
    private String getAllSeafarers(Model model) {
        model.addAttribute("seafarersOnBoard", seafarerService.showCrew());
        model.addAttribute("seafarersOffBoard", seafarerService.showDisembarked());
        return "showSeafarers";
    }

    @GetMapping("/crewlist")
    private String showCrewListForm(CrewList crewList) {
        return "crewlistGenerator";
    }

    @PostMapping("/generateCrewList")
    private String generateCrewList(@Validated CrewList crewList, BindingResult result) throws OpenXML4JException, XmlException, IOException {
        if (result.hasErrors()) {
            System.out.println(result);
            return "crewlistGenerator";
        }

        DocParser docParser = new DocParser(seafarerService.sortByFunction());
        docParser.changeSignDate(crewList.getSignLocal(), crewList.getSignDate().toString());
        docParser.populateCrewList(seafarerService.showCrew());
        docParser.populateCrewListInfo(crewList.getPortOfArrival(), crewList.getDepartureDate().toString(), crewList.getLastPortOfCall());
        docParser.write();
        System.out.println("FOI PORRA");

        return "redirect:/index";
    }


}
