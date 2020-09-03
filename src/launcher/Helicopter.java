package launcher;

import weather.*;
//import weather.WriteToFile;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                if (this.coordinates.getHeight() > 100)
                    this.coordinates.setHeight(100);
                WriteToFile.getWriteToFile().writeFile("Helicopter#" + this.name + "(" + this.id + "): OH WAIT I CAN SEE MY HOUSE FROM HERE!");
                break;
            case "RAIN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                WriteToFile.getWriteToFile().writeFile("Helicopter#" + this.name + "(" + this.id + "): I LOVE A RAINY NIGHT");
                break;
            case "FOG":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                WriteToFile.getWriteToFile().writeFile("Helicopter#" + this.name + "(" + this.id + "): SHUCKS! LET'S HOPE WE DON'T CRASH INTO A BUILDING");
                break;
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                WriteToFile.getWriteToFile().writeFile("Helicopter#" + this.name + "(" + this.id + "): I'M SOO COLD - OMARION");
                break;
            default:
                WriteToFile.getWriteToFile().writeFile("Helicopter#" + this.name + "(" + this.id + "): NETWORK IS BAD I CAN'T CONTACT THE TOWER");
                break;
        }
        if (this.coordinates.getHeight() <= 0)
        {
            WriteToFile.getWriteToFile().writeFile("Helicopter#" + this.name + "(" + this.id + ") landing.");
            WriteToFile.getWriteToFile().writeFile("Tower  says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    public	void	registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        WriteToFile.getWriteToFile().writeFile("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        weatherTower.register(this);
    }
}
