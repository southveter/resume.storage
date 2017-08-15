package com.company.form.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by cic56 on 26.06.2017.
 */
public class CrudForm  {
    private JPanel rootPanel;
    private JTextField name;
    private JButton showMessage;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public CrudForm() throws HeadlessException {

        showMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // JOptionPane.showConfirmDialog(rootPanel,"ты меня уважаешь ");
                int lenth = name.getText().length();
                Object[] options = { "OK", "CANCEL" };
                int i = JOptionPane.showOptionDialog(null, lenth , "Warning",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
                name.setText(lenth + "");
            }
        });
        name.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                System.out.print(e.getKeyChar());
            }
        });
    }
}
