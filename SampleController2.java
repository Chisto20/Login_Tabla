package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import application.Main;
import application.Productos;

public class SampleController2 {

	private Main main;

	@FXML
	private TableView<Productos> productoTable;
	@FXML
	private TableColumn<Productos, String> descripcionColumn;
	@FXML
	private TableColumn<Productos, Integer> stockColumn;

	@FXML
	private Label txtDescripcion;

	@FXML
	private Label txtPrecio;

	@FXML
	private Label txtStock;

	@FXML
	private Label txtFecha;

	public SampleController2() {
	}
	@FXML
	private void initialize() {
		descripcionColumn.setCellValueFactory(cellData -> cellData.getValue().descripcionProperty());
		stockColumn.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
		showProductosDetails(null);
		
		productoTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showProductosDetails(newValue));

	}

	public void setMainApp(Main main) {
		this.main = main;

		productoTable.setItems(this.main.getProductData());
	}

	private void showProductosDetails(Productos productos) {
		if (productos != null) {
			txtDescripcion.setText(productos.getDescripcion());
			txtStock.setText(Integer.toString(productos.getStock()));
			txtPrecio.setText(Integer.toString(productos.getprecio()));
			txtFecha.setText(DateUtil.format(productos.getfecha()));

		} else {
			txtDescripcion.setText("");
			txtStock.setText("");
			txtPrecio.setText("");
			txtFecha.setText("");
		}
	}

}