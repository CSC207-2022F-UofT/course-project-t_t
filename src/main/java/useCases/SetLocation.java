package useCases;
import entities.User;
import entities.Location;
import entities.Timetable;
import entities.Section;
import entities.Interval;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.time.LocalDateTime;
//public class SetLocation{
//    public void manualSetLocation(Student student, Location location){
//        student.setLocation(location);
//    }
//
//    public void automaticSetLocation(Student student){
//        LocalDateTime now = LocalDateTime.now().minusHours(5);
//        int now_m = 24 * 60 * (now.getDayOfWeek().getValue() - 1) + 60 * now.getHour() + now.getMinute();
//        Timetable tt = student.getTimetable();
//        ArrayList<Section> sections = tt.getSections();
//
//        for(int i = 0; i < sections.size(); i++){
//            Interval interval = sections.get(i).intervals();
//        }
//    }
//}

