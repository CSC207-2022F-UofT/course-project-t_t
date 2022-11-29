package database;

import entities.User;
import entities.Timetable;
import entities.Location;
import entities.FriendsList;

import java.io.*;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.text.html.parser.Parser;
import javax.xml.xpath.XPathEvaluationResult;

import java.util.ArrayList;
import java.util.Objects;

public class Database {

    public static void main(String[] args) {

    }

    private static final ArrayList<User> db = new ArrayList<User>();

    public ArrayList<User> getDatabase() {
        JSONParser parser = new JSONParser();
        ArrayList<User> returnArrayList = new ArrayList<User>();
        try{
            JSONArray a = (JSONArray) parser.parse(new FileReader("UserDataBase.json"));
            for (Object o: a) {
                JSONObject user = (JSONObject) o;
                String username = (String) user.get("username");
                String password = (String) user.get("password");
                String email = (String) user.get("email");
                Location location = (Location) user.get("location");
                Timetable timetable = (Timetable) user.get("timetable");
                FriendsList friendsList = (FriendsList) (user.get("FriendsList"));
                User newUser = new User(username, password, email, location, timetable, friendsList);
                returnArrayList.add(newUser);
            }
            return returnArrayList;
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException");
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("IOException");
        } catch(ParseException e) {
            e.printStackTrace();
            System.out.println("ParseException");
        }
        return returnArrayList;
    }
}