package database;

import entities.User;
import entities.Timetable;
import entities.Location;
import entities.

import java.io.*;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.text.html.parser.Parser;
import javax.xml.xpath.XPathEvaluationResult;
import java.util.ArrayList;

public class Database {
    private static ArrayList<User> db = new ArrayList<User>();

    public ArrayList<User> getDatabase() {
        JSONParser parser = new JSONParser();

        try{
            JSONArray a = (JSONArray) parser.parse(new FileReader("UserDataBase.json"));
            ArrayList<User> returnArrayList = new ArrayList<User>();
            for (Object o: a) {
                JSONObject user = (JSONObject) o;
                String username = (String) user.get("username");
                String password = (String) user.get("password");
                String email = (String) user.get("email");
                Location location = (Location) user.get("location");
                Timetable timetable = (Timetable) user.get("timetable");
                FriendsList friendsList = (FriendsList) user.get("FriendsList")

                User newUser = new User(username, password, email, location, timetable, friendsList, blockedList);
                returnArrayList.add(newUser);
            }
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

    }

    public void setDatabase(ArrayList<User> l) {

    }
}