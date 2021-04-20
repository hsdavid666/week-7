package java_StudentSubjectEnrolment;

public class SubjectEnrolment {
	private int count;
	private Subject[] SubList;
	
	public SubjectEnrolment() 
	{
		int maxsize=10;
		SubList = new Subject[maxsize];
		count=0;
	}
	public SubjectEnrolment(int maxsize)
	{
		SubList = new Subject[maxsize];
		count=0;
	}
	public boolean add(Subject subject)
	{
		if(subject==null)
			return false;
		if(count>SubList.length)
			return false;
		SubList[count]=subject;
		count++;
		return true;
	}
	public int indexOf(String i)
	{
		for(int index=0;index<count&&SubList[index]!=null;index++) {
			if(SubList[index].getSubID().equals(i))
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
			SubList[index]=null;
			count--;
		}
		for(int i=index;i<count;i++)
			SubList[index]=SubList[index+1];
		SubList[count]=null;
		count--;
		return true;
	}
	public Subject getSub(String ID)
	{
		int index;
		index=indexOf(ID);
		return SubList[index];
	}
	public void SubTravelList()
	{
		for(int i=0;i<count;i++)
		{
			System.out.println(SubList[i].toString());
			SubList[i].getStuList().StuTravelList();
		}
	}
}
