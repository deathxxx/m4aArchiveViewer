package kg.dengine.hararchive.viewer.hararchiveViewer.other;

import com.sun.org.apache.regexp.internal.RE;
import kg.dengine.hararchive.viewer.hararchiveViewer.entity.AllEntity;
import kg.dengine.hararchive.viewer.hararchiveViewer.repository.AllSongRepository;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ReadFilesTxtBase {

    AllSongRepository repository;

    public static void main(String[] args) {
        ReadFilesTxtBase readFilesTxtBase = new ReadFilesTxtBase();
        readFilesTxtBase.Start();
    }

    public void Start(){
        /** song/timestamp **/
        Map<String, String> filesFolders = GetSavedFiles();
        System.out.println(filesFolders.size());
        for (Map.Entry<String, String> entry : filesFolders.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
            String track = entry.getKey();
            String folder = entry.getValue();
            //doesnt work in console (only spring)
//            if(!track.equals("")) {
//                List<AllEntity> byTrack = repository.findByTrack(track);
//                System.out.println(byTrack.size());
//            }
        }
    }

    public Map<String,String> styles(){
        Map<String,String> stat = new HashMap<>();

        //<editor-fold desc="заполняем все скаыиваемые стили - те которые конкретно скачивают аудио файлы">
        stat.put("club-dubstep",      "mp4");
        stat.put("ambient",           "mp4");
        stat.put("chillout",          "mp4");
        stat.put("chilloutdreams",    "mp4");
        stat.put("trap",              "mp4");
        stat.put("vocaltrance",       "mp4");
        stat.put("vocallounge",       "mp4");
        stat.put("spacemusic",        "mp4");
        stat.put("liquidtrap",        "mp4");
        stat.put("atmosphericbreaks", "mp4");
        stat.put("psychill",          "mp4");
        stat.put("progressivepsy",    "mp4");
        stat.put("jungle",            "mp4");
        stat.put("jazzhouse",         "mp4");
        stat.put("goapsy",            "mp4");
        stat.put("drumstep",          "mp4");
        stat.put("vocalchillout",     "mp4");
        stat.put("hardstyle",         "mp4");

        stat.put("00sclubhits",       "mp4");
        stat.put("nightcore",         "mp4");
        stat.put("melodicprogressive","mp4");
        stat.put("ebm",               "mp4");
        stat.put("edm",               "mp4");
        stat.put("idm",               "mp4");
        stat.put("nudisco",           "mp4");

        stat.put("minimal",           "mp4");
        stat.put("liquiddnb",         "mp4");
        stat.put("drumandbass",       "mp4");
        stat.put("dub",               "mp4");

        stat.put("bassnjackinhouse",  "mp4");
        stat.put("breaks",            "mp4");
        stat.put("bigroomhouse",      "mp4");
        stat.put("bigbeat",           "mp4");
        stat.put("bassline",          "mp4");

        stat.put("chillntropicalhouse","mp4");
        stat.put("chillhop",          "mp4");
        stat.put("chillstep",         "mp4");
        stat.put("classiceurodance",  "mp4");
        stat.put("classiceurodisco",  "mp4");
        stat.put("classictrance",     "mp4");
        stat.put("club",              "mp4");

        stat.put("darkdnb",         "mp4");
        stat.put("darkpsytrance",   "mp4");
        stat.put("deephouse",       "mp4");
        stat.put("deepnudisco",     "mp4");
        stat.put("deeptech",        "mp4");
        stat.put("detroithousentechno", "mp4");
        stat.put("discohouse",      "mp4");
        stat.put("djmixes",         "mp4");
        stat.put("downtempolounge", "mp4");
        stat.put("dubtechno",       "mp4");
        stat.put("dubstep",         "mp4");

        stat.put("eclectronica",    "mp4");
        stat.put("electro",         "mp4");
        stat.put("electroswing",    "mp4");
        stat.put("electronicpioneers","mp4");
        stat.put("electronics",     "mp4");
        stat.put("electropop",      "mp4");
        stat.put("epictrance",      "mp4");
        stat.put("eurodance",       "mp4");

        stat.put("funkyhouse",      "mp4");
        stat.put("futurebass",      "mp4");
        stat.put("futuregarage",    "mp4");
        stat.put("futuresynthpop",  "mp4");
        stat.put("gabber",          "mp4");
        stat.put("glitchhop",       "mp4");


        stat.put("handsup",         "mp4");
        stat.put("harddance",       "mp4");
        stat.put("hardtechno",      "mp4");
        stat.put("hardcore",        "mp4");
        stat.put("house",           "mp4");
        stat.put("indiebeats",      "mp4");
        stat.put("indiedance",      "mp4");
        stat.put("latinhouse",      "mp4");
        stat.put("liquiddubstep",   "mp4");
        stat.put("lofihiphop",      "mp4");
        stat.put("lounge",          "mp4");
        stat.put("mainstage",       "mp4");
        stat.put("oldschoolacid",   "mp4");
        stat.put("oldschoolhouse",  "mp4");
        stat.put("oldschoolrave",   "mp4");
        stat.put("classictechno",   "mp4");
        stat.put("progressive",     "mp4");
        stat.put("psybient",        "mp4");
        stat.put("russianclubhits", "mp4");
        stat.put("soulfulhouse",    "mp4");
        stat.put("synthwave",       "mp4");
        stat.put("techhouse",       "mp4");
        stat.put("techno",          "mp4");
        stat.put("trance",          "mp4");
        stat.put("tribalhouse",     "mp4");
        stat.put("umfradio",        "mp4");
        stat.put("undergroundtechno","mp4");
        stat.put("vocalhouse",      "mp4");


        stat.put("lofiloungenchill","mp4");
        stat.put("chilledm",        "mp4");
        stat.put("deepprogressivehouse","mp4");
        stat.put("summerchillhouse","mp4");















        stat.put("00srock",         "mp4Rock");
        stat.put("60srock",         "mp4Rock");
        stat.put("70srock",         "mp4Rock");
        stat.put("alternative80s",  "mp4Rock");
        stat.put("80srock",         "mp4Rock");
        stat.put("alternative90s",  "mp4Rock");
        stat.put("90srock",         "mp4Rock");
        stat.put("alternativerock", "mp4Rock");
        stat.put("blackmetal",      "mp4Rock");
        stat.put("bluesrock",       "mp4Rock");
        stat.put("classicfolkrock", "mp4Rock");
        stat.put("classichardrock","mp4Rock");
        stat.put("classicmetal",   "mp4Rock");
        stat.put("classicrock",    "mp4Rock");
        stat.put("deathmetal",     "mp4Rock");
        stat.put("grunge",         "mp4Rock");
        stat.put("hairbands",      "mp4Rock");
        stat.put("hardrock",       "mp4Rock");
        stat.put("heavymetal",     "mp4Rock");
        stat.put("indierock",      "mp4Rock");
        stat.put("industrial",     "mp4Rock");
        stat.put("latinrock",      "mp4Rock");
        stat.put("melodicdeathmetal","mp4Rock");
        stat.put("metal",          "mp4Rock");
        stat.put("metalcore",      "mp4Rock");
        stat.put("modernfolkrock", "mp4Rock");
        stat.put("modernrock",     "mp4Rock");
        stat.put("numetal",        "mp4Rock");
        stat.put("poprock",        "mp4Rock");
        stat.put("powermetal",     "mp4Rock");
        stat.put("progressiverock","mp4Rock");
        stat.put("punkrock",       "mp4Rock");
        stat.put("rockballads",    "mp4Rock");
        stat.put("screamoemo",     "mp4Rock");
        stat.put("softrock",       "mp4Rock");
        stat.put("symphonicmetal", "mp4Rock");
        stat.put("thrashmetal",    "mp4Rock");
        stat.put("yachtrock",      "mp4Rock");







        stat.put("bassjazz",       "mp4Jazz");
        stat.put("bebop",          "mp4Jazz");
        stat.put("blues",          "mp4Jazz");
        stat.put("bluesrockJazz",  "mp4Jazz");//
        stat.put("bossanova",      "mp4Jazz");
        stat.put("classicjazz",    "mp4Jazz");
        stat.put("vocaljazz",      "mp4Jazz");
        stat.put("cooljazz",       "mp4Jazz");
        stat.put("currentjazz",    "mp4Jazz");
        stat.put("davekoz",        "mp4Jazz");
        stat.put("fusionlounge",   "mp4Jazz");
        stat.put("guitarjazz",     "mp4Jazz");
        stat.put("gypsyjazz",      "mp4Jazz");
        stat.put("hardbop",        "mp4Jazz");
        stat.put("jazzballads",    "mp4Jazz");
        stat.put("latinjazz",      "mp4Jazz");
        stat.put("mellowjazz",     "mp4Jazz");
        stat.put("mellowpianojazz","mp4Jazz");
        stat.put("mellowsmoothjazz","mp4Jazz");
        stat.put("modernbigband",  "mp4Jazz");
        stat.put("pariscafe",      "mp4Jazz");
        stat.put("pianojazz",      "mp4Jazz");
        stat.put("pianotrios",     "mp4Jazz");
        stat.put("saxophonejazz",  "mp4Jazz");
        stat.put("sinatrastyle",   "mp4Jazz");
        stat.put("smoothbossanova","mp4Jazz");
        stat.put("smoothjazz",     "mp4Jazz");
        stat.put("smoothjazz247",  "mp4Jazz");
        stat.put("smoothlounge",   "mp4Jazz");
        stat.put("smoothuptempo",  "mp4Jazz");
        stat.put("smoothvocals",   "mp4Jazz");
        stat.put("straightahead",  "mp4Jazz");
        stat.put("swingnbigband",  "mp4Jazz");
        stat.put("timelessclassics","mp4Jazz");
        stat.put("trumpetjazz",    "mp4Jazz");
        stat.put("vibraphonejazz", "mp4Jazz");
        stat.put("vocallegends",   "mp4Jazz");

        stat.put("jazzhop",        "mp4Jazz");
        stat.put("coffeejazz",     "mp4Jazz");



        stat.put("christmas",          "mp4Other");
        stat.put("holidayjazz",        "mp4Other");
        stat.put("classicvocaltrance", "mp4Other");
        stat.put("bolero",             "mp4Other");
        stat.put("classicalchristmas", "mp4Other");
        stat.put("flamenco",           "mp4Other");
        stat.put("flamencojazz",       "mp4Other");
        stat.put("halloween",          "mp4Other");
        stat.put("holidaysmoothjazz",  "mp4Other");
//        stat.put("holidaysmoothjazz2",  "mp4Other");
//        stat.put("latinrock",  "mp4Other");
//        stat.put("downtempolounge",  "mp4Other");
        stat.put("nortena",            "mp4Other");
        stat.put("popchristmas",       "mp4Other");
        stat.put("tango",              "mp4Other");



        stat.put("20thcentury",          "mp4Classic");
        stat.put("21stcentury",          "mp4Classic");
        stat.put("adagios",              "mp4Classic");
        stat.put("bach",                 "mp4Classic");
        stat.put("ballets",              "mp4Classic");
        stat.put("baroqueperiod",        "mp4Classic");
        stat.put("beethoven",            "mp4Classic");
        stat.put("brahms",               "mp4Classic");
        stat.put("celloworks",           "mp4Classic");
        stat.put("chamberworks",         "mp4Classic");
        stat.put("chopin",               "mp4Classic");
        stat.put("choralworks",          "mp4Classic");
        stat.put("classicalguitarworks", "mp4Classic");
        stat.put("classicalperiod",      "mp4Classic");
        stat.put("classicalpianotrios",  "mp4Classic");
        stat.put("classicalrelaxation",  "mp4Classic");
        stat.put("concertos",            "mp4Classic");
        stat.put("contemporaryperiod",   "mp4Classic");
        stat.put("easyclassical",        "mp4Classic");
        stat.put("fluteworks",           "mp4Classic");
        stat.put("gregorianchant",       "mp4Classic");
        stat.put("grieg",                "mp4Classic");
        stat.put("handel",               "mp4Classic");
        stat.put("harpsichordworks",     "mp4Classic");
        stat.put("haydn",                "mp4Classic");
        stat.put("medievalperiod",       "mp4Classic");
        stat.put("mozart",               "mp4Classic");
        stat.put("operahighlights",      "mp4Classic");
        stat.put("operas",               "mp4Classic");
        stat.put("orchestralworks",      "mp4Classic");
        stat.put("organworks",           "mp4Classic");
        stat.put("overtures",            "mp4Classic");
        stat.put("pianoworks",           "mp4Classic");
        stat.put("renaissanceperiod",    "mp4Classic");
        stat.put("romanticperiod",       "mp4Classic");
        stat.put("sacredworks",          "mp4Classic");
        stat.put("schubert",             "mp4Classic");
        stat.put("shostakovich",         "mp4Classic");
        stat.put("soloinstruments",      "mp4Classic");
        stat.put("solopiano",            "mp4Classic");
        stat.put("sonatas",              "mp4Classic");
        stat.put("songsnlieders",        "mp4Classic");
        stat.put("stringworks",          "mp4Classic");
        stat.put("symphonies",           "mp4Classic");
        stat.put("tchaikovsky",          "mp4Classic");
        stat.put("trumpetworks",         "mp4Classic");
        stat.put("violinworks",          "mp4Classic");
        stat.put("vivaldi",              "mp4Classic");
        stat.put("waltzespolkasnmarches","mp4Classic");
        stat.put("windworks",            "mp4Classic");

        stat.put("debussy",              "mp4Classic");
        stat.put("nocturnes",            "mp4Classic");
        stat.put("liszt",                "mp4Classic");
        stat.put("telemann",             "mp4Classic");


        stat.put("00scountry",        "mp4RadioTunes");
        stat.put("00sdance",          "mp4RadioTunes");
        stat.put("hit00s",            "mp4RadioTunes");
        stat.put("00srnb",            "mp4RadioTunes");
//        stat.put("00srock",           "mp4RadioTunes");
        stat.put("hit60s",            "mp4RadioTunes");
//        stat.put("60srock",           "mp4RadioTunes");
        stat.put("hit70s",            "mp4RadioTunes");
//        stat.put("70srock",           "mp4RadioTunes");
        stat.put("80saltnnewwave",    "mp4RadioTunes");
        stat.put("80sdance",          "mp4RadioTunes");
        stat.put("the80s",            "mp4RadioTunes");
//        stat.put("80srock",           "mp4RadioTunes");
        stat.put("90scountry",        "mp4RadioTunes");
        stat.put("90sdance",          "mp4RadioTunes");
        stat.put("hit90s",            "mp4RadioTunes");
        stat.put("90srnb",            "mp4RadioTunes");
//        stat.put("90srock",           "mp4RadioTunes");
        stat.put("altrock",           "mp4RadioTunes");
//        stat.put("ambient",           "mp4RadioTunes");
        stat.put("americansongbook",  "mp4RadioTunes");
        stat.put("baroque",           "mp4RadioTunes");
//        stat.put("bebop",             "mp4RadioTunes");
//        stat.put("bluesrock",         "mp4RadioTunes");
//        stat.put("bossanova",         "mp4RadioTunes");
        stat.put("cafedeparis",       "mp4RadioTunes");
//        stat.put("chillntropicalhouse""mp4RadioTunes");
//        stat.put("chillout",          "mp4RadioTunes");
        stat.put("classicrap",        "mp4RadioTunes");
        stat.put("classicmotown",     "mp4RadioTunes");
//        stat.put("classicrock",       "mp4RadioTunes");
        stat.put("guitar",            "mp4RadioTunes");
//        stat.put("classicalperiod",   "mp4RadioTunes");
//        stat.put("classicalpianotrios""mp4RadioTunes");
        stat.put("clubbollywood",     "mp4RadioTunes");
        stat.put("christian",         "mp4RadioTunes");
        stat.put("country",           "mp4RadioTunes");
        stat.put("cubanlounge",       "mp4RadioTunes");
        stat.put("dancehits",         "mp4RadioTunes");
        stat.put("datempolounge",     "mp4RadioTunes");
//        stat.put("davekoz",           "mp4RadioTunes");
        stat.put("discoparty",        "mp4RadioTunes");
//        stat.put("downtempolounge",   "mp4RadioTunes");
        stat.put("dreamscapes",       "mp4RadioTunes");
        stat.put("ASCO",              "mp4RadioTunes");
//        stat.put("eurodance",         "mp4RadioTunes");
//        stat.put("hardrock",          "mp4RadioTunes");
//        stat.put("indiedance",        "mp4RadioTunes");
//        stat.put("indierock",         "mp4RadioTunes");
        stat.put("jazzclassics",      "mp4RadioTunes");
        stat.put("jpop",              "mp4RadioTunes");
        stat.put("latinpophits",      "mp4RadioTunes");
//        stat.put("lounge",            "mp4RadioTunes");
        stat.put("lovemusic",         "mp4RadioTunes");
        stat.put("meditation",        "mp4RadioTunes");
//        stat.put("mellowjazz",        "mp4RadioTunes");
//        stat.put("mellowsmoothjazz",  "mp4RadioTunes");
//        stat.put("metal",             "mp4RadioTunes");
        stat.put("modernblues",       "mp4RadioTunes");
//        stat.put("modernrock",        "mp4RadioTunes");
        stat.put("classical",         "mp4RadioTunes");
        stat.put("soundtracks",       "mp4RadioTunes");
//        stat.put("mozart",            "mp4RadioTunes");
        stat.put("nature",            "mp4RadioTunes");
        stat.put("newage",            "mp4RadioTunes");
        stat.put("oldschoolfunknsoul","mp4RadioTunes");
        stat.put("oldies",            "mp4RadioTunes");
//        stat.put("pianojazz",         "mp4RadioTunes");
//        stat.put("poprock",           "mp4RadioTunes");
        stat.put("reggaeton",         "mp4RadioTunes");
        stat.put("relaxation",        "mp4RadioTunes");
        stat.put("relaxingambientpiano","mp4RadioTunes");
        stat.put("romantic",          "mp4RadioTunes");
        stat.put("romantica",         "mp4RadioTunes");
        stat.put("romanticalatina",   "mp4RadioTunes");
        stat.put("rootsreggae",       "mp4RadioTunes");
        stat.put("salsa",             "mp4RadioTunes");
        stat.put("sleeprelaxation",   "mp4RadioTunes");
        stat.put("slowjams",          "mp4RadioTunes");
        stat.put("smoothbeats",       "mp4RadioTunes");
//        stat.put("smoothbossanova",   "mp4RadioTunes");
//        stat.put("smoothjazz",        "mp4RadioTunes");
//        stat.put("smoothjazz247",     "mp4RadioTunes");
//        stat.put("smoothlounge",      "mp4RadioTunes");
//        stat.put("softrock",          "mp4RadioTunes");
//        stat.put("solopiano",         "mp4RadioTunes");
        stat.put("tophits",           "mp4RadioTunes");
        stat.put("uptemposmoothjazz", "mp4RadioTunes");
        stat.put("urbanjamz",         "mp4RadioTunes");
        stat.put("urbanpophits",      "mp4RadioTunes");
//        stat.put("vocalchillout",     "mp4RadioTunes");
//        stat.put("vocallounge",       "mp4RadioTunes");
        stat.put("vocalnewage",       "mp4RadioTunes");
        stat.put("vocalsmoothjazz",   "mp4RadioTunes");
        stat.put("world",             "mp4RadioTunes");


//        stat.put("meditation",          "mp4Zenradio");
//        stat.put("relaxation",          "mp4Zenradio");
//        stat.put("nature",              "mp4Zenradio");
//        stat.put("chilloutdreams",      "mp4Zenradio");
//        stat.put("newage",              "mp4Zenradio");
//        stat.put("vocalnewage",         "mp4Zenradio");
        stat.put("spacedreams",         "mp4Zenradio");
//        stat.put("ambient",             "mp4Zenradio");
//        stat.put("chillout",            "mp4Zenradio");
//        stat.put("vocalchillout",       "mp4Zenradio");
        stat.put("babysleep",           "mp4Zenradio");
        stat.put("oceansounds",         "mp4Zenradio");
        stat.put("soundsofrain",        "mp4Zenradio");
        stat.put("perfectsunsets",      "mp4Zenradio");
        stat.put("reiki",               "mp4Zenradio");
        stat.put("sleep",               "mp4Zenradio");
        stat.put("flute",               "mp4Zenradio");
//        stat.put("guitar",              "mp4Zenradio");
        stat.put("yoga",                "mp4Zenradio");
        stat.put("zen",                 "mp4Zenradio");
        stat.put("atmosphericdreams",   "mp4Zenradio");
//        stat.put("downtempolounge",     "mp4Zenradio");
        stat.put("relaxingpiano",       "mp4Zenradio");
        stat.put("relaxingclassical",   "mp4Zenradio");
        stat.put("eastasianmeditation", "mp4Zenradio");
        stat.put("study",               "mp4Zenradio");
        stat.put("deepconcentration",   "mp4Zenradio");
        stat.put("deepfocus",           "mp4Zenradio");
        stat.put("lovenrelaxation",     "mp4Zenradio");
        stat.put("peacefulhealing",     "mp4Zenradio");
        stat.put("pregnancyrelaxation", "mp4Zenradio");
        stat.put("shamanic",            "mp4Zenradio");
        stat.put("stressrelief",        "mp4Zenradio");
        stat.put("tibetan",             "mp4Zenradio");
        stat.put("tibetansingingbowls", "mp4Zenradio");
        stat.put("tranquilitynhealing", "mp4Zenradio");
        stat.put("relaxingspanmassage", "mp4Zenradio");
        stat.put("nativeamericanflute", "mp4Zenradio");
        stat.put("acousticvocalchillout","mp4Zenradio");
        stat.put("lovesmoothjazz",      "mp4Zenradio");

        //</editor-fold>1
        System.out.println(stat.size());
        return stat;
    }

    public Map<String, String> ListToMap(List<String> list, String timestamp){
        Map<String, String> foldersSongs = new HashMap<>();

        for ( String song: list ) {
            foldersSongs.put(song,timestamp);
        }
        return foldersSongs;
    }

//    public List<String> GetSavedFiles() {
    public Map<String, String>  GetSavedFiles() {

        Map<String, String> styles = styles();

        Map<String, String> foldersSongs = new HashMap<>();

        List<String> AllStringsFiles = new ArrayList();

        for (Map.Entry<String, String> entry : styles.entrySet()) {
//            System.out.println(entry.getKey() + "/" + entry.getValue());
            String saveMP4Folder = entry.getValue();
            String style = entry.getKey();

            //сохраненные файлы
            List<String> stringsFiles = new ArrayList();
            //<editor-fold desc="сохраненные файлы - все считываем в 1 лист (все стили)">
            if (saveMP4Folder.equals("mp4")) {
                List<String> stringList1 = readFilesStyleMusic(style, "1548407697800", "mp4", false);
                List<String> stringList2 = readFilesStyleMusic(style, "1548925855107", "mp4", false);
                List<String> stringList3 = readFilesStyleMusic(style, "1549276404562", "mp4", false);
                List<String> stringList4 = readFilesStyleMusic(style, "1549433082084", "mp4", false);
                List<String> stringList5 = readFilesStyleMusic(style, "1549531789497", "mp4", false);
                List<String> stringList6 = readFilesStyleMusic(style, "1549624208223", "mp4", false);
                List<String> stringList7 = readFilesStyleMusic(style, "1549861402567", "mp4", false);
                List<String> stringList8 = readFilesStyleMusic(style, "1550031564143", "mp4", false);
                List<String> stringList9 = readFilesStyleMusic(style, "1550126243850", "mp4", false);
                List<String> stringList10 = readFilesStyleMusic(style, "1550549520337", "mp4", false);
                List<String> stringList11 = readFilesStyleMusic(style, "1552970386569", "mp4", false);
                List<String> stringList12 = readFilesStyleMusic(style, "1556531092678", "mp4", false);
                List<String> stringList13 = readFilesStyleMusic(style, "1560397957745", "mp4", false);
                List<String> stringList14 = readFilesStyleMusic(style, "1563257801324", "mp4", false);
                List<String> stringList15 = readFilesStyleMusic(style, "1565838524472", "mp4", false);
                List<String> stringList16 = readFilesStyleMusic(style, "1568610793564", "mp4", false);
                List<String> stringList17 = readFilesStyleMusic(style, "1572928225399", "mp4", false);
                List<String> stringList18 = readFilesStyleMusic(style, "1575437044104", "mp4", false);
                List<String> stringList19 = readFilesStyleMusic(style, "1577428239839", "mp4", false);
                List<String> stringList20 = readFilesStyleMusic(style, "1579606271907", "mp4", false);
                List<String> stringList21 = readFilesStyleMusic(style, "1580873562042", "mp4", false);
                List<String> stringList22 = readFilesStyleMusic(style, "1581482416345", "mp4", false);
                List<String> stringList23 = readFilesStyleMusic(style, "1582167429983", "mp4", false);
                stringsFiles = stringList1;
                stringsFiles.addAll(stringList2);
                stringsFiles.addAll(stringList3);
                stringsFiles.addAll(stringList4);
                stringsFiles.addAll(stringList5);
                stringsFiles.addAll(stringList6);
                stringsFiles.addAll(stringList7);
                stringsFiles.addAll(stringList8);
                stringsFiles.addAll(stringList9);
                stringsFiles.addAll(stringList10);
                stringsFiles.addAll(stringList11);
                stringsFiles.addAll(stringList12);
                stringsFiles.addAll(stringList13);
                stringsFiles.addAll(stringList14);
                stringsFiles.addAll(stringList15);
                stringsFiles.addAll(stringList16);
                stringsFiles.addAll(stringList17);
                stringsFiles.addAll(stringList18);
                stringsFiles.addAll(stringList19);
                stringsFiles.addAll(stringList20);
                stringsFiles.addAll(stringList21);
                stringsFiles.addAll(stringList22);
                stringsFiles.addAll(stringList23);

                foldersSongs.putAll(ListToMap(stringList1,"15484"));
                foldersSongs.putAll(ListToMap(stringList2,"15489"));
                foldersSongs.putAll(ListToMap(stringList3,"15492"));
                foldersSongs.putAll(ListToMap(stringList4,"15494"));
                foldersSongs.putAll(ListToMap(stringList5,"15495"));
                foldersSongs.putAll(ListToMap(stringList6,"15496"));
                foldersSongs.putAll(ListToMap(stringList7,"15498"));
                foldersSongs.putAll(ListToMap(stringList8,"15500"));
                foldersSongs.putAll(ListToMap(stringList9,"15501"));
                foldersSongs.putAll(ListToMap(stringList10,"15505"));
                foldersSongs.putAll(ListToMap(stringList11,"15529"));
                foldersSongs.putAll(ListToMap(stringList12,"15565"));
                foldersSongs.putAll(ListToMap(stringList13,"15603"));
                foldersSongs.putAll(ListToMap(stringList14,"15632"));
                foldersSongs.putAll(ListToMap(stringList15,"15658"));
                foldersSongs.putAll(ListToMap(stringList16,"15686"));
                foldersSongs.putAll(ListToMap(stringList17,"15729"));
                foldersSongs.putAll(ListToMap(stringList18,"15754"));
                foldersSongs.putAll(ListToMap(stringList19,"15774"));
                foldersSongs.putAll(ListToMap(stringList20,"15796"));
                foldersSongs.putAll(ListToMap(stringList21,"15808"));
                foldersSongs.putAll(ListToMap(stringList22,"15814"));
                foldersSongs.putAll(ListToMap(stringList23,"15821"));

            }
//            if (saveMP4Folder.equals("mp4Rock")) {
//                List<String> stringList1 = readFilesStyleMusic(style, "1549626731444", "mp4Rock", false);
//                List<String> stringList2 = readFilesStyleMusic(style, "1549861402567", "mp4Rock", false);
//                List<String> stringList3 = readFilesStyleMusic(style, "1550031564143", "mp4Rock", false);
//                List<String> stringList4 = readFilesStyleMusic(style, "1550126243850", "mp4Rock", false);
//                List<String> stringList5 = readFilesStyleMusic(style, "1550549520337", "mp4Rock", false);
//                List<String> stringList6 = readFilesStyleMusic(style, "1552970386569", "mp4Rock", false);
//                List<String> stringList7 = readFilesStyleMusic(style, "1556531092678", "mp4Rock", false);
//                List<String> stringList8 = readFilesStyleMusic(style, "1560397957745", "mp4Rock", false);
//                List<String> stringList9 = readFilesStyleMusic(style, "1563257801324", "mp4Rock", false);
//                List<String> stringList10 = readFilesStyleMusic(style, "1565838524472", "mp4Rock", false);
//                List<String> stringList11 = readFilesStyleMusic(style, "1568610793564", "mp4Rock", false);
//                List<String> stringList12 = readFilesStyleMusic(style, "1572928225399", "mp4Rock", false);
//                List<String> stringList13 = readFilesStyleMusic(style, "1575437044104", "mp4Rock", false);
//                List<String> stringList14 = readFilesStyleMusic(style, "1577428239839", "mp4Rock", false);
//                List<String> stringList15 = readFilesStyleMusic(style, "1579606271907", "mp4Rock", false);
//                List<String> stringList16 = readFilesStyleMusic(style, "1580873562042", "mp4Rock", false);
//                List<String> stringList17 = readFilesStyleMusic(style, "1581482416345", "mp4Rock", false);
//                List<String> stringList18 = readFilesStyleMusic(style, "1582167429983", "mp4Rock", false);
//                stringsFiles.addAll(stringList1);
//                stringsFiles.addAll(stringList2);
//                stringsFiles.addAll(stringList3);
//                stringsFiles.addAll(stringList4);
//                stringsFiles.addAll(stringList5);
//                stringsFiles.addAll(stringList6);
//                stringsFiles.addAll(stringList7);
//                stringsFiles.addAll(stringList8);
//                stringsFiles.addAll(stringList9);
//                stringsFiles.addAll(stringList10);
//                stringsFiles.addAll(stringList11);
//                stringsFiles.addAll(stringList12);
//                stringsFiles.addAll(stringList13);
//                stringsFiles.addAll(stringList14);
//                stringsFiles.addAll(stringList15);
//                stringsFiles.addAll(stringList16);
//                stringsFiles.addAll(stringList17);
//                stringsFiles.addAll(stringList18);
//
//                foldersSongs.putAll(ListToMap(stringList1,"15496"));
//                foldersSongs.putAll(ListToMap(stringList2,"15498"));
//                foldersSongs.putAll(ListToMap(stringList3,"15500"));
//                foldersSongs.putAll(ListToMap(stringList4,"15501"));
//                foldersSongs.putAll(ListToMap(stringList5,"15505"));
//                foldersSongs.putAll(ListToMap(stringList6,"15529"));
//                foldersSongs.putAll(ListToMap(stringList7,"15565"));
//                foldersSongs.putAll(ListToMap(stringList8,"15603"));
//                foldersSongs.putAll(ListToMap(stringList9,"15632"));
//                foldersSongs.putAll(ListToMap(stringList10,"15658"));
//                foldersSongs.putAll(ListToMap(stringList11,"15686"));
//                foldersSongs.putAll(ListToMap(stringList12,"15729"));
//                foldersSongs.putAll(ListToMap(stringList13,"15754"));
//                foldersSongs.putAll(ListToMap(stringList14,"15774"));
//                foldersSongs.putAll(ListToMap(stringList15,"15796"));
//                foldersSongs.putAll(ListToMap(stringList16,"15808"));
//                foldersSongs.putAll(ListToMap(stringList17,"15814"));
//                foldersSongs.putAll(ListToMap(stringList18,"15821"));
//
//            }
//
//            if (saveMP4Folder.equals("mp4Jazz")) {
//                List<String> stringList1 = readFilesStyleMusic(style, "1550126243850", "mp4Jazz", false);
//                List<String> stringList2 = readFilesStyleMusic(style, "1550203331496", "mp4Jazz", false);
//                List<String> stringList3 = readFilesStyleMusic(style, "1550549520337", "mp4Jazz", false);
//                List<String> stringList4 = readFilesStyleMusic(style, "1552970386569", "mp4Jazz", false);
//                List<String> stringList5 = readFilesStyleMusic(style, "1556531092678", "mp4Jazz", false);
//                List<String> stringList6 = readFilesStyleMusic(style, "1560397957745", "mp4Jazz", false);
//                List<String> stringList7 = readFilesStyleMusic(style, "1563257801324", "mp4Jazz", false);
//                List<String> stringList8 = readFilesStyleMusic(style, "1565838524472", "mp4Jazz", false);
//                List<String> stringList9 = readFilesStyleMusic(style, "1568610793564", "mp4Jazz", false);
//                List<String> stringList10 = readFilesStyleMusic(style, "1572928225399", "mp4Jazz", false);
//                List<String> stringList11 = readFilesStyleMusic(style, "1575437044104", "mp4Jazz", false);
//                List<String> stringList12 = readFilesStyleMusic(style, "1577428239839", "mp4Jazz", false);
//                List<String> stringList13 = readFilesStyleMusic(style, "1579606271907", "mp4Jazz", false);
//                List<String> stringList14 = readFilesStyleMusic(style, "1580873562042", "mp4Jazz", false);
//                List<String> stringList15 = readFilesStyleMusic(style, "1581482416345", "mp4Jazz", false);
//                List<String> stringList16 = readFilesStyleMusic(style, "1582167429983", "mp4Jazz", false);
//                stringsFiles.addAll(stringList1);
//                stringsFiles.addAll(stringList2);
//                stringsFiles.addAll(stringList3);
//                stringsFiles.addAll(stringList4);
//                stringsFiles.addAll(stringList5);
//                stringsFiles.addAll(stringList6);
//                stringsFiles.addAll(stringList7);
//                stringsFiles.addAll(stringList8);
//                stringsFiles.addAll(stringList9);
//                stringsFiles.addAll(stringList10);
//                stringsFiles.addAll(stringList11);
//                stringsFiles.addAll(stringList12);
//                stringsFiles.addAll(stringList13);
//                stringsFiles.addAll(stringList14);
//                stringsFiles.addAll(stringList15);
//                stringsFiles.addAll(stringList16);
//
//                foldersSongs.putAll(ListToMap(stringList1,"15501"));
//                foldersSongs.putAll(ListToMap(stringList2,"15502"));
//                foldersSongs.putAll(ListToMap(stringList3,"15505"));
//                foldersSongs.putAll(ListToMap(stringList4,"15529"));
//                foldersSongs.putAll(ListToMap(stringList5,"15565"));
//                foldersSongs.putAll(ListToMap(stringList6,"15603"));
//                foldersSongs.putAll(ListToMap(stringList7,"15632"));
//                foldersSongs.putAll(ListToMap(stringList8,"15658"));
//                foldersSongs.putAll(ListToMap(stringList9,"15686"));
//                foldersSongs.putAll(ListToMap(stringList10,"15729"));
//                foldersSongs.putAll(ListToMap(stringList11,"15754"));
//                foldersSongs.putAll(ListToMap(stringList12,"15774"));
//                foldersSongs.putAll(ListToMap(stringList13,"15796"));
//                foldersSongs.putAll(ListToMap(stringList14,"15808"));
//                foldersSongs.putAll(ListToMap(stringList15,"15814"));
//                foldersSongs.putAll(ListToMap(stringList16,"15821"));
//
//            }
//
//            if (saveMP4Folder.equals("mp4Other")) {
//                List<String> stringList1 = readFilesStyleMusic(style, "1550126243850", "mp4Other", false);
//                List<String> stringList2 = readFilesStyleMusic(style, "1550549520337", "mp4Other", false);
//                List<String> stringList3 = readFilesStyleMusic(style, "1552970386569", "mp4Other", false);
//                List<String> stringList4 = readFilesStyleMusic(style, "1556531092678", "mp4Other", false);
//                List<String> stringList5 = readFilesStyleMusic(style, "1560397957745", "mp4Other", false);
//                List<String> stringList6 = readFilesStyleMusic(style, "1563257801324", "mp4Other", false);
//                List<String> stringList7 = readFilesStyleMusic(style, "1565838524472", "mp4Other", false);
//                List<String> stringList8 = readFilesStyleMusic(style, "1568610793564", "mp4Other", false);
//                List<String> stringList9 = readFilesStyleMusic(style, "1572928225399", "mp4Other", false);
//                List<String> stringList10 = readFilesStyleMusic(style, "1575437044104", "mp4Other", false);
//                List<String> stringList11 = readFilesStyleMusic(style, "1577428239839", "mp4Other", false);
//                List<String> stringList12 = readFilesStyleMusic(style, "1579606271907", "mp4Other", false);
//                List<String> stringList13 = readFilesStyleMusic(style, "1580873562042", "mp4Other", false);
//                List<String> stringList14 = readFilesStyleMusic(style, "1581482416345", "mp4Other", false);
//                List<String> stringList15 = readFilesStyleMusic(style, "1582167429983", "mp4Other", false);
//                stringsFiles.addAll(stringList1);
//                stringsFiles.addAll(stringList2);
//                stringsFiles.addAll(stringList3);
//                stringsFiles.addAll(stringList4);
//                stringsFiles.addAll(stringList5);
//                stringsFiles.addAll(stringList6);
//                stringsFiles.addAll(stringList7);
//                stringsFiles.addAll(stringList8);
//                stringsFiles.addAll(stringList9);
//                stringsFiles.addAll(stringList10);
//                stringsFiles.addAll(stringList11);
//                stringsFiles.addAll(stringList12);
//                stringsFiles.addAll(stringList13);
//                stringsFiles.addAll(stringList14);
//                stringsFiles.addAll(stringList15);
//
//                foldersSongs.putAll(ListToMap(stringList1,"15501"));
//                foldersSongs.putAll(ListToMap(stringList2,"15505"));
//                foldersSongs.putAll(ListToMap(stringList3,"15529"));
//                foldersSongs.putAll(ListToMap(stringList4,"15565"));
//                foldersSongs.putAll(ListToMap(stringList5,"15603"));
//                foldersSongs.putAll(ListToMap(stringList6,"15632"));
//                foldersSongs.putAll(ListToMap(stringList7,"15658"));
//                foldersSongs.putAll(ListToMap(stringList8,"15686"));
//                foldersSongs.putAll(ListToMap(stringList9,"15729"));
//                foldersSongs.putAll(ListToMap(stringList10,"15754"));
//                foldersSongs.putAll(ListToMap(stringList11,"15774"));
//                foldersSongs.putAll(ListToMap(stringList12,"15796"));
//                foldersSongs.putAll(ListToMap(stringList13,"15808"));
//                foldersSongs.putAll(ListToMap(stringList14,"15814"));
//                foldersSongs.putAll(ListToMap(stringList15,"15821"));
//
//
//            }
//
//            if (saveMP4Folder.equals("mp4Classic")) {
//                List<String> stringList1 = readFilesStyleMusic(style, "1550144961649", "mp4Classic", false);
//                List<String> stringList2 = readFilesStyleMusic(style, "1550203331496", "mp4Classic", false);
//                List<String> stringList3 = readFilesStyleMusic(style, "1550549520337", "mp4Classic", false);
//                List<String> stringList4 = readFilesStyleMusic(style, "1552970386569", "mp4Classic", false);
//                List<String> stringList5 = readFilesStyleMusic(style, "1556531092678", "mp4Classic", false);
//                List<String> stringList6 = readFilesStyleMusic(style, "1560397957745", "mp4Classic", false);
//                List<String> stringList7 = readFilesStyleMusic(style, "1563257801324", "mp4Classic", false);
//                List<String> stringList8 = readFilesStyleMusic(style, "1565838524472", "mp4Classic", false);
//                List<String> stringList9 = readFilesStyleMusic(style, "1568610793564", "mp4Classic", false);
//                List<String> stringList10 = readFilesStyleMusic(style, "1572928225399", "mp4Classic", false);
//                List<String> stringList11 = readFilesStyleMusic(style, "1575437044104", "mp4Classic", false);
//                List<String> stringList12 = readFilesStyleMusic(style, "1577428239839", "mp4Classic", false);
//                List<String> stringList13 = readFilesStyleMusic(style, "1579606271907", "mp4Classic", false);
//                List<String> stringList14 = readFilesStyleMusic(style, "1580873562042", "mp4Classic", false);
//                List<String> stringList15 = readFilesStyleMusic(style, "1581482416345", "mp4Classic", false);
//                List<String> stringList16 = readFilesStyleMusic(style, "1582167429983", "mp4Classic", false);
//                stringsFiles.addAll(stringList1);
//                stringsFiles.addAll(stringList2);
//                stringsFiles.addAll(stringList3);
//                stringsFiles.addAll(stringList4);
//                stringsFiles.addAll(stringList5);
//                stringsFiles.addAll(stringList6);
//                stringsFiles.addAll(stringList7);
//                stringsFiles.addAll(stringList8);
//                stringsFiles.addAll(stringList9);
//                stringsFiles.addAll(stringList10);
//                stringsFiles.addAll(stringList11);
//                stringsFiles.addAll(stringList12);
//                stringsFiles.addAll(stringList13);
//                stringsFiles.addAll(stringList14);
//                stringsFiles.addAll(stringList15);
//                stringsFiles.addAll(stringList16);
//
//                foldersSongs.putAll(ListToMap(stringList1,"15501"));
//                foldersSongs.putAll(ListToMap(stringList2,"15502"));
//                foldersSongs.putAll(ListToMap(stringList3,"15505"));
//                foldersSongs.putAll(ListToMap(stringList4,"15529"));
//                foldersSongs.putAll(ListToMap(stringList5,"15565"));
//                foldersSongs.putAll(ListToMap(stringList6,"15603"));
//                foldersSongs.putAll(ListToMap(stringList7,"15632"));
//                foldersSongs.putAll(ListToMap(stringList8,"15658"));
//                foldersSongs.putAll(ListToMap(stringList9,"15686"));
//                foldersSongs.putAll(ListToMap(stringList10,"15729"));
//                foldersSongs.putAll(ListToMap(stringList11,"15754"));
//                foldersSongs.putAll(ListToMap(stringList12,"15774"));
//                foldersSongs.putAll(ListToMap(stringList13,"15796"));
//                foldersSongs.putAll(ListToMap(stringList14,"15808"));
//                foldersSongs.putAll(ListToMap(stringList15,"15814"));
//                foldersSongs.putAll(ListToMap(stringList16,"15821"));
//
//            }
//
//            if (saveMP4Folder.equals("mp4RadioTunes")) {
//                List<String> stringList1 = readFilesStyleMusic(style, "1550637167128", "mp4RadioTunes", false);
//                List<String> stringList2 = readFilesStyleMusic(style, "1550810150487", "mp4RadioTunes", false);
//                List<String> stringList3 = readFilesStyleMusic(style, "1552970386569", "mp4RadioTunes", false);
//                List<String> stringList4 = readFilesStyleMusic(style, "1556531092678", "mp4RadioTunes", false);
//                List<String> stringList5 = readFilesStyleMusic(style, "1560397957745", "mp4RadioTunes", false);
//                List<String> stringList6 = readFilesStyleMusic(style, "1563257801324", "mp4RadioTunes", false);
//                List<String> stringList7 = readFilesStyleMusic(style, "1565838524472", "mp4RadioTunes", false);
//                List<String> stringList8 = readFilesStyleMusic(style, "1568610793564", "mp4RadioTunes", false);
//                List<String> stringList9 = readFilesStyleMusic(style, "1572928225399", "mp4RadioTunes", false);
//                List<String> stringList10 = readFilesStyleMusic(style, "1575437044104", "mp4RadioTunes", false);
//                List<String> stringList11 = readFilesStyleMusic(style, "1577428239839", "mp4RadioTunes", false);
//                List<String> stringList12 = readFilesStyleMusic(style, "1579606271907", "mp4RadioTunes", false);
//                List<String> stringList13 = readFilesStyleMusic(style, "1580873562042", "mp4RadioTunes", false);
//                List<String> stringList14 = readFilesStyleMusic(style, "1581482416345", "mp4RadioTunes", false);
//                List<String> stringList15 = readFilesStyleMusic(style, "1582167429983", "mp4RadioTunes", false);
//                stringsFiles.addAll(stringList1);
//                stringsFiles.addAll(stringList2);
//                stringsFiles.addAll(stringList3);
//                stringsFiles.addAll(stringList4);
//                stringsFiles.addAll(stringList5);
//                stringsFiles.addAll(stringList6);
//                stringsFiles.addAll(stringList7);
//                stringsFiles.addAll(stringList8);
//                stringsFiles.addAll(stringList9);
//                stringsFiles.addAll(stringList10);
//                stringsFiles.addAll(stringList11);
//                stringsFiles.addAll(stringList12);
//                stringsFiles.addAll(stringList13);
//                stringsFiles.addAll(stringList14);
//                stringsFiles.addAll(stringList15);
//                foldersSongs.putAll(ListToMap(stringList1,"15506"));
//                foldersSongs.putAll(ListToMap(stringList2,"15508"));
//                foldersSongs.putAll(ListToMap(stringList3,"15529"));
//                foldersSongs.putAll(ListToMap(stringList4,"15565"));
//                foldersSongs.putAll(ListToMap(stringList5,"15603"));
//                foldersSongs.putAll(ListToMap(stringList6,"15632"));
//                foldersSongs.putAll(ListToMap(stringList7,"15658"));
//                foldersSongs.putAll(ListToMap(stringList8,"15686"));
//                foldersSongs.putAll(ListToMap(stringList9,"15729"));
//                foldersSongs.putAll(ListToMap(stringList10,"15754"));
//                foldersSongs.putAll(ListToMap(stringList11,"15774"));
//                foldersSongs.putAll(ListToMap(stringList12,"15796"));
//                foldersSongs.putAll(ListToMap(stringList13,"15808"));
//                foldersSongs.putAll(ListToMap(stringList14,"15814"));
//                foldersSongs.putAll(ListToMap(stringList15,"15821"));
//            }

//            if (saveMP4Folder.equals("mp4Zenradio")) {
//                List<String> stringList1 = readFilesStyleMusic(style, "1557286145331", "mp4Zenradio", false);
//                List<String> stringList2 = readFilesStyleMusic(style, "1560397957745", "mp4Zenradio", false);
//                List<String> stringList3 = readFilesStyleMusic(style, "1563257801324", "mp4Zenradio", false);
//                List<String> stringList4 = readFilesStyleMusic(style, "1565838524472", "mp4Zenradio", false);
//                List<String> stringList5 = readFilesStyleMusic(style, "1568610793564", "mp4Zenradio", false);
//                List<String> stringList6 = readFilesStyleMusic(style, "1572928225399", "mp4Zenradio", false);
//                List<String> stringList7 = readFilesStyleMusic(style, "1575437044104", "mp4Zenradio", false);
//                List<String> stringList8 = readFilesStyleMusic(style, "1577428239839", "mp4Zenradio", false);
//                List<String> stringList9 = readFilesStyleMusic(style, "1579606271907", "mp4Zenradio", false);
//                List<String> stringList10 = readFilesStyleMusic(style, "1580873562042", "mp4Zenradio", false);
//                List<String> stringList11 = readFilesStyleMusic(style, "1581482416345", "mp4Zenradio", false);
//                List<String> stringList12 = readFilesStyleMusic(style, "1582167429983", "mp4Zenradio", false);
//                stringsFiles.addAll(stringList1);
//                stringsFiles.addAll(stringList2);
//                stringsFiles.addAll(stringList3);
//                stringsFiles.addAll(stringList4);
//                stringsFiles.addAll(stringList5);
//                stringsFiles.addAll(stringList6);
//                stringsFiles.addAll(stringList7);
//                stringsFiles.addAll(stringList8);
//                stringsFiles.addAll(stringList9);
//                stringsFiles.addAll(stringList10);
//                stringsFiles.addAll(stringList11);
//                stringsFiles.addAll(stringList12);
//
//                foldersSongs.putAll(ListToMap(stringList1,"15572"));
//                foldersSongs.putAll(ListToMap(stringList2,"15603"));
//                foldersSongs.putAll(ListToMap(stringList3,"15632"));
//                foldersSongs.putAll(ListToMap(stringList4,"15658"));
//                foldersSongs.putAll(ListToMap(stringList5,"15686"));
//                foldersSongs.putAll(ListToMap(stringList6,"15729"));
//                foldersSongs.putAll(ListToMap(stringList7,"15754"));
//                foldersSongs.putAll(ListToMap(stringList8,"15774"));
//                foldersSongs.putAll(ListToMap(stringList9,"15796"));
//                foldersSongs.putAll(ListToMap(stringList10,"15808"));
//                foldersSongs.putAll(ListToMap(stringList11,"15814"));
//                foldersSongs.putAll(ListToMap(stringList12,"15821"));
//
//            }
            //</editor-fold>

//            System.out.println(stringsFiles.size());
            AllStringsFiles.addAll(stringsFiles);
        }

//        System.out.println(foldersSongs.size());
//        return AllStringsFiles;
        return foldersSongs;

    }

    public String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public String readFilesStyleMusic(String style, String timeStamp, boolean print) {
        String content = null;
        try {
//            content = PJ.readFile("./mp4/"+style+"+"+timeStamp, StandardCharsets.UTF_8);

            File tmpDir = new File("./mp4/"+timeStamp+"+"+style+".files");
            boolean exists = tmpDir.exists();
            if (exists) {
                content = readFile("./mp4/"+timeStamp+"+"+style+".files", StandardCharsets.UTF_8);
            } else {
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (print) {
            System.out.println(content);
        }
        return content;
    }


    public List<String> readFilesStyleMusic(String style, String timeStamp, String saveMP4Folder, boolean print) {
        String content = null;
        try {
//            content = PJ.readFile("./"+saveMP4Folder+"/"+style+"+"+timeStamp, StandardCharsets.UTF_8);

            File tmpDir = new File("./"+saveMP4Folder+"/_txtBase/"+timeStamp+"+"+style+".files");
            boolean exists = tmpDir.exists();
            if (exists) {
                content = readFile("./"+saveMP4Folder+"/_txtBase/"+timeStamp+"+"+style+".files", StandardCharsets.UTF_8);
            } else {
                return new ArrayList<String>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (print) {
            System.out.println(content);
        }
        List<String> myList = new ArrayList<String>(Arrays.asList(content.split("\n")));
        return myList;
    }


}
