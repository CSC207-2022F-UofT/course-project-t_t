package database;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
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
import java.util.List;
import java.util.stream.Collectors;

public class Database{

    public static void main(String[] args) {
        getDatabase();
    }

    private static final ArrayList<User> db = new ArrayList<User>();

    public static ArrayList<User> getDatabase() {
        try {
            String filename = "C:\\Users\\Clare\\Documents\\UofT\\Year 3 Sem 1\\CSC207\\New Project\\course-project-t_t\\src\\main\\java\\database\\UsersDataBase.json";
            // creates reader
            Reader reader = Files.newBufferedReader(Paths.get(filename));

            // read JSON from the file
            JsonArray objects = Jsoner.deserializeMany(reader);

            // create a Dozer mapper
            Mapper mapper = DozerBeanMapperBuilder.buildDefault();

            // convert JsonArray to ArrayList<User>
            JsonArray jsonArrayList = (JsonArray) objects.get(0);
            List<User> userList = jsonArrayList.stream()
                    .map(obj -> mapper.map(obj, User.class)).toList();
            ArrayList<User> userArrayList = new ArrayList<User>(userList);
            for (User u : userArrayList) {
                System.out.println(u);
            }
            return db;
        } catch (Exception e) {
            System.out.println("Exception Caught!");
            e.printStackTrace();
        }
        return db;
    }
}