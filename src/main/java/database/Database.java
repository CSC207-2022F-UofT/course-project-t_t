package database;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import entities.User;
import entities.Timetable;
import entities.Location;
import entities.FriendsList;
import entities.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.runtime.ObjectMethods;
import java.util.Iterator;

import java.lang.reflect.Type;

//import com.github.cliftonlabs.json_simple.JsonArray;
//import com.github.cliftonlabs.json_simple.Jsoner;
//import com.github.dozermapper.core.DozerBeanMapperBuilder;
//import com.github.dozermapper.core.Mapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Paths;
import java.nio.file.Files;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.parser.*;

public class Database{
    public static void main(String[] args) {
        getDatabase();
    }

    private static ArrayList<User> db = new ArrayList<>();

    public static ArrayList<User> getDatabase() {
        JSONParser jsonParser = new JSONParser();
        try {
            String filename = "src/main/java/database/UsersDataBase.json";

            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(filename));
//
//            // creates reader
//            Reader reader = Files.newBufferedReader(Paths.get(filename));
//
//            // read JSON from the file
//            JSONArray objects = Jsoner.deserializeMany(reader);
//
//            // create a Dozer mapper
//            Mapper mapper = DozerBeanMapperBuilder.buildDefault();
//
//            // convert JsonArray to List<User>
//            JsonArray jsonArrayList = (JsonArray) objects.get(0);
//            Object j = jsonArrayList.getJSONObject();
//            System.out.println(jsonArrayList);
//            System.out.printf("U----:%s\n", j);
//            List<User> userList = jsonArrayList.stream()
//                    .map(obj -> mapper.map(obj, User.class)).toList();
//
//            // convert List<User> to ArrayList<User>
//            ArrayList<User> userArrayList = new ArrayList<>(userList);
//
//            for (User u : userArrayList) {
//                System.out.println(u.toString());
//                System.out.println("\n");
//            }
//
//            db = userArrayList;
//            return db;
        } catch (Exception e) {
            System.out.println("Exception on getting database!");
            e.printStackTrace();
        }
        return db;
    }

    public static void setDataBase(ArrayList<User> users) {}


    public static void setDatabase(ArrayList<User> users){
        File directory = new File("./" + "src\\main\\java\\database\\UsersDataBase.json");
        JsonArray jsonArray = new JsonArray(users);

        try {
                FileWriter writer = new FileWriter(directory.getAbsolutePath(), true);
                writer.write(jsonArray.toJson());
                writer.flush();
                writer.close();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
    }
}