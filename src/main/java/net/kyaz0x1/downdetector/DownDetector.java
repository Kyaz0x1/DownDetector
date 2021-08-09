package net.kyaz0x1.downdetector;

import net.kyaz0x1.downdetector.view.HomeView;

import javax.swing.SwingUtilities;

public class DownDetector {

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new HomeView().setVisible(true));
    }

}