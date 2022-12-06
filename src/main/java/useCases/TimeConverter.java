package useCases;

public class TimeConverter {
    // convert the given time into minutes
    public Integer convertMinutes(String day, Integer time) {
        switch (day) {
            case "Mon":
                return time * 60 + 24 * 60;
            case "Tue":
                return time * 60 + 2 * 24 * 60;
            case "Wed":
                return time * 60 + 3 * 24 * 60;
            case "Thu":
                return time * 60 + 4 * 24 * 60;
            case "Fri":
                return time * 60 + 5 * 24 * 60;
            case "Sat":
                return time * 60 + 6 * 24 * 60;
            default:
                return time * 60;
        }
    }
}
