import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student{
    private String name;
    private int rollno;
    private int grade;

    public Student(String name,int rollno,int grade)
    {
        this.name=name;
        this.rollno=rollno;
        this.grade=grade;
    }
    public String getName()
    {
        return name;
    }
    public int getRollno(){
        return rollno;
    }
    public int getGrade()
    {
        return grade;
    }
}
class StudentManagementSystem{
    private ArrayList<Student>students=new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }
    public void removeStudent(int rollno){
        students.removeIf(student->student.getRollno()==rollno);
    }
    public Student searchStudent(int rollno){
        for(Student student:students){
            if(student.getRollno()==rollno){
                return student;
            }
        }
        return null;
    }
    public void dispalyAllStudents(){
        for(Student student :students){
            System.out.println("Name:"+student.getName()+",Rollno:"+student.getRollno()+",Grade:"+student.getGrade());
        }
    }
    public void saveStudentToFile(String fileName){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(students);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void readStudentsFromFile(String fileName){
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fileName))){
            students=(ArrayList<Student>)ois.readObject();
        }catch(IOException |ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
}
public class Management_system{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StudentManagementSystem system=new StudentManagementSystem();

        boolean running=true;
        while(running){
            System.out.println("********Options*********");
            System.out.println("1.Add anew student");
            System.out.println("2.Remove a student");
            System.out.println("3.Search for a student");
            System.out.println("4.Display all students");
            System.out.println("5.Save students to file");
            System.out.println("6.Read students from file");
            System.out.println("7.Exit");
            
            int choice=sc.nextInt();

            switch(choice)
            {
                case 1:System.out.println("Enter name:");
                        String name=sc.next();
                        System.out.println("Enter rollno:");
                        int rollno=sc.nextInt();
                        System.out.println("Enter grade:");
                        int grade=sc.nextInt();
                        system.addStudent(new Student(name,rollno,grade));
                        break;
                case 2:System.out.println("Enter rollno of student to remove:");
                        int rollToRemove=sc.nextInt();
                        system.removeStudent(rollToRemove);
                        break;
                case 3:System.out.println("Enter rollno of the student to search:");
                        int rollToSearch=sc.nextInt();
                        Student foundStudent=system.searchStudent(rollToSearch);
                        if(foundStudent!=null){
                            System.out.println("Student foundname:"+foundStudent.getName()+",Rollno:"+foundStudent.getRollno()+",grade:"+foundStudent.getGrade());
                        }
                        else{
                            System.out.println("student not found");
                        }
                        break;
                case 4: system.dispalyAllStudents();
                            break;
                case 5: System.out.println("Enter file name to save students:");
                            String fileToSave=sc.next();
                            system.saveStudentToFile(fileToSave);
                            break;
                case 6:System.out.println("Enter file name to read students:");
                            String fileToRead=sc.next();
                            system.readStudentsFromFile(fileToRead);
                            break;
                case 7:running=false;
                        break;
                default: System.out.println("Invakid option");
            }

        }

    }
    
}