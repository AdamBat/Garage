package pl.coderslab.garage.model;

import java.math.BigDecimal;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String note;
	private BigDecimal wage;

	public Employee() {
		super();
	}

	public Employee(int id, String firstName, String lastName, String address, String phone, String note,
			BigDecimal wage) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.note = note;
		this.wage = wage;
	}

	public Employee(String firstName, String lastName, String address, String phone, String note, BigDecimal wage) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.note = note;
		this.wage = wage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public BigDecimal getWage() {
		return wage;
	}

	public void setWage(BigDecimal wage) {
		this.wage = wage;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", phone=" + phone + ", note=" + note + ", wage=" + wage + "]";
	}

}
