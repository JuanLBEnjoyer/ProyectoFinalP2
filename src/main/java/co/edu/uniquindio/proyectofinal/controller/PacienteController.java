package co.edu.uniquindio.proyectofinal.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyectofinal.model.Personal.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PacienteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistro;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDireccion;

    @FXML
    void guardarPaciente(ActionEvent event) {

        agregarPaciente();
        
    }

    private void agregarPaciente() {

        String nombre = this.txtNombre.getText();
        String cedula = this.txtCedula.getText();
    

        Paciente paciente = new Paciente(nombre, cedula, LocalDate.of(2000,2,24), null);

        System.out.println(paciente.toString());

    }

    @FXML
    void initialize() {}

}

