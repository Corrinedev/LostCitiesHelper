package com.corrinedev.lostcitieshelper;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileSplitter {

    public static void extractPallete() {
        JOptionPane.showMessageDialog(null,"Choose your lostcities directory, this is NOT the same directory as your file, its the directory your datapack is in, it should go like this ~/lostcities/lostcities");
        DirectoryChooser directoryChooser = new DirectoryChooser();

        String directory = String.valueOf(directoryChooser.showDialog(null));

        System.out.println(directory);

        if(!(directory == null)) {

            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);
            String filePath = file.getAbsolutePath();
            System.out.println(filePath);
            String fileContents = null;
            try {
                fileContents = Files.readString(Path.of(filePath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(fileContents);

        }


    }

}
