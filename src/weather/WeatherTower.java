package weather;

import launcher.Coordinates;

public class WeatherTower extends Tower
{
    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getcurrentWeather(coordinates);
    }

    public void changeWeather()
    {
        this.conditionsChanged();
    }
}
