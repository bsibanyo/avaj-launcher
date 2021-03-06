package launcher;

import launcher.*;

public class Aircraft
{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
        this.idCounter = nextID();
        this.id = this.idCounter;
    }

    private long nextID()
    {
        return (++idCounter);
    }

//    ADD
    public Coordinates getCoordinates()
    {
        return this.coordinates;
    }
}
