package studentmanager;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Student extends Person implements Comparable<Student>{
    private String neptunCode;
    private String programme;
    private double grade;
    private ArrayList<Course> courses;


    public Student(String name, String email, String phone, String neptunCode, String programme) {
        super(name, email, phone);
        this.neptunCode = neptunCode;
        this.programme = programme;
        this.grade = 0;
        this.courses = new ArrayList<>();
    }

    public Student(String name, String email, String phone, String programme) {
        super(name, email, phone);
        this.programme = programme;
        this.neptunCode = generateNeptunCode();
        this.grade = 0;
        this.courses = new ArrayList<>();
    }

    public String getNeptunCode() {
        return neptunCode;
    }

    public void setNeptunCode(String neptunCode) {
        this.neptunCode = neptunCode;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course c) {
        if(!isCourseTaken(c)) {
            this.courses.add(c);
        } else{
            System.out.println(c.getName() + " course is already taken!");
        }
    }

    public boolean isCourseTaken(Course c){
        return this.courses.contains(c);
    }

    public void deleteCourse(Course c){
        if(courses.contains(c)){
            courses.remove(c);
            System.out.println(c.getName() + " course deleted successfully");
        } else {
            System.out.println("There is no course with name: " + c.getName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(neptunCode, student.neptunCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(neptunCode);
    }

    private String generateNeptunCode() {
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        // combine all strings
        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 5;
        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(lowerAlphabet.length());

            // get character specified by index
            // from the string
            char randomChar = lowerAlphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public int getSumOfCredits(){
        int sum = 0;
        for (Course c:courses){
            sum = sum + c.getCredit();
        }
        return sum;
    }

    @Override
    public String toString() {
        return  "Name: " + this.getName() + "\n" +
                "Neptun code: " + this.getNeptunCode() + "\n" +
                "Study program: " + this.getProgramme() + "\n" +
                "Grade: " + this.getGrade() + "\n" +
                "Birth date: " + this.getBirthDate() + "\n" +
                "Courses: " + this.courses;

        //return String.format("Name: %s\nNeptun code: %s\nStudy program: %s\nGrade: %s", this.getName(), this.getNeptunCode(), this.getProgramme(), this.getGrade()); // String.format használata
        //return super.toString(); // Ős osztály toString metódusa
    }

    @Override
    public int compareTo(Student o) {
        //return (Double.valueOf(this.grade)).compareTo(o.grade);
        return Double.compare(this.grade, o.grade);
    }

/*
    @Override
    public int compareTo(Student o) {
        double s1 = o.getGrade();
        double s2 = this.getGrade();
        if (s1 < s2) {
            return -1;
        } else if (s1 > s2) {
            return 1;
        } else {
            return 0;
        }
    }

*/
}