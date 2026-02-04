package jhn;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;





public class Weather {

    public Weather(){
        try {
            //Public API
            //https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m
            


            URL url = new URL("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m");
        
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //check if the connection is made (debugging)
            int responseCode = conn.getResponseCode();

             //200 = ok
            if(responseCode != 200){
                //throw an error
                throw new RuntimeException("HttpResponseCode: " + responseCode);

            }
            else{

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                
                while(scanner.hasNext()){
                    //just puts everything in one big line 
                    informationString.append(scanner.nextLine());
                }
                //close the scanner
                scanner.close();

                // Change 1: Parse as JSONObject, not JSONArray
                JSONParser parse = new JSONParser();
                JSONObject dataObject = (JSONObject) parse.parse(String.valueOf(informationString));

                // Change 2: Now you can access keys directly from dataObject
                System.out.println("Latitude: " + dataObject.get("latitude"));

                // hourly is nested so we are going to need multiple
                JSONObject hourly = (JSONObject) dataObject.get("hourly");
                JSONArray temperatures = (JSONArray) hourly.get("temperature_2m");

                System.out.println("First temperature: " + temperatures.get(2));
                System.out.println("done printing");
                

            }


            
        //not the best way to catch but it works!
        } catch (Exception e) {
           
            e.printStackTrace();
        }
    
        }
    
}
