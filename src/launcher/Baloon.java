package launcher;

import weather.*;
//import weather.WriteToFile;

public class Baloon extends Aircraft
{
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String theWeather = this.weatherTower.getWeather(this.coordinates);

        if(theWeather.equalsIgnoreCase("RAIN"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()  - 5);
            WriteToFile.getWriteToFile().writeFile("Baloon#" + this.name + "(" + this.id + "): I love a rainy night");
        }
        else if(theWeather.equalsIgnoreCase("FOG"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()  - 3);
            WriteToFile.getWriteToFile().writeFile("Baloon#" + this.name + "(" + this.id + "): Foggy");
        }
        else if(theWeather.equalsIgnoreCase("SUN"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
            WriteToFile.getWriteToFile().writeFile("Baloon#" + this.name + "(" + this.id + "): Summer Time");
        }
        else if(theWeather.equalsIgnoreCase("SNOW"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
            WriteToFile.getWriteToFile().writeFile("Baloon#" + this.name + "(" + this.id + "): Snowy");
        }
    }
}
