package com.example.ngangavictor.myschoolapp;

public class ListItem {
    private String english;
    private String kiswahili;
    private String mathematics;
    private String chemistry;
    private String biology;
    private String physics;
    private String geography;
    private String history;
    private String cre;
    private String agriculture;
    private String business;
    private String total;


    public ListItem(String english, String kiswahili, String mathematics, String chemistry, String biology, String physics, String geography, String history, String cre, String agriculture, String business, String total) {
        this.english = english;
        this.kiswahili = kiswahili;
        this.mathematics = mathematics;
        this.chemistry = chemistry;
        this.biology = biology;
        this.physics = physics;
        this.geography = geography;
        this.history = history;
        this.cre = cre;
        this.agriculture = agriculture;
        this.business = business;
        this.total = total;
    }

    public String getEnglish() {
        return english;
    }

    public String getKiswahili() {
        return kiswahili;
    }

    public String getMathematics() {
        return mathematics;
    }

    public String getChemistry() {
        return chemistry;
    }

    public String getBiology() {
        return biology;
    }

    public String getPhysics() {
        return physics;
    }

    public String getGeography() {
        return geography;
    }

    public String getHistory() {
        return history;
    }

    public String getCre() {
        return cre;
    }

    public String getAgriculture() {
        return agriculture;
    }

    public String getBusiness() {
        return business;
    }

    public String getTotal() {
        return total;
    }

}
