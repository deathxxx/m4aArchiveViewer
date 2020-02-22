package kg.dengine.hararchive.viewer.hararchiveViewer.controllers;

import com.google.gson.*;
import kg.dengine.hararchive.viewer.hararchiveViewer.entity.AllEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.entity.ArtistEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.entity.StyleEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.AllSongRepository;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.ArtistRepository;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.StyleRepository;
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

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private StyleRepository styleRepository;

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);

//        List<AllEntity> prodigy = repository.findByTrack("Marshmello - Stars");

        model.addAttribute("count", "0");

        return "index1";
    }

//    @GetMapping("/2")
//    public String template(Model model) {
//        model.addAttribute("appName", appName);
//        return "home";
//    }

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

        return "index1";
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

//    @PostMapping(path = "/searchStyle", consumes = {"text/plain", "application/*"})
//    public String findByStyle(HttpServletRequest request,
//                              UriComponentsBuilder uriComponentsBuilder, Model model) {
//        return "index1";
//    }

    @GetMapping("/artist")
    public String homePageArtist(Model model) {
        model.addAttribute("appName", appName);

//        List<AllEntity> prodigy = repository.findByTrack("Marshmello - Stars");

        model.addAttribute("count", "0");

        return "indexArtist";
    }

    @PostMapping(path = "/searchArtistSongs", consumes = {"text/plain", "application/*"})
    public String searchArtistSongs(HttpServletRequest request,
                         UriComponentsBuilder uriComponentsBuilder, Model model) {
        String search = request.getParameter("search");

        System.out.println("hello");
        System.out.println(search);

        List<ArtistEntity> artist = new ArrayList<>();
        if (!search.equals("")) {
            artist = artistRepository.findByDisplayArtistContains(search);
        }

        System.out.println(artist.size());
        model.addAttribute("search", search);
        model.addAttribute("count", artist.size());
        model.addAttribute("artists", artist);

        return "indexArtist";
    }

    @GetMapping("/viewArtistSongs/{artistId}")
    public String viewSrtistSongs(@PathVariable Long artistId, Model model) {

        List<AllEntity> tracks = repository.findByArtistId(artistId);
        model.addAttribute("songs", tracks);
        model.addAttribute("search", tracks.get(0).getDisplayArtist());
        model.addAttribute("count", tracks.size());
        model.addAttribute("songs", tracks);


        return "indexArtistSongs";
    }


    @GetMapping("/style")
    public String homePageStyle(Model model) {
        model.addAttribute("appName", appName);

//        List<AllEntity> prodigy = repository.findByTrack("Marshmello - Stars");

        model.addAttribute("count", "0");

        return "indexStyle";
    }

    @PostMapping(path = "/searchStyle", consumes = {"text/plain", "application/*"})
    public String searchStyles(HttpServletRequest request,
                                    UriComponentsBuilder uriComponentsBuilder, Model model) {
        String search = request.getParameter("search");
        String all = request.getParameter("all");

        System.out.println("serachStyle");
        System.out.println(search);

        List<StyleEntity> style = new ArrayList<>();
        if (!search.equals("")) {
            style = styleRepository.findByName(search);
        } else {
            style = (List<StyleEntity>) styleRepository.findAll();
        }

//        for (StyleEntity ent: style) {
//            ent.setCount(styleRepository.nativeCountStyle(ent.getId()));
//        }



        System.out.println(style.size());
        model.addAttribute("search", search);
        model.addAttribute("count", style.size());
        model.addAttribute("styles", style);

        return "indexStyle";
    }


}
