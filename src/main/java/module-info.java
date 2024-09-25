module com.corrinedev.lostcitieshelper {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.corrinedev.lostcitieshelper to javafx.fxml;
    exports com.corrinedev.lostcitieshelper;
}