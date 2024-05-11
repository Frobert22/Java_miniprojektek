package csop2;

public class Student {
    private String name;
    private String etr;
    private int mark;
    private String szak;

    public Student(String name, String etr, int mark, String szak) {
        this.name = name;
        this.etr = etr;
        this.mark = mark;
        this.szak = szak;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEtr() {
        return etr;
    }

    public void setEtr(String etr) {
        this.etr = etr;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getSzak() {
        return szak;
    }

    public void setSzak(String szak) {
        this.szak = szak;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", etr='" + etr + '\'' +
                ", mark=" + mark +
                ", szak='" + szak + '\'' +
                '}';
    }
}
