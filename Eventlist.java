//اسحب عليه
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime; //we will use this library to convert start and 
public class Eventlist<T> { //-end times from string into localTime so we can detect colflicts
    //Attributes
    private Node<Event> head;
    private Node<Event> current;
    private Node<Event> tail;

    //Constructor and DLL methods
    public Eventlist() {
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
//احتاجها عشان احذف ايفنت 
    public void remove() {
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


/*هذي الميثود سلمك الله اذا ناديتها بتمسك الفترة الزمنية الي انت دخلتها
 * ولو كانت الليست غير فارغة بتمشي على الليست واحد واحد تشيك هل فيه تعارض
 *فنفس الوقت واليوم ولالا ولو فيه تعارض بترجع لك ترو لو مافيه ترجع لك فولس
 * نحتاجها اذا جينا نسوي إضافة ايفنت ننادي الميثود هذي اول واذا فولس مافي تعارض كملنا
 */
public boolean isConflict(String date, String startTime, String endTime) {
    if(empty()){
        return false; 
    }
    findFirst();
    LocalTime start2 = LocalTime.parse(startTime); //الي نبي نشيك ندخلهم او لا نرمزلهم 2
    LocalTime end2 = LocalTime.parse(endTime);
    while(current!=null){
    LocalTime start1 = LocalTime.parse(current.event.getstartTime()); //هذولي الي موجودين فالليست فبنرمز لهم 1
    LocalTime end1 = LocalTime.parse(current.event.getstartTime());
        if(current.event.getDate().equals(date)
          &&!((end1.isBefore(start2) || start1.isAfter(end2)))){
            return true;
        }
        findNext();
    }
    return false;
}
/*ملاااااحظة إذا جينا بنضيف بنضيف بشكل مرتب أبجديًا 
عشان لين جينا نطبعهم أبجديًا يصيرون مرتبين سلفًا والتكلفة و(ن)
*/
public void addEvent(Event event){
    if(isConflict(event.getDate(),event.getstartTime(),event.getendTime())){
        System.out.println("You already have Event at this time!");
    }
    else{//User is Available for event
    Node<Event> newNode = new Node<Event>(event);
            
            if (empty()){
             head = newNode;
             tail = newNode;
                        } 
            else{
                findFirst();
                while(current!=null && current.event.compareTo(event)<0){ //عشان نشوف من أولى ابجديا ونضيفه 
                    findNext();
                }
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
//now with searching (we have only 2 searching criterias)(title,contact name)
//كلهم لازم يرجعون مصفوفة ايفنتات زي الي كتبتها باللينكد ليست حقت الاسم
        public List<Event> searchBytitle(String title){
            List<Event> foundEvent_s = new ArrayList<>();
            findFirst();
            while(current!=null){
                if(current.event.getTitle().equalsIgnoreCase(title)){
                    foundEvent_s.add(current.event);
                                                                    }
            findNext();
                                }
            return foundEvent_s;
                                                    }


        public List<Event> searchByContactName(String name){
        List<Event> foundEvent_s = new ArrayList<>();
        findFirst();
        while(current!=null){
            if(current.event.getContact().getName().equalsIgnoreCase(name)){
                foundEvent_s.add(current.event);
            }
            findNext();
            }
            return foundEvent_s;
            }
            //هذي سلمك الله بتطبع لك كل الايفنتات وبحكم اننا ضايفينهم مرتبين أصلا بتطبعهم مرتبين أبجديًا
        public void displayAllEvents(){
        if(empty()){
            System.out.println("You have no events scheduled");
        }
        findFirst();
        while(current!=null){
            current.event.display();
            findNext();
        }
        }
        
        public void deleteEvent(Contact c){ //هذي بنناديها اذا جينا نحذف كونتاكت
            findFirst();
            while(current!=null){
                if(current.event.getContact().equals(c)){
                    remove();
                }
                findNext();
            }               
            
        }



}

