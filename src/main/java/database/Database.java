package database;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import entities.User;
import entities.Timetable;
import entities.Location;
import entities.FriendsList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import java.nio.file.Paths;
import java.nio.file.Files;

import java.io.*;

import java.util.ArrayList;

public class Database{

//    public static void main(String[] args) {
//        Database db = new Database();
//        db.getDatabase();
//    }

    private static final ArrayList<User> db = new ArrayList<User>();

    public void getDatabase() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("UsersDataBase.json"));
            JsonObject jsonObject = (JsonObject) Jsoner.deserialize(reader);
            Mapper mapper = DozerBeanMapperBuilder.buildDefault();
            User user = mapper.map(jsonObject, User.class);
            System.out.println(user);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}