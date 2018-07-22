package rest;

public enum EndPointUrl {

    BASE_URL_UI("https://translate.yandex.ru/"),
    BASE_URL_TRANSLATION("https://translate.yandex.net/api/v1.5/tr.json/"),
    TRANSLATE("translate"),
    BASE_URL_DICTIONARY("https://dictionary.yandex.net/api/v1/dicservice.json/"),
    LANGS("getLangs"),
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
