package pekopeko.afpa.view.swing;

import pekopeko.afpa.view.swingUI.MenuUI;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MainSwingUI {
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MenuUI myMenu = new MenuUI();
        myMenu.setVisible(true);
    }
}