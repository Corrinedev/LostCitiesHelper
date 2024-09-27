package com.corrinedev.lostcitieshelper;

import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BuildingCreator {

    public static void createBuilding() {
        JOptionPane.showMessageDialog(null,"Choose a PART file and your lostcities root directory");
        DirectoryChooser directoryChooser = new DirectoryChooser();
        String directory = directoryChooser.createDirectory(true);
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        try {

            JOptionPane.showMessageDialog(null,"Make sure you have an empty part!, If not create it after creating this building, this building tool autogenerates 1 floor buildings");
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
                    "      \"part\": \"" + file.getName().substring(0, file.getName().indexOf(".json")) + "\"\n" +
                    "\n" +
                    "    },\n" +
                    "\t{\n" +
                    "\t  \"top\": false,\n" +
                    "      \"cellar\": false,\n" +
                    "      \"ground\": false,\n" +
                    "      \"part\": \"empty\"\n" +
                    "    },\n" +
                    "\t{\n" +
                    "      \"top\": true,\n" +
                    "      \"cellar\": false,\n" +
                    "      \"ground\": false,\t\n" +
                    "      \"part\": \"empty\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
