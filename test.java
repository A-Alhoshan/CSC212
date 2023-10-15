public class test {
    public static void main (String[] args){
        LinkedList contacts = new LinkedList<>();
        LinkedList events = new LinkedList<>();
        LinkedList found = new LinkedList<>();

        Contact c = new Contact("Ali", "0591288433", "a@yahoo",
                    "ksu", "01-01-2000", "Friend");
        Contact b = new Contact("Ziyad", "059122", "z@yahoo",
                    "Hatten", "01-01-2000", "Friend");
        Contact d = new Contact("Abood", "123", "z@yahoo",
                    "Naseem", "01-01-2000", "Friend");
        Contact f = new Contact("Mohammed", "567", "z@yahoo",
                    "KSU", "01-01-2000", "Friend");


        Event x1 = new Event("Arrangement", "01-01-2024", "12:30", "14:30", "Nakheel",c);
        Event x2 = new Event("Dinner", "01-01-2024", "22:00", "23:59", "Nakheel",b);
        Event x3 = new Event("Lunch", "01-01-2024", "12:00", "13:30", "Nakheel",d);
        Event x4 = new Event("Project", "02-01-2024", "22:00", "23:59", "Nakheel",b);
        Event x5 = new Event("Explain", "10-01-2024", "22:00", "23:59", "Nakheel",d);
        Event x6 = new Event("Meeting", "11-01-2024", "22:00", "23:59", "Nakheel",c);

        
        
        
         
        contacts.addContact(c);
        contacts.addContact(b);
        contacts.addContact(d);
        contacts.addContact(f);
        //contacts.addContact(b);
        //contacts.displayAll();

        // نجح في اختبار الاضافة واكتشاف التشابه


        events.addEvent(x1);
        events.addEvent(x2);
        //events.addEvent(x3);// تعارض 
        events.addEvent(x4);
        events.addEvent(x5);
        events.addEvent(x6);
        //events.displayAllEvents();
        //نجح في اختبار الاضافة واكتشاف التعارض


       //events.deleteEvent(c);       
       //events.displayAllEvents();
       //contacts.deleteContact(c);
       //contacts.deleteContact(b);
       //contacts.displayAll();
       //events.displayAllEvents();

       //نجح في اختبار حذف الايفنت وحذف الكونتاكت

       //found=contacts.searchByAddress("ksu");
       //found.displayAll(); 
       // نجح 
       //found = contacts.searchByBirthday("01-01-2000");
       //found.displayAll();
       //نجح
       //found=contacts.searchByFirstName("");
       //found.displayAll();
       //found= contacts.searchByEmailAddress("z@yahoo");
       //found.displayAll();
       //نجح
       //found=events.searchByContactName("Ziyad");  
       //found.displayAllEvents(); 
       //نجح
       //contacts.searchByName("").display();  
       //contacts.searchByPhoneNumber("123").display();
       //نجح
       //found=events.searchBytitle("dinner");
       //found.displayAllEvents();
    //System.out.println("B".compareTo("A"));    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
       
}
