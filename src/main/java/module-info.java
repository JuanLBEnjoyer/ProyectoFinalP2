module co.edu.uniquindio.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.proyectofinal to javafx.fxml;
    exports co.edu.uniquindio.proyectofinal;

    opens co.edu.uniquindio.proyectofinal.controller;
    exports co.edu.uniquindio.proyectofinal.controller;
}
