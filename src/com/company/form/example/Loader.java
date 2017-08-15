package com.company.form.example;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cic56 on 26.06.2017.
 */
public class Loader {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        CrudForm form = new CrudForm();
        frame.setContentPane(form.getRootPanel());
        frame.setTitle("CRUD Window!");
        Dimension dim = new Dimension(800,600);
        frame.setSize(dim);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
