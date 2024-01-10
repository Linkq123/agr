package com.agr.agrsecurity.entry.euns;

public enum UserStatus {



    OK("0","正常"),
    DISABLE("1","停用"),

    ;


    private String code;

    private String mes;

    UserStatus(String code, String mes) {
        this.code = code;
        this.mes = mes;
    }

    public String getCode() {
        return code;
    }

    public String getMes() {
        return mes;
    }
}
