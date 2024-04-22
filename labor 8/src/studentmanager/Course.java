package studentmanager;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Course {
    private String code; // "FGU123"
    private String name;
    private int credit;
    private int studentsNr;
    private String teacher;
    private ArrayList<Student> students;

    public Course(String code, String name, int credit, String teacher) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.teacher = teacher;
        this.studentsNr = 0;
        this.students = new ArrayList<>();
    }

    public Course(String name, int credit, String teacher) {
        this.code = this.generateCode();
        this.name = name;
        this.credit = credit;
        this.teacher = teacher;
        this.studentsNr = 0;
        this.students = new ArrayList<>();
    }

    private String generateCode(){
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        // combine all strings
        String alphaNumeric = upperAlphabet + numbers;

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        //upperAlphabet
        int length = 3;
        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(upperAlphabet.length());

            // get character specified by index
            // from the string
            char randomChar = upperAlphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        // numeric
        int lengthNum = 3;
        for (int i = 0; i < lengthNum; i++) {

            // generate random index number
            int index = random.nextInt(numbers.length());

            // get character specified by index
            // from the string
            char randomChar = numbers.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudentsNr(int studentsNr) {
        this.studentsNr = studentsNr;
    }

    public void addStudent(Student s){
        if(!students.contains(s)) {
            this.students.add(s);
        } else {
            System.out.println("The student is already enrolled");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(code, course.code);
    }


    @Override
    public String toString() {
        return this.name;
    }
}