import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Scanner;

public class PhoneBook extends JFrame {
	int i = 0;
	static PhoneBook frame;

	static Icon icon = new ImageIcon("C:\\Users\\zyad9\\Desktop\\Logo3.png");
	static JPanel myPanel;
	static JPanel panel;
	static JPanel panel2;
	static JPanel panel3;
	static JPanel panel4;
	static JPanel panel5;

	static String choice = "";
	static String Scriteria = "";
	static String Secriteria = "";
	static String Seacriteria = "";
	static String Searcriteria = "";
	static boolean t = false;

	public PhoneBook() {
		JButton[] buttons = new JButton[8];
		panel = new JPanel(new GridLayout(5, 2));
		panel.add(new JLabel(icon));
		panel.add(new JLabel("                   Please choose an option:"));
		String b[] = { "Add a contact", "Search for a contact", "Delete a contact", "Schedule an event/appointment",
				"Print event details", "Print contacts by first name", "Print all events alphabetically", "Exit" };
		for (i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(b[i]);
			buttons[i].setSize(80, 80);
			buttons[i].setActionCommand(b[i]);
			buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					choice = e.getActionCommand();

				}
			});
			panel.add(buttons[i]);

		}
		JButton[] buttons2 = new JButton[5];
		panel2 = new JPanel(new GridLayout(4, 2));
		panel2.add(new JLabel(icon));
		panel2.add(new JLabel("                   Enter search criteria: "));
		String b2[] = { "Name", "Phone Number", "Email address", "Address", "Birthday" };
		for (i = 0; i < buttons2.length; i++) {
			buttons2[i] = new JButton(b2[i]);
			buttons2[i].setSize(80, 80);
			buttons2[i].setActionCommand(b2[i]);
			buttons2[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					Scriteria = e.getActionCommand();

				}
			});
			panel2.add(buttons2[i]);

		}

		JButton[] buttons3 = new JButton[2];
		panel3 = new JPanel(new GridLayout(2, 2));
		panel3.add(new JLabel(icon));
		panel3.add(new JLabel("                   Enter search criteria: "));
		String b3[] = { "Name", "Phone Number" };
		for (i = 0; i < buttons3.length; i++) {
			buttons3[i] = new JButton(b3[i]);
			buttons3[i].setSize(80, 80);
			buttons3[i].setActionCommand(b3[i]);
			buttons3[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Secriteria = e.getActionCommand();

				}
			});
			panel3.add(buttons3[i]);

		}
		JButton[] buttons4 = new JButton[2];
		panel4 = new JPanel(new GridLayout(2, 2));
		panel4.add(new JLabel(icon));
		panel4.add(new JLabel("                   Enter search criteria: "));
		String b4[] = { "Contact name", "Event title" };
		for (i = 0; i < buttons4.length; i++) {
			buttons4[i] = new JButton(b4[i]);
			buttons4[i].setSize(80, 80);
			buttons4[i].setActionCommand(b4[i]);
			buttons4[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seacriteria = e.getActionCommand();

				}
			});
			panel4.add(buttons4[i]);

		}
		JButton[] buttons5 = new JButton[2];
		panel5 = new JPanel(new GridLayout(2, 2));
		panel5.add(new JLabel(icon));
		panel5.add(new JLabel("                   Enter Event Or Appointment: "));
		String b5[] = { "Event", "Appointment" };
		for (i = 0; i < buttons5.length; i++) {
			buttons5[i] = new JButton(b5[i]);
			buttons5[i].setSize(80, 80);
			buttons5[i].setActionCommand(b5[i]);
			buttons5[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Searcriteria = e.getActionCommand();

				}
			});
			panel5.add(buttons5[i]);
		}
	}

	public static void main(String[] args) {

		ContactBST contacts = new ContactBST();
		LinkedList<Event> events = new LinkedList<Event>();
		Contact cTemp = null;
		LinkedList<Contact> cTemps;
		Event eTemp;
		LinkedList<Event> eTemps;
		Scanner input = new Scanner(System.in);
		boolean main_run = true;

		String s = "Welcome to the Linked Tree phonebook !";
		JOptionPane.showMessageDialog(null, s, "result", 0, icon);

		do {
			try {
				if (t == false) {
					frame = new PhoneBook();

					frame.add(panel);

					frame.pack();
					frame.setSize(600, 600);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					// frame.setLocation(EXIT_ON_CLOSE, ABORT);
					frame.setLocation(660, 240);
					frame.setVisible(true);
				}

				// System.out.println("jj");
				while (choice.equalsIgnoreCase("")) {
					System.out.print("");
				}

				switch (choice) {
				case "Add a contact": // Case 1 Add contact
					frame.dispose();
					t = false;
					JTextField CoNameF = new JTextField(10);
					JTextField CoPhoneNF = new JTextField(10);
					JTextField CoEmailF = new JTextField(10);
					JTextField CoAddressF = new JTextField(10);
					JTextField CoBirthDF = new JTextField(10);
					JTextField CoNoteF = new JTextField(10);

					myPanel = new JPanel(new GridLayout(7, 2));
					myPanel.add(new JLabel("Enter the contact's name: "));
					myPanel.add(CoNameF);
					myPanel.add(Box.createHorizontalStrut(60)); // a spacer
					myPanel.add(new JLabel("Enter the contact's phone number: "));
					myPanel.add(CoPhoneNF);
					myPanel.add(Box.createHorizontalStrut(60)); // a spacer
					myPanel.add(new JLabel("Enter the contact's email address: "));
					myPanel.add(CoEmailF);
					myPanel.add(Box.createHorizontalStrut(60)); // a spacer
					myPanel.add(new JLabel("Enter the contact's address: "));
					myPanel.add(CoAddressF);
					myPanel.add(Box.createHorizontalStrut(60)); // a spacer
					myPanel.add(new JLabel("Enter the contact's birthday: "));
					myPanel.add(CoBirthDF);
					myPanel.add(Box.createHorizontalStrut(60)); // a spacer
					myPanel.add(new JLabel("Enter any notes for the contact: "));
					myPanel.add(CoNoteF);
					String CoName = "";
					String CoPhone = "";
					String CoEmail = "";
					String CoAddress = "";
					String CoBirthday = "";
					String CoNote = "";

					int result = JOptionPane.showConfirmDialog(null, myPanel, "Adding a contact",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);
					// choice ="";
					if (result == JOptionPane.OK_OPTION) {
						CoName = CoNameF.getText();
						CoPhone = CoPhoneNF.getText();
						CoEmail = CoEmailF.getText();
						CoAddress = CoAddressF.getText();
						CoBirthday = CoBirthDF.getText();
						CoNote = CoNoteF.getText();
					}
					try {
						cTemp = new Contact(CoName, CoPhone, CoEmail, CoAddress, CoBirthday, CoNote);
						contacts.addContact(cTemp);
						s = "Contact added succesfully!";
						JOptionPane.showMessageDialog(null, s, "result", 0, icon);

						System.out.println("");
					} catch (IllegalArgumentException a) {
						s = a.getMessage();
						JOptionPane.showMessageDialog(null, s, "result", 0, icon);

					}
					choice = "";

					break;

				case "Search for a contact": // Case 2 search for contact "nested switch"
					frame.dispose();
					t = false;
					frame = new PhoneBook();

					frame.add(panel2);

					frame.pack();
					frame.setSize(600, 600);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLocation(660, 240);

					frame.setVisible(true);

					while (Scriteria.equalsIgnoreCase("")) {
					}
					switch (Scriteria) {

					case "Name":
						frame.dispose();
						JTextField NameF = new JTextField(10);

						myPanel = new JPanel(new GridLayout(7, 2));
						myPanel.add(new JLabel("Enter the contact's name: "));
						myPanel.add(NameF);
						int result1 = JOptionPane.showConfirmDialog(null, myPanel, "Searching for contact",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);
						String Name = "";
						if (result1 == JOptionPane.OK_OPTION) {
							Name = NameF.getText();
						}
						try {
							cTemp = contacts.searchByName(Name);
							s = "Contact Found!";
							JOptionPane.showMessageDialog(null, s, "result", 0, icon);

							cTemp.display();
						} catch (IllegalArgumentException a) {
							s = a.getMessage();
							JOptionPane.showMessageDialog(null, s, "result", 0, icon);

						}
						Scriteria = "";
						break;

					case "Phone Number":
						frame.dispose();
						JTextField PhoNF = new JTextField(10);

						myPanel = new JPanel(new GridLayout(7, 2));
						myPanel.add(new JLabel("Enter the contact's Phone number: "));
						myPanel.add(PhoNF);
						int result2 = JOptionPane.showConfirmDialog(null, myPanel, "Searching for contact",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);
						String PhoN = "";
						if (result2 == JOptionPane.OK_OPTION) {
							PhoN = PhoNF.getText();
						}
						try {
							cTemp = contacts.searchByPhoneNumber(PhoN);
							s = "Contact Found!";
							JOptionPane.showMessageDialog(null, s, "result", 0, icon);

							cTemp.display();
						} catch (IllegalArgumentException a) {
							s = a.getMessage();
							JOptionPane.showMessageDialog(null, s, "result", 0, icon);

						}
						Scriteria = "";

						break;

					case "Email address":
						frame.dispose();
						JTextField EmailF = new JTextField(10);

						myPanel = new JPanel(new GridLayout(7, 2));
						myPanel.add(new JLabel("Enter the contact's Email: "));
						myPanel.add(EmailF);
						int result3 = JOptionPane.showConfirmDialog(null, myPanel, "Searching for contact",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);
						String Email = "";
						if (result3 == JOptionPane.OK_OPTION) {
							Email = EmailF.getText();
						}
						try {
							cTemps = contacts.searchByEmailAddress(Email);
							if (cTemps.empty()) {
								s = "Contact not found!";
								JOptionPane.showMessageDialog(null, s, "result", 0, icon);
							}

							else {
								s = "Contact/s Found!";
								JOptionPane.showMessageDialog(null, s, "result", 0, icon);

								cTemps.displayAll();
							}
						} catch (IllegalArgumentException a) {
							s = a.getMessage();
							JOptionPane.showMessageDialog(null, s, "result", 0, icon);

						}
						Scriteria = "";

						break;

					case "Address":
						frame.dispose();
						JTextField AddressF = new JTextField(10);

						myPanel = new JPanel(new GridLayout(7, 2));
						myPanel.add(new JLabel("Enter the contact's Address: "));
						myPanel.add(AddressF);
						int result4 = JOptionPane.showConfirmDialog(null, myPanel, "Searching for contact",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);
						String Address = "";
						if (result4 == JOptionPane.OK_OPTION) {
							Address = AddressF.getText();
						}
						try {
							cTemps = contacts.searchByAddress(Address);
							if (cTemps.empty()) {
								s = "Contact not found!";
								JOptionPane.showMessageDialog(null, s, "result", 0, icon);
							}

							else {
								s = "Contact/s found!";
								JOptionPane.showMessageDialog(null, s, "result", 0, icon);

								cTemps.displayAll();
							}
						} catch (IllegalArgumentException a) {
							s = a.getMessage();
							JOptionPane.showMessageDialog(null, s, "result", 0, icon);

						}
						Scriteria = "";

						break;

					case "Birthday":
						frame.dispose();
						JTextField BdayF = new JTextField(10);

						myPanel = new JPanel(new GridLayout(7, 2));
						myPanel.add(new JLabel("Enter the contact's Birthday: "));
						myPanel.add(BdayF);
						int result5 = JOptionPane.showConfirmDialog(null, myPanel, "Searching for contact",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);
						String Bday = "";
						if (result5 == JOptionPane.OK_OPTION) {
							Bday = BdayF.getText();
						}
						try {
							cTemps = contacts.searchByBirthday(Bday);
							if (cTemps.empty()) {
								s = "Contact not found!";
								JOptionPane.showMessageDialog(null, s, "result", 0, icon);
							}

							else {
								s = "Contact/s found!";
								JOptionPane.showMessageDialog(null, s, "result", 0, icon);

								cTemps.displayAll();

							}
						} catch (IllegalArgumentException a) {
							s = a.getMessage();
							JOptionPane.showMessageDialog(null, s, "result", 0, icon);

						}
						Scriteria = "";

						break;

					default:
						s = "Wrong input";
						JOptionPane.showMessageDialog(null, s, "result", 0, icon);

						Scriteria = "";

						break;
					}
					choice = "";

					break; // exit Case 2

				case "Delete a contact": // Case 3 delete contact, "nested switch"
					frame.dispose();
					t = false;
					// contacts.displayAll();
					frame = new PhoneBook();

					frame.add(panel3);

					frame.pack();
					frame.setSize(600, 600);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLocation(660, 240);

					frame.setVisible(true);

					while (Secriteria.equalsIgnoreCase("")) {
					}

					switch (Secriteria) {

					case "Name":
						frame.dispose();
						JTextField NameF = new JTextField(10);

						myPanel = new JPanel(new GridLayout(7, 2));
						myPanel.add(new JLabel("Enter the contact's name: "));
						myPanel.add(NameF);
						int result1 = JOptionPane.showConfirmDialog(null, myPanel, "Searching for  contact",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);
						String Name = "";
						if (result1 == JOptionPane.OK_OPTION) {
							Name = NameF.getText();
						}
						try {
							cTemp = contacts.searchByName(Name);
							events.deleteEvent(cTemp);
							contacts.deleteContact(cTemp);
						} catch (NullPointerException npe) {
							System.out.println(npe.getMessage());
						} // in case last node is deleted

						catch (IllegalArgumentException a) {
							s = a.getMessage();
							JOptionPane.showMessageDialog(null, s, "result", 0, icon);

						}
						Secriteria = "";
						break;

					case "Phone Number":
						frame.dispose();
						JTextField PhoNF = new JTextField(10);

						myPanel = new JPanel(new GridLayout(7, 2));
						myPanel.add(new JLabel("Enter the contact's Phone number: "));
						myPanel.add(PhoNF);
						int result2 = JOptionPane.showConfirmDialog(null, myPanel, "Searching for  contact",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);
						String PhoN = "";
						if (result2 == JOptionPane.OK_OPTION) {
							PhoN = PhoNF.getText();
						}
						try {
							cTemp = contacts.searchByPhoneNumber(PhoN);
							events.deleteEvent(cTemp);
							contacts.deleteContact(cTemp);
						} catch (NullPointerException npe) {
						} catch (IllegalArgumentException a) {
							s = a.getMessage();
							JOptionPane.showMessageDialog(null, s, "result", 0, icon);

						}
						Secriteria = "";
						break;

					default:
						s = "Wrong input";
						JOptionPane.showMessageDialog(null, s, "result", 0, icon);

						Secriteria = "";
						break;

					}
					choice = "";

					break;// exit Case3

				case "Schedule an event/appointment": // Case 4 add event
					frame.dispose();
					t = false;
					frame = new PhoneBook();

					frame.add(panel5);

					frame.pack();
					frame.setSize(600, 600);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLocation(660, 240);

					frame.setVisible(true);

					while (Searcriteria.equalsIgnoreCase("")) {
					}

					switch (Searcriteria) {
					case "Appointment":
						frame.dispose();
						JTextField ApTitleF = new JTextField(10);
						JTextField ApCoNameF = new JTextField(10);
						JTextField ApDateF = new JTextField(10);
						JTextField ApStartTimeF = new JTextField(10);
						JTextField ApEndTimeF = new JTextField(10);
						JTextField ApLocF = new JTextField(10);

						myPanel = new JPanel(new GridLayout(7, 2));
						myPanel.add(new JLabel("Enter appointment title: "));
						myPanel.add(ApTitleF);
						myPanel.add(Box.createHorizontalStrut(60)); // a spacer
						myPanel.add(new JLabel("Enter contact name: "));
						myPanel.add(ApCoNameF);
						myPanel.add(Box.createHorizontalStrut(60)); // a spacer
						myPanel.add(new JLabel("Enter appointment date (MM-DD-YYYY): "));
						myPanel.add(ApDateF);
						myPanel.add(Box.createHorizontalStrut(60)); // a spacer
						myPanel.add(new JLabel("Enter Start time (HH:MM): "));
						myPanel.add(ApStartTimeF);
						myPanel.add(Box.createHorizontalStrut(60)); // a spacer
						myPanel.add(new JLabel("Enter end time (HH:MM): "));
						myPanel.add(ApEndTimeF);
						myPanel.add(Box.createHorizontalStrut(60)); // a spacer
						myPanel.add(new JLabel("Enter appointment location: "));
						myPanel.add(ApLocF);
						String ApTitle = "";
						String ApCoName = "";
						String ApDate = "";
						String ApStartTime = "";
						String ApEndTime = "";
						String ApLoc = "";

						int result2 = JOptionPane.showConfirmDialog(null, myPanel, "Adding an appointment",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);
						// choice ="";
						if (result2 == JOptionPane.OK_OPTION) {
							ApTitle = ApTitleF.getText();
							ApCoName = ApCoNameF.getText();
							ApDate = ApDateF.getText();
							ApStartTime = ApStartTimeF.getText();
							ApEndTime = ApEndTimeF.getText();
							ApLoc = ApLocF.getText();

						}

						try {
							cTemp = contacts.searchByName(ApCoName);// To satisfy requirement that says {events must be
																	// added to existing contacts only}
							eTemp = new Event(ApTitle, ApDate, ApStartTime, ApEndTime, ApLoc, cTemp);
							events.addEvent(eTemp);
							s = "Appointment added succesfully!";
							JOptionPane.showMessageDialog(null, s, "result", 0, icon);

						} catch (IllegalArgumentException a) {
							s = a.getMessage();
							JOptionPane.showMessageDialog(null, s, "result", 0, icon);

						}
						Searcriteria = "";
						break;
					case "Event":
						frame.dispose();
						JTextField EvTitleF = new JTextField(10);
						JTextField EvCoNameF = new JTextField(10);
						JTextField EvDateF = new JTextField(10);
						JTextField StartTimeF = new JTextField(10);
						JTextField EndTimeF = new JTextField(10);
						JTextField EvLocF = new JTextField(10);

						myPanel = new JPanel(new GridLayout(7, 2));
						myPanel.add(new JLabel("Enter event title: "));
						myPanel.add(EvTitleF);
						myPanel.add(Box.createHorizontalStrut(60)); // a spacer
						myPanel.add(new JLabel("Enter contacts names seperated by a comma: "));
						myPanel.add(EvCoNameF);
						myPanel.add(Box.createHorizontalStrut(60)); // a spacer
						myPanel.add(new JLabel("Enter event date (MM-DD-YYYY): "));
						myPanel.add(EvDateF);
						myPanel.add(Box.createHorizontalStrut(60)); // a spacer
						myPanel.add(new JLabel("Enter Start time (HH:MM): "));
						myPanel.add(StartTimeF);
						myPanel.add(Box.createHorizontalStrut(60)); // a spacer
						myPanel.add(new JLabel("Enter end time (HH:MM): "));
						myPanel.add(EndTimeF);
						myPanel.add(Box.createHorizontalStrut(60)); // a spacer
						myPanel.add(new JLabel("Enter event location: "));
						myPanel.add(EvLocF);
						String EvTitle = "";
						String[] EvCoName = null;
						String EvDate = "";
						String StartTime = "";
						String EndTime = "";
						String EvLoc = "";

						int result3 = JOptionPane.showConfirmDialog(null, myPanel, "Adding an event",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);
						// choice ="";
						if (result3 == JOptionPane.OK_OPTION) {
							EvTitle = EvTitleF.getText();
							EvCoName = EvCoNameF.getText().split("\\s*,\\s*");
							EvDate = EvDateF.getText();
							StartTime = StartTimeF.getText();
							EndTime = EndTimeF.getText();
							EvLoc = EvLocF.getText();

						}
						LinkedList<Contact> EvContacts = new LinkedList<>();

						try {

							EvContacts.findFirst();
							for (int i = 0; i < EvCoName.length; i++) {
								if (contacts.searchByName(EvCoName[i]) != null)
									EvContacts.addContact(contacts.searchByName(EvCoName[i]));
								// To satisfy requirement that says {events must be
								// added to existing contacts only}
							}
							if (EvCoName.length == EvContacts.getLength()) {
								eTemp = new Event(EvTitle, EvDate, StartTime, EndTime, EvLoc, EvContacts);
								events.addEvent(eTemp);
								s = "Event added succesfully!";
								JOptionPane.showMessageDialog(null, s, "result", 0, icon);
							} else {
								System.out.println("Couldn't add Event with given contacts");
							}
						} catch (IllegalArgumentException a) {
							s = a.getMessage();
							JOptionPane.showMessageDialog(null, s, "result", 0, icon);

						}
						Searcriteria = "";
						break;
					default:
						s = "Wrong input";
						JOptionPane.showMessageDialog(null, s, "result", 0, icon);

						Searcriteria = "";

						break;
					}

					choice = "";

					break;

				case "Print event details": // Case 5 search for event "nested switch"
					frame.dispose();
					t = false;
					frame = new PhoneBook();

					frame.add(panel4);

					frame.pack();
					frame.setSize(600, 600);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLocation(660, 240);

					frame.setVisible(true);
					while (Seacriteria.equalsIgnoreCase("")) {
						System.out.print("");
					}

					switch (Seacriteria) {

					case "Contact name":
						frame.dispose();
						JTextField NameF = new JTextField(10);

						myPanel = new JPanel(new GridLayout(7, 2));
						myPanel.add(new JLabel("Enter the contact's name: "));
						myPanel.add(NameF);
						int result1 = JOptionPane.showConfirmDialog(null, myPanel, "Searching for event",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);
						String Name = "";
						if (result1 == JOptionPane.OK_OPTION) {
							Name = NameF.getText();
						}
						try {
							eTemps = events.searchByContactName(Name);
							if (eTemps.empty()) {
								s = "Not found!";
								JOptionPane.showMessageDialog(null, s, "result", 0, icon);

							} else {
								s = "Event found!";
								JOptionPane.showMessageDialog(null, s, "result", 0, icon);

								eTemps.displayAllEvents();
							}
						} catch (IllegalArgumentException a) {
							s = a.getMessage();
							JOptionPane.showMessageDialog(null, s, "result", 0, icon);

						}
						Seacriteria = "";
						break;

					case "Event title":
						frame.dispose();
						JTextField titleF = new JTextField(10);

						myPanel = new JPanel(new GridLayout(7, 2));
						myPanel.add(new JLabel("Enter the event's title: "));
						myPanel.add(titleF);
						int result3 = JOptionPane.showConfirmDialog(null, myPanel, "Searching for event",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);
						String title = "";
						if (result3 == JOptionPane.OK_OPTION) {
							title = titleF.getText();
						}
						try {
							eTemps = events.searchBytitle(title);
							if (eTemps.empty()) {
								s = "Not found!";
								JOptionPane.showMessageDialog(null, s, "result", 0, icon);

							} else {
								s = "Event found!";
								JOptionPane.showMessageDialog(null, s, "result", 0, icon);

								eTemps.displayAllEvents();
							}
						} catch (IllegalArgumentException a) {
							s = a.getMessage();
							JOptionPane.showMessageDialog(null, s, "result", 0, icon);

						}
						Seacriteria = "";
						break;
					default:
						s = "Wrong input";
						JOptionPane.showMessageDialog(null, s, "result", 0, icon);
						Seacriteria = "";
						break;
					}
					choice = "";

					break;// exit Case 5

				case "Print contacts by first name":// Case 6 search by first name "display all "contacts that have this
													// name"
					frame.dispose();
					JTextField NameF = new JTextField(10);

					myPanel = new JPanel(new GridLayout(7, 2));
					myPanel.add(new JLabel("Enter the contact's first name: "));
					myPanel.add(NameF);
					int result1 = JOptionPane.showConfirmDialog(null, myPanel, "Searching for contact",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);
					String Name = "";
					if (result1 == JOptionPane.OK_OPTION) {
						Name = NameF.getText();
					}
					try {
						cTemps = contacts.searchByFirstName(Name);
						if (cTemps.empty()) {
							s = "No contacts with that name!";
							JOptionPane.showMessageDialog(null, s, "result", 0, icon);
						}

						else
							cTemps.displayAll();
					} catch (IllegalArgumentException a) {
						s = a.getMessage();
						JOptionPane.showMessageDialog(null, s, "result", 0, icon);

					}
					choice = "";

					break;

				case "Print all events alphabetically":// Case 7 display all events in alphabetical order
					frame.dispose();

					if (events.empty()) {
						s = "You have no events scheduled";
						JOptionPane.showMessageDialog(null, s, "result", 0, icon);

					}
					events.displayAllEvents();
					choice = "";

					break;

				case "Exit":// Case 8 exit
					frame.dispose();
					s = "Goodbye!";
					JOptionPane.showMessageDialog(null, s, "result", 0, icon);

					main_run = false;
					choice = "";

					break;

				default:
					s = "Wrong input";
					JOptionPane.showMessageDialog(null, s, "result", 0, icon);
					t = true;
					break;

				}
			} catch (Exception e) {
				s = e.getMessage();
				JOptionPane.showMessageDialog(null, s, "result", 0, icon);

			}

		} while (main_run);
	}
}
