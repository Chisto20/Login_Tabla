package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import application.Main;


public class SampleController {

	private Main main;
	private BorderPane rootLayout;
	@FXML
	private Button btnLogin;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtPassword;

	@FXML
	void login(ActionEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informaci�n");
		alert.setHeaderText(null);

		String email = "chisto@gmail.com";
		String password = "qwerty";

		if (txtEmail.getText().equals(email) && txtPassword.getText().equals(password)) {

			alert.setContentText("Se ha iniciado sesi�n correctamente");
			Stage stage = new Stage();
			
			try {
				FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Main.class.getResource("RootLayout.fxml"));
	            rootLayout = (BorderPane) loader.load();

			} catch (IOException e) {

				e.printStackTrace();
			}

			Scene escena = new Scene(rootLayout);

			stage.setTitle("Tabla de datos");
			stage.setScene(escena);
			stage.show();
			showSample2();
			
			((Node)(event.getSource())).getScene().getWindow().hide();

		} else {

			alert.setContentText("Email o contrase�a incorrectos");
			System.out.println(email + " " + password + " " + txtEmail.getText() + " " + txtPassword.getText() + " ");
		}

		alert.showAndWait();

	}
	
	public void showSample2() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Sample2.fxml"));
            AnchorPane Sample2product = (AnchorPane) loader.load();
            
            rootLayout.setCenter(Sample2product);
            
            SampleController2 controller = loader.getController();
            controller.setMainApp(main);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void setMainApp(Main main) {
		
		this.main = main;
	}

}