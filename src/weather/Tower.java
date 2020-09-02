package weather;
import launcher.Flyable;

import java.util.*;

public abstract class Tower
{
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable)
    {
        if(!observers.contains(flyable))
        {
            this.observers.add(flyable);
        }
    }

    public void unregister(Flyable flyable)
    {
        this.observers.remove(flyable);
    }

    protected void conditionsChanged()
    {
//        Position
        int pos = 0;
        while(pos < observers.size())
        {
            observers.get(pos).updateConditions();
            pos++;
        }
    }
}
