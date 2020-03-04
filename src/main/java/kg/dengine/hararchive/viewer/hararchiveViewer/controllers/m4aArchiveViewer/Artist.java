package kg.dengine.hararchive.viewer.hararchiveViewer.controllers.m4aArchiveViewer;

import kg.dengine.hararchive.viewer.hararchiveViewer.entity.AllEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.entity.ArtistEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.AllSongRepository;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/artist")
public class Artist {

    @Autowired
    private AllSongRepository repository;

    @Autowired
    private ArtistRepository artistRepository;

    @Value("${spring.application.name}")
    String appName;

    @GetMapping({"/artist", "/"})
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

}
