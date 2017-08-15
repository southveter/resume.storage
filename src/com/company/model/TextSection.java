package com.company.model;

import java.util.Objects;

/**
 * Created by cic56 on 22.06.2017.
 */
public class TextSection extends Section {
    private static final long serialVersionUID = 1L;
    private String content;

    public TextSection() {
    }

    public TextSection(String content) {
        Objects.requireNonNull(content,"content must be not null");
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }
}
