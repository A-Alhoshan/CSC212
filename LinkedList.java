public class LinkedList<T> {
    //Atrr
    private Node<T> head;
    private Node<T> current;
    private Node<T> tail;

    //Constructor and DLL methods
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
            if(this.current.contact.getName()==contact.getName()
            && this.current.contact.getPhoneNumber()==contact.getPhoneNumber()){
                flag = true;
            }
            findNext();
        }
        return flag;
    }
}


    public void addContact(Contact contact){
        if(alreadyExist(contact)){
            System.out.println("Contact "+contact.getName()+" is already exist");
        }
        else{//not exist

            Node<T> newNode = new Node<T>(contact);
            if (empty()){
                head = newNode;
            }       
            else{//لو كانت الليست غير فارغة والكونتاكت ليس موجود سلفًا بيدخل هنا
                    findFirst();

                    while (current != null && contact.compareTo(contact) > 0){
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




    //Search

}
