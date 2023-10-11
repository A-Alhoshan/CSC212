public class Event implements Comparable<Event> {
    		
		//Attributes
	    private String title;
	    private String date;
		private String time;
	    private String location;
	    private Contact contact; //هنا حطينا متغير كونتاكت من نوع كونتاكت عشان بنضيف الفعاليات للكونتاكت نفسه فبنحتاجه في هذا الكلاس
	  
	    //Default and Set Constructors 
	    public Event() {
	    	this.title = null;
	    	this.date=null;
	    	this.location=null;
	    	this.contact=null;
			this.time=null;
	    }
	    public Event(String title, String date,String time, String location, Contact contact) {
	        this.title = title;
	        this.date = date;
			this.time=time;
	        this.location = location;
	        this.contact = contact;
	    }
	    
	    //Setters and Getters
	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getDate() {
	        return date;
	    }
		public String getTime(){
			return time;
		}

	    public void setDate(String date) {
	        this.date = date;
	    }
		public void setTime(String time){
			this.time=time;
		}

	    public String getLocation() {
	        return location;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }

	    public Contact getContact() {
	        return contact;
	    }

	    public void setContact(Contact contact) {
	        this.contact = contact;
	    }
	    @Override
	    public int compareTo(Event e) {
	        return this.title.compareTo(e.title);
	    }
		//Compare للمقارنة بين اسماء الأحداث بناءً على الأبجدية عشان بعدين بنحتاج نطبعهم بالترتيب

		/*remember, we will stick with requirement and we assume
		that every event should have only one contact!
		*/
		public void display(){
			System.out.println("Event title:"+this.title);
			System.out.println("Contact name:"+this.contact.getName());
			System.out.println("Event date:"+this.date);
			System.out.println("Event time:"+this.time);
			System.out.println("Event location"+this.location);
		}
	}
