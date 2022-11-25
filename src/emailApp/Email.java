package emailApp;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Email {
	//
	public Scanner sc = new Scanner(System.in);
	private String fname;
	private String lname;
	private String dept;
	private String email;
	private String password;
	private int mailCapacity = 500;
	private String alter_email;
	//
	public Email(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
		System.out.println("New Employee created: "+this.fname+" "+this.lname);
		//Calling methods
		this.dept = this.setDept();
		this.password = this.generate_password(8);
		this.email = this.generate_Email();
		
	}
	//
	//
	//Generate Email method, email format: fname.lname@dept.company.com
	private String generate_Email() {
		return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
	}
	//Get the Departament
	public String setDept() {
		boolean flag = false;
		System.out.println("Departament Codes: \n1 For Sales \n2 Development \n3 Accounting \n4 None");
		do {
			System.out.println("Enter departament code: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				return "Sales";
			case 2:
				return "Development";
			case 3:
				return "Accounting";
			case 0:
				return "None";
			default:
				System.out.println("Invalid Choice, try again...");
			}
		} while (!flag);
		return null;
	}
	//Generate Random Password method
	private String generate_password(int length) {
		Random r = new Random();
		String Capital_characters="ABCDEFGHIJKLMNOPQRSTUVYZ";
		String Small_characters="abcdefghijklmnopqrstuvyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*?";
		String values = Capital_characters+Small_characters+numbers+symbols;
		String password = "";
		for(int i=0;i<length;i++) {
			password = password+values.charAt(r.nextInt(values.length()));
		}//
		return password;
	}//
	//
	//Change password method, for the user
	public void set_password() {
		boolean flag = false;
		do {
			System.out.println("Do you want to change your password?(Y/N)");
			char choice = sc.next().charAt(0);
			if(choice =='Y'|| choice=='y') {
				flag = true;
				System.out.println("Enter current password: ");
				String temp = sc.next();
				if(temp.equals(this.password)) {
					System.out.println("Enter your new password: ");
					this.password = sc.next();
					System.out.println("Password changed successfully!...");
				}else {
					System.out.println("Incorrect password!...");
				}
			}else if(choice=='N' || choice=='n'){
				flag = true;
				System.out.println("Password changed cancelled.");
			}else {
				System.out.println("Enter valid choice.");
			}//
		}while(!flag);
	}//
	//
	//Set mailbox capacity.
	public void set_mailCap() {
		System.out.println("Current capacity= "+this.mailCapacity+" mb");
		System.out.println("Enter new mailbox capacity: ");
		this.mailCapacity = sc.nextInt();
		System.out.println("Mailbox capacity successfully changed!");
	}//
	//
	public void alternate_email() {
		System.out.println("Enter new alternate mail: ");
		this.alter_email = sc.next();
		System.out.println("Alternate email is set.");
	}//
	//
	//Display user information.
	public void getInfo() {
		System.out.println("New: "+this.fname+" "+this.lname);
		System.out.println("Department: "+this.dept);
		System.out.println("Email: "+this.email);
		System.out.println("Password: "+this.password);
		System.out.println("Mailbox Capacity: "+this.mailCapacity+" mb");
		System.out.println("Alternate Mail: "+this.alter_email);
	}//
	//Store in File (java.IO)
	public void storeFile() {
		try {
			FileWriter in = new FileWriter("(USE YOUR DIRECTORY PATH HERE)\\info.txt");
			in.write("First Name: "+this.fname);
			in.append("\nLast Name: "+this.lname);
			in.append("\nEmail: "+this.email);
			in.append("\nPassword: "+this.password);
			in.append("\nCapacity: "+this.mailCapacity+" mb");
			in.append("\nAlternate mail: "+this.alter_email);
			in.close();
			System.out.println("Data Stored...");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e.getMessage());
			e.getStackTrace();
		}
	}//
	//
	//Reading file method.
	public void read_file() {
		try {
			FileReader f1 = new FileReader("(USE YOUR DIRECTORY PATH HERE)\\info.txt");
			int i;
			//While condition test not null
			while((i=f1.read())!=-1) {
				System.out.print((char)i);
			}//
			f1.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e.getMessage());
			e.getStackTrace();
		}
	}//
}
