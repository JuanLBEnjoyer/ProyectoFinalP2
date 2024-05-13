package co.edu.uniquindio.proyectofinal.controller;

import java.net.URL;
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
    void guardarPaciente(ActionEvent event) {

        agregarPaciente();
        
    }

    private void agregarPaciente() {

        String nombre = this.txtNombre.getText();
        String cedula = this.txtCedula.getText();
        int edad = Integer.parseInt(this.txtEdad.getText());


        Paciente paciente = new Paciente(nombre, cedula, edad);

        System.out.println(paciente.toString());

    }

    @FXML
    void initialize() {
    }

}

