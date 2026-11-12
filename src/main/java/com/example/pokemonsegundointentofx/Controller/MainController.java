package com.example.pokemonsegundointentofx.Controller;

import com.example.pokemonsegundointentofx.Pokemon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtNivel;
    @FXML private ComboBox<String> cmbTipo;

    @FXML private TableView<Pokemon> tblPokemones;
    @FXML private TableColumn<Pokemon, String> colNombre;
    @FXML private TableColumn<Pokemon, Integer> colNivel;
    @FXML private TableColumn<Pokemon, String> colTipo;
    @FXML private TableColumn<Pokemon, Double> colCosto;

    private ObservableList<Pokemon> ListaPokemones = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        cmbTipo.getItems().addAll("Agua", "Fuego", "Planta", "Electrico");
        cmbTipo.getSelectionModel().selectFirst();

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colNivel.setCellValueFactory(new PropertyValueFactory<>("nivel"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colCosto.setCellValueFactory(new PropertyValueFactory<>("costo"));

        tblPokemones.setItems(ListaPokemones);

    }
    @FXML
    private void handleRegistrar(){
        try{
            String nombre = txtNombre.getText();
            int nivel = Integer.parseInt(txtNivel.getText().trim());
            String tipo = cmbTipo.getValue();

            Pokemon nuevo = new Pokemon(nombre, nivel, tipo);
            ListaPokemones.add(nuevo);

            txtNombre.clear();
            txtNivel.clear();

        }catch (NumberFormatException e){
            mostrarAlerta("Error de entrada", "El nivel debe ser un número entero válido.");
        }catch (IllegalArgumentException e){
            mostrarAlerta("Error de validacion", e.getMessage());
        }
    }
    private void mostrarAlerta(String titulo, String mensaje){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    @FXML
    private void handleEliminar() {
        // Obtiene la fila que el usuario marcó con clic en la tabla
        Pokemon seleccionado = tblPokemones.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            ListaPokemones.remove(seleccionado);
        } else {
            mostrarAlerta("Sin selección", "Haz clic sobre un Pokémon en la tabla antes de darlo de alta.");
        }
    }
}

