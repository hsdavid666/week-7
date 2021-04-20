package java_StudentSubjectEnrolment;

public class StudentEnrolment {
	private int count;
	private Student[] List;
	
	public StudentEnrolment() 
	{
		int maxsize=10;
		List = new Student[maxsize];
		count=0;
	}
	public StudentEnrolment(int maxsize)
	{
		List = new Student[maxsize];
		count=0;
	}
	public boolean add(Student student)
	{
		if(student==null)
			return false;
		if(count>List.length)
			return false;
		List[count]=student;
		count++;
		return true;
	}
	public int indexOf(String i)
	{
		for(int index=0;index<count&&List[index]!=null;index++) {
			if(List[index].getId().equals(i))
				return index;
		}
		return -1;
	}
	public boolean remove(int index)
	{
		if(index<0||index>count)
			return false;
		if(count==1)
		{
			List[index]=null;
			count--;
		}
		for(int i=index;i<count;i++)
			List[index]=List[index+1];
		List[count]=null;
		count--;
		return true;
	}
	public Student getStu(String ID)
	{
		int index;
		index=indexOf(ID);
		return List[index];
	}

	public void StuTravelList() {
		System.out.println("该课程的学生信息为:\nStuID\tStuName");
		for(int i=0;i<count;i++)
		{
			System.out.println(List[i].toString());
		}
	}
}
