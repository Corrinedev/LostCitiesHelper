package com.corrinedev.lostcitieshelper;

import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BuildingCreator {

    public static void createBuilding() {
        //Not a loop
        JOptionPane.showMessageDialog(null,"Choose a PART file and your lostcities root directory");
        DirectoryChooser directoryChooser = new DirectoryChooser();
        String directory = directoryChooser.createDirectory(true);

        File file = null;
        try {
            file = File.createTempFile("tempfile","e");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CitystyleAppend citystyleAppend = new CitystyleAppend();
        File building = citystyleAppend.cityStyleChooser();


        //Loop
        while(!(file == null)) {

        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(null);



        try {
            CitystyleAppend createbuildings = new CitystyleAppend();
            createbuildings.addBuilding(file.getName().substring(0, file.getName().indexOf(".json")), building);
            Files.createFile(Path.of(directory + "/lostcities/buildings/" + file.getName()));
            Files.writeString(Path.of(directory + "/lostcities/buildings/" + file.getName()), "{\n" +
                    "  \"filler\": \"#\",\n" +
                    "  \"rubble\": \"}\",\n" +
                    "  \"minfloors\": 1,\n" +
                    "  \"maxfloors\": 1,\n" +
                    "  \"parts\": [\n" +
                    "    {\n" +
                    "\t  \"top\": false,\n" +
                    "      \"cellar\": false,\n" +
                    "      \"ground\": true,\t\n" +
                    "      \"part\": \"" + "lostcities:" + file.getName().substring(0, file.getName().indexOf(".json")) + "\"\n" +
                    "\n" +
                    "    },\n" +
                    "\t{\n" +
                    "\t  \"top\": false,\n" +
                    "      \"cellar\": false,\n" +
                    "      \"ground\": false,\n" +
                    "      \"part\": \"lostcities:empty\"\n" +
                    "    },\n" +
                    "\t{\n" +
                    "      \"top\": true,\n" +
                    "      \"cellar\": false,\n" +
                    "      \"ground\": false,\t\n" +
                    "      \"part\": \"lostcities:empty\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}");


        } catch (IOException e) {
            System.out.println("File cannot be null! r you closed out of the file chooser");
        }
    }

    }

}
