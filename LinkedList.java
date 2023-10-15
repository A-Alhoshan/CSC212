import java.time.LocalTime; //This library is used to prevent conflicts in user's eventlist 

public class LinkedList<T> {
	// Atrributes
	private Node<T> head;
	private Node<T> current;
	private Node<T> tail;

	// Constructor and DLL methods
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

	public void findLast() {
		current = tail;
	}

	public void findPrevious() {
		current = current.prev;
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

	//هذي تشيك لو كان الكونتاكت موجود أو لا (ترجع خطأ لو كان مب موجود وصح لو موجود)
	public boolean alreadyExist(Contact contact) {

		boolean flag = false;
		if (empty()) {
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
	//هذي الميثود تستقبل كونتاكت وتتأكد لو كان موجود أو لا ثم تضيفه في المكان الصحيح بناءً على اسمه ابجديًا
	public void addContact(Contact contact) throws IllegalArgumentException {
		if (alreadyExist(contact)) {
			throw new IllegalArgumentException("Contact " + contact.getName() + " is already exist!");
		} else{// not exist

			Node<T> newNode = new Node<T>((T) contact);
			if (empty()) {
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
	// Unique search نبحث بالأشياء الي ماتتكرر زي رقم الجوال والاسم كامل
	// باختصار ضامنين نرجع اوبجكت واحد
	// لاتنسَ هذي النوعية من السيرش بنخليها ترجع اوبجكت مب طباعة يعني لو بتستدعيها
	// بالمين لاتنسَ تطبعها من هناك
	public Contact searchByPhoneNumber(String num) {
		findFirst();
		while (current != null) {
			if (((Contact) current.data).getPhoneNumber().equals(num)) {
				System.out.println("Contact found!");
				return ((Contact) current.data);
			}
			findNext();
		}
		System.out.println("No results for: "+num);
		return null;
	}
	//هذي تستقبل اسم وتعلمك لو موجود أو لا وإذا ايه بترجعه لك ملاحظة:تراها ماتهتم كبتل او سمول
	public Contact searchByName(String name) {
		findFirst();
		while (current != null) {
			if (((Contact) current.data).getName().equalsIgnoreCase(name)) {
				return ((Contact) current.data);
			}
			findNext();
		}
		System.out.println("No results for: "+name);
		return null;
	}
	// not unique search الي قد يكون فيها تكرار نفس الاسم والآدريس ويوم الميلاد والايميل
	// هذي قد ترجع لك أكثر من شخص وش الحل؟ نخليهاترجع لك مصفوفةاوبجيكتات
	// الاربع ميثودات هذولي يرجعون إما فارغة او اوبجكت او اوبجكتس لاتنسَ تتعامل مع
	// ذا الشيء
	public LinkedList<Contact> searchByFirstName(String name) throws IllegalArgumentException {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Empty field!");
		}
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

	public LinkedList<Contact> searchByAddress(String address) throws IllegalArgumentException {
		if (address == null || address.isEmpty()) {
			throw new IllegalArgumentException("Empty field!");
		}
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

	public LinkedList<Contact> searchByBirthday(String birthday) throws IllegalArgumentException {
		if (birthday == null || birthday.isEmpty()) {
			throw new IllegalArgumentException("Empty field!");
		}
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

	public LinkedList<Contact> searchByEmailAddress(String email) throws IllegalArgumentException {
		if (email == null || email.isEmpty()) {
			throw new IllegalArgumentException("Empty field!");
		}
		LinkedList<Contact> foundContact_s = new LinkedList<Contact>();
		findFirst();
		while (current != null) {
			if (((Contact) current.data).getEmailAddress().equalsIgnoreCase(email)) {
				foundContact_s.addContact(((Contact) current.data));
			}
			findNext();
		}
		return foundContact_s;
	}
	//هذي الميثود تستقبل كونتاكت وتحذفه، لوتمت العملية يرجع لك صح والعكس صحيح
	//ملاحظة: رجاءًا بالمين إذا جيت تستدعيها امسك الكونتاكت واحذف الايفنتات اول ثمن ناد هذي الميثود
	public boolean deleteContact(Contact c) throws IllegalArgumentException {
		if (c == null) {
			throw new IllegalArgumentException("Can't delete contact.");
		}		
		if (empty() || c == null) {
			return false;
		}
		findFirst();
		while (current != null) {
			if (((Contact) current.data).equals(c)) {
				remove();
				System.out.println("Contact and all related events deleted!");
				return true;
			}
			findNext();
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

	// ---------------------------------------Now with Event methods------------------------------------
	//هذي تستقبل تاريخ ووقت بداية ووقت نهاية وإذا كانوا بنفس اليوم تعلمك لو الفترتين بينهم تعارض أو لا
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
	//هذي الميثود تضيف لك ايفنت في المكان الصحيح بناءً على أبجدية عنوانه عشان بعدين لين جينا نطبع يصير و(ن) على طول
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
				while (current != null && ((Event)current.data).compareTo(event) < 0) {
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
			throw new IllegalArgumentException("Empty field!");
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
	
	public LinkedList<Event> searchByContactName(String name) throws IllegalArgumentException{
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Empty field!");
		}			
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

	// هذي بتطبع لك كل الايفنتات وبحكم اننا ضايفينهم مرتبين أصلا بتطبعهم مرتبين أبجديًا وأحلى بيق و(ن)
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
	//هذي ماتناديها إلا قبل ماتحذف كونتاكت تدخل الكونتاكت هنا وتحذف كل ايفنتاته ثمن تحذفه
	public void deleteEvent(Contact c) throws IllegalArgumentException {
		if (c == null) {
			throw new IllegalArgumentException("");
		}	
		findFirst();
		while (current != null) {
			if (((Event) current.data).getContact().equals(c)) {
				remove();
			}
			findNext();
		}
	}
}
