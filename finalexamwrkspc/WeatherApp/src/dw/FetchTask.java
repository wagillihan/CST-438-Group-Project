package dw;

import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import com.google.gson.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class FetchTask implements Callable<Void> {

    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String APPID = "&appid=4cdc90111e0528db2d929c9090ee6e3c";

    private ArrayList<String> cityList; 
    private JLabel label;
    private JTextField cityField;
    
    public FetchTask(JTextField cityField, JLabel  label ) {
        cityList = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(cityField.getText() , ",");
        while (st.hasMoreTokens()){
            String token = st.nextToken();
            cityList.add(token);
        }
        this.label = label;
        this.cityField = cityField;
    }

    public Void  call()  {
        WeatherJson[] cityWeathers = new WeatherJson[ cityList.size() ];
        int index = 0;
       
        try {
            for (String city : cityList) {
                //DEBUG Thread.sleep(5000);
                //DEBUG System.out.println("URL "+WEATHER_URL + URLEncoder.encode(city,"UTF-8") + APPID);
                URL url = new URL( WEATHER_URL + URLEncoder.encode(city,"UTF-8") + APPID);
                URLConnection con = url.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(
                            con.getInputStream()));

                String output = "";
                String line;
                while ( (line = in.readLine()) != null) 
                    output = output + line;
                in.close();
                //DEBUG System.out.println("FetchTask :"+output);

                Gson gson = new GsonBuilder().create();
                cityWeathers[index]  = gson.fromJson(output, WeatherJson.class);
                index++;
            }
            String t = formatWeather(cityWeathers);
            label.setText(t);
           
            
        } catch (Exception e){
            label.setText("FetchTask Exception: "+e.getMessage());
            
        } finally {
            cityField.setEnabled(true);
        }
        return null;
    }  

    private String formatWeather( WeatherJson[] w) {
        String r = "<html>";
        for (WeatherJson x: w) {
            r = r + "<h1>"+x.name+"</h1>  ";
            r = r + "  Current Condition :" + x.weather[0].description;
            int temp = (int) (kelvinToFahrenheit( x.main.temp)+0.5) ;
            r = r + " Current Temp :"+temp;
        }
        r = r+ "</html>";
        return r;
    }

    /**
     *  Convert temperature from Kelvin degrees to Fahrenheit degrees
     */
    private double kelvinToFahrenheit(double k) {
        return 1.8 * (k -273.15)  + 32.0; 
    }

}
