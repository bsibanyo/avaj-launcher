package weather;

//import launcher.Coordinates;
import launcher.*;
import java.util.*;
public class WeatherProvider
{
    private static WeatherProvider weatherProvider = null;
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider()
    {
        weatherProvider = this;
    }

    public static WeatherProvider getProvider()
    {
        if(weatherProvider == null)
        {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

//    public String getcurrentWeather(Coordinates coordinates)
//    {
//        int height = coordinates.getHeight();
//
////        If height exceeds 100
//        if(height > 100)
//        {
//            height = 100;
//        }
//
//        int average = (coordinates.getLatitude() + coordinates.getLongitude() + height) / 3;
//        String iWeather = "Out of Bound";
////"RAIN", "FOG", "SUN", "SNOW"
//        if(average > 75)
//        {
//            iWeather = weather[3];
//        }
//        else if(average > 0 && average <= 25)
//        {
//            iWeather = weather[2];
//        }
//        else if(average > 25 && average <= 50)
//        {
//            iWeather = weather[0];
//        }
//        else if(average > 50 && average <= 75)
//        {
//            iWeather = weather[1];
//        }
////        else
//        return iWeather;
//    }
    public String	getCurrentWeather(Coordinates coordinates) {
        Random rand = new Random();
        int rand_int = 0;
        rand_int = rand.nextInt(4);
        return (weather[rand_int]);
    }
}
