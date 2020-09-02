package launcher;

import weather.WeatherTower;
import weather.WriteToFile;

public class Helicopter extends Aircraft
{
    private WeatherTower weatherTower =  new WeatherTower();

    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String theWeather = this.weatherTower.getWeather(this.coordinates);

        if(theWeather.equalsIgnoreCase("RAIN"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
            WriteToFile.getWriteToFile().writeFile("Helicopter#" + this.name + "(" + this.id + "): I love a rainy night");
        }
        else if(theWeather.equalsIgnoreCase("FOG"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
            WriteToFile.getWriteToFile().writeFile("Helicopter#" + this.name + "(" + this.id + "): Foggy");
        }
        else if(theWeather.equalsIgnoreCase("SUN"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
            WriteToFile.getWriteToFile().writeFile("Helicopter#" + this.name + "(" + this.id + "): Summer Time");
        }
        else if(theWeather.equalsIgnoreCase("SNOW"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
            WriteToFile.getWriteToFile().writeFile("Helicopter#" + this.name + "(" + this.id + "): Snowy");
        }
    }
}
