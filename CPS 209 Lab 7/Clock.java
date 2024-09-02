/**
 * Stores necessary fields for a clock.
 *
 * Complete the constructor so that it throws an IllegalArgumentException if given
 * invalid inputs, and otherwise sets attributes appropriately.
 */
public class Clock {
    private int hours;
    private int minutes;
    private int seconds;

    /**
     * Sets the clock variables to the correct values.
     *
     * @param hours What to set hours to
     * @param minutes What to set minutes to
     * @param seconds What to set seconds to
     * @throws IllegalArgumentException if the input parameters are illegal
     */
    public Clock(int hours, int minutes, int seconds) {
        //$start
        // If the hours is not from 1 and 12, should throw an IllegalArgumentException with message
        // "Hour value is invalid. Must be between 1 and 12"
        // If minutes is not from 0 to 59, should throw an IllegalArgumentException with message
        // "Minutes value is invalid. Must be between 0 and 59"
        // If seconds is not from 0 to 59, should throw an IllegalArgumentException with message
        // "Seconds value is invalid. Must be between 0 and 59"
        if (hours < 1 || hours > 12) {
            throw new IllegalArgumentException("Hour value is invalid. Must be between 1 and 12");
        } else if (minutes < 0 || minutes >= 60) {
            throw new IllegalArgumentException("Minutes value is invalid. Must be between 0 and 59");
        } else if (seconds < 0 || seconds >= 60) {
            throw new IllegalArgumentException("Seconds value is invalid. Must be between 0 and 59");
        }
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        //$end
    }

    public void secondElapsed() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }
        if(minutes == 60) {
            minutes = 0;
            hours++;
        }
        if(hours == 13) {
            hours = 1;
        }
    }

    public String toString() {
        String time = "";
        if (hours < 10) {
            time += "0";
        }
        time += hours + ":";
        if (minutes < 10) {
            time += "0";
        }
        time += minutes + ":";
        if(seconds < 10) {
            time += "0";
        }
        time += seconds;
        return time;
    }

    public int getHours() {
        return hours;
    }
    public int getMinutes() {
        return minutes;
    }
    public int getSeconds() {
        return seconds;
    }

    public boolean equals(Clock other) {
        if (this.hours == other.hours && this.minutes == other.minutes && this.seconds == other.seconds) {
            return true;
        }
        return false;
    }
}