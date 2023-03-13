package com.leniolabs.challenge.constants;

public enum AccountType {
    CORPORATE("COR","Corporativo"),
    PERSONAL("PER","Personal");
    private String id;
    private String description;


    AccountType(String id, String description) {
        this.id=id;
        this.description=description;
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }
}
