# Rise and Shine ☀️

A feature-rich Java weather application that displays current and forecasted weather data with an elegant, interactive interface.

## Features

### 🌤️ Weather Display
- **Current Weather**: View real-time weather conditions for your location
- **Hourly Forecasts**: 24-hour breakdown with detailed statistics
- **Multi-day Forecasts**: View weather up to 10 days ahead
- **Historical Data**: Access weather data from the past 61 days
- **Date Picker**: Interactive calendar popup to select specific dates

### 📊 Customizable Statistics
Configure which weather metrics to display:
- Temperature & Apparent Temperature
- Humidity & Dew Point
- Precipitation, Rain & Showers
- Snowfall
- Pressure (MSL & Surface)
- Cloud Cover
- Wind Speed
- Soil Temperature & Moisture

### ⚙️ Settings & Customization
- **Temperature Units**: Toggle between Celsius and Fahrenheit
- **Location Controls**: Adjust latitude and longitude manually or use current location
- **Stat Configuration**: Enable/disable specific weather metrics
- **Dynamic Backgrounds**: Seasonal backgrounds based on average temperature

### 🎵 Audio Experience
- Background music support with looping playback
- Integrated audio controls

## Technologies Used

- **Language**: Java
- **GUI Framework**: Swing
- **API**: [Open-Meteo Weather API](https://open-meteo.com/)
- **Geolocation**: IP-API for automatic location detection
- **Data Format**: JSON (using org.json.simple)

## Project Structure

```
weatherapp1/
├── src/main/java/jhn/
│   ├── WeatherApp.java           # Main application entry point
│   ├── Menu.java                 # Main menu interface
│   ├── Weather.java              # Weather data handler & API calls
│   ├── DisplayWeather.java       # Hourly weather display panel
│   ├── DisplayStats.java         # Detailed statistics view
│   ├── ConfigureStats.java       # Statistics configuration panel
│   ├── settings.java             # Settings panel
│   ├── JsonHandler.java          # JSON file management
│   ├── CurrentTime.java          # Time formatting utilities
│   ├── CustomCalendarPopup.java  # Interactive date picker
│   ├── BackgroundHandler.java    # Dynamic background selection
│   ├── SongHandler.java          # Audio playback management
│   ├── location/
│   │   ├── CurrentLocation.java  # Geolocation via IP
│   │   └── GetIP.java            # IP address retrieval
│   └── resources/
│       ├── summerBackground.gif
│       ├── springBackground.gif
│       ├── winterBackground.gif
│       ├── settingsLogo.png
│       └── KCDII.wav
└── settings.json                 # User preferences storage
```

## Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven (optional, for dependency management)
- Internet connection for API calls

### Dependencies
Add to your `pom.xml`:
```xml
<dependency>
    <groupId>com.googlecode.json-simple</groupId>
    <artifactId>json-simple</artifactId>
    <version>1.1.1</version>
</dependency>
```

### Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/rise-and-shine.git
   cd rise-and-shine
   ```

2. Ensure the `settings.json` file is in the correct path:
   ```
   weatherapp1/src/main/java/jhn/settings.json
   ```

3. Compile and run:
   ```bash
   javac -cp ".:json-simple-1.1.1.jar" weatherapp1/src/main/java/jhn/*.java
   java -cp ".:json-simple-1.1.1.jar" jhn.WeatherApp
   ```

   Or with Maven:
   ```bash
   mvn clean compile
   mvn exec:java -Dexec.mainClass="jhn.WeatherApp"
   ```

## Configuration

The `settings.json` file stores user preferences:

```json
{
  "latitude": 45.2496,
  "longitude": -75.9181,
  "celcius": true,
  "humidity": true,
  "dewPoint": true,
  "apparentTemp": true,
  "precipitation": true,
  "rain": true,
  "showers": true,
  "PressureMSL": true,
  "surfacePressure": true,
  "cloudCover": true,
  "windSpeed": true,
  "soilTemp": false,
  "soilMoisture": false
}
```

## Usage

### Main Menu
- **Today's Weather**: View current day's hourly forecast
- **Tomorrow's Weather**: View next day's forecast
- **Pick a Date**: Open calendar to select any available date
- **Settings**: Configure temperature units and visible statistics
- **Exit**: Close the application

### Navigating Weather Display
- Click any hour to view detailed statistics
- Yellow border indicates current hour
- Click "Menu" to return to main menu

### Settings Panel
- Toggle Celsius/Fahrenheit
- Adjust location coordinates
- Configure which statistics to display
- Click "Go Back" to return to main menu

## API Information

This application uses the [Open-Meteo API](https://open-meteo.com/) with the following configuration:
- Model: GEM Regional
- Timezone: America/New_York
- Past Days: 61
- Forecast Days: 10

## Features in Detail

### Dynamic Backgrounds
Backgrounds change based on average daily temperature:
- **Summer** (≥10°C): Summer background
- **Spring** (0-9°C): Spring background
- **Winter** (<0°C): Winter background

### Location Detection
Automatic location detection using:
1. IP address retrieval (ipify.org)
2. Geolocation via IP-API
3. Manual override available in settings

### Interactive Calendar
- Navigate months with arrow buttons
- Dates with available data shown in black
- Unavailable dates shown in gray
- Click date to view weather

## Known Issues

- Hardcoded file paths may need adjustment for different systems
- Application runs in fullscreen mode by default
- Windows-specific path separators (`\\`) in some file paths

## Future Enhancements

- [ ] Add weather alerts and warnings
- [ ] Implement location search by city name
- [ ] Add weather charts and graphs
- [ ] Support for multiple saved locations
- [ ] Export weather data to CSV/PDF
- [ ] Dark mode theme
- [ ] Configurable audio tracks
- [ ] Multi-language support

## Contributing

Contributions are welcome! Please follow these steps:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Weather data provided by [Open-Meteo](https://open-meteo.com/)
- Geolocation services by [IP-API](http://ip-api.com/)
- IP address detection via [ipify](https://www.ipify.org/)
