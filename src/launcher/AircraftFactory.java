package launcher;

import launcher.*;
import java.io.*;
//import weather.*;

public class AircraftFactory
{
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        String str = type.toLowerCase();
        if(str.equals("Helicopter"))
        {
            return (Flyable) new Helicopter(name, coordinates);
        }
        else if(str.equals("JetPlane"))
        {
            return (Flyable) new JetPlane(name, coordinates);
        }
        else if(str.equals("Baloon"))
        {
            return (Flyable) new Baloon(name, coordinates);
        }
        else
        {
            System.out.println("Unknown Type: " + type);
            return null;
        }

    }
}
