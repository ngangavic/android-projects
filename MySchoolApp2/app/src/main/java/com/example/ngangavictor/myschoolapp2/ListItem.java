package com.example.ngangavictor.myschoolapp2;

public class ListItem {
    private String english;
    private String kiswahili;
    private String mathematics;
    private String science;
    private String ssre;

    public ListItem(String english, String kiswahili, String mathematics, String science, String ssre) {
        this.english = english;
        this.kiswahili = kiswahili;
        this.mathematics = mathematics;
        this.science = science;
        this.ssre = ssre;

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

    public String getScience() {
        return science;
    }

    public String getSsre() {
        return ssre;
    }
}
