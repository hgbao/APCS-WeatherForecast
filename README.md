# WeatherForecast

A simple android application for weather forcast

## Technology

### Check for network state

Check the network state of the device, to announce user if there is no network connection.

### Custom toolbar with navigation drawer

The toolbar appears in main activity is a custom toolbar, with navigation drawer layout for accessibility to other activies.
The toolbar also has the refresh button to refresh the current view.

```
android.support.v7.widget.Toolbar
android.support.v4.widget.DrawerLayout
```

### Fragment for different views

The main activity has only a toolbar with a fragment container, displaying Current Weather (has weather information for tomorrow) and Weekly Weather. Fragment view changes whenever the user choose another item in navigation menu.

* Fragment also refresh if user clicks on refresh button on toolbar.

### RecyclerView for weather information weekly

Weekly weather list is a custom list of RecyclerView, each item in the list is an customized layout object to display weather information of a specific weekday.

```
RecyclerAdapterWeather.java - the main RecyclerView adapter file
row_weather.xml - customized layout for an item
```

### AsyncTask for API request (OpenWeatherMap)

Using AsyncTask with GET request from OpenWeatherMap with a ProgressDialog, update the view after the result is found.
* Task for the current weather
* Task for hourly weather
* Task for daily weather
```
FetchCurrentWeatherTask - Current weather information
FetchTommorrowWeatherTask - Get hourly weather information, then find out the first weather data of the next day
FetchWeeklyWeatherTask - Get daily weather information
```

### Parse data using JSON

The responding data from OpenWeatherMap will be converted into an object model **Weather**, the model can be parsed from different result of API requesting.

```
parseFromCurrent - Parse the data due from current weather API
parseFromHourly - Parse the data due from houlry weather API
parseFromDaily - Parse the data due from weekly weather API
```

### SharedPreferences for city chosen

The chosen city will be stored in SharedPreferences file of the application, for every activity can access to the data whenever they need.

```
LocationPreference.java - File for getting and setting the city data in SharedPreferences
```

## Screenshot

Screenshots for each activity of the project

### Current

![current](https://user-images.githubusercontent.com/15858532/28532917-81de58d2-70c5-11e7-843d-c8e1a7d77b85.png)

### Weekly

![weekly](https://user-images.githubusercontent.com/15858532/28532918-81e5e4da-70c5-11e7-8b9e-2565e733c00b.png)

### Setting

![setting](https://user-images.githubusercontent.com/15858532/28532916-81a44e12-70c5-11e7-8982-8edfac00f31a.png)

### Location

![location](https://user-images.githubusercontent.com/15858532/28530823-349a00e0-70bf-11e7-912f-023cdb4b30e6.png)

### Navigation

![navigation](https://user-images.githubusercontent.com/15858532/28531066-dd073fd6-70bf-11e7-81af-e8cdb69fdc43.png)

## Built With

* [Android Studio](https://developer.android.com/studio/intro/index.html)

## Authors

* **Bao Huynh** [hgbao](https://github.com/hgbao)

## Acknowledgments

* Layout weather information inspiration from [forcastie](https://github.com/martykan/forecastie)
* API for weather information powered by [OpenWeatherMap](http://openweathermap.org/api)
