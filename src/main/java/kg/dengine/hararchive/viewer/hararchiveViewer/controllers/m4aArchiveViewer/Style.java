package kg.dengine.hararchive.viewer.hararchiveViewer.controllers.m4aArchiveViewer;

import kg.dengine.hararchive.viewer.hararchiveViewer.entity.AllEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.entity.StyleEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.AllSongRepository;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.StyleRepository;
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
import java.util.Optional;

@Controller
@RequestMapping("/style")
public class Style {
    @Autowired
    private StyleRepository styleRepository;

    @Autowired
    private AllSongRepository repository;

    @Value("${spring.application.name}")
    String appName;

    @GetMapping({"/style", "/"})
    public String homePageStyle(Model model) {
        model.addAttribute("appName", appName);

//        List<AllEntity> prodigy = repository.findByTrack("Marshmello - Stars");

        model.addAttribute("count", "0");

        return "indexStyle";
    }

    @PostMapping(path = "/searchStyle", consumes = {"text/plain", "application/*"})
    public String searchStyles(HttpServletRequest request,
                               UriComponentsBuilder uriComponentsBuilder, Model model) {
        model.addAttribute("appName", appName);

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

        //TODO: long loading - need to renew to ajax single load style
//        for (StyleEntity ent: style) {
//            ent.setCount(styleRepository.nativeCountStyle(ent.getId()));
//        }



        System.out.println(style.size());
        model.addAttribute("search", search);
        model.addAttribute("count", style.size());
        model.addAttribute("styles", style);

        return "indexStyle";
    }

    @GetMapping({"/searchStyleOrder/{order}/{search}", "/searchStyleOrder/{order}"})
    public String searchStylesOrder(@PathVariable String order, String search, Model model){
        model.addAttribute("appName", appName);

        System.out.println("serachStyle - get");
        System.out.println(search);

        List<StyleEntity> style = new ArrayList<>();
        if (search != null && !search.equals("")) {
            style = styleRepository.findByName(search);
        } else {
            switch (order) {
                case "id" :
                    style = styleRepository.findAllByOrderByIdAsc();
                    break;
                case "style" :
                    style = styleRepository.findAllByOrderByNameAsc();
                    break;
                case "root" :
                    style = styleRepository.findAllByOrderByRootFolderAsc();
                    break;
                default:
                    style = (List<StyleEntity>) styleRepository.findAll();
            }
        }

        //TODO: long loading - need to renew to ajax single load style
//        for (StyleEntity ent: style) {
//            ent.setCount(styleRepository.nativeCountStyle(ent.getId()));
//        }



        System.out.println(style.size());
        model.addAttribute("search", search);
        model.addAttribute("count", style.size());
        model.addAttribute("styles", style);

        return "indexStyle";
    }

    @GetMapping("/viewStyleId/{styleId}")
    public String viewStyleId(@PathVariable Integer styleId, Model model) {
//        List<AllEntity> allByStyle = styleRepository.getAllByStyle(styleId);

        Optional<StyleEntity> byIdSingle = styleRepository.findById(styleId);
        StyleEntity byIdSingle1 = styleRepository.findByIdIs(styleId);

        List<AllEntity> allByStyleAllContains = repository.findAllByStyleAllContains(byIdSingle1.getName());
//
        System.out.println(byIdSingle.get().getName());
        System.out.println(byIdSingle1.getName());


        model.addAttribute("search", byIdSingle.get().getName());
        model.addAttribute("count", allByStyleAllContains.size());
        model.addAttribute("songs", allByStyleAllContains);
        model.addAttribute("styleCountMagicQuery", styleRepository.nativeCountStyle(styleId));

        return "indexStyleSongs";
    }

    @GetMapping("/viewStyleName/{styleName}")
    public String viewStyleName(@PathVariable String styleName, Model model) {

        StyleEntity byNameIs = styleRepository.findByNameIs(styleName);
        Integer styleId = byNameIs.getId();
        Optional<StyleEntity> byIdSingle = styleRepository.findById(styleId);
        StyleEntity byIdSingle1 = styleRepository.findByIdIs(styleId);

        List<AllEntity> allByStyleAllContains = repository.findAllByStyleAllContains(byIdSingle1.getName());
//
        System.out.println(byIdSingle.get().getName());
        System.out.println(byIdSingle1.getName());


        model.addAttribute("search", byIdSingle.get().getName());
        model.addAttribute("count", allByStyleAllContains.size());
        model.addAttribute("songs", allByStyleAllContains);
        model.addAttribute("styleCountMagicQuery", styleRepository.nativeCountStyle(styleId));

        return "indexStyleSongs";
    }

}
