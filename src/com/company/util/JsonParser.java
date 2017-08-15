package com.company.util;

import com.company.model.Section;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by cic56 on 17.07.2017.
 */
public class JsonParser {
    private static Gson GSON = new GsonBuilder().registerTypeAdapter(Section.class, new JsonSectionAdapter()).create();
}
