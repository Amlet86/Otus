package rest;

public enum ApiKeys {

    API_KEY_TRANSLATE("trnsl.1.1.20180721T114543Z.d58b03818313efca.51798d718478c8384510ef94555688a7d71d8091"),
    API_KEY_DICTIONARY("dict.1.1.20180721T140439Z.5bca30e704cc24ff.86803afeec18fc206a1dd196966d6c7db35f6c7e");

    String api;

    ApiKeys(String  api){
        this.api = api;
    }

    public String getApiKey(){
        return api;
    }

    }
