import java.util.Scanner;

public class PhoneBook {

	public static void main(String[] args) {
		LinkedList<Contact> contacts = new LinkedList<Contact>();
		LinkedList<Event> events = new LinkedList<Event>();
		Contact cTemp = null;
		LinkedList<Contact> cTemps;
		Event eTemp;
		LinkedList<Event> eTemps;
		Scanner input = new Scanner(System.in);
		boolean main_run = true;

		System.out.println("Welcome to the Linked Tree phonebook !");
		do {
			try {
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
				System.out.println("");
				switch (choice) {
				case "1": // Case 1 Add contact

					System.out.print("Enter the contact's name: ");
					String CoName = input.nextLine();
					System.out.print("Enter the contact's phone number: ");
					String CoPhone = input.nextLine();
					System.out.print("Enter the contact's email address: ");
					String CoEmail = input.nextLine();
					System.out.print("Enter the contact's address: ");
					String CoAddress = input.nextLine();
					System.out.print("Enter the contact's birthday: ");
					String CoBtithday = input.nextLine();
					System.out.print("Enter any notes for the contact: ");
					String CoNote = input.nextLine();
					System.out.println("");

					try {
						cTemp = new Contact(CoName, CoPhone, CoEmail, CoAddress, CoBtithday, CoNote);
						contacts.addContact(cTemp);
						System.out.println("Contact added succesfully!");
						System.out.println("");
					} catch (IllegalArgumentException a) {
						System.out.println(a.getMessage());
					}
					break;

				case "2": // Case 2 search for contact "nested switch"

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
						try {
							String Name = input.nextLine();
							System.out.println();
							cTemp = contacts.searchByName(Name);
							System.out.println("Contact Found!");
							System.out.println("");
							cTemp.display();
						} catch (IllegalArgumentException a) {
							System.out.println(a.getMessage());
						}
						break;

					case "2":
						System.out.print("Enter contact's Phone number: ");
						try {
							String number = input.nextLine();
							System.out.println("");
							cTemp = contacts.searchByPhoneNumber(number);
							System.out.println("Contact Found!");
							System.out.println("");
							cTemp.display();
						} catch (IllegalArgumentException a) {
							System.out.println(a.getMessage());
						}
						break;

					case "3":
						System.out.print("Enter contact's Email: ");
						try {
							String Email = input.nextLine();
							System.out.println();
							cTemps = contacts.searchByEmailAddress(Email);
							if (cTemps.empty())
								System.out.println("Contact not found!");
							else {
								System.out.println("Contact/s Found!");
								cTemps.displayAll();
							}
						} catch (IllegalArgumentException a) {
							System.out.println(a.getMessage());
						}
						break;

					case "4":
						System.out.print("Enter contact's Address: ");
						try {
							String Address = input.nextLine();
							System.out.println("");
							cTemps = contacts.searchByAddress(Address);
							if (cTemps.empty())
								System.out.println("Contact not found!");
							else {
								System.out.println("Contact/s found!");
								cTemps.displayAll();
							}
						} catch (IllegalArgumentException a) {
							System.out.println(a.getMessage());
						}
						break;

					case "5":
						System.out.print("Enter contact's Birthday: ");
						try {
							String Bday = input.nextLine();
							System.out.println();
							cTemps = contacts.searchByBirthday(Bday);
							if (cTemps.empty())
								System.out.println("Contact not found!");
							else {
								System.out.println("Contact/s found!");
								cTemps.displayAll();

							}
						} catch (IllegalArgumentException a) {
							System.out.println(a.getMessage());
						}
						break;

					default:
						System.out.println("Wrong input");
						break;
					}
					break; // exit Case 2

				case "3": // Case 3 delete contact, "nested switch"
					System.out.println("Enter search criteria: rrrr ");
					System.out.println("1.Name ");
					System.out.println("2.Phone Number");
					System.out.println("");
					System.out.print("Enter your choice: ");
					String Secriteria = input.nextLine();
					System.out.println("");
					switch (Secriteria) {

					case "1":
						System.out.print("Enter contact's name: ");
						try {
							String Name = input.nextLine();
							System.out.println("");
							cTemp = contacts.searchByName(Name);
							events.deleteEvent(cTemp);
							contacts.deleteContact(cTemp);
						} catch (NullPointerException npe) {
						} // in case last node is deleted
						catch (IllegalArgumentException a) {
							System.out.println(a.getMessage());
						}
						break;

					case "2":
						System.out.print("Enter contact's Phone number: ");
						try {
							String number = input.nextLine();
							System.out.println("");
							cTemp = contacts.searchByPhoneNumber(number);
							events.deleteEvent(cTemp);
							contacts.deleteContact(cTemp);
						} catch (NullPointerException npe) {
						} catch (IllegalArgumentException a) {
							System.out.println(a.getMessage());
						}
						break;

					default:
						System.out.println("Wrong input");
						break;

					}
					break;// exit Case3

				case "4": // Case 4 add event
					System.out.print("Enter event title: ");
					String EvTitle = input.nextLine();
					System.out.print("Enter contact name: ");
					String EvCoName = input.nextLine();
					System.out.print("Enter event date (MM-DD-YYYY): ");
					String EvDate = input.nextLine();
					System.out.print("Enter Start time (HH:MM): ");
					String StartTime = input.nextLine();
					System.out.print("Enter end time (HH:MM): ");
					String EndTime = input.nextLine();
					System.out.print("Enter event location: ");
					String EvLoc = input.nextLine();
					System.out.println("");
					try {
						cTemp = contacts.searchByName(EvCoName);// To satisfy requirement that says {events must be
																// added to existing contacts only}
						eTemp = new Event(EvTitle, EvDate, StartTime, EndTime, EvLoc, cTemp);
						events.addEvent(eTemp);
						System.out.println("Event added succesfully!");
						System.out.println("");
					} catch (IllegalArgumentException a) {
						System.out.println(a.getMessage());
					}
					break;

				case "5": // Case 5 search for event "nested switch"
					System.out.println("Enter search criteria: ");
					System.out.println("1.contact name ");
					System.out.println("2.Event title");
					System.out.println("");
					System.out.print("Enter your choice: ");
					String Seacriteria = input.nextLine();
					System.out.println("");
					switch (Seacriteria) {

					case "1":
						System.out.print("Enter contact's name: ");
						try {
							String Name = input.nextLine();
							System.out.println("");
							eTemps = events.searchByContactName(Name);
							if (eTemps.empty()) {
								System.out.println("Not found!");
							} else {
								System.out.println("Event found!");
								eTemps.displayAllEvents();
							}
						} catch (IllegalArgumentException a) {
							System.out.println(a.getMessage());
						}
						break;

					case "2":
						System.out.print("Enter the event title: ");
						try {
							String title = input.nextLine();
							System.out.println("");
							eTemps = events.searchBytitle(title);
							if (eTemps.empty()) {
								System.out.println("Not found!");
							} else {
								System.out.println("Event found!");
								eTemps.displayAllEvents();
							}
						} catch (IllegalArgumentException a) {
							System.out.println(a.getMessage());
						}
						break;
					default:
						System.out.println("Wrong input");
						break;
					}
					break;// exit Case 6

				case "6":// Case 6 search by first name "display all "contacts that have this name"
					System.out.print("Enter the first name: ");
					try {
						String Name = input.nextLine();
						cTemps = contacts.searchByFirstName(Name);
						if (cTemps.getLength() < 1)
							System.out.println("No contacts with that name!");
						else
							cTemps.displayAll();
					} catch (IllegalArgumentException a) {
						System.out.println(a.getMessage());
					}
					break;

				case "7":// Case 7 display all events in alphabit order
					if (events.empty()) {
						System.out.println("You have no events scheduled");
					}
					events.displayAllEvents();
					break;

				case "8":// Case 8 exit
					System.out.println("Goodbye!");
					main_run = false;
					break;

				default:
					System.out.println("Wrong input");
					System.out.println("");
					break;

				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} while (main_run);
	}
}
