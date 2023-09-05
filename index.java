import java.io.Serializable;
import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Scanner;
import java.util.*;

class Labour {

	private int id;
	private String name;
	private int  age;
	private String desiganation;
	private String department;
	private double salary;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesiganation() {
		return desiganation;
	}
	public void setDesiganation(String desiganation) {
		this.desiganation = desiganation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Labour [id=" + id + ", name=" + name + ", age=" + age + ", desiganation=" + desiganation
				+ ", department=" + department + ", salary=" + salary + "]";
	}
	public Labour(int id, String name, int age, String desiganation, String department, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.desiganation = desiganation;
		this.department = department;
		this.salary = salary;
	}
}
class LabourService {

	HashSet<Labour> labset=new HashSet<>();

	Labour lab1=new Labour(101, "Shital", 24, "Developer", "IT", 25000);
	Labour lab2=new Labour(102, "Meena", 26, "Tester","CO", 57000);
	Labour lab3=new Labour(103, "Bob", 20, "DevOps Eng","Admin", 5000);
	Labour lab4=new Labour(104, "Max", 27, "System Eng","CO",  70000);

	Scanner sc=new Scanner(System.in);
	boolean found=false;
	int id;
	String name;
	int age;
	String department;
	String desiganation;
	double sal;

	public LabourService() {

		labset.add(lab1);
		labset.add(lab2);
		labset.add(lab3);
		labset.add(lab4);

	}

	//view all Labours
	public void viewAlllabs() {
		for(Labour lab:labset) {
			System.out.println(lab);
		}
	}
	//view lab based on there id
	public void viewlab(){

		System.out.println("Enter id: ");
		id=sc.nextInt();
		for(Labour lab:labset) {
			if(lab.getId()==id) {
				System.out.println(lab);
				found=true;
			}

		}
		if(!found) {
			System.out.println("Labour with this id is not present");
		}
	}
	//update the Labour
	public void updateLabour() {
		System.out.println("Enter id: ");
		id=sc.nextInt();
		boolean found=false;
		for(Labour lab:labset) {
			if(lab.getId()==id) {
				System.out.println("Enter name: ");
				name=sc.next();
				System.out.println("Enter new Salary");
				sal=sc.nextDouble();
				lab.setName(name);
				lab.setSalary(sal);
				System.out.println("Updated Details of Labour are: ");
				System.out.println(lab);
				found=true;
			}
		}
		if(!found) {
			System.out.println("Labour is not present");
		}
		else {
			System.out.println("Labour details updated successfully !!");
		}
	}
	//delete lab
	public void deletelab() {
		System.out.println("Enter id");
		id=sc.nextInt();
		boolean found=false;
		Labour labdelete=null;
		for(Labour lab:labset) {
			if(lab.getId()==id) {
				labdelete=lab;
				found=true;
			}
		}
		if(!found) {
			System.out.println("Labour is not present");
		}
		else {
			labset.remove(labdelete);
			System.out.println("Labour deleted successfully!!");
		}
	}
	//add lab
	public void addlab() {
		System.out.println("Enter id:");
		id=sc.nextInt();
		System.out.println("Enter name");
		name=sc.next();
		System.out.println("Enter age");
		age=sc.nextInt();
		System.out.println("enter Desiganation");
		desiganation=sc.next();
		System.out.println("Enter Department");
		department=sc.next();
		System.out.println("Enter sal");
		sc.nextDouble();

		Labour lab=new Labour(id, name, age, desiganation, department, sal);

		labset.add(lab);
		System.out.println(lab);
		System.out.println("labloytee addeed successsfully");

	}

}

public class index {
	static boolean ordering = true;
	public static void menu() {
        System.out.println("****************Welcome To Labour Managment System *********** "
        		+ "\n1. Add Labour "
        		+ "\n2.View Labour"
        		+ "\n3.Update Labour"
        		+ "\n4. Delete Labour"
        		+ "\n5.View All Labour"
        		+ "\n6. Exist ");
    }
	 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		LabourService service=new LabourService();
		
		do {
			menu();
			System.out.println("Enter your Choice");
			int choice=sc.nextInt();
			switch(choice) {
			
			case 1:
				System.out.println("Add Labour");
				service.addlab();
				break;
			case 2:
				System.out.println("View Labour");
				service.viewlab();
				break;
			case 3:
				System.out.println("Update Labour");
				service.updateLabour();
				break;
			case 4:
				System.out.println("Delete Labour");
				service.deletelab();
				break;
			case 5:
				System.out.println("view All Labour");
				service.viewAlllabs();
				break;
			case 6:
				System.out.println("Thank you for using application!!");
				System.exit(0);
				
			default:
				System.out.println("Please enter valid choice");
				break;
			
			
			}
			
		}while(ordering);
		
			}
		
	}

