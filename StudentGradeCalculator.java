import java.util.Scanner;
public class StudentGradeCalculator{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int no_of_subjects,i,total_marks=0;
        double avg_per;
        System.out.println("Enter number of subjects : ");
        no_of_subjects=sc.nextInt();
        int[] marks = new int[no_of_subjects];
        System.out.println("Enter the marks of the student:");
        //
        for(i=0;i<no_of_subjects;i++)
        {
            System.out.println("Enter marks of subject "+(i+1)+":");
            marks[i]=sc.nextInt();
        }
        //calculating total marks 
        for(int Marks : marks)
            total_marks+=Marks;
        //calculating avg percentage
        avg_per=(double)total_marks/(no_of_subjects);
        //Assigining grades using else-if ladder
        String grade;
        if(avg_per>= 90)
            grade="O";
        else if(avg_per >= 80)
            grade="A+";
        else if(avg_per >= 70)
            grade="A";
        else if(avg_per >= 60)
            grade="B+";
        else if(avg_per >= 50)
            grade="B";
        else if(avg_per >= 40)
            grade="C";
        else 
            grade="F";
        //Displaying results 
        System.out.println("Total marks obtained : "+total_marks);
        System.out.println("Average percentage of student : "+avg_per+ "%");
        System.out.println("Grade : "+grade);
    }
    
}
