module com.jhonysystems.estructuraslineales {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.jhonysystems.estructuraslineales to javafx.fxml;
    exports com.jhonysystems.estructuraslineales;
    exports com.jhonysystems.estructuraslineales.controller;
    opens com.jhonysystems.estructuraslineales.controller to javafx.fxml;
}