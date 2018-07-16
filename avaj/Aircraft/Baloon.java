package Aircraft;

import Fly.Flyable;
import Fly.WeatherTower;
import files.writing;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateCondition()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        if (weather.equals("RAIN"))
        {
            this.coordinates.setHeight(this.coordinates.getHeight() - 5);
            writing.WriteToFile("Baloon#" + this.name + "(" + this.id + ") : Bloody rain i just hate this weather gosh!! ");
        }
        else if (weather.equals("SNOW"))
        {
            this.coordinates.setHeight(this.coordinates.getHeight() - 15);
            writing.WriteToFile("Baloon#" + this.name + "(" + this.id + ") : I should stop watching games of throne because its that time of the year");
        }
        else if (weather.equals("SUN"))
        {
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
            this.coordinates.setHeight(this.coordinates.getHeight() + 4);
            writing.WriteToFile("Baloon#" + this.name + "(" + this.id + ") : Summer time babe anyone want to go for a swim");
        }
        else if (weather.equals("FOG"))
        {
            this.coordinates.setHeight(this.coordinates.getHeight() - 3);
            writing.WriteToFile("Baloon#" + this.name  + "(" + this.id + ") : Every time when weather is like this i always think about dead people");
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        else if (this.coordinates.getHeight() <= 0)
        {
            this.weatherTower.unregister(this);
            writing.WriteToFile("Baloon#" + this.name + "(" + this.id + ")  landing");
            writing.WriteToFile("Tower says: " + "Baloon#" + this.name + "("+this.id+")" + " unregistered from weather tower");
        }



        }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        writing.WriteToFile("Tower says: " + "Baloon"+ this.name +"#" + "("+ this.id+")" + " registered to weather tower");
    }

}
