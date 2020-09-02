package launcher;

import launcher.*;

public class Aircraft
{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter = 1;

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextID();
    }

    private long nextID()
    {
        return idCounter++;
    }

//    ADD
    public Coordinates getCoordinates()
    {
        return this.coordinates;
    }
}
