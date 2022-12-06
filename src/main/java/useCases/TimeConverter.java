package useCases;

public class TimeConverter {
    // convert the given time into minutes
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
