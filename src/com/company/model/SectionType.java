package com.company.model;

/**
 * Created by cic56 on 22.06.2017.
 */
public enum SectionType {
    PERSONAL("Personal"),
    ACHIEVMENT("Achievment"),
    OBJECTIVE("Objective"),
    QUALIFICATION("Qualification"),
    EXPIRIENCE("Expirience"),
    EDUCATION("Education");

    private  final String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
