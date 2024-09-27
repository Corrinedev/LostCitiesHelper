package com.corrinedev.lostcitieshelper;

import javax.swing.*;

public class DirectoryChooser {

    public static String createDirectory(boolean print) {

        JOptionPane.showMessageDialog(null,"Choose your lostcities directory, this is NOT the same directory as your file, its the directory your datapack is in, choose the root folder NOT the second lostcties folder");

        javafx.stage.DirectoryChooser directoryChooser = new javafx.stage.DirectoryChooser();

        String directory = String.valueOf(directoryChooser.showDialog(null));
        if(print == true) {
            System.out.println(directory);
        }

        return directory;
    }

}
