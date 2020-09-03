package weather;
//import launcher.Flyable;
import launcher.*;
import java.util.*;

public abstract class Tower
{
    private ArrayList<Flyable> observers = new ArrayList<>();
    private ArrayList<Flyable> landed = new ArrayList<>();

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

//    protected void conditionsChanged()
//    {
////        Position
//        int pos = 0;
//        while(pos < observers.size())
//        {
//            observers.get(pos).updateConditions();
//            pos++;
//        }
//    }
    protected void	conditionsChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
            if(flyable.getCoordinates().getHeight() <= 0)
                landed.add(flyable);
        }
        observers.removeAll(landed);
    }
}
