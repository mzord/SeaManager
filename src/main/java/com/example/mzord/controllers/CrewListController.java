package com.example.mzord.controllers;

import com.example.mzord.models.CrewList;
import com.example.mzord.models.Seafarer;
import com.example.mzord.services.DocParser;
import com.example.mzord.services.ISeafarerService;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.xmlbeans.XmlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/crewlist/")
public class CrewListController {

    @Autowired
    ISeafarerService seafarerService;

    @GetMapping("/generate")
    public CrewList generateCrewList(@RequestBody CrewList crewList) throws OpenXML4JException, XmlException, IOException {
        DocParser docParser = new DocParser(seafarerService.sortByFunction());
        docParser.changeSignDate(crewList.getSignLocal(), crewList.getSignDate().toString());
        docParser.populateCrewList(seafarerService.showCrew());
        docParser.populateCrewListInfo(crewList.getPortOfArrival(), crewList.getDepartureDate().toString(), crewList.getLastPortOfCall());
        docParser.write();
        return crewList;
    }

    @GetMapping("/show")
    public List<Seafarer> crew() {
        return seafarerService.showCrew();
    }

    @GetMapping("/teste")
    public CrewList returnCrewList() {
        CrewList crewList = new CrewList();
        crewList.setDepartureDate(LocalDate.now());
        crewList.setLastPortOfCall("PORTO");
        crewList.setPortOfArrival("POROT QUE SAI");
        crewList.setSignDate(LocalDate.now());
        crewList.setSignLocal("AKI");
        return crewList;
    }

}
