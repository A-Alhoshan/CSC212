
//الكلاس هذا بيبقى عشان الايفنت بنمثله كـدبل لنكد ليست، وأيضًا بعض ميثودات الكونتاكت بنخليها عشان نحتاجها عشان لستة الكونتاكتات الي جوا الايفنت نفسه
import java.time.LocalTime; //This library is used to prevent conflicts in user's eventlist 

public class LinkedList<T> {
	// Atrributes
	private Node<T> head;
	private Node<T> current;
	private Node<T> tail;
	private int length = 0;

	// Constructor and DLL methods
	public Node<T> getCurrent() {
		return this.current;
	}

	public LinkedList() {
		head = current = null;
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

	public T retrieve() {
		return current.data;
	}

	public void findLast() {
		current = tail;
	}

	public void findPrevious() {
		current = current.prev;
	}

	public int getLength() {
		return length;
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

	// هذي تشيك لو كان الكونتاكت موجود أو لا (ترجع خطأ لو كان مب موجود وصح لو موجود)
	public boolean alreadyExist(Contact contact) {

		boolean flag = false;
		if (this.empty()) {
			return flag;
		} else {
			findFirst();
			while (current != null) {
				if (((Contact) this.current.data).getName().equalsIgnoreCase(contact.getName())
						|| ((Contact) this.current.data).getPhoneNumber().equals(contact.getPhoneNumber())) {
					flag = true;
				}
				findNext();
			}
			return flag;
		}
	}

	// هذي الميثود تستقبل كونتاكت وتتأكد لو كان موجود أو لا ثم تضيفه في المكان
	// الصحيح بناءً على اسمه ابجديًا
	public void addContact(Contact contact) throws IllegalArgumentException {
		if (alreadyExist(contact)) {
			throw new IllegalArgumentException("Contact " + contact.getName() + " already exists!\n");
		} else {// not exist
			length++;
			Node<T> newNode = new Node<T>((T) contact);
			if (this.empty()) {
				head = newNode;
				tail = newNode;
			} else {// لو كانت الليست غير فارغة والكونتاكت ليس موجود سلفًا بيدخل هنا
				findFirst();
				while (current != null && ((Contact) current.data).compareTo(contact) < 0) {
					findNext(); // طالما الكرنت مب فاضي والكرنت ليس أدنى أبجديا كمل
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

	// هذي تستقبل اسم وتعلمك لو موجود أو لا وإذا ايه بترجعه لك ملاحظة:تراها ماتهتم
	// كبتل او سمول
	public Contact searchByName(String name) throws IllegalArgumentException {
		findFirst();
		while (current != null) {
			if (((Contact) current.data).getName().equalsIgnoreCase(name)) {
				return ((Contact) current.data);
			}
			findNext();
		}
		// System.out.println("No results for: "+name);
		throw new IllegalArgumentException("No results for: " + name + "\n");
	}

	// هذي الميثود تستقبل كونتاكت وتحذفه، لوتمت العملية يرجع لك صح والعكس صحيح
	// ملاحظة: رجاءًا بالمين إذا جيت تستدعيها امسك الكونتاكت واحذف الايفنتات اول ثمن
	// ناد هذي الميثود
	public boolean deleteContact(Contact c) throws IllegalArgumentException {
		if (c == null) {
			throw new IllegalArgumentException("Can't delete contact.\n");
		} else if (this.empty() || c == null) {
			return false;
		} else {
			findFirst();
			while (current != null) {
				if (((Contact) current.data).equals(c)) {
					remove();
					// System.out.println("Contact and all related events deleted!\n");
					length--;
					return true;
				}
				findNext();
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

	// ---------------------------------------Now with Event
	// methods------------------------------------
	// هذي تستقبل تاريخ ووقت بداية ووقت نهاية وإذا كانوا بنفس اليوم تعلمك لو
	// الفترتين بينهم تعارض أو لا
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
			LocalTime end1 = LocalTime.parse(((Event) current.data).getendTime());
			if (((Event) current.data).getDate().equals(date) && !((end1.isBefore(start2) || start1.isAfter(end2)))) {
				return true;
			}
			findNext();
		}
		return false;
	}

	// هذي الميثود تضيف لك ايفنت في المكان الصحيح بناءً على أبجدية عنوانه عشان بعدين
	// لين جينا نطبع يصير و(ن) على طول
	public void addEvent(Event event) throws IllegalArgumentException {
		if (isConflict(event.getDate(), event.getstartTime(), event.getendTime())) {
			throw new IllegalArgumentException("You already have Event or Appointment at this time!\n");
		} else {// User is Available for event
			Node<T> newNode = new Node<T>((T) event);
			length++;

			if (empty()) {
				head = newNode;
				tail = newNode;
			} else {
				findFirst();
				while (current != null && ((Event) current.data).compareTo(event) < 0) {
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
	public LinkedList<Event> searchBytitle(String title) throws IllegalArgumentException {
		if (title == null || title.isEmpty()) {
			throw new IllegalArgumentException("Empty field!\n");
		}
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

	// editied
	public LinkedList<Event> searchByContactName(String name) throws IllegalArgumentException {
		// الحالة الاولى لو لعب عليك المستخدم وماحط لك شيء
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Empty field!\n");
		}
		// الحالة الثانية لو كان الكرنت عبارة عن ابوينتمنت ماله إلا كونتاكت واحد سهلات
		// يعني
		LinkedList<Event> foundEvent_s = new LinkedList<Event>();
		findFirst();
		while (current != null) {
			if (((Event) current.data).isAppointment()) {
				if (((Event) current.data).getContact().getName().equalsIgnoreCase(name)) {
					foundEvent_s.addEvent(((Event) current.data));
				}
			}
			// الحالة الثالثة لو كان الكرنت عبارة عن ايفنت وهذي مشكلة شوي لأن فيه اكثر من
			// كونتاكت
			else if (!(((Event) current.data).isAppointment())) {
				((Event) current.data).getContacts().findFirst();
				while (((Event) current.data).getContacts().current != null) {
					if (((Event) current.data).getContacts().current.data.getName().equalsIgnoreCase(name)) {
						foundEvent_s.addEvent(((Event) current.data));
					}
					((Event) current.data).getContacts().findNext();
				}
			}

			findNext();
		}
		return foundEvent_s;
	}

	// هذي بتطبع لك كل الايفنتات وبحكم اننا ضايفينهم مرتبين أصلا بتطبعهم مرتبين
	// أبجديًا وأحلى بيق و(ن)
	public void displayAllEvents() {
		if (empty()) {
			System.out.println("");
		}
		findFirst();
		while (current != null) {
			((Event) current.data).display();
			findNext();
		}
	}

	// editied for phase 2
	// هذي ماتناديها إلا قبل ماتحذف كونتاكت تدخل الكونتاكت هنا وتحذف كل ايفنتاته ثمن
	// تحذفه
	public void deleteEvent(Contact c) throws IllegalArgumentException {
		boolean f = false;
		if (c == null) {
			throw new IllegalArgumentException("Empty field!\n");
		}

		findFirst();
		while (current != null) {

			if (((Event) current.data).isAppointment()) {
				if (((Event) current.data).getContact().getName().equalsIgnoreCase(c.getName())) {
					remove();
					continue;
				}
			}
			// لو كان ايفنت بنحذف الكونتاكت حقنا من اللستة حقت الايفنت بس منب حاذفين الايفنت
			// بكبره

			if (!(((Event) current.data).isAppointment()) && ((Event) current.data).getContacts() != null) {
				((Event) current.data).getContacts().findFirst();
				while (current != null && ((Event) current.data).getContacts().current != null) {
					if (((Event) current.data).getContacts().current.data.getName().equalsIgnoreCase(c.getName())) {
						((Event) current.data).getContacts().remove();
						if (((Event) current.data).getContacts().empty()) {
							remove();
							f = true;
							break;
						}
						((Event) current.data).getContacts().findFirst();
						findNext();
						f = true;
						break;
					}
					if (current != null)
						((Event) current.data).getContacts().findNext();

				}
				if (f == true) {
					f = false;
					continue;
				}

				if (current != null && ((Event) current.data).getContacts() != null)
					((Event) current.data).getContacts().findFirst();

			}
			if (current != null)
				findNext();

		}
		findFirst();
	}
}
