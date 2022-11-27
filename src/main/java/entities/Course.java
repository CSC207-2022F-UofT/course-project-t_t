package entities;
import java.util.ArrayList;

public class Course {
    String courseCode;
    String sectionCode;
    ArrayList<Lecture> lectures;

    public Course(String courseCode, String sectionCode, ArrayList<Lecture> lectures){
        this.courseCode = courseCode;
        this.sectionCode = sectionCode;
        this.lectures = lectures;
    }

    public ArrayList<Lecture> getLectures(){
        return this.lectures;
    }
}
