import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Event implements Comparable<Event> {

	// Attributes
	private String title;
	private String date;// (MM/DD/YYYY) AS Mentioned in requirement
	private String startTime;// HH:mm
	private String endTime;// HH:mm هذولي الثنين قسمناهم عشان نعرف اذا فيه تعارض بين ايفنتين ولالا
	private String location;
	private Contact contact;// هنا حطينا متغير كونتاكت من نوع كونتاكت عشان بنضيف الفعاليات للكونتاكت نفسه
							// فبنحتاجه في هذا الكلاس
	private LinkedList<Contact> contacts; // لينكد ليست من نوع كونتاكتس، ياعيال لحد يحذف الميثودات حقت فيز 1 بستفيد منها
											// هنا
	// Default and Set Constructors

	public Event() {
		this.title = null;
		this.date = null;
		this.location = null;
		this.contact = null;
		this.startTime = null;
		this.endTime = null;
		this.contacts = null;
	}

	// constructor for appointment
	public Event(String title, String date, String startTime, String endTime, String location, Contact contact)
			throws IllegalArgumentException {
		if (!title.isEmpty() && !date.isEmpty() && !startTime.isEmpty() && !endTime.isEmpty() && contact != null) {
			this.title = title;
			this.date = date;
			this.startTime = startTime;
			this.endTime = endTime;
			this.location = location;
			this.contact = contact;
			this.contacts = null;
		} else {
			throw new IllegalArgumentException(
					"Title, date, start time, end time, and contact cannot be null or empty.");
		}
	}

	public boolean isAppointment() {
		return this.contacts == null; // لو كان ابوينتمينت ذي الليست بتصير فاضية وبيرجع لك ترو
	}

	// constructor for event
	public Event(String title, String date, String startTime, String endTime, String location,
			LinkedList<Contact> contacts) throws IllegalArgumentException {
		if (!title.isEmpty() && !date.isEmpty() && !startTime.isEmpty() && !endTime.isEmpty() && contacts != null) {
			this.title = title;
			this.date = date;
			this.startTime = startTime;
			this.endTime = endTime;
			this.location = location;
			this.contact = null;
			this.contacts = contacts;
		} else {
			throw new IllegalArgumentException(
					"Title, date, start time, end time, and contacts cannot be null or empty.");
		}
	}

	// Getters
	public String getTitle() {
		return title;
	}

	public String getDate() {
		return date;
	}

	public String getstartTime() {
		return startTime;
	}

	public String getendTime() {
		return endTime;
	}

	public String getLocation() {
		return location;
	}

	public Contact getContact() {
		return contact;
	}

	public LinkedList<Contact> getContacts() {
		return contacts;
	}

	@Override
	public int compareTo(Event e) {
		return this.title.compareTo(e.title);
	}

	// Compare للمقارنة بين اسماء الأحداث بناءً على الأبجدية عشان بعدين بنحتاج
	// نطبعهم بالترتيب
	// editied
	public void display() {
		Icon icon = new ImageIcon("C:\\Users\\zyad9\\Desktop\\Logo3.png");
		if (this.isAppointment()) {
			String s = "Appointment title: " + this.title + "\n" + "Contact name: " + this.contact.getName() + "\n"
					+ "Appointment date: " + this.date + "\n" + "Appointment start time: " + this.startTime + "\n"
					+ "Appointment end time: " + this.endTime + "\n" + "Appointment location: " + this.location + "\n";
			JOptionPane.showMessageDialog(null, s, "result", 0, icon);
		} else { // لو كان ايفنت
			String c = "Event title: " + this.title + "\n" + "Contact names: " + this.displayingNames() + "\n"
					+ "Event date: " + this.date + "\n" + "Event start time: " + this.startTime + "\n"
					+ "Event end time: " + this.endTime + "\n" + "Event location: " + this.location + "\n";
			JOptionPane.showMessageDialog(null, c, "result", 0, icon);
		}
	}

	// هذي بس عشان الميثود الي فوقها بس!
	public String displayingNames() {
		String names = "";
		this.contacts.findFirst();
		while (!(this.contacts.last())) {
			names = names + this.contacts.getCurrent().data.getName() + ",";
			this.contacts.findNext();
		}
		names = names + this.contacts.getCurrent().data.getName();
		return names;
	}
}
