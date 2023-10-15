import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class LinkedList<T> {
	// Atrr
	private Node<T> head;
	private Node<T> current;
	private Node<T> tail;

	// Constructor and DLL methods
	public LinkedList() {
		head = current = tail = null;
	}

	public boolean empty() {
		return head == null;
	}

	public boolean last() {
		return current.next == null;
	}

	public boolean first() {
		return current.prev == null;
	}

	public void findFirst() {
		current = head;
	}

	public void findNext() {
		current = current.next;
	}

	public void findLast() {
		current = tail;
	}

	public void findPrevious() {
		current = current.prev;
	}

	// هذي تشيك لو كان الكونتاكت موجود أو لا (ترجع خطأ لو كان مب موجود وصح لو موجود)
	public boolean alreadyExist(Contact contact) {

		boolean flag = false;
		if (empty()) {
			return flag;
		} else {
			findFirst();
			while (current != null) {
				if (((Contact) this.current.data).getName().equalsIgnoreCase(contact.getName())
						&& ((Contact) this.current.data).getPhoneNumber() == contact.getPhoneNumber()) {
					flag = true;
				}
				findNext();
			}
			return flag;
		}
	}

	public void addContact(Contact contact) {
		if (alreadyExist(contact)) {
			System.out.println("Contact " + contact.getName() + " is already exist!");
		} else {// not exist

			Node<T> newNode = new Node<T>((T) contact);
			if (empty()) {
				head = newNode;
				tail = newNode;
			} else {// لو كانت الليست غير فارغة والكونتاكت ليس موجود سلفًا بيدخل هنا
				findFirst();

				while (current != null && ((Contact) current.data).compareTo(contact) < 0) {
					findNext(); // طالما الكرنت مب فاضي والكرنت ليس أدنى أبجديا كمل
				} // If item is A and current is B this will be negative and exit loop

				if (current == head) {
					newNode.next = head;
					head.prev = newNode; // الحالة الأولى: عنصرك أولى أبجديًا وبتضيف بالبداية
					head = newNode;
				} else if (current == null) {
					newNode.prev = tail;
					tail.next = newNode; // الحالة الثانية:عنصرك متدني أبجديًا وبتضيف آخر خانة
					tail = newNode;
				} else {
					newNode.prev = current.prev;
					newNode.next = current; // بتضيف بين عنصرين هنا لازم شوية تركيز
					current.prev.next = newNode;
					current.prev = newNode;
				}
			}

		}
	}

	public void remove() { // هذي للحذف من الدبل لينكد ليست، بنحتاجها يوم نسوي ديليت
		if (current == head) {
			head = head.next;
			if (head != null)
				head.prev = null;
		} else {
			current.prev.next = current.next;
			if (current.next != null)
				current.next.prev = current.prev;
		}

		if (current.next == null)
			current = head;
		else
			current = current.next;
	}

	// Unique search نبحث بالأشياء الي ماتتكرر زي الايميل ورقم الجوال والاسم كامل
	// باختصار ضامنين نرجع اوبجكت واحد
	// لاتنسَ هذي النوعية من السيرش بنخليها ترجع اوبجكت مب طباعة يعني لو بتستدعيها
	// بالمين لاتنسَ تطبعها من هناك
	public Contact searchByEmailAddress(String email) {
		findFirst();
		while (current != null) {
			if (((Contact) current.data).getEmailAddress().equalsIgnoreCase(email)) {
				return ((Contact) current.data);
			}
			findNext();
		}
		return null;

	}

	public Contact searchByPhoneNumber(String num) {
		findFirst();
		while (current != null) {
			if (((Contact) current.data).getPhoneNumber().equals(num)) {
				return ((Contact) current.data);
			}
			findNext();
		}
		return null;
	}

	public Contact searchByName(String name) {
		findFirst();
		while (current != null) {
			if (((Contact) current.data).getName().equalsIgnoreCase(name)) {
				return ((Contact) current.data);
			}
			findNext();
		}
		return null;
	}

	// not unique search الي قد يكون فيها تكرار نفس الاسم والآدريس ويوم الميلاد
	// هذي قد ترجع لك أكثر من شخص وش الحل؟ نخليهاترجع لك مصفوفةاوبجيكتات
	// الثلاث ميثودات هذولي يرجعون إما فارغة او اوبجكت او اوبجكتس لاتنسَ تتعامل مع
	// ذا الشيء
	public LinkedList<Contact> searchByFirstName(String name) {
		LinkedList<Contact> foundContact_s = new LinkedList<Contact>();
		findFirst();
		while (current != null) {
			if (((Contact) current.data).getName().toString().toLowerCase().contains(name.toLowerCase())) {
				foundContact_s.addContact(((Contact) current.data));
			}
			findNext();
		}
		return foundContact_s;
	}

	public LinkedList<Contact> searchByAddress(String address) {
		LinkedList<Contact> foundContact_s = new LinkedList<Contact>();
		findFirst();
		while (current != null) {
			if (((Contact) current.data).getAddress().toString().toLowerCase().contains(address.toLowerCase())) {
				foundContact_s.addContact(((Contact) current.data));
			}
			findNext();
		}
		return foundContact_s;
	}

	public LinkedList<Contact> searchByBirthday(String birthday) {
		LinkedList<Contact> foundContact_s = new LinkedList<Contact>();
		findFirst();
		while (current != null) {
			if (((Contact) current.data).getBirthDay().equalsIgnoreCase(birthday)) {
				foundContact_s.addContact(((Contact) current.data));
			}
			findNext();
		}
		return foundContact_s;
	}

	public boolean deleteContact(Contact c) {
		;
		if (empty() || c == null) {
			return false;
		}
		findFirst();
		while (current != null) {
			if (((Contact) current.data).equals(c)) {
				remove();
				return true;
			}
		}
		return false;
	}

	public void displayAll() { // testing بتفيدنا في الـ
		findFirst();
		while (current != null) {
			((Contact) current.data).display();
			findNext();
		}
	}

	// ---------------------------------------------------------------------------

	public boolean isConflict(String date, String startTime, String endTime) {
		if (empty()) {
			return false;
		}
		findFirst();
		LocalTime start2 = LocalTime.parse(startTime); // الي نبي نشيك ندخلهم او لا نرمزلهم 2
		LocalTime end2 = LocalTime.parse(endTime);
		while (current != null) {
			LocalTime start1 = LocalTime.parse(((Event) current.data).getstartTime()); // هذولي الي موجودين فالليست
																						// فبنرمز لهم 1
			LocalTime end1 = LocalTime.parse(((Event) current.data).getstartTime());
			if (((Event) current.data).getDate().equals(date) && !((end1.isBefore(start2) || start1.isAfter(end2)))) {
				return true;
			}
			findNext();
		}
		return false;
	}

	public void addEvent(Event event) {
		if (isConflict(event.getDate(), event.getstartTime(), event.getendTime())) {
			System.out.println("You already have Event at this time!");
		} else {// User is Available for event
			Node<T> newNode = new Node<T>((T) event);

			if (empty()) {
				head = newNode;
				tail = newNode;
			} else {
				findFirst();
				while (current != null && event.compareTo(event) > 0) {
					findNext();
				}
				if (current == head) {
					newNode.next = head;
					head.prev = newNode; // الحالة الأولى: عنصرك أولى أبجديًا وبتضيف بالبداية
					head = newNode;
				} else if (current == null) {
					newNode.prev = tail;
					tail.next = newNode; // الحالة الثانية:عنصرك متدني أبجديًا وبتضيف آخر خانة
					tail = newNode;
				} else {
					newNode.prev = current.prev;
					newNode.next = current; // بتضيف بين عنصرين هنا لازم شوية تركيز
					current.prev.next = newNode;
					current.prev = newNode;
				}
			}
		}
	}

	// now with searching (we have only 2 searching criterias)(title,contact name)
	// كلهم لازم يرجعون مصفوفة ايفنتات زي الي كتبتها باللينكد ليست حقت الاسم
	public LinkedList<Event> searchBytitle(String title) {
		LinkedList<Event> foundEvent_s = new LinkedList<Event>();
		findFirst();
		while (current != null) {
			if (((Event) current.data).getTitle().equalsIgnoreCase(title)) {
				foundEvent_s.addEvent(((Event) current.data));
			}
			findNext();
		}
		return foundEvent_s;
	}

	public LinkedList<Event> searchByContactName(String name) {
		LinkedList<Event> foundEvent_s = new LinkedList<Event>();
		findFirst();
		while (current != null) {
			if (((Event) current.data).getContact().getName().equalsIgnoreCase(name)) {
				foundEvent_s.addEvent(((Event) current.data));
			}
			findNext();
		}
		return foundEvent_s;
	}

	// هذي سلمك الله بتطبع لك كل الايفنتات وبحكم اننا ضايفينهم مرتبين أصلا بتطبعهم
	// مرتبين أبجديًا
	public void displayAllEvents() {
		if (empty()) {
			System.out.println("You have no events scheduled");
		}
		findFirst();
		while (current != null) {
			((Event) current.data).display();
			findNext();
		}
	}

	public void deleteEvent(Contact c) { // هذي بنناديها اذا جينا نحذف كونتاكت
		findFirst();
		while (current != null) {
			if (((Event) current.data).getContact().equals(c)) {
				remove();
			}
			findNext();
		}

	}
}
