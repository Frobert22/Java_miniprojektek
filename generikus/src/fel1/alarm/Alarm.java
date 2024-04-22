package fel1.alarm;

public class Alarm {
    private int time;

    public int getTime() {
        return time;
    }
    public void setDay(Day d){
        switch (d){
            case MONDAY,THURSDAY,TUESDAY,WEDNESDAY,FRIDAY ->time=8;
            case SUNDAY, SATURDAY -> time=10;
        }
    }
}
