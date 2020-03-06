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

        model.addAttribute("idOrder", "idAsc");
        model.addAttribute("styleOrder", "styleAsc");
        model.addAttribute("rootOrder", "rootAsc");

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
                case "idAsc" :
                    style = styleRepository.findAllByOrderByIdAsc();
                    break;
                case "idDesc" :
                    style = styleRepository.findAllByOrderByIdDesc();
                    break;
                case "styleAsc" :
                    style = styleRepository.findAllByOrderByNameAsc();
                    break;
                case "styleDesc" :
                    style = styleRepository.findAllByOrderByNameDesc();
                    break;
                case "rootAsc" :
                    style = styleRepository.findAllByOrderByRootFolderAsc();
                    break;
                case "rootDesc" :
                    style = styleRepository.findAllByOrderByRootFolderDesc();
                    break;
                default:
                    style = (List<StyleEntity>) styleRepository.findAll();
            }
        }

        //TODO: long loading - need to renew to ajax single load style
//        for (StyleEntity ent: style) {
//            ent.setCount(styleRepository.nativeCountStyle(ent.getId()));
//        }


        String idOrder = order.equals("idAsc") ? "idDesc" : "idAsc";
        String styleOrder = order.equals("styleAsc") ? "styleDesc" : "styleAsc";
        String rootOrder = order.equals("rootAsc") ? "rootDesc" : "rootAsc";

        model.addAttribute("idOrder", idOrder);
        model.addAttribute("styleOrder", styleOrder);
        model.addAttribute("rootOrder", rootOrder);

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

    @GetMapping({"/viewStyleNameOrder/{order}/{styleName}"})
    public String viewStyleNameOrder(@PathVariable String styleName, @PathVariable String order, Model model) {

        StyleEntity byNameIs = styleRepository.findByNameIs(styleName);
        Integer styleId = byNameIs.getId();
        Optional<StyleEntity> byIdSingle = styleRepository.findById(styleId);
        StyleEntity byIdSingle1 = styleRepository.findByIdIs(styleId);

        List<AllEntity> allByStyleAllContains = new ArrayList<>();
        switch (order) {
            case "idAsc" :
                allByStyleAllContains = repository.findAllByStyleAllContainsOrderByTrackIdAsc(byIdSingle1.getName());
                break;
            case "idDesc" :
                allByStyleAllContains = repository.findAllByStyleAllContainsOrderByTrackIdDesc(byIdSingle1.getName());
                break;
            case "artistAsc" :
                allByStyleAllContains = repository.findAllByStyleAllContainsOrderByDisplayArtistAsc(byIdSingle1.getName());
                break;
            case "artistDesc" :
                allByStyleAllContains = repository.findAllByStyleAllContainsOrderByDisplayArtistDesc(byIdSingle1.getName());
                break;
            case "titleAsc" :
                allByStyleAllContains = repository.findAllByStyleAllContainsOrderByTrackAsc(byIdSingle1.getName());
                break;
            case "titleDesc" :
                allByStyleAllContains = repository.findAllByStyleAllContainsOrderByTrackDesc(byIdSingle1.getName());
                break;
            case "styleAsc" :
                allByStyleAllContains = repository.findAllByStyleAllContainsOrderByStyleAsc(byIdSingle1.getName());
                break;
            case "styleDesc" :
                allByStyleAllContains = repository.findAllByStyleAllContainsOrderByStyleDesc(byIdSingle1.getName());
                break;
            case "upAsc" :
                allByStyleAllContains = repository.findAllByStyleAllContainsOrderByVoteUpAsc(byIdSingle1.getName());
                break;
            case "upDesc" :
                allByStyleAllContains = repository.findAllByStyleAllContainsOrderByVoteUpDesc(byIdSingle1.getName());
                break;
            case "downAsc" :
                allByStyleAllContains = repository.findAllByStyleAllContainsOrderByVoteDownAsc(byIdSingle1.getName());
                break;
            case "downDesc" :
                allByStyleAllContains = repository.findAllByStyleAllContainsOrderByVoteDownDesc(byIdSingle1.getName());
                break;
            default:
                allByStyleAllContains = repository.findAllByStyleAllContains(byIdSingle1.getName());
        }
        System.out.println(byIdSingle.get().getName());
        System.out.println(byIdSingle1.getName());

        String idOrder = order.equals("idAsc") ? "idDesc" : "idAsc";
        String artistOrder = order.equals("artistAsc") ? "artistDesc" : "artistAsc";
        String titleOrder = order.equals("titleAsc") ? "titleDesc" : "titleAsc";
        String styleOrder = order.equals("styleAsc") ? "styleDesc" : "styleAsc";
        String upOrder = order.equals("upAsc") ? "upDesc" : "upAsc";
        String downOrder = order.equals("downAsc") ? "downDesc" : "downAsc";




        model.addAttribute("idOrder", idOrder);
        model.addAttribute("artistOrder", artistOrder);
        model.addAttribute("titleOrder", titleOrder);
        model.addAttribute("styleOrder", styleOrder);
        model.addAttribute("upOrder", upOrder);
        model.addAttribute("downOrder", downOrder);

        model.addAttribute("search", byIdSingle.get().getName());
        model.addAttribute("count", allByStyleAllContains.size());
        model.addAttribute("songs", allByStyleAllContains);
        model.addAttribute("styleCountMagicQuery", styleRepository.nativeCountStyle(styleId));

        return "indexStyleSongs";
    }

}
