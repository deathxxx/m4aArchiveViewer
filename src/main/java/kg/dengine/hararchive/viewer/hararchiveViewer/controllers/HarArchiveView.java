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
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    @PostMapping(path = "/search", consumes = {"text/plain", "application/*"})
    public String search(HttpServletRequest request,
                         UriComponentsBuilder uriComponentsBuilder, Model model) {
        String search = request.getParameter("search");

        System.out.println("hello");
        System.out.println(search);
//        System.out.println(request.toString());
//        model.addAttribute("appName", appName);
//

        List<AllEntity> tracks = new ArrayList<>();
        if (!search.equals("")) {
            tracks = repository.findByTrackContains(search);
        }

        System.out.println(tracks.size());
//
        model.addAttribute("search", search);
        model.addAttribute("count", tracks.size());
        model.addAttribute("songs", tracks);

        return "index";
    }
}
