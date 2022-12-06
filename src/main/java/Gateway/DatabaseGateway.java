package Gateway;
import com.google.gson.GsonBuilder;
import entities.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.google.gson.Gson;

public class DatabaseGateway {
    public static void main(String[] args) {
        setDatabase(getDatabase());
        System.out.println(db);
    }
    private static ArrayList<User> db = new ArrayList<>();
    //@SuppressWarnings is used because json.simple has not updated since generics
    //were added to java. This is an issue with json.simple, not us.
    @SuppressWarnings("unchecked")
    public static void setDatabase(ArrayList<User> users){
        try (Writer writer = new FileWriter("src/main/java/UsersDataBase.json")) {
            JSONArray jsonArray = new JSONArray();
            for (User user : users) {

                JSONObject juser = new JSONObject();
                juser.put("username", user.getUsername());
                juser.put("password", user.getPassword());

                // Friendslist JSONobject
                ArrayList<String> friends = new ArrayList<>();
                ArrayList<String> blocked = new ArrayList<>();

                //Adding friends & blocked to <friends> and <blocked>
                for (User f : user.getFriends()) {
                    friends.add(f.getUsername());
                }
                for (User b : user.getBlocked()) {
                    blocked.add(b.getUsername());
                }

                juser.put("friendsList", friends);
                juser.put("blockedList", blocked);
                juser.put("location", user.getLocation().getName());


                JSONArray timetable = new JSONArray();
                //loop through  user timetable
                for (Course c : user.getTimetable().getCourses()) {
                    JSONObject course = new JSONObject();
                    course.put("courseCode", c.getCourseCode());
                    course.put("section", c.getSectionCode());

                    JSONArray lectures = new JSONArray();
                    for (Lecture l : c.getLectures()) {
                        JSONObject lecture = new JSONObject();
                        lecture.put("start", l.getInterval().getStart());
                        lecture.put("end", l.getInterval().getEnd());
                        lecture.put("location", l.getLocation().getName());
                        lectures.add(lecture);
                    }
                    course.put("lectures", lectures);
                    timetable.add(course);
                }
                juser.put("timetable", timetable);
                jsonArray.add(juser);
            }
            db = jsonArray;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            writer.write(jsonArray.toString());
            writer.write(gson.toJson(jsonArray));
            writer.flush();
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public static ArrayList<User> getDatabase() {
        JSONParser parser = new JSONParser();

        ArrayList<User> returnUsers = new ArrayList<>();
        try (Reader reader = new FileReader("src/main/java/UsersDataBase.json")) {

            JSONArray listOfUsers = (JSONArray) parser.parse(reader);

            for (Object o: listOfUsers) {
                JSONObject user = (JSONObject) o;

                // string information
                String username = (String) user.get("username");
                String password = (String) user.get("password");

                //location information
                Location location = new Location((String) user.get("location"));

                // empty friendsList
                ArrayList<User> friends = new ArrayList<>();
                ArrayList<User> blocked = new ArrayList<>();

                // timetable Object
                ArrayList<Course> courses = new ArrayList<>();
                JSONArray timetableArray = (JSONArray) user.get("timetable");
                for (Object course : timetableArray) {
                    JSONObject courseObject = (JSONObject) course;

                    // courseCode
                    String courseCode = (String) courseObject.get("courseCode");
                    // sectionCode
                    String sectionCode = (String) courseObject.get("section");
                    // lecture
                    ArrayList<Lecture> lectures = new ArrayList<>();
                    JSONArray lectureArray = (JSONArray) courseObject.get("lectures");
                    for (Object lectureObject: lectureArray) {
                        JSONObject lecture = (JSONObject) lectureObject;

                        // location
                        Location locationOfLecture = new Location((String) lecture.get("location"));

                        // interval
                        int s = ((Long) lecture.get("start")).intValue();
                        int e = ((Long) lecture.get("end")).intValue();
                        Interval interval = new Interval(s, e);

                        Lecture newLecture = new Lecture(interval, locationOfLecture);
                        lectures.add(newLecture);
                    }
                    Course newCourse = new Course(courseCode, sectionCode, lectures);
                    courses.add(newCourse);
                }
                Timetable timetable = new Timetable(courses);
                User newUser = new User(username, password, friends, blocked, location, timetable);
                returnUsers.add(newUser);
            }

            // add blocked
            for (Object m: listOfUsers) {
                User currUser = new User();
                User targetUser = new User();

                JSONObject blockedListObject = (JSONObject) m;

//                JSONObject friendsList = (JSONObject) blockedListObject.get("friendsList");

                // find current User
                for (User curr: returnUsers) {
                    if (curr.getUsername() == blockedListObject.get("username")) {
                        currUser = curr;
                    }
                }

                // add blocked users
//                JSONArray blockedArray = (JSONArray) friendsList.get("blockedList");
                JSONArray blockedArray = (JSONArray) blockedListObject.get("blockedList");
                for (Object value : blockedArray) {
                    String targetUserName = (String) value;

                    // find User class of target
                    for (User us : returnUsers) {
                        if (Objects.equals(us.getUsername(), targetUserName)) {
                            targetUser = us;
                        }
                    }
                    currUser.addBlocked(targetUser);
                }
            }

            // add friends
            for (Object m: listOfUsers) {
                User currUser = new User();
                User targetUser = new User();

                JSONObject friendsListObject = (JSONObject) m;

//                JSONObject friendsList = (JSONObject) friendsListObject.get("friendsList");

                // find current User
                for (User curr: returnUsers) {
                    if (curr.getUsername() == friendsListObject.get("username")) {
                        currUser = curr;
                    }
                }

                // add friends
                JSONArray friendsArray = (JSONArray) friendsListObject.get("friendsList");
                for (Object value : friendsArray) {
                    String targetUserName = (String) value;

                    // find User class of target
                    for (User us : returnUsers) {
                        if (Objects.equals(us.getUsername(), targetUserName)) {
                            targetUser = us;
                        }
                    }
                    currUser.addFriend(targetUser);
                }
            }
            db = returnUsers;
            return db;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return db;
    }









    public static void addUser(String username, String password, ArrayList<User> friends, ArrayList<User> blocked) {
        db.add(new User(username, password, friends, blocked));
    }
    public static User getUser(String username) {
        System.out.println(username);
        for (User user : db) {
            System.out.println(user);
            if (Objects.equals(user.getUsername(), username)) {
                return user;
            }
        }
        return null;
    }

    public static ArrayList<Timetable> getDummyTimetablesTemp() {
        ArrayList<Lecture> dummyLectures1 = new ArrayList<>();

        dummyLectures1.add(
                new Lecture(new Interval(2160, 2220), new Location("BA 2222"))
        );
        dummyLectures1.add(
                new Lecture(new Interval(6660, 6720), new Location("BA 2222"))
        );

        ArrayList<Lecture> dummyLectures2 = new ArrayList<>();

        dummyLectures2.add(
                new Lecture(new Interval(2160, 2220), new Location("BA 2222"))
        );
        dummyLectures2.add(
                new Lecture(new Interval(3720, 3840), new Location("BA 2222"))
        );


        ArrayList<Course> dummyCourses1 = new ArrayList<>();

        dummyCourses1.add(
                new Course("KIM101", "LEC 0101", dummyLectures1)
        );
        dummyCourses1.add(
                new Course("JJJ265", "LEC 0101", dummyLectures2)
        );

        ArrayList<Course> dummyCourses2 = new ArrayList<>();

        dummyCourses2.add(
                new Course("KIM101", "LEC 0101", dummyLectures1)
        );
        dummyCourses2.add(
                new Course("JJJ265", "LEC 0101", dummyLectures2)
        );

        Timetable dummyTimetable1 = new Timetable(dummyCourses1);
        Timetable dummyTimetable2 = new Timetable(dummyCourses2);

        ArrayList<Timetable> timetables = new ArrayList<>();
        timetables.add(dummyTimetable1);
        timetables.add(dummyTimetable2);

        return timetables;
    }

}