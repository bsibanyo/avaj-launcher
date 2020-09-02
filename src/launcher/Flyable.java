package launcher;

import weather.WeatherTower;

public interface Flyable
{
    void updateConditions();
    void registerTower(WeatherTower weatherTower);

   void add(Flyable flyable);
}
