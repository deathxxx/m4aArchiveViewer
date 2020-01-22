package kg.dengine.hararchive.viewer.hararchiveViewer.controllers;

import kg.dengine.hararchive.viewer.hararchiveViewer.entity.AllEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.AllSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class HarArchiveView {

    @Autowired
    private AllSongRepository repository;

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/1")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);

//        List<AllEntity> prodigy = repository.findByTrack("Marshmello - Stars");

        model.addAttribute("count", "0");

        return "index";
    }
    @GetMapping("/2")
    public String template(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }
    @PostMapping("/search")
    public String search(@RequestBody String input) {
        System.out.println(input);
//        model.addAttribute("appName", appName);
//
//        List<AllEntity> prodigy = repository.findByTrack("Marshmello - Stars");
//
//        model.addAttribute("count", prodigy.size());

        return "index";
    }
}
