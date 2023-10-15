import java.util.Scanner;

public class PhoneBook {

	public static void main(String[] args) {
		LinkedList<Contact> CList = new LinkedList<Contact>();
		boolean main_run = true;
		Contact temp;
		LinkedList<Contact> Ltemp;
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Linked Tree phonebook !");
		do {
			System.out.println("Please choose an option");
			System.out.println("1. Add a contact");
			System.out.println("2. Search for a contact");
			System.out.println("3. Delete a contact");
			System.out.println("4. Schedule an event");
			System.out.println("5. Print event details");
			System.out.println("6. Print contacts by first name");
			System.out.println("7. Print all events alphabetically");
			System.out.println("8. Exit");
			System.out.println("");
			System.out.print("Enter your choice: ");
			String choice = input.nextLine();
			System.out.println();
			switch (choice) {
			case "1":

				System.out.print("Enter the contact's name:");
				String CoName = input.nextLine();
				System.out.print("Enter the contact's phone number:");
				String CoPhone = input.nextLine();
				System.out.print("Enter the contact's email address:");
				String CoEmail = input.nextLine();
				System.out.print("Enter the contact's address:");
				String CoAddress = input.nextLine();
				System.out.print("Enter the contact's birthday:");
				String CoBtithday = input.nextLine();
				System.out.print("Enter any notes for the contact:");
				String CoNote = input.nextLine();
				System.out.println("");

				// ADDING CONTACT LOGIC HERE//

				System.out.println("Contact added successfully!");

				break;
			case "2":

				System.out.println("Enter search criteria: ");
				System.out.println("1.Name ");
				System.out.println("2.Phone Number");
				System.out.println("3.Email address");
				System.out.println("4.Address");
				System.out.println("5.Birthday");
				System.out.println("");

				System.out.print("Enter your choice: ");
				String Scriteria = input.nextLine();
				System.out.println("");
				switch (Scriteria) {
				case "1":
					System.out.print("Enter contact's name: ");
					String Name = input.nextLine();
					System.out.println();
					temp = CList.searchByName(Name);
					if (temp == null)
						System.out.println("Contact not found!");
					else {
						System.out.println("Contact Found!");
						temp.display();
					}

					break;
				case "2":
					System.out.print("Enter contact's Phone number: ");
					String number = input.nextLine();
					System.out.println();
					temp = CList.searchByPhoneNumber(number);
					if (temp == null)
						System.out.println("Contact not found!");
					else {
						System.out.println("Contact Found!");
						temp.display();
					}

					break;
				case "3":
					System.out.print("Enter contact's Email: ");
					String Email = input.nextLine();
					System.out.println();
					temp = CList.searchByEmailAddress(Email);
					if (temp == null)
						System.out.println("Contact not found!");
					else {
						System.out.println("Contact Found!");
						temp.display();
					}
					// Case logic here

					break;
				case "4":
					System.out.print("Enter contact's Address: ");
					String Address = input.nextLine();
					System.out.println();
					Ltemp = CList.searchByAddress(Address);
					if (Ltemp == null)
						System.out.println("Contact not found!");
					else if (Ltemp.getLength() == 1) {
						System.out.println("Contact Found!");
						Ltemp.displayAll();
					} else {
						System.out.println("Multiple contacts found!");
						Ltemp.displayAll();

					}

					break;
				case "5":
					System.out.print("Enter contact's Birthday: ");
					String Bday = input.nextLine();
					System.out.println();
					Ltemp = CList.searchByBirthday(Bday);
					if (Ltemp == null)
						System.out.println("Contact not found!");
					else if (Ltemp.getLength() == 1) {
						System.out.println("Contact Found!");
						Ltemp.displayAll();
					} else {
						System.out.println("Multiple contacts found!");
						Ltemp.displayAll();

					}

					break;
				default:
					System.out.println("Wrong input");

				}

				break;
			case "3":
				break;
			case "4":
				System.out.print("Enter event title: ");
				String EventTitle = input.nextLine();
				System.out.print("Enter contact name: ");
				String ContactName = input.nextLine();
				System.out.print("Enter event date and time(MM/DD/YYYY HH:MM): ");
				String DateAndTime = input.nextLine();
				System.out.print("Enter event location: ");
				String EventLocation = input.nextLine();
				System.out.print("\n");

				// ADDING EVENT LOGIC HERE//

				System.out.println("Event scheduled successfully\n");
				break;
			case "5":
				boolean case5RUN = true;
				while (case5RUN) {
					System.out.println("Enter search criteria: ");
					System.out.println("1.Contact name ");
					System.out.println("2.Event title\n");

					System.out.print("Enter your choice: ");
					String criteria = input.nextLine();

					switch (criteria) {
					case "1":
						System.out.print("Enter contact name: ");
						String Contactname = input.nextLine();
						System.out.println();

						case5RUN = false;
						// Case logic here

						break;

					case "2":
						System.out.print("Enter the event title: ");
						String Etitle = input.nextLine();
						System.out.println();
						// Case logic here
						case5RUN = false;

						break;

					default:
						System.out.println("Wrong input");
					}
				}

				break;
			case "6":
				System.out.print("Enter the first name: ");
				String firstname = input.next();
				System.out.println("");
				// case logic here
				break;
			case "7":
				break;
			case "8":
				System.out.print("Goodbye!");
				main_run = false;
				break;
			case "\n":
				break;

			default:

			}

		} while (main_run);

	}

}
