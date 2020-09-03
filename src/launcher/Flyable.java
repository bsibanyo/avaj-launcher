package launcher;

import weather.*;

public interface Flyable
{
    public Coordinates getCoordinates();
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}
