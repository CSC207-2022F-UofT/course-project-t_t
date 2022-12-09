package entities;

/**
 * The interval entity which represents the time lectures are held.
 */
public class Interval{
    int start;
    int end;
    public Interval(int start, int end){
        assert start < end;

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
    public String toString() {
        return String.format("[%s, %s)", this.start, this.end);
    }
}
