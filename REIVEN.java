import java.util.ArrayList;
import java.util.Scanner;

class Employee {
	//NAVAL Reiven Yessa
	private int id;
	private String name;
	private double rate;
	private String birthday;
    private String address;
    private String JobPosition;

	
	public Employee(final int id, final String name, final double rate ,final String birthday, final String address, final String JobPosition ) {
		this.id = id;
		this.name = ucfirst(name);
		this.rate = rate;
		this.birthday = birthday;
		this.address = address;
		this.JobPosition = JobPosition;
 	}

	public void setName(final String name) {
		this.name = ucfirst(name);
	}

	public void setRate(final double rate) {
		this.rate = rate;
	}
	public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setJobPosiition(String JobPosition){
        this.JobPosition = JobPosition;
	}
	
	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}
	public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getJobPosition() {
		return JobPosition;
	}

	public double getRate() {
		return rate;
	}

	public double getSalary(double hours) {
		return hours * rate;
	}

	private String ucfirst(String s) {
		return String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1, s.length());
	}
}

class Test {
	public static void main(final String[] args) {
		final Scanner scan = new Scanner(System.in);
		final ArrayList<Employee> employees = new ArrayList<Employee>();
		int id = 0;
		boolean exit = false;
		Employee e;
		
		do {
			System.out.println("Select Activity: ");
			System.out.println("1. Add New Employee");
			System.out.println("2. Show all Employees Details");
			System.out.println("3. Update Employee Details");
			System.out.println("4. Delete Employee Details");
			System.out.println("5. Compute Monthly Salary");
			System.out.println("6. EXIT");

			System.out.print("Option: ");
			int option = scan.nextInt();
			
			switch(option) {
				case 1: 
					int last_id = employees.isEmpty() ? 0 : 1 + employees.get(employees.size() - 1).getID();
					employees.add(addEmployee(last_id)); 
				break;
				case 2: displayEmployees(employees); break;
				case 3: 
					id = inputID();
					e = searchEmployee(id, employees);
					if(e == null) {
						System.out.println("Could not find Employee.");
					} else {
						updateEmployee(e);
					}
				break;
				case 4: 
					id = inputID();
					e = searchEmployee(id, employees);
					if(e == null) {
						System.out.println("Could not find Employee.");
					} else {
						employees.remove(e);
					}
				break;
				case 5:
					id = inputID();
					e = searchEmployee(id, employees);
					System.out.print("Enter Number of Hours: ");
					double hours = scan.nextDouble();
					System.out.println("Salary: " +  e.getSalary(hours));
					break;
				case 6: exit = true; break;
			}
		} while(!exit);
		scan.close();
	}

	public static Employee addEmployee(final int last_id) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Employee Birthday: ");
        String birthday = sc.nextLine();

        System.out.print("Employee Address: ");
        String address = sc.nextLine();

        System.out.print("Employee Job Position: ");
        String JobPosition = sc.nextLine();

        System.out.print("Employee Rate: ");
        double rate = sc.nextDouble();

        

        return new Employee(last_id,name, rate, birthday, address, JobPosition);
	}

	public static void updateEmployee(final Employee employee) {
		final Scanner scan = new Scanner(System.in);
		System.out.println("Choose a variable to update:\n1.Name\n2. Rate \n3.Birthday \n4.Address \n5.Job Position ");
		System.out.print("Option: ");
		final int option = scan.nextInt();
		
		System.out.print("Enter new value: ");
		String update = scan.next();
		switch(option) {
			case 1: employee.setName(update); break;
			case 2: employee.setRate(Double.parseDouble(update)); break;
			case 3: employee.setBirthday(update); break;
			case 4: employee.setAddress(update); break;
			case 5: employee.setJobPosiition(update); break;
		}
	}

	public static Employee searchEmployee(final int id, final ArrayList<Employee> employees) {
		for (final Employee employee : employees) {
			if (employee.getID() == id) {
				return employee;
			}
		}
		return null;
	}

	public static int inputID() {
		final Scanner scan = new Scanner(System.in);
		System.out.print("Enter Employee ID: ");
		int n = scan.nextInt();
		return n;
	}

	public static void displayEmployees(final ArrayList<Employee> employees) {
		if (employees.isEmpty()) {
			System.out.println("Cannot find employe record.");
			return;
		}
		System.out.println("List of Employees:");
		for (final Employee employee : employees) {
			System.out.println("ID: " + employee.getID() + ", Name: " + employee.getName() + ", Rate: " + employee.getRate() + ", Birthday: " + employee.getBirthday() + ", Address "
			+ employee.getAddress() + ", Job Position " + employee.getJobPosition());
		}
	}
}