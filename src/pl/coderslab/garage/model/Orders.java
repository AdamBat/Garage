package pl.coderslab.garage.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Orders {
	private int id;
	private LocalDate startDate;
	private LocalDate endDate;
	private int employeeId;
	private String descProblem;
	private String descRepair;
	private String status;
	private BigDecimal repairCost;
	private BigDecimal partsCost;
	private BigDecimal employeeWage;
	private BigDecimal employeeHours;

	public Orders() {
		super();
	}

	public Orders(LocalDate startDate, LocalDate endDate, int employeeId, String descProblem, String descRepair,
			String status, BigDecimal repairCost, BigDecimal partsCost, BigDecimal employeeWage,
			BigDecimal employeeHours) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.employeeId = employeeId;
		this.descProblem = descProblem;
		this.descRepair = descRepair;
		this.status = status;
		this.repairCost = repairCost;
		this.partsCost = partsCost;
		this.employeeWage = employeeWage;
		this.employeeHours = employeeHours;
	}

	public Orders(int id, LocalDate startDate, LocalDate endDate, int employeeId, String descProblem, String descRepair,
			String status, BigDecimal repairCost, BigDecimal partsCost, BigDecimal employeeWage,
			BigDecimal employeeHours) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.employeeId = employeeId;
		this.descProblem = descProblem;
		this.descRepair = descRepair;
		this.status = status;
		this.repairCost = repairCost;
		this.partsCost = partsCost;
		this.employeeWage = employeeWage;
		this.employeeHours = employeeHours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getDescProblem() {
		return descProblem;
	}

	public void setDescProblem(String descProblem) {
		this.descProblem = descProblem;
	}

	public String getDescRepair() {
		return descRepair;
	}

	public void setDescRepair(String descRepair) {
		this.descRepair = descRepair;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getRepairCost() {
		return repairCost;
	}

	public void setRepairCost(BigDecimal repairCost) {
		this.repairCost = repairCost;
	}

	public BigDecimal getPartsCost() {
		return partsCost;
	}

	public void setPartsCost(BigDecimal partsCost) {
		this.partsCost = partsCost;
	}

	public BigDecimal getEmployeeWage() {
		return employeeWage;
	}

	public void setEmployeeWage(BigDecimal employeeWage) {
		this.employeeWage = employeeWage;
	}

	public BigDecimal getEmployeeHours() {
		return employeeHours;
	}

	public void setEmployeeHours(BigDecimal employeeHours) {
		this.employeeHours = employeeHours;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", employeeId=" + employeeId
				+ ", descProblem=" + descProblem + ", descRepair=" + descRepair + ", status=" + status + ", repairCost="
				+ repairCost + ", partsCost=" + partsCost + ", employeeWage=" + employeeWage + ", employeeHours="
				+ employeeHours + "]";
	}

}
