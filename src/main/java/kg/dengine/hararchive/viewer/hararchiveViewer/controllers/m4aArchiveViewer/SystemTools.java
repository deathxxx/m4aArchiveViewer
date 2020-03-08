package kg.dengine.hararchive.viewer.hararchiveViewer.controllers.m4aArchiveViewer;

import com.sun.xml.internal.messaging.saaj.util.FinalArrayList;
import kg.dengine.hararchive.viewer.hararchiveViewer.entity.AllEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.entity.StyleEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.other.ReadFilesTxtBase;
import kg.dengine.hararchive.viewer.hararchiveViewer.other.txtb.TxtBase0;
import kg.dengine.hararchive.viewer.hararchiveViewer.other.txtb.TxtBase1;
import kg.dengine.hararchive.viewer.hararchiveViewer.other.txtb.TxtBase2;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.AllSongRepository;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/systemTools")
public class SystemTools {
    @Autowired
    private AllSongRepository repository;

    @Autowired
    private StyleRepository styleRepository;

    @Value("${spring.application.name}")
    String appName;

    @GetMapping({"/system", "/"})
    public String homePageStyle(Model model) {
        model.addAttribute("appName", appName);

        return "systemTools/index";
    }

    @GetMapping("/viewTxtBase")
    public String viewTxtBase(Model model) {
        ReadFilesTxtBase readFilesTxtBase = new ReadFilesTxtBase();
        Map<String, String> styles = readFilesTxtBase.styles();

//        List<Map<String, String>> mapsList = new ArrayList<Map<String, String>>();
//        mapsList.add(styles);
//        model.addAttribute("styles",mapsList);

        model.addAttribute("styles", styles);

        return "systemTools/viewTxtBase";
    }

    @GetMapping("/viewTxtBaseAll")
    public String viewTxtBaseAll(Model model) {
        ReadFilesTxtBase readFilesTxtBase = new ReadFilesTxtBase();
        Map<String, String> styles = readFilesTxtBase.GetSavedFiles();
        model.addAttribute("styles", styles);

        return "systemTools/viewTxtBase";


    }


    @GetMapping("/viewTreeTest")
    public String viewTreeTest(Model model) {
        ReadFilesTxtBase readFilesTxtBase = new ReadFilesTxtBase();
//        Map<String, String> styles = readFilesTxtBase.GetSavedFiles();
//        model.addAttribute("styles", styles);

        return "systemTools/tree-test";


    }


    @GetMapping("/viewTreeMap")
    public String viewTreeMap(Model model) {
        ReadFilesTxtBase readFilesTxtBase = new ReadFilesTxtBase();
//        Map<String, String> styles = readFilesTxtBase.GetSavedFiles();
//        model.addAttribute("styles", styles);

        TxtBase0 d0 = new TxtBase0();
        TxtBase1 d1 = new TxtBase1();
        TxtBase2 d2 = new TxtBase2();

        System.out.println(d0.root());
        System.out.println(d1.root());
        Map<String,Map<String,Map<String,String>>> all = new HashMap<>();
        for (Map.Entry<String, String> entry0 : d0.root().entrySet()) {                         //root
//            System.out.println(entry0.getKey() + "/" + entry0.getValue());
            Map<String,Map<String,String>> allSt = new HashMap<>();
            for (Map.Entry<String, String> entry1 : d1.root().entrySet()) {                     //mediafolder
                if(entry0.getKey().equals(entry1.getValue())){
                      System.out.println(d2.get(entry1.getKey()));
                    for(Map.Entry<String,String> entry2 : d2.get(entry1.getKey()).entrySet()){  //style
                        if(entry2.getValue().equals(entry1.getKey())) {
                            allSt.put(entry1.getKey(),d2.get(entry1.getKey()));
                        }
                    }
                    all.put(entry0.getKey(), allSt);
                    System.out.println(entry1.getKey() + "/" + entry1.getValue());
                }


            }
        }
        System.out.println(all);

        model.addAttribute("all", all);
        return "systemTools/tree-map";


    }



    @GetMapping("/updateStyleRootFolder")
    public String updateStyleRootFolder(Model model) {

        ReadFilesTxtBase readFilesTxtBase = new ReadFilesTxtBase();

        Map<String, String> styles = readFilesTxtBase.styles();
        System.out.println(styles.size());
        for (Map.Entry<String, String> entry : styles.entrySet()) {
            StyleEntity styleByNameIs = styleRepository.findByNameIs(entry.getKey());
            if(entry.getValue() != null ) {
                styleByNameIs.setRootFolder(entry.getValue());
                styleRepository.save(styleByNameIs);
            }
//            System.out.print(entry.getKey() + " - ");
//            System.out.println(styleByNameIs.getId());
        }
        return "indexStyle";

    }

    @GetMapping("/updateFoldersToBase")
    public String updateFolderToBase(Model model) {

        ReadFilesTxtBase readFilesTxtBase = new ReadFilesTxtBase();
        Map<String, String> filesFolders = readFilesTxtBase.GetSavedFiles();

        for (Map.Entry<String, String> entry : filesFolders.entrySet()) {
            System.out.print(entry.getKey() + "/" + entry.getValue() + " \t ");
            String track = entry.getKey();
            String folder = entry.getValue();
            if(!track.equals("")) {
                track = entry.getKey().substring(0,entry.getKey().length()-4);

                List<AllEntity> byTrack = repository.findByTrack(track);
                if (byTrack.size() == 1) {
//                System.out.println(byTrack.size());

                    AllEntity byTrackIs = byTrack.get(0);
//                    AllEntity byTrackIs = repository.findByTrackIs(track);
                    System.out.print(byTrackIs.getTrackId() + " \t ");
                    if (byTrackIs.getFolder() == null) {
                        byTrackIs.setFolder(folder);
                        AllEntity save = repository.save(byTrackIs);
                        System.out.println(" - saved");
                    } else {
                        System.out.println("\n");
                    }
                } else {
                    for (AllEntity byTrackIs: byTrack) {
                        if (byTrackIs.getFolder() == null) {
                            byTrackIs.setFolder(folder);
                            AllEntity save = repository.save(byTrackIs);
                            System.out.print(" - saved double - \t");
                        } else {

                        }
                    }
//                    System.out.println("\n");
                    System.out.println("!!!many result");
                }

            }
        }

        model.addAttribute("count", "0");
        return "indexStyle";
    }


    @GetMapping("/updateFoldersToBaseSelected")
    public String updateFolderToBaseSelected(Model model) {

        ReadFilesTxtBase readFilesTxtBase = new ReadFilesTxtBase();
        Map<String, String> filesFolders = readFilesTxtBase.GetSavedFiles();

        List<AllEntity> allByStyle = new ArrayList<>();
        List<AllEntity> allByStyleToSave = new ArrayList<>();

        List<StyleEntity> mp4Jazz = styleRepository.findByRootFolderIs("mp4");
        for (StyleEntity st: mp4Jazz ) {
            allByStyle.addAll(repository.getAllByStyleNoFolder(st.getId()));
//            allByStyle.addAll(repository.getAllByStyle(st.getId()));
        }
        System.out.println(allByStyle.size());

        int i = 0;
        for (AllEntity ent: allByStyle             ) {
            String folder = filesFolders.get(ent.getTrack() + ".m4a");
            if (folder != null) {
                if (ent.getFolder() == null) {
                    ent.setFolder(folder);
                    allByStyleToSave.add(ent);
                    System.out.print(folder);
                    i++;
                    repository.save(ent);
                }
            }
        }
        System.out.println();
        System.out.println(i);
        System.out.println(allByStyleToSave.size());

//        repository.saveAll(allByStyleToSave);


//        for (Map.Entry<String, String> entry : filesFolders.entrySet()) {
//            System.out.println(entry.getKey() );
//        }

//        String s = filesFolders.get("02 - Green Eyes.m4a");
//        String s = filesFolders.get("Jair Rodrigues - Rio.m4a");
//        System.out.println(s);
/*            System.out.print(entry.getKey() + "/" + entry.getValue() + " \t ");
            String track = entry.getKey();
            String folder = entry.getValue();
            if(!track.equals("")) {
                track = entry.getKey().substring(0,entry.getKey().length()-4);

                List<AllEntity> byTrack = repository.findByTrack(track);
                if (byTrack.size() == 1) {
//                System.out.println(byTrack.size());

                    AllEntity byTrackIs = byTrack.get(0);
//                    AllEntity byTrackIs = repository.findByTrackIs(track);
                    System.out.print(byTrackIs.getTrackId() + " \t ");
                    if (byTrackIs.getFolder() == null) {
                        byTrackIs.setFolder(folder);
                        AllEntity save = repository.save(byTrackIs);
                        System.out.println(" - saved");
                    } else {
                        System.out.println("\n");
                    }
                } else {
                    for (AllEntity byTrackIs: byTrack) {
                        if (byTrackIs.getFolder() == null) {
                            byTrackIs.setFolder(folder);
                            AllEntity save = repository.save(byTrackIs);
                            System.out.print(" - saved double - \t");
                        } else {

                        }
                    }
//                    System.out.println("\n");
                    System.out.println("!!!many result");
                }

            }
        }

        model.addAttribute("count", "0");
*/
        return "indexStyle";
    }

}
