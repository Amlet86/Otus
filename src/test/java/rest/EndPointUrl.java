package rest;

public enum EndPointUrl {

    TRANSLATE("translate"),
    GET_LANGS("getLangs"),
    LOOKUP("lookup");

    String path;

    EndPointUrl(String  path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }

    public String addPath(String additionalPath){
        return path + additionalPath;
    }
}
