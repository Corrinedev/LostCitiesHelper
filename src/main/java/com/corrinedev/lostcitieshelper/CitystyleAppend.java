package com.corrinedev.lostcitieshelper;

import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CitystyleAppend {

    public File cityStyleChooser() {
        JOptionPane.showMessageDialog(null, "Choose your citystyle .json file");

        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        return file;
    }
    public void addBuilding(String buildingname, File cityStyle) {


        try {
            float factor = 1;
            String fileContents = Files.readString(Path.of(cityStyle.getAbsolutePath()));
            try {
                factor = Float.parseFloat(JOptionPane.showInputDialog(null, "Input the NUMBER for your factor, it can be a decimal"));
            } catch(Exception e) {
                System.out.println("That is NOT a float number");
                JOptionPane.showMessageDialog(null,"That is NOT a decimal, defaulting to a value of 1");
            }
            String citystylepart1 = fileContents.substring(fileContents.indexOf("{"), fileContents.indexOf("\"buildings\": ["));
            String citystylepart2 = fileContents.substring(fileContents.indexOf("            {\n" +
                    "                \"factor\":"), fileContents.length());

            System.out.println(citystylepart1 + "\"buildings\": [" + "            {\n" +
                    "                \"factor\": " + factor +",\n" +
                    "                \"value\": \"" + buildingname + "\"\n" +
                    "            }," + citystylepart2);

            String citystylefinal = citystylepart1 + "\"buildings\": [" + "            {\n" +
                    "                \"factor\": " + factor + ",\n" +
                    "                \"value\": \"" + buildingname + "\"\n" +
                    "            }," + citystylepart2;
            Files.writeString(Path.of(cityStyle.getAbsolutePath()), citystylefinal);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
