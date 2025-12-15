module com.jhonysiystem.estructurasnolineales {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.jhonysiystem.estructurasnolineales.controller to javafx.fxml;
    exports com.jhonysiystem.estructurasnolineales;
}
