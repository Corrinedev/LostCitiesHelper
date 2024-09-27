package com.corrinedev.lostcitieshelper;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


public class FileSplitter {

    public static void extractPieces() {
        JOptionPane.showMessageDialog(null,"Choose your lostcities directory, this is NOT the same directory as your file, its the directory your datapack is in, it should go like this ~/lostcities/lostcities");
        DirectoryChooser directoryChooser = new DirectoryChooser();

        String directory = String.valueOf(directoryChooser.showDialog(null));

        System.out.println(directory);

        if(!(directory == null)) {

            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);
            String filePath = file.getAbsolutePath();
            System.out.println(filePath);
            String fileContents;
            try {
                fileContents = Files.readString(Path.of(filePath));


                String palleteexported1 = fileContents.substring(0, 1);
                String palleteexported2 = fileContents.substring(fileContents.indexOf("    \"palette\": ["), fileContents.indexOf("    ]\n" +
                        "  },"));

                String pallete = palleteexported1 + palleteexported2 + "] }";

                //System.out.println(pallete);
                Files.writeString(Path.of(directory + "/lostcities/palettes/" + file.getName()), pallete);


                String partexported1 = fileContents.substring(fileContents.indexOf("    \"xsize\": 16,"), fileContents.indexOf("      ]\n" +
                        "    ]"));
                //String partexported2 = fileContents.substring(fileContents.indexOf("    \"palette\": ["), fileContents.indexOf("    ]\n" +
                //        "  },"));
                String[] filename = file.getName().split(".");
                String part = "{\n" + "\t\"refpalette\": \"" + file.getName().substring(0 , file.getName().indexOf(".json")) + "\",\n" + partexported1 + "\n" + "      ]\n" +
                        "    ]\n" +
                        "  }";

                System.out.println(part);
                Files.writeString(Path.of(directory + "/lostcities/parts/" + "part_" + file.getName()), part);





            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }

}
