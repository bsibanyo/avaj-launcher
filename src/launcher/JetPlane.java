package launcher;

import weather.*;

public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                if (this.coordinates.getHeight() > 100)
                    this.coordinates.setHeight(100);
                WriteToFile.getWriteToFile().writeFile("JetPlane#" + this.name + "(" + this.id + "): IT'S A SUNNY DAY AND EVERYBODY IS FEELING OKAY!");
                break;
            case "RAIN":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                WriteToFile.getWriteToFile().writeFile("JetPlane#" + this.name + "(" + this.id + "): NO WIPERS AT THIS SPEED");
                break;
            case "FOG":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                WriteToFile.getWriteToFile().writeFile("JetPlane#" + this.name + "(" + this.id + "): I SHOULD HAVE BOUGHT A CAR, ATLEAST IT HAS AN AIRCON");
                break;
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                WriteToFile.getWriteToFile().writeFile("JetPlane#" + this.name + "(" + this.id + "): I THINK I CAN SEE THE WHITE WALKERS");
                break;
            default:
                WriteToFile.getWriteToFile().writeFile("JetPlane#" + this.name + "(" + this.id + "): NETWORK IS BAD I CAN'T CONTACT THE TOWER");
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            WriteToFile.getWriteToFile().writeFile("JetPlane#" + this.name + "(" + this.id + ") landing.");
            WriteToFile.getWriteToFile().writeFile("Tower  says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    public	void	registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        WriteToFile.getWriteToFile().writeFile("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.weatherTower.register(this);
    }
}
