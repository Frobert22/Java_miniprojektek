package fel1.alarm;

public class TestAlarm {
    public static void main(String[] args) {
        Alarm al=new Alarm();
        al.setDay(Day.MONDAY);
        System.out.println(al.getTime());

        al.setDay(Day.SATURDAY);
        System.out.println(al.getTime());
        System.out.println(Day.FRIDAY.getShortName());

        Day[] days=Day.values();
        for (Day d:days){
            System.out.println(d.name());
        }
    }
}
