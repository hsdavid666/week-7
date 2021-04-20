package java_StudentSubjectEnrolment;

public class Student {
	private String Id;
	private String name;
	
	public Student()
	{
	}
	public Student(String Id,String name)
	{
		this.Id=Id;
		this.name=name;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		String msg="";
		return msg+=this.Id+"    "+this.name+"\n";
	}

}
