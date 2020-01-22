package kg.dengine.hararchive.viewer.hararchiveViewer.controllers;

import com.google.gson.*;
import kg.dengine.hararchive.viewer.hararchiveViewer.entity.AllEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.AllSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List<AllEntity> tracks = new ArrayList<>();
        if (!search.equals("")) {
            tracks = repository.findByTrackContains(search);
        }

        System.out.println(tracks.size());
        model.addAttribute("search", search);
        model.addAttribute("count", tracks.size());
        model.addAttribute("songs", tracks);

        return "index";
    }

    @GetMapping("/view/{trackId}")
    public String view(@PathVariable Long trackId, Model model) {

        AllEntity track = repository.findByTrackId(trackId);
        model.addAttribute("track", track);

        model.addAttribute("jsonFormated", parseJson(track.getJson()));

        model.addAttribute("asset_url", "http:"+parseJsonObjectElementToString(track.getJson(),"asset_url"));
        model.addAttribute("details_url", parseJsonObjectElementToString(track.getJson(), "details_url"));
        return "view";
    }

    public String parseJson(String jsonString) {
        JsonParser parser = new JsonParser();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonElement el = parser.parse(jsonString);
        jsonString = gson.toJson(el); // done
        return jsonString;
    }

    public String parseJsonObjectElementToString(String json, String obj) {
        String out = "";

        JsonParser parser = new JsonParser();

        JsonElement jsonTree = parser.parse(json);

        if (jsonTree.isJsonObject()) {
            JsonObject jsonObject = jsonTree.getAsJsonObject();

            JsonElement el = jsonObject.get(obj);

            out = el.getAsString();
        }

        return out;
    }
}
