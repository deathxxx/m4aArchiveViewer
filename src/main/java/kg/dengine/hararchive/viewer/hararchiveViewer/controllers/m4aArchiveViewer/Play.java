package kg.dengine.hararchive.viewer.hararchiveViewer.controllers.m4aArchiveViewer;

import kg.dengine.hararchive.viewer.hararchiveViewer.entity.AllEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.entity.StyleEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.other.ReadFilesTxtBase;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.AllSongRepository;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.ArtistRepository;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

@Controller
public class Play {

    @Autowired
    private AllSongRepository repository;

    @Autowired
    private StyleRepository styleRepository;

    public static String mainPath = "/home/dex/Projects/Music/";
//    public static String mainPath = "/media/dex/Music/";

    private ResponseEntity getResponseEntity(String path) {
        String file = path;

        long length = new File(file).length();

        InputStreamResource inputStreamResource = null;
        try {
            inputStreamResource = new InputStreamResource( new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentLength(length);
        httpHeaders.setCacheControl(CacheControl.noCache().getHeaderValue());
        return new ResponseEntity(inputStreamResource, httpHeaders, HttpStatus.OK);
    }
    @RequestMapping(value = "/play/{id}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_OCTET_STREAM_VALUE })
    public ResponseEntity playAudioById(HttpServletRequest request, HttpServletResponse response,
                                        @PathVariable("id") Long trackId) throws FileNotFoundException {

        AllEntity track = repository.findByTrackId(trackId);
//        System.out.println(track.getStyle());
        StyleEntity style = styleRepository.findByNameIs(track.getStyle());
        String path = "";
        if(!track.getFolder().equals("")) {
            path = mainPath + style.getRootFolder()+"/"+style.getName()+"/"+track.getFolder()+"/"+track.getTrack()+".m4a";
//            path = mainPath + style.getRootFolder()+"/"+style.getName()+"/"+track.getFolder()+"/"+track.getTrack()+".m4a";
        }

        return getResponseEntity(path);
    }

    @RequestMapping(value = "/playSpecialFolderRoot/{root}/{style}/{folder}/{id}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_OCTET_STREAM_VALUE })
    public ResponseEntity playAudioByIdInSpecialFolder(HttpServletRequest request, HttpServletResponse response,
                                                       @PathVariable("root") String root,
                                                       @PathVariable("style") String style,
                                                       @PathVariable("folder") String folder,
                                                       @PathVariable("id") Long trackId
    ) throws FileNotFoundException {
        AllEntity track = repository.findByTrackId(trackId);
        String path = mainPath + root + "/" + style + "/" + folder + "/" + track.getTrack()+".m4a";

        return getResponseEntity(path);
    }

    @RequestMapping(value = "/playSpecialFolder/{style}/{folder}/{id}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_OCTET_STREAM_VALUE })
    public ResponseEntity playAudioByIdAccordingByStyle(HttpServletRequest request, HttpServletResponse response,
                                                       @PathVariable("style") String style,
                                                       @PathVariable("folder") String folder,
                                                       @PathVariable("id") Long trackId
    ) throws FileNotFoundException {
        AllEntity track = repository.findByTrackId(trackId);
        StyleEntity styleEnt = styleRepository.findByNameIs(track.getStyle());
        String path = mainPath + styleEnt.getRootFolder() + "/" + style + "/" + folder + "/" + track.getTrack()+".m4a";

        return getResponseEntity(path);
    }

}
