package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private ObservableList<Productos> productData = FXCollections.observableArrayList();

    public Main() {
    	productData.add(new Productos("PS4", 50, 500));
    	productData.add(new Productos("Xbox", 30, 450));
        productData.add(new Productos("Pc Gaming", 10, 1000));
        productData.add(new Productos("Monitor", 89, 92));
        productData.add(new Productos("Volante", 35, 120));
        productData.add(new Productos("Scuff", 10, 200));
        productData.add(new Productos("Wii", 10, 150));
        productData.add(new Productos("Nintendo", 20, 130));
        productData.add(new Productos("Portatil", 10, 600));
    }

    public ObservableList<Productos> getProductData() {
        return productData;
    }
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Sample.fxml"));
			HBox root = (HBox)loader.load();
			Scene scene = new Scene(root,500,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			SampleController controller = loader.getController();
			controller.setMainApp(this);
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}