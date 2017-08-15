package com.company.model;

/**
 * Created by cic56 on 22.06.2017.
 */
public enum ContactType {
    PHONE("Tel."),
    MOBILE("Mobile Tel."),
    SKYPE("Skype"),
    EMAIL("E-mail"),
    LINKEDIN("LinkedIn"),
    STACKOVERFLOW("StackOverFlow"),
    FACEBOOK("Facebook");

    private  final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
