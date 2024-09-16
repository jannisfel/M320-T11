package D1.src;

public class Time {
    private int second;
    private int minute;
    private int hour;

    public Time(int second, int minute, int hour) {
        setTime(second, minute, hour);
    }

    public Time() {
        this(0, 0, 0);
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Invalid second value: " + second);
        }
        this.second = second;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid minute value: " + minute);
        }
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Invalid hour value: " + hour);
        }
        this.hour = hour;
    }

    public void setTime(int second, int minute, int hour) {
        setSecond(second);
        setMinute(minute);
        setHour(hour);
    }

    @Override 
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public Time nextSecond() {
        second++;
        if (second >= 60) {
            second = 0;
            minute++;
            if (minute >= 60) {
                minute = 0;
                hour++;
                if (hour >= 24) {
                    hour = 0;
                }
            }
        }
        return this;
    }
}
