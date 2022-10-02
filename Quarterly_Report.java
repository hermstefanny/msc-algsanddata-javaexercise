import java.util.ArrayList;

	class MonthlySales {
		// ATTRIBUTES
		private double value;
		private String monthName;
		private int assignedQuarter;

		// METHODS
		// Constructor
		public MonthlySales(double valueIn, String monthNameIn) {

			validateIn(valueIn);
			monthName = monthNameIn.toUpperCase();
			assignQuarter();
		}

		// Function to validate the value entered: It prints a warning if a negative
		// value is entered
		public void validateIn(double valueIn) {
			if (valueIn > 0) {
				value = valueIn;
			} else {
				value = 0;
				System.out.println("WARNING: This value is out of range. This sale has been saved as 0");
				System.out.println("Please, check the accuracy of the data");
			}
		}

		public void assignQuarter() {

			switch (monthName) {
			case "JANUARY":
			case "FEBRUARY":
			case "MARCH":
				assignedQuarter = 1;
				break;

			case "APRIL":
			case "MAY":
			case "JUNE":
				assignedQuarter = 2;
				break;

			case "JULY":
			case "AUGUST":
			case "SEPTEMBER":
				assignedQuarter = 3;
				break;

			case "OCTOBER":
			case "NOVEMBER":
			case "DECEMBER":
				assignedQuarter = 4;
				break;

			default:
				System.out.println("The name of the month could not be recognized");
			}
		}

		// Return the value with format *1000
		public double getValue() {
			return value * 1000;
		}

		public String getMonthName() {
			return monthName;
		}

		public int getQuarter() {
			return assignedQuarter;
		}

		public void setValue(double valueIn) {
			validateIn(valueIn);
		}

		public void setMonthName(String monthNameIn) {
			monthName = monthNameIn;
		}
	}

	class DepartmentSales {

		// ATTRIBUTES
		ArrayList<MonthlySales> quarterSales;
		private String departmentName;
		private int registeredQuarter;

		// Attributes used to return useful values
		private double totalDepartmentSales = 0;
		private double averageDepartmentSales = 0;
		private double maxValue = 0;
		private MonthlySales bestMonth;

		// METHODS
		// Constructor
		public DepartmentSales(String departmentNameIn, int quarterIn) {
			departmentName = departmentNameIn;
			registeredQuarter = quarterIn;
			quarterSales = new ArrayList<>();
		}

		// Getter methods

		public String getDeparmentName() {
			return departmentName;
		}

		public int getQuarter() {
			return registeredQuarter;
		}

		public double getMaxValue() {
			return maxValue;
		}

		// Setter Methods
		public void setDepartmentName(String departmentNameIn) {
			departmentName = departmentNameIn;
		}

		public void setQuarter(int quarterIn) {
			registeredQuarter = quarterIn;
		}

		// Method used to add a MonthlySales in ArrayList
		public void addMonthlySale(MonthlySales monthlySaleIn) {
			int d1 = 0;
			// Validate if the month is not already entered on the ArrayList
			for (int i = 0; i < quarterSales.size(); i++) {
				if (monthlySaleIn.getMonthName().equals(quarterSales.get(i).getMonthName())) {
					d1++;
					System.out.println("WARNING");
					System.out.println(
							"The month " + monthlySaleIn.getMonthName() + " is already registered for this quarter");
				}
			}

			// Validate if the quarter entered corresponds to the month
			// Only if the quarters match, the object is added to the ArrayList
			if (monthlySaleIn.getQuarter() == registeredQuarter && d1 == 0) {
				quarterSales.add(monthlySaleIn);
			} else if (d1 == 0) {
				System.out.println("The submitted month (" + monthlySaleIn.getMonthName()
						+ ") does not match the registered quarter ");
				System.out.println("The item has not been added");
			}
		}

		// Method that returns the total department Sales
		public double calculateTotalDepartmentSales() {

			for (int i = 0; i < quarterSales.size(); i++) {
				totalDepartmentSales = totalDepartmentSales + quarterSales.get(i).getValue();
			}
			return totalDepartmentSales;
		}

		public double calculateAverageDepartmentSales() {
			averageDepartmentSales = totalDepartmentSales / quarterSales.size();
			return averageDepartmentSales;
		}

		public MonthlySales calculateBestMonth() {
			int indexMax = 0;
			for (int i = 0; i < quarterSales.size(); i++) {
				if (quarterSales.get(i).getValue() > maxValue) {
					maxValue = quarterSales.get(i).getValue();
					indexMax = i;
				}
			}
			bestMonth = quarterSales.get(indexMax);
			return bestMonth;
		}

		public void listDepartmentSales() {
			for (int i = 0; i < quarterSales.size(); i++) {
				System.out.println(quarterSales.get(i));
			}
		}

	}

public class Quarterly_Report {
	public static void main(String[] args) {

		// --------------------CREATING THE INSTANCES OF MONTHLY
		// SALES-------------------------//

		// Creation of the MonthlySales objects for the Electrical Department
		MonthlySales aprilElectrical = new MonthlySales(67, "APRIL");
		MonthlySales mayElectrical = new MonthlySales(63, "may");
		MonthlySales juneElectrical = new MonthlySales(78, "JUNE");
		MonthlySales julyElectrical = new MonthlySales(78, "JULY");
		MonthlySales augustElectrical = new MonthlySales(104, "August");
		MonthlySales septemberElectrical = new MonthlySales(103, "SEPTEMBER");

		// Creation of the MonthlySales objects for the Kitchen Department
		MonthlySales aprilKitchen = new MonthlySales(65, "APRIL");
		MonthlySales mayKitchen = new MonthlySales(67, "MAY");
		MonthlySales juneKitchen = new MonthlySales(56, "JUNE");
		MonthlySales julyKitchen = new MonthlySales(45, "juLy");
		MonthlySales augustKitchen = new MonthlySales(56, "AUGUST");
		MonthlySales septemberKitchen = new MonthlySales(72, "SEPTEMBER");

		// Creation of the MonthlySales objects for the Bathroom Department
		MonthlySales aprilBathroom = new MonthlySales(63, "april");
		MonthlySales mayBathroom = new MonthlySales(63, "MAY");
		MonthlySales juneBathroom = new MonthlySales(65, "JUNE");
		MonthlySales julyBathroom = new MonthlySales(71, "juLy");
		MonthlySales augustBathroom = new MonthlySales(73, "August");
		MonthlySales septemberBathroom = new MonthlySales(69, "SEPTEMBER");

		// Creation of the MonthlySales objects for the Soft Furnishing Department
		MonthlySales aprilSFurnishing = new MonthlySales(18, "April");
		MonthlySales maySFurnishing = new MonthlySales(24, "May");
		MonthlySales juneSFurnishing = new MonthlySales(22, "June");
		MonthlySales julySFurnishing = new MonthlySales(19, "July");
		MonthlySales augustSFurnishing = new MonthlySales(17, "August");
		MonthlySales septemberSFurnishing = new MonthlySales(16, "September");

		// Creation of the MonthlySales objects for the Accesories Department
		MonthlySales aprilAccessories = new MonthlySales(16, "APRIL");
		MonthlySales mayAccessories = new MonthlySales(23, "MAY");
		MonthlySales juneAccessories = new MonthlySales(21, "JUNE");
		MonthlySales julyAccessories = new MonthlySales(19, "JULY");
		MonthlySales augustAccessories = new MonthlySales(20, "AUGUST");
		MonthlySales septemberAccessories = new MonthlySales(19, "SEPTEMBER");

		// -----------------------CREATING THE DEPARTMENT SALES BY
		// QUARTER---------------------------//
		// Electrical Department
		DepartmentSales electricalQ2 = new DepartmentSales("Electrical", 2);
		DepartmentSales electricalQ3 = new DepartmentSales("Electrical", 3);

		// Kitchen Department
		DepartmentSales kitchenQ2 = new DepartmentSales("Kitchen", 2);
		DepartmentSales kitchenQ3 = new DepartmentSales("Kitchen", 3);

		// Bathroom Department
		DepartmentSales bathroomQ2 = new DepartmentSales("Bathroom", 2);
		DepartmentSales bathroomQ3 = new DepartmentSales("Bathroom", 3);

		// Soft Furnishing Department
		DepartmentSales sFurnishingQ2 = new DepartmentSales("Soft Furnishing", 2);
		DepartmentSales sFurnishingQ3 = new DepartmentSales("Soft Furnishing", 3);

		// Accessories Department
		DepartmentSales accessoriesQ2 = new DepartmentSales("Accesories", 2);
		DepartmentSales accessoriesQ3 = new DepartmentSales("Accesories", 3);

		// ---------------ADDING THE INSTANCES OF MONTHLY SALES TO EACH DEPARTMENT BY
		// QUARTER---------------//
		// Electrical Department
		// 2nd Quarter
		electricalQ2.addMonthlySale(aprilElectrical);
		electricalQ2.addMonthlySale(mayElectrical);
		electricalQ2.addMonthlySale(juneElectrical);

		// 3rd Quarter
		electricalQ3.addMonthlySale(julyElectrical);
		electricalQ3.addMonthlySale(augustElectrical);
		electricalQ3.addMonthlySale(septemberElectrical);

		// Kitchen Department
		// 2nd Quarter
		kitchenQ2.addMonthlySale(aprilKitchen);
		kitchenQ2.addMonthlySale(mayKitchen);
		kitchenQ2.addMonthlySale(juneKitchen);

		// 3rd Quarter
		kitchenQ3.addMonthlySale(julyKitchen);
		kitchenQ3.addMonthlySale(augustKitchen);
		kitchenQ3.addMonthlySale(septemberKitchen);

		// Bathroom Department
		// 2nd Quarter
		bathroomQ2.addMonthlySale(aprilBathroom);
		bathroomQ2.addMonthlySale(mayBathroom);
		bathroomQ2.addMonthlySale(juneBathroom);

		// 3rd Quarter
		bathroomQ3.addMonthlySale(julyBathroom);
		bathroomQ3.addMonthlySale(augustBathroom);
		bathroomQ3.addMonthlySale(septemberBathroom);

		// Soft Furnishing Department
		// 2nd Quarter
		sFurnishingQ2.addMonthlySale(aprilSFurnishing);
		sFurnishingQ2.addMonthlySale(maySFurnishing);
		sFurnishingQ2.addMonthlySale(juneSFurnishing);

		// 3rd Quarter
		sFurnishingQ3.addMonthlySale(julySFurnishing);
		sFurnishingQ3.addMonthlySale(augustSFurnishing);
		sFurnishingQ3.addMonthlySale(septemberSFurnishing);

		// Accessories Department
		// 2nd Quarter
		accessoriesQ2.addMonthlySale(aprilAccessories);
		accessoriesQ2.addMonthlySale(mayAccessories);
		accessoriesQ2.addMonthlySale(juneAccessories);

		// 3rd Quarter
		accessoriesQ3.addMonthlySale(julyAccessories);
		accessoriesQ3.addMonthlySale(augustAccessories);
		accessoriesQ3.addMonthlySale(septemberAccessories);

		// ------------------- CALLING OF THE METHODS AND PRINTING
		// RESULTS--------------------------//
		// -----------------------------------------------------------------------------------------//
		System.out.println("\n--------------------Total Department Sales--------------------");

		// Electrical Department
		System.out.println(electricalQ2.getQuarter() + " Quarter  totals, " + electricalQ2.getDeparmentName()
				+ " Department: £" + electricalQ2.calculateTotalDepartmentSales());
		System.out.println(electricalQ3.getQuarter() + " Quarter  totals, " + electricalQ3.getDeparmentName()
				+ " Department: £" + electricalQ3.calculateTotalDepartmentSales());

		// Kitchen Department
		System.out.println(kitchenQ2.getQuarter() + " Quarter  totals, " + kitchenQ2.getDeparmentName()
				+ " Department: £" + kitchenQ2.calculateTotalDepartmentSales());
		System.out.println(kitchenQ3.getQuarter() + " Quarter  totals, " + kitchenQ3.getDeparmentName()
				+ " Department: £" + kitchenQ3.calculateTotalDepartmentSales());

		// Bathroom Department
		System.out.println(bathroomQ2.getQuarter() + " Quarter  totals, " + bathroomQ2.getDeparmentName()
				+ " Department: £" + bathroomQ2.calculateTotalDepartmentSales());
		System.out.println(bathroomQ3.getQuarter() + " Quarter  totals, " + bathroomQ3.getDeparmentName()
				+ " Department: £" + bathroomQ3.calculateTotalDepartmentSales());

		// Soft Furnishing Department
		System.out.println(sFurnishingQ2.getQuarter() + " Quarter  totals, " + sFurnishingQ2.getDeparmentName()
				+ " Department: £" + sFurnishingQ2.calculateTotalDepartmentSales());
		System.out.println(sFurnishingQ3.getQuarter() + " Quarter  totals, " + sFurnishingQ3.getDeparmentName()
				+ " Department: £" + sFurnishingQ3.calculateTotalDepartmentSales());

		// Accessories Department
		System.out.println(accessoriesQ2.getQuarter() + " Quarter  totals, " + accessoriesQ2.getDeparmentName()
				+ " Department: £" + accessoriesQ2.calculateTotalDepartmentSales());
		System.out.println(accessoriesQ3.getQuarter() + " Quarter  totals, " + accessoriesQ3.getDeparmentName()
				+ " Department: £" + accessoriesQ3.calculateTotalDepartmentSales());

		// -----------------------------------------------------------------------------------------//
		System.out.println("\n--------------------Best Month by Department--------------------");
		// Electrical Department
		System.out.println(electricalQ2.getQuarter() + " Quarter, " + electricalQ2.getDeparmentName() + ": "
				+ electricalQ2.calculateBestMonth().getMonthName() + " with £" + electricalQ2.getMaxValue());
		System.out.println(electricalQ3.getQuarter() + " Quarter, " + electricalQ3.getDeparmentName() + ": "
				+ electricalQ3.calculateBestMonth().getMonthName() + " with £" + electricalQ3.getMaxValue());

		// Kitchen Department
		System.out.println(kitchenQ2.getQuarter() + " Quarter, " + kitchenQ2.getDeparmentName() + ": "
				+ kitchenQ2.calculateBestMonth().getMonthName() + " with £" + kitchenQ2.getMaxValue());
		System.out.println(kitchenQ3.getQuarter() + " Quarter, " + kitchenQ3.getDeparmentName() + ": "
				+ kitchenQ3.calculateBestMonth().getMonthName() + " with £" + kitchenQ3.getMaxValue());

		// Bathroom Department
		System.out.println(bathroomQ2.getQuarter() + " Quarter, " + bathroomQ2.getDeparmentName() + ": "
				+ bathroomQ2.calculateBestMonth().getMonthName() + " with £" + bathroomQ2.getMaxValue());
		System.out.println(bathroomQ3.getQuarter() + " Quarter, " + bathroomQ3.getDeparmentName() + ": "
				+ bathroomQ3.calculateBestMonth().getMonthName() + " with £" + bathroomQ3.getMaxValue());

		// Soft Furnishing Department
		System.out.println(sFurnishingQ2.getQuarter() + " Quarter, " + sFurnishingQ2.getDeparmentName() + ": "
				+ sFurnishingQ2.calculateBestMonth().getMonthName() + " with £" + sFurnishingQ2.getMaxValue());
		System.out.println(sFurnishingQ3.getQuarter() + " Quarter, " + sFurnishingQ3.getDeparmentName() + ": "
				+ sFurnishingQ3.calculateBestMonth().getMonthName() + " with £" + sFurnishingQ3.getMaxValue());

		// Accessories Department
		System.out.println(accessoriesQ2.getQuarter() + " Quarter, " + accessoriesQ2.getDeparmentName() + ": "
				+ accessoriesQ2.calculateBestMonth().getMonthName() + " with £" + accessoriesQ2.getMaxValue());
		System.out.println(accessoriesQ3.getQuarter() + " Quarter, " + accessoriesQ3.getDeparmentName() + ": "
				+ accessoriesQ3.calculateBestMonth().getMonthName() + " with £" + accessoriesQ3.getMaxValue());

		// -------------------------------------------------------------------------------------------//
		System.out.println("\n--------------------New Target Sales for Next Quarter--------------------");
		// Electrical Department
		System.out.println("Goal for the " + electricalQ3.getDeparmentName() + " Department for "
				+ (electricalQ3.getQuarter() + 1) + " Quarter: £"
				+ String.format("%,.2f", electricalQ3.calculateAverageDepartmentSales() * 1.12));

		// Kitchen Department
		System.out.println(
				"Goal for the " + kitchenQ3.getDeparmentName() + " Department for " + (kitchenQ3.getQuarter() + 1)
						+ " Quarter: £" + String.format("%,.2f", kitchenQ3.calculateAverageDepartmentSales() * 1.12));

		// Bathroom Department
		System.out.println(
				"Goal for the " + bathroomQ3.getDeparmentName() + " Department for " + (bathroomQ3.getQuarter() + 1)
						+ " Quarter: £" + String.format("%,.2f", bathroomQ3.calculateAverageDepartmentSales() * 1.12));

		// Soft Furnishing
		System.out.println("Goal for the " + sFurnishingQ3.getDeparmentName() + " Department for "
				+ (sFurnishingQ3.getQuarter() + 1) + " Quarter: £"
				+ String.format("%,.2f", sFurnishingQ3.calculateAverageDepartmentSales() * 1.12));

		// Accessories
		System.out.println("Goal for the " + accessoriesQ3.getDeparmentName() + " Department for "
				+ (accessoriesQ3.getQuarter() + 1) + " Quarter: £"
				+ String.format("%,.2f", accessoriesQ3.calculateAverageDepartmentSales() * 1.12));
	}

}
