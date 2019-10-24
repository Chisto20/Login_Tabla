package application;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Productos {

	private final StringProperty descripcion;
	private final IntegerProperty stock;
	private final IntegerProperty precio;
	private final ObjectProperty<LocalDate> fecha;

	public Productos() {
		this(null,0,0);
	}

	public Productos(String descripcion, int stock, int precio) {
		this.descripcion = new SimpleStringProperty(descripcion);
		this.stock = new SimpleIntegerProperty(stock);
		this.precio = new SimpleIntegerProperty(precio);
		this.fecha = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 05, 23));
	}

	public String getDescripcion() {
		return descripcion.get();
	}

	public void setDescripcione(String descripcion) {
		this.descripcion.set(descripcion);
	}

	public StringProperty descripcionProperty() {
		return descripcion;
	}
	

	public int getStock() {
		return stock.get();
	}

	public void setStock(int stock) {
		this.stock.set(stock);
	}

	public IntegerProperty stockProperty() {
		return stock;
	}

	public int getprecio() {
		return precio.get();
	}

	public void setprecio(int precio) {
		this.precio.set(precio);
	}

	public IntegerProperty precioProperty() {
		return precio;
	}
	public LocalDate getfecha() {
		return fecha.get();
	}

	public void setFecha(LocalDate fecha) {
		this.fecha.set(fecha);
	}

	public ObjectProperty<LocalDate> fechaProperty() {
		return fecha;
	}
}