package co.edu.uniquindio.proyectofinal.controller;



import java.io.IOException;
import java.time.LocalDate;

import co.edu.uniquindio.proyectofinal.App;
import co.edu.uniquindio.proyectofinal.model.Consultorio.Consultorio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class ConsultorioController {

    @FXML
    private Button bttoncrearconsultorio;

    @FXML
    private TextField txtdireccion;

    @FXML
    private TextField txtnombre;

    @FXML
    private TextField txtIdAdmin;

    @FXML
    private DatePicker txtNacimientoAdmin;

    @FXML
    private TextField txtnombreAdmin;

    private Consultorio consultorio;


    @FXML
    private void initialize() {
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void crearConsultorio(ActionEvent event) {
        String nombre = txtnombre.getText();
        String direccion = txtdireccion.getText();

        if (nombre.isEmpty() || direccion.isEmpty()) {
            mostrarMensaje("Por favor, llene todos los campos del consultorio.");
            return;
        }

        // Crear la instancia de Consultorio
        this.consultorio = Consultorio.obtenerInstancia(nombre, direccion);
        System.out.println(consultorio.toString());
        mostrarMensaje("Consultorio creado exitosamente.");

        String nombreAdmin = txtnombreAdmin.getText();
        String idAdmin = txtIdAdmin.getText();
        LocalDate fechaNacimientoAdmin = txtNacimientoAdmin.getValue();

        if (nombreAdmin.isEmpty() || idAdmin.isEmpty() || fechaNacimientoAdmin == null) {
            mostrarMensaje("Por favor, llene todos los campos del administrador.");
            return;
        }

        consultorio.crearAdministrador(nombreAdmin, idAdmin, fechaNacimientoAdmin);

         try {
            App.setRoot("admin");
        } catch (IOException e) {
            e.printStackTrace();

        }
        
    }
}


