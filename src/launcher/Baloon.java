package launcher;

import weather.*;
import launcher.*;
//import weather.WriteToFile;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                if (this.coordinates.getHeight() > 100)
                    this.coordinates.setLongitude(100);
                WriteToFile.getWriteToFile().writeFile("Baloon#" + this.name + "(" + this.id + "): GOOD MORNING MZANSI");
                break;
            case "RAIN":
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                WriteToFile.getWriteToFile().writeFile("Baloon#" + this.name + "(" + this.id + "): ATLEAST THE GAS CAN KEEP US WARM");
                break;
            case "FOG":
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                WriteToFile.getWriteToFile().writeFile("Baloon#" + this.name + "(" + this.id + "): WE JUST FLOATING AWAY!!!");
                break;
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                WriteToFile.getWriteToFile().writeFile("Baloon#" + this.name + "(" + this.id + "): MY ASS IS FREEZING FROM HERE!");
                WriteToFile.getWriteToFile().writeFile("Tower  says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
                break;
            default:
                WriteToFile.getWriteToFile().writeFile("Baloon#" + this.name + "(" + this.id + "): NETWORK IS BAD I CAN'T CONTACT THE TOWER");
                break;
        }
        if (this.coordinates.getHeight() <= 0)
        {
            WriteToFile.getWriteToFile().writeFile("Baloon#" + this.name + "(" + this.id + ") landing.");
        }
    }
    public	void	registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        WriteToFile.getWriteToFile().writeFile("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        weatherTower.register(this);
    }
}

