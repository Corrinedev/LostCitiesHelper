package com.corrinedev.lostcitieshelper;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EmptyCreator {

    public static void createEmpty() {

        JOptionPane.showMessageDialog(null,"Choose your lostcities directory, this is NOT the same directory as your file, its the directory your datapack is in, choose the root folder NOT the second lostcties folder");

        DirectoryChooser directoryChooser = new DirectoryChooser();

        String directory = String.valueOf(directoryChooser.showDialog(null));

        System.out.println(directory);
        if(!(directory == null)) {
            try {

                Files.writeString(Path.of(directory + "/lostcities/palettes/empty.json"), "");
                Files.writeString(Path.of(directory + "/lostcities/parts/empty.json"), "");



            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }

}