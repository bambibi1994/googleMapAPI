package com.tts.MapsApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MapController {
    //    @GetMapping("/home")
//    public String getDefaultMap() {
//        Location location = new Location();
//        location.setCity("Dallas");
//        location.setState("Texas");
//        MapService.addCoordinates(location);
//        System.out.println(location);
//        return "index.html";
//    }
    @Autowired
    private MapService mapService;

    @GetMapping("/home")
    public String getDefaultMap(Model model) {
        model.addAttribute(new Location());
        return "index.html";
    }

    @PostMapping("/home")
    public String getMapForLocation(Location location, Model model) {
        mapService.addCoordinates(location);
        model.addAttribute(location);
        return "index.html";
    }
}
