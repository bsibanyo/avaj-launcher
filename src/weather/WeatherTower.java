package weather;

//import launcher.Coordinates;
import launcher.*;

public class WeatherTower extends Tower
{
    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather()
    {
        this.conditionsChanged();
    }
}
