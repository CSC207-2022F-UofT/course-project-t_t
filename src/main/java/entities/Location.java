package entities;

import java.util.ArrayList;

public class Location{
    String name;
    //ArrayList<Float> coordinates; long/lat for google maps api feature?

    public Location(String name){
        this.name = name;
    }

    public String getName(){ return this.name; }
}


