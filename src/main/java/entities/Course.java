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

    public String getCourseCode() {
        return courseCode;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public ArrayList<Lecture> getLectures(){
        return this.lectures;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("%s-%s:\n", courseCode, sectionCode));
        for (Lecture lecture : lectures) {
            str.append(String.format("    %s\n", lecture.toString()));
        }
        return str.toString();
    }
}
