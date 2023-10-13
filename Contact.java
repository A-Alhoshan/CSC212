public class Contact implements Comparable<Contact> {
                    //Attributes
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String birthDay;
    private String notes;
    //private Eventlist events;

                    //Default & Set Constructors
public Contact() {
    this.name = null;
    this.phoneNumber = null;
    this.emailAddress = null;
    this.address = null;
    this.birthDay = null;
    this.notes = null;
    //this.events=null;
}
public Contact(String name, String phoneNumber, String emailAddress, String address, String birthDay, String notes) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
    this.address = address;
    this.birthDay = birthDay;
    this.notes = notes;
}

                    //Setters & Getters
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getPhoneNumber() {
    return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
}
public String getEmailAddress() {
    return emailAddress;
}
public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
}
public String getAddress() {
    return address;
}

//public Eventlist getEvents(){
 //   return events;
//}
//public void setEvents(Eventlist events){
  //  this.events=events;
//}

public void setAddress(String address) {
    this.address = address;
}
public String getBirthDay() {
    return birthDay;
}
public void setBirthDay(String birthDay) {
    this.birthDay = birthDay;
}
public String getNotes() {
    return notes;
}
public void setNotes(String notes) {
    this.notes = notes;
}

//ديسبلاي فنكشن
public void display() {
    System.out.println("Name: " + name);
    System.out.println("Phone Number: " + phoneNumber);
    System.out.println("Email Address: " + emailAddress);
    System.out.println("Address: " + address);
    System.out.println("Birthday: " + birthDay);
    System.out.println("Notes: " + notes);
    System.out.println("***************");
}
//هذي نحتاجها عشان لين جينا نقارن بين جهات الاتصال ونرتبهم في الكلاس حق لينكد ليست ترتيب أبجدي
//طريقتها سلمك الله أنها بترجع عدد سالب لو كان الي بالبارامتر أدنى أبجديًا   
     @Override
      public  int compareTo(Contact c){
         return this.name.compareTo(c.name);
    }
}
