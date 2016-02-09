package com.example.veraj.aplicacionandroid;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OWCity extends AppCompatActivity {
    private EditText inputCity;
    private CardView cardview;
    OWCityClass owclima;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owcity);
        prepareUI();

    }

    private void prepareUI() {
        inputCity= (EditText) findViewById(R.id.input_city);
        cardview= (CardView) findViewById(R.id.cardview);
        /*LinearLayoutManager linLayManager = new LinearLayoutManager(this);
        cardview.setLayoutManager(linLayManager);
        recyclerCities.setHasFixedSize(true);*/

    }
    public void searchCities(View view) {
        String ciudadn = inputCity.getText().toString();
        if (!TextUtils.isEmpty(ciudadn)) {
            String url="http://api.openweathermap.org/data/2.5/weather?q="+ciudadn+"&appid=44db6a862fba0b067b1930da0d769e98";


            new LoadCityTask().execute(url);
        }

    }
    private class LoadCityTask extends AsyncTask<String, Long, String> {
        protected String doInBackground(String... urls) {
            try {

                return HttpRequest.get(urls[0]).accept("application/json")
                        .body();

            } catch (HttpRequest.HttpRequestException exception) {


                return null;
            }
        }
        protected void onPostExecute(String response) {

            OWCityClass busquedaciu= getCities(response);
            if(busquedaciu!=null){
                mostrarCity(busquedaciu);
            }
            else{
                Toast mensaje4 = Toast.makeText(getApplicationContext(),"ERROR: CITY NOT FOUND", Toast.LENGTH_SHORT);
                mensaje4.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0,80);
                mensaje4.show();
            }
        }
    }
    private OWCityClass getCities(String json) {
        /*String json2="{\"ResCiudades\":"+json+"}";

        Toast mensaje4 = Toast.makeText(getApplicationContext(),json2, Toast.LENGTH_SHORT);
        mensaje4.setGravity(Gravity.BOTTOM | Gravity.CENTER,0,0);
        mensaje4.show();*/
        Gson gson = new Gson();
        OWCityClass busqueda = gson.fromJson(json,OWCityClass.class);
        return busqueda;

    }
    private void mostrarCity(OWCityClass busquedaciu) {

        CardView cv1 = (CardView)findViewById(R.id.cardview);
        TextView tv1= (TextView)findViewById(R.id.citynameow);
        ImageView iv1= (ImageView)findViewById(R.id.imageow);
        TextView tv2= (TextView)findViewById(R.id.tempow);
        TextView tv3= (TextView)findViewById(R.id.detailsow);

        TextView tv4= (TextView)findViewById(R.id.tv4);

        tv2.setText("Temp: " + busquedaciu.getMain().getTemp().toString());
        tv3.setText("\" " + busquedaciu.getWeather().get(0).getDescription()+"\"");

        tv4.setText("Latitud " + busquedaciu.getCoord().getLat().toString() + " \n LOngitud " + busquedaciu.getCoord().getLon().toString());
        String urlimg="http://openweathermap.org/img/w/"+busquedaciu.getWeather().get(0).getIcon()+".png";
        Picasso.with(context).load(urlimg).into(iv1);



        /*List<Ciudad> ciudades =busquedaciu.getResCiudades();
        RecyclerAdaptCities adaptercities = new RecyclerAdaptCities(ciudades,getApplicationContext());
        recyclerCities.setAdapter(adaptercities);*/
    }

    private String prettyfyJSON(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);
        return gson.toJson(element);
    }

}
