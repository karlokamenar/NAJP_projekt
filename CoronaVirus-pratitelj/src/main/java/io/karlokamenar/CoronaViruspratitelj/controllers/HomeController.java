package io.karlokamenar.CoronaViruspratitelj.controllers;

import io.karlokamenar.CoronaViruspratitelj.models.LocationStats;
import io.karlokamenar.CoronaViruspratitelj.services.CoronaVirusPodaciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusPodaciService coronaVirusPodaciService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = coronaVirusPodaciService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();

        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);

        return "home";
    }
}
