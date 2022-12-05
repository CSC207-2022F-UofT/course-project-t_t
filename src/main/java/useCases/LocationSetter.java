package useCases;
import entities.User;
import entities.Location;
import entities.Timetable;
import entities.Course;
import entities.Lecture;

import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * Class which handles the setting of user locations.
 */
public class LocationSetter {
    /**
     * A method which sets the user's location to location.
     * @param user A User.
     * @param location A Location.
     */
    public static void manualSetLocation(User user, Location location){
        user.setLocation(location);
    }

    /**
     * A method which checks
     * @param user A User.
     */
    public static void automaticSetLocation(User user){
        LocalDateTime now = LocalDateTime.now().minusHours(5);
        int now_m = 24 * 60 * (now.getDayOfWeek().getValue() - 1) + 60 * now.getHour() + now.getMinute();
        Timetable tt = user.getTimetable();
        ArrayList<Course> courses = tt.getCourses();

        for(int i = 0; i < courses.size(); i++){
            ArrayList<Lecture> lectures = courses.get(i).getLectures();
            for(int j = 0; j < lectures.size(); j++){
                int start = lectures.get(j).getInterval().getStart();
                int end = lectures.get(j).getInterval().getEnd();
                if(start <= now_m && now_m < end){
                    user.setLocation(lectures.get(j).getLocation());
                    return;
                }
            }
        }
        user.setLocation(new Location("Temporary placeholder"));
    }
}

