package entities;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class Location implements Jsonable {
    String name;
    //ArrayList<Float> coordinates; long/lat for google maps api feature?

    public Location(String name){
        this.name = name;
    }

    public String getName(){ return this.name; }

    @Override
    public String toJson() {
        JsonObject json = new JsonObject();
        json.put("location", this.name);
        return json.toJson();
    }

    @Override
    public void toJson(Writer writable) throws IOException {
        try {
            writable.write(this.toJson());
        } catch (Exception ignored) {

        }
    }

}


