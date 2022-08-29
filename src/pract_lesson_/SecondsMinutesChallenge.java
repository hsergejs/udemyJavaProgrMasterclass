package pract_lesson_;

public class SecondsMinutesChallenge {
    private static final String INVALID_VALUE_MSG = "Invalid value";
    public static String getDurationString(int minutes, int seconds) {
        if (minutes >= 0) {
            if (seconds >= 0 && seconds <= 59) {
                int calc_hours = minutes / 60;
                int rem_minutes = minutes % 60;

                String leading_zero = "0";
                String hour_string = calc_hours + "";
                String minutes_string = rem_minutes + "";
                String seconds_string = seconds + "";
                if(calc_hours < 10){
                    hour_string = leading_zero + calc_hours;
                }
                if(rem_minutes < 10){
                    minutes_string = leading_zero + rem_minutes;
                }
                if(seconds < 10){
                    seconds_string = leading_zero + seconds;
                }

                return hour_string + "h " + minutes_string + "m " + seconds_string + "s ";
            }

            return INVALID_VALUE_MSG;
        }

        return INVALID_VALUE_MSG;
    }

    public static String getDurationString(int seconds) {
        if (seconds >= 0) {
            int calc_minutes = seconds / 60;
            int rem_seconds = seconds % 60;

            return getDurationString(calc_minutes,rem_seconds);
        }

        return INVALID_VALUE_MSG;
    }
}
