package ve.com.leonardocabeza.sunshine;

/**
 * Created by Leonardo on 21/11/2014.
 */

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataParser {
    private static final String LOG_TAG = WeatherDataParser.class.getSimpleName();
    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        try {
            JSONObject jsonObject = new JSONObject(weatherJsonStr);
            JSONArray jsonArray = jsonObject.getJSONArray("list");

            JSONObject element = jsonArray.getJSONObject(dayIndex);
            JSONObject tempData = element.getJSONObject("temp");

            return tempData.getDouble("max");
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
        }

        return -1;
    }

}
