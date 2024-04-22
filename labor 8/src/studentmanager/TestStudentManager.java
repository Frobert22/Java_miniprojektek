package studentmanager;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestStudentManager {

    public static void listOfStudents(ArrayList<Student> students, String progr) {
        for (Student s : students) {
            if (s.getProgramme().equals(progr)) {
                System.out.println(s);
                System.out.println("-----------------------------------------------");
            }
        }
    }

    public static void listOfStudentsCredit(ArrayList<Student> students) {
        for (Student s : students) {
            System.out.println(s.getName() + ": " + s.getSumOfCredits());
        }
    }

    public static void setStudentsOfCourse(ArrayList<Course> courses, ArrayList<Student> students) {
        for (Course c : courses) {
            for (Student s : students) {
                if (s.getCourses().contains(c)) {
                    c.addStudent(s);
                }
            }
            c.setStudentsNr(c.getStudents().size());
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> studs = new ArrayList<>();

        //Students

        Student s1 = new Student("Kiss Balazs", "balazs@gmail.com", "075555555", "GI");
        Student s2 = new Student("Nagy Ella", "ella@gmail.com", "075555555", "GI");
        Student s3 = new Student("Egy Elek", "elek@gmail.com", "075555555", "GI");
        Student s4 = new Student("Ket Barna", "barna@gmail.com", "075555555", "GI");
        s1.setBirthDate(LocalDate.parse("2003-01-08"));
        s2.setBirthDate(LocalDate.parse("2006-01-08"));
        s3.setBirthDate(LocalDate.parse("2005-01-08"));
        s4.setBirthDate(LocalDate.parse("2004-01-08"));
        studs.add(s1);
        studs.add(s2);
        studs.add(s3);
        studs.add(s4);

        //Courses
        Course math = new Course("ABC123", "Mathematics", 4, "Okos Peter");
        Course webTech = new Course("TRE567", "Web technologies", 4, "Okos Janos");
        Course db = new Course("DBE5897", "Databases", 6, "Okos Anna");
        Course javaProg = new Course("IOP453", "Java programming", 5, "Okos Lajos");
        Course webProg = new Course("Web programming", 5, "Okos Emma");

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(math);
        courses.add(webTech);
        courses.add(db);
        courses.add(javaProg);
        courses.add(webProg);

        s1.addCourse(math);
        s1.addCourse(webTech);
        s1.addCourse(webProg);

        s2.addCourse(db);
        s2.addCourse(webTech);
        s2.addCourse(javaProg);

        s3.addCourse(db);
        s3.addCourse(webTech);
        s3.addCourse(javaProg);

        s4.addCourse(db);
        s4.addCourse(math);
        s4.addCourse(javaProg);

        //System.out.println(s1);
        //System.out.println(s2);

        for (Student s : studs) {
            System.out.println(s);
            System.out.println("-------------------------------------------");
        }

        System.out.println("GI-s hallgatok:");
        listOfStudents(studs, "GI");
        System.out.println("KGI-s hallgatok:");
        listOfStudents(studs, "KGI");

        System.out.println("Number of credits:");
        listOfStudentsCredit(studs);

        setStudentsOfCourse(courses, studs);
        System.out.println("Students of Mathematics course:\n " + math.getStudents());
        System.out.println("Students of Java programming course:\n " + javaProg.getStudents());

        System.out.println("Check if a course is taken or not:");
        System.out.println("s1->math: " + s1.isCourseTaken(math));
        System.out.println("s1->db: " + s1.isCourseTaken(db));

        s1.deleteCourse(db);
        s1.deleteCourse(math);
        System.out.println(s1.getCourses());

        s1.addCourse(db);
        s1.addCourse(db);

        Person p1 = new Person("Person1", "a@a.ro", "01222");
        Person p2 = new Person("Person2", "b@a.ro", "01222");

        ArrayList list = new ArrayList();

        list.add(p1);
        list.add(p2);
        list.add(s1);
        list.add(s2);
        list.add(s3);

        for (Object obj:list) {
            if (obj instanceof Student){
                //System.out.println(((Student)obj).getCourses());
                System.out.println(obj);
            }
        }

        //studs.sort(Comparator.comparing(Student::getBirthDate));
        System.out.println(studs);
        studs.sort(new BirthDateComparator());
        System.out.println(studs);


    }
}