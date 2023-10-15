//ااسحب على ذا الكلاس
import java.util.ArrayList;
import java.util.List;
public class LinkedListN {
    //Atrr
    private Node<Contact> head;
    private Node<Contact> current;
    private Node<Contact> tail;
    
 // Constructor and DLL methods
 	public LinkedListN() {
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
    public void findLast(){
        current = tail;
    }
    
    public void findPrevious() {
		current = current.prev;
	}
    //هذي تشيك لو كان الكونتاكت موجود أو لا (ترجع خطأ لو كان مب موجود وصح لو موجود)
    public boolean alreadyExist(Contact contact){

        boolean flag = false;
        if(empty()){
            return flag;
        }
        else {
            findFirst();
            while(current !=null){
            if(this.current.contact.getName().equalsIgnoreCase(contact.getName()) //نفس الاسم بالضبط بدون اعتبار للكبتل والسمول
            && this.current.contact.getPhoneNumber()==contact.getPhoneNumber()){  //نفس الرقم بالضبط
                flag = true;
            }
            findNext();
        }
        return flag;
    }
    }

    public void remove() { //هذي للحذف من الدبل لينكد ليست، بنحتاجها يوم نسوي ديليت
        if(current == head) {
            head = head.next;
                if(head != null)
                    head.prev = null;
                            }
        else {
            current.prev.next = current.next;
                if(current.next != null)
                    current.next.prev = current.prev;
             }   

        if(current.next == null)
            current = head;
        else
            current = current.next;
                        }


    public void addContact(Contact contact){
        if(alreadyExist(contact)){ //لو كان موجود سلفًا خلاص مايحتاج تكمل
            System.out.println("Contact "+contact.getName()+" is already exist!");
        }
        else{//not exist

            Node<Contact> newNode = new Node<Contact>(contact); 
            if (empty()){ //لو كانت فاضية خله الراس والذيل 
                head = newNode; 
                tail = newNode;
            }       
            else{//لو كانت الليست غير فارغة والكونتاكت ليس موجود سلفًا بيدخل هنا
                    findFirst();

                    while (current != null && current.contact.compareTo(contact) < 0){
                        findNext(); //طالما الكرنت مب فاضي والكرنت ليس أدنى أبجديا كمل 
                        }//If item is A and current is B this will be negative and exit loop

                        if(current==head){
                        newNode.next=head;
                        head.prev=newNode;  //الحالة الأولى: عنصرك أولى أبجديًا وبتضيف بالبداية
                        head=newNode;
                         }
                        else if(current==null){
                        newNode.prev=tail;
                        tail.next=newNode; //الحالة الثانية:عنصرك متدني أبجديًا وبتضيف آخر خانة
                        tail=newNode;
                        }
                        else{
                        newNode.prev = current.prev;
                        newNode.next = current;     //بتضيف بين عنصرين هنا لازم شوية تركيز
                        current.prev.next=newNode;
                        current.prev=newNode;
                        }
                        }

                        }
                    }




    //Unique search  نبحث بالأشياء الي ماتتكرر زي الايميل ورقم الجوال والاسم كامل باختصار ضامنين نرجع اوبجكت واحد
    //Unique search عندنا ثلاثة ايميل،رقم جوال، اسم كاملًا
    //لاتنسَ هذي النوعية من السيرش بنخليها ترجع اوبجكت مب طباعة يعني لو بتستدعيها بالمين لاتنسَ تطبعها من هناك  
        public Contact searchByEmailAddress(String email){
            findFirst();
            while(current!=null){
                if(current.contact.getEmailAddress().equalsIgnoreCase(email)){
                    return current.contact;
                }
                findNext();
            }
            return null;
        }

        public Contact searchByPhoneNumber(String num){
            findFirst();
            while(current!=null){
                if(current.contact.getPhoneNumber().equals(num)){
                    return current.contact;
                }
                findNext();
            }
            return null;
        }

        public Contact searchByName(String name){
            findFirst();
            while(current!=null){
                if(current.contact.getName().equalsIgnoreCase(name)){
                    return current.contact;
                }
                findNext();
            }
            return null;
        }

        //not unique search الي قد يكون فيها تكرار نفس الاسم الاول والآدريس ويوم الميلاد
        //هذي قد ترجع لك أكثر من شخص وش الحل؟ نخليهاترجع لك مصفوفةاوبجيكتات
        //الثلاث ميثودات هذولي يرجعون إما فارغة او اوبجكت او اوبجكتس لاتنسَ تتعامل مع ذا الشيء
        public List<Contact> searchByFirstName(String name){
            List<Contact> foundContact_s = new ArrayList<>();
            findFirst();
            while(current!=null){ //contains هذي من اسمها تقارن لك لو كان السترنق هذاك يحتوي السترينق هذا
                if(current.contact.getName().toString().toLowerCase().contains(name.toLowerCase())){
                    foundContact_s.add(current.contact);
                }
                findNext();
            }
            return foundContact_s;
        }

        public List<Contact> searchByAddress(String address){
            List<Contact> foundContact_s = new ArrayList<>();
            findFirst();
            while(current!=null){
                if(current.contact.getAddress().toString().toLowerCase().contains(address.toLowerCase())){
                foundContact_s.add(current.contact);
                }
                findNext();
            }
            return foundContact_s;
        }

        public List<Contact> searchByBirthday(String birthday){
            List<Contact> foundContact_s = new ArrayList<>();
            findFirst();
            while(current!=null){
                if(current.contact.getBirthDay().equalsIgnoreCase(birthday)){
                    foundContact_s.add(current.contact);
                }
                findNext();
            }
            return foundContact_s;
        }

        public boolean deleteContact(Contact c){;
        	if(empty() || c==null) {
        		return false;
        	}
        	findFirst();
        		while(current!=null) {
        			if(current.contact.equals(c)) {
        				remove();
        				return true;
        		}}
        			return false;
        		}



                public void displayAll() { //testing بتفيدنا في الـ
                    findFirst();
                    while(current!=null) {
                        current.contact.display();
                        findNext();
                    }
                }
 	
 	
 	
}
