package useCases;

/**
 * useCase that takes the time in hours and the day to convert into minutes.
 */
public class TimeConverter {
    /**
     * Converts a given time and day into the equivalent time in minutes.
     *
     * @param day given day.
     *
     * @param time given time in a military time format.
     *
     * @return the time in minutes as an integer.
     */
    public Integer convertMinutes(String day, Integer time) {
        switch (day) {
            case "MON":
                return time * 60 + 24 * 60;
            case "TUE":
                return time * 60 + 2 * 24 * 60;
            case "WED":
                return time * 60 + 3 * 24 * 60;
            case "THU":
                return time * 60 + 4 * 24 * 60;
            case "FRI":
                return time * 60 + 5 * 24 * 60;
            case "SAT":
                return time * 60 + 6 * 24 * 60;
            default:
                return time * 60;
        }
    }
}
