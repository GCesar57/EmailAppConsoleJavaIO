package emailApp;

import java.util.Scanner;

public class EmailApp {
	public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //User info.
        System.out.println("Enter First Name: ");
        String f_name = sc.next();
        System.out.println("Enter Last Name: ");
        String l_name = sc.next();
        //Create new employee object.
        Email em1 = new Email(f_name, l_name);
        int choice = -1;
        do {
        	System.out.println("\n********\nEnter your choice:\n1.Show Info\n2.Change Password\n3.Change Mailbox Capacity\n4.Set Alternate mail\n5.Store Data in File\n6.Display Data From File\n7.Exit");
        	choice = sc.nextInt();
        	switch (choice) {
			case 1:
				em1.getInfo();
				break;
			case 2:
				em1.set_password();
				break;
			case 3:
				em1.set_mailCap();
				break;
			case 4:
				em1.alternate_email();
				break;
			case 5:
				em1.storeFile();
				break;
			case 6:
				em1.read_file();
				break;
			case 7:
				System.out.println("Thanks for using the App.");
				break;
			default:
				System.out.println("Invalid choice.\nEnter a valid choice.");
			}
        }while(choice!=7);
        
    }
}
