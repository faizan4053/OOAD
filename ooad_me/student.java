import java.io.*;
import java.util.Scanner;

interface Sports{

	//float calculate_final_marks();
	void calculate_final_marks1();

	void display_final_marks1();
}

class Student{

	int roll_no;
	int marks_in_maths;
	int marks_in_english;
	int marks_in_science;
	int marks_in_cs;
	int marks_in_hindi;
	int grace_marks;

	Student(int maths,int eng,int sci,int cs,int hindi,int grace){
		this.marks_in_maths=maths;
		this.marks_in_english=eng;
		this.marks_in_science=sci;
		this.marks_in_cs=cs;
		this.marks_in_hindi=hindi;
		this.grace_marks=grace;
	}
}

class Exam extends Student{

	 int total_marks=500;

	 int marks_obtained=0;

	 Exam(int maths,int eng,int sci,int cs,int hindi,int grace ){
			super(maths,eng,sci,cs,hindi,grace);
		this.marks_obtained=(marks_in_cs+marks_in_hindi+marks_in_science+marks_in_english+marks_in_maths);
		this.marks_obtained+=grace_marks;
	}

}

class Results extends Exam {

		int final_marks=0;

		int total=total_marks;
		int marks_opt=marks_obtained;

		Results(int maths,int eng,int sci,int cs,int hindi,int grace ){
			super(maths,eng,sci,cs,hindi,grace);
		}

		 void calculate_final_marks(){

			if(marks_opt>total)
				this.final_marks=total;
			else
				this.final_marks=marks_opt;

		}

		 void display_final_marks(){
			System.out.println("Final marks="+this.final_marks);
		}
}


public class student{

	public static void main(String [] arg){

			int m,e,h,cs,s,g;
			System.out.println("Enter the marks of student in five subjects");


			Results obj=new Results(80,90,78,90,95,45);

			obj.calculate_final_marks();
			obj.display_final_marks();
	}
}