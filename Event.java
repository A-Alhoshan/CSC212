public class Event implements Comparable<Event> {
    		
		//Attributes
	    private String title;
	    private String date; //(MM/DD/YYYY) AS Mentioned in requirement
		private String startTime;//HH:mm 
		private String endTime; //HH:mm هذولي الثنين قسمناهم عشان نعرف اذا فيه تعارض بين ايفنتين ولالا
	    private String location;
	    private Contact contact; //هنا حطينا متغير كونتاكت من نوع كونتاكت عشان بنضيف الفعاليات للكونتاكت نفسه فبنحتاجه في هذا الكلاس
	    						 //We will assume that an event have only one contact
	    //Default and Set Constructors 
	    public Event() {
	    	this.title = null;
	    	this.date=null;
	    	this.location=null;
	    	this.contact=null;
			this.startTime=null;
			this.endTime=null;
	    }
		//We don't want title, date,start time, endtime, contact to be empty or null , location ok to be empty
		public Event(String title, String date, String startTime, String endTime, String location, Contact contact) throws IllegalArgumentException {
			if (!title.isEmpty() && !date.isEmpty() && !startTime.isEmpty() && !endTime.isEmpty() && contact != null) {
				this.title = title;
				this.date = date;
				this.startTime = startTime;
				this.endTime = endTime;
				this.location = location;
				this.contact = contact;
			} else {
				throw new IllegalArgumentException("Title, date, start time, end time, and contact cannot be null or empty.");
			}
		}
		
	    
	    //Setters and Getters نفس الكلام مدري وشوله سيترز بس يمكن نحتاجها بعدين فاحتياط
	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getDate() {
	        return date;
	    }
		public void setDate(String date) {
	        this.date = date;
	    }
		public String getstartTime(){
			return startTime;
		}
		public void setstartTime(String startTime){
			this.startTime=startTime;
		}
		public String getendTime(){
			return endTime;
		}
		public void setendTime(String endTime){
			this.endTime=endTime;
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
			System.out.println("Event title: "+this.title);
			System.out.println("Contact name: "+this.contact.getName());
			System.out.println("Event date: "+this.date);
			System.out.println("Event start time: "+this.startTime);
			System.out.println("Event end time: "+this.endTime);
			System.out.println("Event location: "+this.location);
			System.out.println("***************");
			System.out.println("");
		}
	}
