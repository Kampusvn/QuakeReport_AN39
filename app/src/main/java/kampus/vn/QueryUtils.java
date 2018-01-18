package kampus.vn;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QueryUtils {
    //This is sample
    private static final String SAMPLE_JSON = "{\"type\":\"FeatureCollection\",\"metadata\":{\"generated\":1512042475000,\"url\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2017-11-25&endtime=2017-11-28&minmag=4.5&limit=10\",\"title\":\"USGS Earthquakes\",\"status\":200,\"api\":\"1.5.8\",\"limit\":10,\"offset\":1,\"count\":10},\"features\":[{\"type\":\"Feature\",\"properties\":{\"mag\":5,\"place\":\"136km S of Sigave, Wallis and Futuna\",\"time\":1511822781130,\"updated\":1511823969040,\"tz\":-720,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us2000bv6c\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us2000bv6c&format=geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":385,\"net\":\"us\",\"code\":\"2000bv6c\",\"ids\":\",us2000bv6c,\",\"sources\":\",us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":6.329,\"rms\":0.83,\"gap\":57,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 5.0 - 136km S of Sigave, Wallis and Futuna\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-178.1018,-15.536,399.02]},\"id\":\"us2000bv6c\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":5.3,\"place\":\"72km ESE of Whittier, Alaska\",\"time\":1511821110410,\"updated\":1512010738522,\"tz\":-540,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/ak17394411\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=ak17394411&format=geojson\",\"felt\":1022,\"cdi\":3.6,\"mmi\":4.66,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":1,\"sig\":792,\"net\":\"ak\",\"code\":\"17394411\",\"ids\":\",at00p03kmu,ak17394411,us2000bv5s,\",\"sources\":\",at,ak,us,\",\"types\":\",dyfi,geoserve,impact-link,losspager,moment-tensor,origin,phase-data,shakemap,\",\"nst\":null,\"dmin\":null,\"rms\":0.63,\"gap\":null,\"magType\":\"ml\",\"type\":\"earthquake\",\"title\":\"M 5.3 - 72km ESE of Whittier, Alaska\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-147.4192,60.5634,15.7]},\"id\":\"ak17394411\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":4.5,\"place\":\"16km S of San Mateo del Mar, Mexico\",\"time\":1511820207990,\"updated\":1511896986156,\"tz\":-360,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us2000bv5j\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us2000bv5j&format=geojson\",\"felt\":1,\"cdi\":1,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":312,\"net\":\"us\",\"code\":\"2000bv5j\",\"ids\":\",us2000bv5j,\",\"sources\":\",us,\",\"types\":\",dyfi,geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":2.751,\"rms\":0.99,\"gap\":140,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.5 - 16km S of San Mateo del Mar, Mexico\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-94.9904,16.0532,63.74]},\"id\":\"us2000bv5j\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":4.8,\"place\":\"59km S of Ialibu, Papua New Guinea\",\"time\":1511818466140,\"updated\":1511819946040,\"tz\":600,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us2000bv54\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us2000bv54&format=geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":354,\"net\":\"us\",\"code\":\"2000bv54\",\"ids\":\",us2000bv54,\",\"sources\":\",us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":4.031,\"rms\":1.11,\"gap\":106,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.8 - 59km S of Ialibu, Papua New Guinea\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[144.0196,-6.8218,10]},\"id\":\"us2000bv54\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":4.8,\"place\":\"70km NNE of Putre, Chile\",\"time\":1511810372910,\"updated\":1511891223751,\"tz\":-240,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us2000bv2n\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us2000bv2n&format=geojson\",\"felt\":3,\"cdi\":3.1,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":355,\"net\":\"us\",\"code\":\"2000bv2n\",\"ids\":\",us2000bv2n,\",\"sources\":\",us,\",\"types\":\",dyfi,geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":0.116,\"rms\":1.3,\"gap\":48,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 4.8 - 70km NNE of Putre, Chile\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-69.3579,-17.5889,154.3]},\"id\":\"us2000bv2n\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":5.1,\"place\":\"129km S of Sigave, Wallis and Futuna\",\"time\":1511795713490,\"updated\":1511798341040,\"tz\":-720,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us2000buw8\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us2000buw8&format=geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":400,\"net\":\"us\",\"code\":\"2000buw8\",\"ids\":\",us2000buw8,\",\"sources\":\",us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":6.345,\"rms\":1.17,\"gap\":62,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 5.1 - 129km S of Sigave, Wallis and Futuna\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-178.1361,-15.4682,396.55]},\"id\":\"us2000buw8\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":4.8,\"place\":\"59km ENE of Tadine, New Caledonia\",\"time\":1511769263690,\"updated\":1511770198040,\"tz\":660,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us2000bus2\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us2000bus2&format=geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":354,\"net\":\"us\",\"code\":\"2000bus2\",\"ids\":\",us2000bus2,\",\"sources\":\",us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":0.385,\"rms\":1.13,\"gap\":108,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.8 - 59km ENE of Tadine, New Caledonia\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[168.4362,-21.4046,10]},\"id\":\"us2000bus2\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":6,\"place\":\"25km SE of Taron, Papua New Guinea\",\"time\":1511766672270,\"updated\":1511805808040,\"tz\":600,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us2000burc\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us2000burc&format=geojson\",\"felt\":3,\"cdi\":2.7,\"mmi\":4.38,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":1,\"sig\":555,\"net\":\"us\",\"code\":\"2000burc\",\"ids\":\",us2000burc,\",\"sources\":\",us,\",\"types\":\",dyfi,geoserve,losspager,moment-tensor,origin,phase-data,shakemap,\",\"nst\":null,\"dmin\":1.126,\"rms\":0.85,\"gap\":63,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 6.0 - 25km SE of Taron, Papua New Guinea\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[153.2105,-4.6187,57.77]},\"id\":\"us2000burc\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":4.6,\"place\":\"70km S of Yunaska Island, Alaska\",\"time\":1511753628430,\"updated\":1511803849599,\"tz\":-660,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us2000buq4\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us2000buq4&format=geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":326,\"net\":\"us\",\"code\":\"2000buq4\",\"ids\":\",ak17392501,us2000buq4,\",\"sources\":\",ak,us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":2.243,\"rms\":1.08,\"gap\":175,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.6 - 70km S of Yunaska Island, Alaska\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-170.5739,52.005,37.63]},\"id\":\"us2000buq4\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":4.7,\"place\":\"Kuril Islands\",\"time\":1511746854230,\"updated\":1511750499040,\"tz\":600,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us2000bupp\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us2000bupp&format=geojson\",\"felt\":null,\"cdi\":null,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":0,\"sig\":340,\"net\":\"us\",\"code\":\"2000bupp\",\"ids\":\",us2000bupp,\",\"sources\":\",us,\",\"types\":\",geoserve,origin,phase-data,\",\"nst\":null,\"dmin\":6.94,\"rms\":0.71,\"gap\":135,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 4.7 - Kuril Islands\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[152.7322,46.954,66.46]},\"id\":\"us2000bupp\"}],\"bbox\":[-178.1361,-21.4046,10,168.4362,60.5634,399.02]}";


    public static ArrayList<EarthQuake> extractEarthquakes() {
        ArrayList<EarthQuake> earthQuakes = new ArrayList<>();

        //Create JSON Object
        try {
            JSONObject rootJson = new JSONObject(SAMPLE_JSON);
            JSONArray jsonArray = rootJson.getJSONArray("features");

            for (int i = 0; i < jsonArray.length(); i ++){
                JSONObject childJson = jsonArray.getJSONObject(i);
                JSONObject properties = childJson.getJSONObject("properties");

                double mag = properties.getDouble("mag");
                String place = properties.getString("place");
                long time = properties.getLong("time");
                //Extract value for key url
                String url = properties.getString("url");

                EarthQuake earthQuake = new EarthQuake(mag, place, time, url);
                earthQuakes.add(earthQuake);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return earthQuakes;
    }


}
