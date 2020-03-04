package kg.dengine.hararchive.viewer.hararchiveViewer.controllers.m4aArchiveViewer;

import com.sun.xml.internal.messaging.saaj.util.FinalArrayList;
import kg.dengine.hararchive.viewer.hararchiveViewer.entity.AllEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.entity.StyleEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.other.ReadFilesTxtBase;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.AllSongRepository;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class SystemTools {
    @Autowired
    private AllSongRepository repository;

    @Autowired
    private StyleRepository styleRepository;

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
