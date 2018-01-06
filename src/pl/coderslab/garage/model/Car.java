package pl.coderslab.garage.model;

import java.time.LocalDate;

public class Car {
	private int id;
	private int client_id;
	private String brand;
	private String model;
	private int year;
	private int regNr;
	private LocalDate nextReview;

	public Car() {
		super();
	}

	public Car(int client_id, String brand, String model, int year, int regNr, LocalDate nextReview) {
		super();
		this.client_id = client_id;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.regNr = regNr;
		this.nextReview = nextReview;
	}

	public Car(int id, int client_id, String brand, String model, int year, int regNr, LocalDate nextReview) {
		super();
		this.id = id;
		this.client_id = client_id;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.regNr = regNr;
		this.nextReview = nextReview;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRegNr() {
		return regNr;
	}

	public void setRegNr(int regNr) {
		this.regNr = regNr;
	}

	public LocalDate getNextReview() {
		return nextReview;
	}

	public void setNextReview(LocalDate nextReview) {
		this.nextReview = nextReview;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", client_id=" + client_id + ", brand=" + brand + ", model=" + model + ", year=" + year
				+ ", regNr=" + regNr + ", nextReview=" + nextReview + "]";
	}

}
