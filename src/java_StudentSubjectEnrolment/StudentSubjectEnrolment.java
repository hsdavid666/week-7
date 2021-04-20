package java_StudentSubjectEnrolment;

import java.util.Scanner;

public class StudentSubjectEnrolment {
	public static SubjectEnrolment se = new SubjectEnrolment();
	public static StudentEnrolment stu;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int change = menu();
		while (change != 1 && change != 5) {
			System.out.println("���ȴ����γ�!");
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
		System.out.println("======WTUѡ��ϵͳ======");
		System.out.println("1.�����γ�");
		System.out.println("2.ѡ��");
		System.out.println("3.��ѡ");
		System.out.println("4.��ӡѧ����Ϣ");
		System.out.println("5.�˳�����");
		System.out.print("���������ѡ��:");
		Scanner scan = new Scanner(System.in);
		change = scan.nextInt();
		return change;
	}

	// ����һ���γ�
	public static void createsub(String SubID) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������γ�����:");
		String name = scan.next();
		System.out.print("������γ�ѧ��:");
		String semester = scan.next();
		System.out.print("������γ�ѧ��:");
		String year = scan.next();
		System.out.print("������ÿγ�ѧ������:");
		int num = scan.nextInt();
		stu = new StudentEnrolment(num);
		Subject sub = new Subject(SubID, name, semester, year, stu);
		se.add(sub);
	}

	public static boolean CreateSub() {
		Scanner scan = new Scanner(System.in);
		String Y = "Y";
		System.out.print("������γ�ID:");
		String SubID = scan.next();
		if (se.indexOf(SubID) >= 0) {
			System.out.println("�ÿγ��Ѵ���,����Y���´���!(���������˳�)");
			String YN = scan.next();
			if (YN.equals(Y)) {
				se.remove(se.indexOf(SubID));
				createsub(SubID);
			} else {
				System.out.println("����ʧ��!");
				return false;
			}
		} else {
			System.out.println("*2*");
			createsub(SubID);
		}
		return true;
	}

	// ���һ��ѧ��
	public static void addstudent(String SubID, String StuID) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������ѧ������:");
		String StuName = scan.next();
		Student stu = new Student(StuID, StuName);
		se.getSub(SubID).getStuList().add(stu);
	}

	public static boolean AddStudent() {
		Scanner scan = new Scanner(System.in);
		String Y = "Y";
		System.out.println("������Ҫ���ѧ���Ŀγ�ID:");
		String SubID = scan.next();
		if (se.indexOf(SubID) < 0) {
			System.out.println("�ÿγ̲�����!");
			return false;
		}
		System.out.print("������ѧ��ѧ��:");
		String StuID = scan.next();
		if (se.getSub(SubID).getStuList().indexOf(StuID) > 0) {
			System.out.println("��ѧ���Ѵ���,����Y���´���!(���������˳�)");
			String YN = scan.next();
			if (YN.equals(Y)) {
				se.getSub(SubID).getStuList().remove(se.getSub(SubID).getStuList().indexOf(StuID));
				addstudent(SubID, StuID);
			} else {
				System.out.println("����ʧ��!");
				return false;
			}
		} else
			addstudent(SubID, StuID);
		return true;
	}

	// ɾ��һ��ѧ��
	public static boolean RemoveStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�������ѧ�����ڿγ�ID:");
		String SubID = scan.next();
		if (se.indexOf(SubID) < 0) {
			System.out.println("�ÿγ̲�����!");
			return false;
		}

		else {
			System.out.print("������ѧ��ѧ��:");
			String StuID = scan.next();
			if (se.getSub(SubID).getStuList().indexOf(StuID) > 0) {
				se.getSub(SubID).getStuList().remove(se.getSub(SubID).getStuList().indexOf(StuID));
				System.out.println("ɾ���ɹ�!");
				return true;
			} else {
				System.out.println("�ÿγ��޴�ѧ��!");
				return false;
			}
		}
	}

	public static void Travel() {
		se.SubTravelList();
	}
}
