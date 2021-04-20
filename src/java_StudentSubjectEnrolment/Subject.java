package java_StudentSubjectEnrolment;

public class Subject {
	private String SubID;
	private String SubName;
	private String Semester;
	private String Year;
	private StudentEnrolment StuList;
	public Subject(String subID, String subName, String semester, String year, StudentEnrolment stuList) {
		SubID = subID;
		SubName = subName;
		Semester = semester;
		Year = year;
		StuList = stuList;
	}
	public String getSubID() {
		return SubID;
	}
	public void setSubID(String subID) {
		SubID = subID;
	}
	public String getSubName() {
		return SubName;
	}
	public void setSubName(String subName) {
		SubName = subName;
	}
	public String getSemester() {
		return Semester;
	}
	public void setSemester(String semester) {
		Semester = semester;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public StudentEnrolment getStuList() {
		return StuList;
	}
	public void setStuList(StudentEnrolment stuList) {
		StuList = stuList;
	}
	public String toString() {
		String msg="";
		msg+="SubID:"+this.SubID+"\tSubName:"+this.SubName;
		return msg+="\nSubSemester:"+this.Semester+"\tSubYear"+this.Year;
	}
}
