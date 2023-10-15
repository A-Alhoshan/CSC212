public class Contact implements Comparable<Contact> {
    //Attributes
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String birthDay;
    private String notes;
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
    //We don't want name, phoneNumber to be null otherwise ok
    public Contact(String name, String phoneNumber, String emailAddress, String address, String birthDay, String notes) throws IllegalArgumentException {
        if (name != null && !name.isEmpty() && phoneNumber != null && !phoneNumber.isEmpty()) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
            this.address = address;
            this.birthDay = birthDay;
            this.notes = notes;
        } else {
            throw new IllegalArgumentException("Name and phone number cannot be null or empty.");
        }
    }

    //Setters & Getters بصراحة مدري وشوله السيت بس يمكن نحتاجها بعدين فنحطها
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
    System.out.println("");
}
//هذي نحتاجها عشان لين جينا نقارن بين جهات الاتصال ونرتبهم في الكلاس حق لينكد ليست ترتيب أبجدي
//طريقتها سلمك الله أنها بترجع عدد سالب لو كان الي بالبارامتر أدنى أبجديًا   
     @Override
      public  int compareTo(Contact c){
         return this.name.compareTo(c.name);
    }
}
//شرح زيادة عن الكومبير تو 
//Assume that you have this list { A -> B -> D}
//And we want to insert new node "C"
//First we will compare this A with C with compareTo, the result will be negative
//negative means C doesn't have rights to be in this place
//comparing D with C will give positive value that means C have rights to be here more than D
//{ A -> B -> C -> D}
//"A".compareTo("B") = -1
//"B".copareTo("A") = 1
