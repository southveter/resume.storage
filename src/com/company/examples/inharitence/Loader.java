package com.company.examples.inharitence;

import com.company.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cic56 on 05.07.2017.
 */
public class Loader {
    public static void main(String[] args) {
        Dragon dragon = new Dragon();
        dragon.getWeigt();
        DragonBaby db = new DragonBaby();
        db.fly();
        List<Dragon> dragons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            dragons.add(new Dragon());
        }

        for (Dragon dragon1 :  dragons) {
            dragon1.voice();
        }

        for (int i = 0; i < 100; i++) {
            dragons.get(i).voice();
        }


    }
}
