package entities;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.Writer;

public class Interval implements Jsonable {
    int start;
    int end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int getStart(){
        return this.start;
    }
    public void setStart(int start){
        this.start = start;
    }

    public int getEnd(){
        return this.end;
    }

    public void setEnd(int end){
        this.end = end;
    }

    @Override
    public String toJson() {
        JsonObject json = new JsonObject();
        json.put("start", this.start);
        json.put("end", this.end);
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
