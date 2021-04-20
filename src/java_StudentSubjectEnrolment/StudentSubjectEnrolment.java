package java_StudentSubjectEnrolment;

import java.util.Scanner;

public class StudentSubjectEnrolment {
	public static SubjectEnrolment se = new SubjectEnrolment();
	public static StudentEnrolment stu;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int change = menu();
		while (change != 1 && change != 5) {
			System.out.println("请先创建课程!");
			change = menu();
		}
		while (change != 5) {
			switch (change) {
			case 1:
				CreateSub();
				break;
			case 2:
				AddStudent();
				break;
			case 3:
				RemoveStudent();
				break;
			case 4:
				Travel();
				break;
			case 5:
				break;
			}
			change = menu();
		}

	}

	public static int menu() {
		int change;
		System.out.println("======WTU选课系统======");
		System.out.println("1.创建课程");
		System.out.println("2.选课");
		System.out.println("3.退选");
		System.out.println("4.打印学生信息");
		System.out.println("5.退出程序");
		System.out.print("请输入你的选择:");
		Scanner scan = new Scanner(System.in);
		change = scan.nextInt();
		return change;
	}

	// 创建一个课程
	public static void createsub(String SubID) {
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入课程名称:");
		String name = scan.next();
		System.out.print("请输入课程学期:");
		String semester = scan.next();
		System.out.print("请输入课程学年:");
		String year = scan.next();
		System.out.print("请输入该课程学生人数:");
		int num = scan.nextInt();
		stu = new StudentEnrolment(num);
		Subject sub = new Subject(SubID, name, semester, year, stu);
		se.add(sub);
	}

	public static boolean CreateSub() {
		Scanner scan = new Scanner(System.in);
		String Y = "Y";
		System.out.print("请输入课程ID:");
		String SubID = scan.next();
		if (se.indexOf(SubID) >= 0) {
			System.out.println("该课程已存在,输入Y重新创建!(输入其他退出)");
			String YN = scan.next();
			if (YN.equals(Y)) {
				se.remove(se.indexOf(SubID));
				createsub(SubID);
			} else {
				System.out.println("创建失败!");
				return false;
			}
		} else {
			System.out.println("*2*");
			createsub(SubID);
		}
		return true;
	}

	// 添加一个学生
	public static void addstudent(String SubID, String StuID) {
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入学生姓名:");
		String StuName = scan.next();
		Student stu = new Student(StuID, StuName);
		se.getSub(SubID).getStuList().add(stu);
	}

	public static boolean AddStudent() {
		Scanner scan = new Scanner(System.in);
		String Y = "Y";
		System.out.println("请输入要添加学生的课程ID:");
		String SubID = scan.next();
		if (se.indexOf(SubID) < 0) {
			System.out.println("该课程不存在!");
			return false;
		}
		System.out.print("请输入学生学号:");
		String StuID = scan.next();
		if (se.getSub(SubID).getStuList().indexOf(StuID) > 0) {
			System.out.println("该学生已存在,输入Y重新创建!(输入其他退出)");
			String YN = scan.next();
			if (YN.equals(Y)) {
				se.getSub(SubID).getStuList().remove(se.getSub(SubID).getStuList().indexOf(StuID));
				addstudent(SubID, StuID);
			} else {
				System.out.println("创建失败!");
				return false;
			}
		} else
			addstudent(SubID, StuID);
		return true;
	}

	// 删除一个学生
	public static boolean RemoveStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入该学生所在课程ID:");
		String SubID = scan.next();
		if (se.indexOf(SubID) < 0) {
			System.out.println("该课程不存在!");
			return false;
		}

		else {
			System.out.print("请输入学生学号:");
			String StuID = scan.next();
			if (se.getSub(SubID).getStuList().indexOf(StuID) > 0) {
				se.getSub(SubID).getStuList().remove(se.getSub(SubID).getStuList().indexOf(StuID));
				System.out.println("删除成功!");
				return true;
			} else {
				System.out.println("该课程无此学生!");
				return false;
			}
		}
	}

	public static void Travel() {
		se.SubTravelList();
	}
}
