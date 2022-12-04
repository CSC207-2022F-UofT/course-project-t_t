
package entities;

import java.util.ArrayList;

public class Timetable {

    ArrayList<Course> courses;

    public Timetable() {
        this.courses = new ArrayList<Course>();
    }

    public Timetable(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Course> getCourses() { return this.courses; }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (Course course : courses) {
            str.append(course.toString()).append("\n");
        }
        return str.toString();
    }

    public Course getCourse(String courseCode2) {
        ArrayList<Course> courseList = this.getCourses();
        for (Course course : courseList) {
            if (course.getCourseCode().equals(courseCode2)) {
                return course;
            }
        }
        return null;
    }

    public void addCourse(String courseCode1, String sectionCode1, Interval interval1, Location location1) {
        Lecture lecture1 = new Lecture(interval1, location1);
        ArrayList<Lecture> lectures1 = new ArrayList<>();
        lectures1.add(lecture1);
        Course course = new Course(courseCode1, sectionCode1, lectures1);

        for (Course c : this.getCourses()) {
            if (courseCode1.equals(c.getCourseCode())) {
                c.lectures.add(lecture1);
            }
        }

        if (!this.getCourses().contains(this.getCourse(courseCode1))) {
            this.getCourses().add(course);
        }
    }

    public void removeCourse(String courseCode) {
        Course removedCourse = this.getCourse(courseCode);
        this.getCourses().remove(removedCourse);
    }

}

