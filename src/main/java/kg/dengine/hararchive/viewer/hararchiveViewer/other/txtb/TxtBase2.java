package kg.dengine.hararchive.viewer.hararchiveViewer.other.txtb;

import java.util.HashMap;
import java.util.Map;

public class TxtBase2 {
    public Map<String,String> get(String mediaFolder){
        switch (mediaFolder){
            case "mp4" : return mp4();
            case "mp4Rock" : return mp4Rock();
            case "mp4Jazz" : return mp4Jazz();
            case "mp4Other": return mp4Other();
            case "mp4Classic": return mp4Classic();
            case "mp4RadioTunes": return mp4RadioTunes();
            case "mp4Zenradio": return mp4Zenradio();
            default: return null;
        }
    }
    public Map<String,String> mp4() {
        Map<String, String> arr = new HashMap<>();

        //<editor-fold desc="заполняем все скаыиваемые стили - те которые конкретно скачивают аудио файлы">
        arr.put("club-dubstep", "mp4");
        arr.put("ambient", "mp4");
        arr.put("chillout", "mp4");
        arr.put("chilloutdreams", "mp4");
        arr.put("trap", "mp4");
        arr.put("vocaltrance", "mp4");
        arr.put("vocallounge", "mp4");
        arr.put("spacemusic", "mp4");
        arr.put("liquidtrap", "mp4");
        arr.put("atmosphericbreaks", "mp4");
        arr.put("psychill", "mp4");
        arr.put("progressivepsy", "mp4");
        arr.put("jungle", "mp4");
        arr.put("jazzhouse", "mp4");
        arr.put("goapsy", "mp4");
        arr.put("drumstep", "mp4");
        arr.put("vocalchillout", "mp4");
        arr.put("hardstyle", "mp4");

        arr.put("00sclubhits", "mp4");
        arr.put("nightcore", "mp4");
        arr.put("melodicprogressive", "mp4");
        arr.put("ebm", "mp4");
        arr.put("edm", "mp4");
        arr.put("idm", "mp4");
        arr.put("nudisco", "mp4");

        arr.put("minimal", "mp4");
        arr.put("liquiddnb", "mp4");
        arr.put("drumandbass", "mp4");
        arr.put("dub", "mp4");

        arr.put("bassnjackinhouse", "mp4");
        arr.put("breaks", "mp4");
        arr.put("bigroomhouse", "mp4");
        arr.put("bigbeat", "mp4");
        arr.put("bassline", "mp4");

        arr.put("chillntropicalhouse", "mp4");
        arr.put("chillhop", "mp4");
        arr.put("chillstep", "mp4");
        arr.put("classiceurodance", "mp4");
        arr.put("classiceurodisco", "mp4");
        arr.put("classictrance", "mp4");
        arr.put("club", "mp4");

        arr.put("darkdnb", "mp4");
        arr.put("darkpsytrance", "mp4");
        arr.put("deephouse", "mp4");
        arr.put("deepnudisco", "mp4");
        arr.put("deeptech", "mp4");
        arr.put("detroithousentechno", "mp4");
        arr.put("discohouse", "mp4");
        arr.put("djmixes", "mp4");
        arr.put("downtempolounge", "mp4");
        arr.put("dubtechno", "mp4");
        arr.put("dubstep", "mp4");

        arr.put("eclectronica", "mp4");
        arr.put("electro", "mp4");
        arr.put("electroswing", "mp4");
        arr.put("electronicpioneers", "mp4");
        arr.put("electronics", "mp4");
        arr.put("electropop", "mp4");
        arr.put("epictrance", "mp4");
        arr.put("eurodance", "mp4");

        arr.put("funkyhouse", "mp4");
        arr.put("futurebass", "mp4");
        arr.put("futuregarage", "mp4");
        arr.put("futuresynthpop", "mp4");
        arr.put("gabber", "mp4");
        arr.put("glitchhop", "mp4");


        arr.put("handsup", "mp4");
        arr.put("harddance", "mp4");
        arr.put("hardtechno", "mp4");
        arr.put("hardcore", "mp4");
        arr.put("house", "mp4");
        arr.put("indiebeats", "mp4");
        arr.put("indiedance", "mp4");
        arr.put("latinhouse", "mp4");
        arr.put("liquiddubstep", "mp4");
        arr.put("lofihiphop", "mp4");
        arr.put("lounge", "mp4");
        arr.put("mainstage", "mp4");
        arr.put("oldschoolacid", "mp4");
        arr.put("oldschoolhouse", "mp4");
        arr.put("oldschoolrave", "mp4");
        arr.put("classictechno", "mp4");
        arr.put("progressive", "mp4");
        arr.put("psybient", "mp4");
        arr.put("russianclubhits", "mp4");
        arr.put("soulfulhouse", "mp4");
        arr.put("synthwave", "mp4");
        arr.put("techhouse", "mp4");
        arr.put("techno", "mp4");
        arr.put("trance", "mp4");
        arr.put("tribalhouse", "mp4");
        arr.put("umfradio", "mp4");
        arr.put("undergroundtechno", "mp4");
        arr.put("vocalhouse", "mp4");


        arr.put("lofiloungenchill", "mp4");
        arr.put("chilledm", "mp4");
        arr.put("deepprogressivehouse", "mp4");
        arr.put("summerchillhouse", "mp4");


        return arr;
    }

    public Map<String,String> mp4Rock(){
        Map<String,String> arr = new HashMap<>();
        arr.put("00srock",         "mp4Rock");
        arr.put("60srock",         "mp4Rock");
        arr.put("70srock",         "mp4Rock");
        arr.put("alternative80s",  "mp4Rock");
        arr.put("80srock",         "mp4Rock");
        arr.put("alternative90s",  "mp4Rock");
        arr.put("90srock",         "mp4Rock");
        arr.put("alternativerock", "mp4Rock");
        arr.put("blackmetal",      "mp4Rock");
        arr.put("bluesrock",       "mp4Rock");
        arr.put("classicfolkrock", "mp4Rock");
        arr.put("classichardrock","mp4Rock");
        arr.put("classicmetal",   "mp4Rock");
        arr.put("classicrock",    "mp4Rock");
        arr.put("deathmetal",     "mp4Rock");
        arr.put("grunge",         "mp4Rock");
        arr.put("hairbands",      "mp4Rock");
        arr.put("hardrock",       "mp4Rock");
        arr.put("heavymetal",     "mp4Rock");
        arr.put("indierock",      "mp4Rock");
        arr.put("industrial",     "mp4Rock");
        arr.put("latinrock",      "mp4Rock");
        arr.put("melodicdeathmetal","mp4Rock");
        arr.put("metal",          "mp4Rock");
        arr.put("metalcore",      "mp4Rock");
        arr.put("modernfolkrock", "mp4Rock");
        arr.put("modernrock",     "mp4Rock");
        arr.put("numetal",        "mp4Rock");
        arr.put("poprock",        "mp4Rock");
        arr.put("powermetal",     "mp4Rock");
        arr.put("progressiverock","mp4Rock");
        arr.put("punkrock",       "mp4Rock");
        arr.put("rockballads",    "mp4Rock");
        arr.put("screamoemo",     "mp4Rock");
        arr.put("softrock",       "mp4Rock");
        arr.put("symphonicmetal", "mp4Rock");
        arr.put("thrashmetal",    "mp4Rock");
        arr.put("yachtrock",      "mp4Rock");

        return arr;
    }

    public Map<String,String> mp4Jazz(){
        Map<String,String> arr = new HashMap<>();






        arr.put("bassjazz",       "mp4Jazz");
        arr.put("bebop",          "mp4Jazz");
        arr.put("blues",          "mp4Jazz");
        arr.put("bluesrockJazz",  "mp4Jazz");//
        arr.put("bossanova",      "mp4Jazz");
        arr.put("classicjazz",    "mp4Jazz");
        arr.put("vocaljazz",      "mp4Jazz");
        arr.put("cooljazz",       "mp4Jazz");
        arr.put("currentjazz",    "mp4Jazz");
        arr.put("davekoz",        "mp4Jazz");
        arr.put("fusionlounge",   "mp4Jazz");
        arr.put("guitarjazz",     "mp4Jazz");
        arr.put("gypsyjazz",      "mp4Jazz");
        arr.put("hardbop",        "mp4Jazz");
        arr.put("jazzballads",    "mp4Jazz");
        arr.put("latinjazz",      "mp4Jazz");
        arr.put("mellowjazz",     "mp4Jazz");
        arr.put("mellowpianojazz","mp4Jazz");
        arr.put("mellowsmoothjazz","mp4Jazz");
        arr.put("modernbigband",  "mp4Jazz");
        arr.put("pariscafe",      "mp4Jazz");
        arr.put("pianojazz",      "mp4Jazz");
        arr.put("pianotrios",     "mp4Jazz");
        arr.put("saxophonejazz",  "mp4Jazz");
        arr.put("sinatrastyle",   "mp4Jazz");
        arr.put("smoothbossanova","mp4Jazz");
        arr.put("smoothjazz",     "mp4Jazz");
        arr.put("smoothjazz247",  "mp4Jazz");
        arr.put("smoothlounge",   "mp4Jazz");
        arr.put("smoothuptempo",  "mp4Jazz");
        arr.put("smoothvocals",   "mp4Jazz");
        arr.put("straightahead",  "mp4Jazz");
        arr.put("swingnbigband",  "mp4Jazz");
        arr.put("timelessclassics","mp4Jazz");
        arr.put("trumpetjazz",    "mp4Jazz");
        arr.put("vibraphonejazz", "mp4Jazz");
        arr.put("vocallegends",   "mp4Jazz");

        arr.put("jazzhop",        "mp4Jazz");
        arr.put("coffeejazz",     "mp4Jazz");

        return arr;
    }

    public Map<String,String> mp4Other(){
        Map<String,String> arr = new HashMap<>();


        arr.put("christmas",          "mp4Other");
        arr.put("holidayjazz",        "mp4Other");
        arr.put("classicvocaltrance", "mp4Other");
        arr.put("bolero",             "mp4Other");
        arr.put("classicalchristmas", "mp4Other");
        arr.put("flamenco",           "mp4Other");
        arr.put("flamencojazz",       "mp4Other");
        arr.put("halloween",          "mp4Other");
        arr.put("holidaysmoothjazz",  "mp4Other");
//        arr.put("holidaysmoothjazz2",  "mp4Other");
//        arr.put("latinrock",  "mp4Other");
//        arr.put("downtempolounge",  "mp4Other");
        arr.put("nortena",            "mp4Other");
        arr.put("popchristmas",       "mp4Other");
        arr.put("tango",              "mp4Other");

        return arr;
    }

    public Map<String,String> mp4Classic(){
        Map<String,String> arr = new HashMap<>();


        arr.put("20thcentury",          "mp4Classic");
        arr.put("21stcentury",          "mp4Classic");
        arr.put("adagios",              "mp4Classic");
        arr.put("bach",                 "mp4Classic");
        arr.put("ballets",              "mp4Classic");
        arr.put("baroqueperiod",        "mp4Classic");
        arr.put("beethoven",            "mp4Classic");
        arr.put("brahms",               "mp4Classic");
        arr.put("celloworks",           "mp4Classic");
        arr.put("chamberworks",         "mp4Classic");
        arr.put("chopin",               "mp4Classic");
        arr.put("choralworks",          "mp4Classic");
        arr.put("classicalguitarworks", "mp4Classic");
        arr.put("classicalperiod",      "mp4Classic");
        arr.put("classicalpianotrios",  "mp4Classic");
        arr.put("classicalrelaxation",  "mp4Classic");
        arr.put("concertos",            "mp4Classic");
        arr.put("contemporaryperiod",   "mp4Classic");
        arr.put("easyclassical",        "mp4Classic");
        arr.put("fluteworks",           "mp4Classic");
        arr.put("gregorianchant",       "mp4Classic");
        arr.put("grieg",                "mp4Classic");
        arr.put("handel",               "mp4Classic");
        arr.put("harpsichordworks",     "mp4Classic");
        arr.put("haydn",                "mp4Classic");
        arr.put("medievalperiod",       "mp4Classic");
        arr.put("mozart",               "mp4Classic");
        arr.put("operahighlights",      "mp4Classic");
        arr.put("operas",               "mp4Classic");
        arr.put("orchestralworks",      "mp4Classic");
        arr.put("organworks",           "mp4Classic");
        arr.put("overtures",            "mp4Classic");
        arr.put("pianoworks",           "mp4Classic");
        arr.put("renaissanceperiod",    "mp4Classic");
        arr.put("romanticperiod",       "mp4Classic");
        arr.put("sacredworks",          "mp4Classic");
        arr.put("schubert",             "mp4Classic");
        arr.put("shostakovich",         "mp4Classic");
        arr.put("soloinstruments",      "mp4Classic");
        arr.put("solopiano",            "mp4Classic");
        arr.put("sonatas",              "mp4Classic");
        arr.put("songsnlieders",        "mp4Classic");
        arr.put("stringworks",          "mp4Classic");
        arr.put("symphonies",           "mp4Classic");
        arr.put("tchaikovsky",          "mp4Classic");
        arr.put("trumpetworks",         "mp4Classic");
        arr.put("violinworks",          "mp4Classic");
        arr.put("vivaldi",              "mp4Classic");
        arr.put("waltzespolkasnmarches","mp4Classic");
        arr.put("windworks",            "mp4Classic");

        arr.put("debussy",              "mp4Classic");
        arr.put("nocturnes",            "mp4Classic");
        arr.put("liszt",                "mp4Classic");
        arr.put("telemann",             "mp4Classic");


        return arr;
    }

    public Map<String,String> mp4RadioTunes(){
        Map<String,String> arr = new HashMap<>();

        arr.put("00scountry",        "mp4RadioTunes");
        arr.put("00sdance",          "mp4RadioTunes");
        arr.put("hit00s",            "mp4RadioTunes");
        arr.put("00srnb",            "mp4RadioTunes");
//        arr.put("00srock",           "mp4RadioTunes");
        arr.put("hit60s",            "mp4RadioTunes");
//        arr.put("60srock",           "mp4RadioTunes");
        arr.put("hit70s",            "mp4RadioTunes");
//        arr.put("70srock",           "mp4RadioTunes");
        arr.put("80saltnnewwave",    "mp4RadioTunes");
        arr.put("80sdance",          "mp4RadioTunes");
        arr.put("the80s",            "mp4RadioTunes");
//        arr.put("80srock",           "mp4RadioTunes");
        arr.put("90scountry",        "mp4RadioTunes");
        arr.put("90sdance",          "mp4RadioTunes");
        arr.put("hit90s",            "mp4RadioTunes");
        arr.put("90srnb",            "mp4RadioTunes");
//        arr.put("90srock",           "mp4RadioTunes");
        arr.put("altrock",           "mp4RadioTunes");
//        arr.put("ambient",           "mp4RadioTunes");
        arr.put("americansongbook",  "mp4RadioTunes");
        arr.put("baroque",           "mp4RadioTunes");
//        arr.put("bebop",             "mp4RadioTunes");
//        arr.put("bluesrock",         "mp4RadioTunes");
//        arr.put("bossanova",         "mp4RadioTunes");
        arr.put("cafedeparis",       "mp4RadioTunes");
//        arr.put("chillntropicalhouse""mp4RadioTunes");
//        arr.put("chillout",          "mp4RadioTunes");
        arr.put("classicrap",        "mp4RadioTunes");
        arr.put("classicmotown",     "mp4RadioTunes");
//        arr.put("classicrock",       "mp4RadioTunes");
        arr.put("guitar",            "mp4RadioTunes");
//        arr.put("classicalperiod",   "mp4RadioTunes");
//        arr.put("classicalpianotrios""mp4RadioTunes");
        arr.put("clubbollywood",     "mp4RadioTunes");
        arr.put("christian",         "mp4RadioTunes");
        arr.put("country",           "mp4RadioTunes");
        arr.put("cubanlounge",       "mp4RadioTunes");
        arr.put("dancehits",         "mp4RadioTunes");
        arr.put("datempolounge",     "mp4RadioTunes");
//        arr.put("davekoz",           "mp4RadioTunes");
        arr.put("discoparty",        "mp4RadioTunes");
//        arr.put("downtempolounge",   "mp4RadioTunes");
        arr.put("dreamscapes",       "mp4RadioTunes");
        arr.put("ASCO",              "mp4RadioTunes");
//        arr.put("eurodance",         "mp4RadioTunes");
//        arr.put("hardrock",          "mp4RadioTunes");
//        arr.put("indiedance",        "mp4RadioTunes");
//        arr.put("indierock",         "mp4RadioTunes");
        arr.put("jazzclassics",      "mp4RadioTunes");
        arr.put("jpop",              "mp4RadioTunes");
        arr.put("latinpophits",      "mp4RadioTunes");
//        arr.put("lounge",            "mp4RadioTunes");
        arr.put("lovemusic",         "mp4RadioTunes");
        arr.put("meditation",        "mp4RadioTunes");
//        arr.put("mellowjazz",        "mp4RadioTunes");
//        arr.put("mellowsmoothjazz",  "mp4RadioTunes");
//        arr.put("metal",             "mp4RadioTunes");
        arr.put("modernblues",       "mp4RadioTunes");
//        arr.put("modernrock",        "mp4RadioTunes");
        arr.put("classical",         "mp4RadioTunes");
        arr.put("soundtracks",       "mp4RadioTunes");
//        arr.put("mozart",            "mp4RadioTunes");
        arr.put("nature",            "mp4RadioTunes");
        arr.put("newage",            "mp4RadioTunes");
        arr.put("oldschoolfunknsoul","mp4RadioTunes");
        arr.put("oldies",            "mp4RadioTunes");
//        arr.put("pianojazz",         "mp4RadioTunes");
//        arr.put("poprock",           "mp4RadioTunes");
        arr.put("reggaeton",         "mp4RadioTunes");
        arr.put("relaxation",        "mp4RadioTunes");
        arr.put("relaxingambientpiano","mp4RadioTunes");
        arr.put("romantic",          "mp4RadioTunes");
        arr.put("romantica",         "mp4RadioTunes");
        arr.put("romanticalatina",   "mp4RadioTunes");
        arr.put("rootsreggae",       "mp4RadioTunes");
        arr.put("salsa",             "mp4RadioTunes");
        arr.put("sleeprelaxation",   "mp4RadioTunes");
        arr.put("slowjams",          "mp4RadioTunes");
        arr.put("smoothbeats",       "mp4RadioTunes");
//        arr.put("smoothbossanova",   "mp4RadioTunes");
//        arr.put("smoothjazz",        "mp4RadioTunes");
//        arr.put("smoothjazz247",     "mp4RadioTunes");
//        arr.put("smoothlounge",      "mp4RadioTunes");
//        arr.put("softrock",          "mp4RadioTunes");
//        arr.put("solopiano",         "mp4RadioTunes");
        arr.put("tophits",           "mp4RadioTunes");
        arr.put("uptemposmoothjazz", "mp4RadioTunes");
        arr.put("urbanjamz",         "mp4RadioTunes");
        arr.put("urbanpophits",      "mp4RadioTunes");
//        arr.put("vocalchillout",     "mp4RadioTunes");
//        arr.put("vocallounge",       "mp4RadioTunes");
        arr.put("vocalnewage",       "mp4RadioTunes");
        arr.put("vocalsmoothjazz",   "mp4RadioTunes");
        arr.put("world",             "mp4RadioTunes");

        return arr;
    }

    public Map<String,String> mp4Zenradio(){
        Map<String,String> arr = new HashMap<>();


//        arr.put("meditation",          "mp4Zenradio");
//        arr.put("relaxation",          "mp4Zenradio");
//        arr.put("nature",              "mp4Zenradio");
//        arr.put("chilloutdreams",      "mp4Zenradio");
//        arr.put("newage",              "mp4Zenradio");
//        arr.put("vocalnewage",         "mp4Zenradio");
        arr.put("spacedreams",         "mp4Zenradio");
//        arr.put("ambient",             "mp4Zenradio");
//        arr.put("chillout",            "mp4Zenradio");
//        arr.put("vocalchillout",       "mp4Zenradio");
        arr.put("babysleep",           "mp4Zenradio");
        arr.put("oceansounds",         "mp4Zenradio");
        arr.put("soundsofrain",        "mp4Zenradio");
        arr.put("perfectsunsets",      "mp4Zenradio");
        arr.put("reiki",               "mp4Zenradio");
        arr.put("sleep",               "mp4Zenradio");
        arr.put("flute",               "mp4Zenradio");
//        arr.put("guitar",              "mp4Zenradio");
        arr.put("yoga",                "mp4Zenradio");
        arr.put("zen",                 "mp4Zenradio");
        arr.put("atmosphericdreams",   "mp4Zenradio");
//        arr.put("downtempolounge",     "mp4Zenradio");
        arr.put("relaxingpiano",       "mp4Zenradio");
        arr.put("relaxingclassical",   "mp4Zenradio");
        arr.put("eastasianmeditation", "mp4Zenradio");
        arr.put("study",               "mp4Zenradio");
        arr.put("deepconcentration",   "mp4Zenradio");
        arr.put("deepfocus",           "mp4Zenradio");
        arr.put("lovenrelaxation",     "mp4Zenradio");
        arr.put("peacefulhealing",     "mp4Zenradio");
        arr.put("pregnancyrelaxation", "mp4Zenradio");
        arr.put("shamanic",            "mp4Zenradio");
        arr.put("stressrelief",        "mp4Zenradio");
        arr.put("tibetan",             "mp4Zenradio");
        arr.put("tibetansingingbowls", "mp4Zenradio");
        arr.put("tranquilitynhealing", "mp4Zenradio");
        arr.put("relaxingspanmassage", "mp4Zenradio");
        arr.put("nativeamericanflute", "mp4Zenradio");
        arr.put("acousticvocalchillout","mp4Zenradio");
        arr.put("lovesmoothjazz",      "mp4Zenradio");

//        System.out.println(arr.size());
        return arr;
    }

}
