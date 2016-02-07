package com.example.veraj.aplicacionandroid;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.List;

public class ActivityCiudades extends AppCompatActivity {



    private EditText inputCity;
    private RecyclerView recyclerCities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudades);
        prepareUI();
    }

    private void prepareUI() {
        inputCity= (EditText) findViewById(R.id.input_city);
        recyclerCities = (RecyclerView) findViewById(R.id.recyclercities);
        LinearLayoutManager linLayManager = new LinearLayoutManager(this);
        recyclerCities.setLayoutManager(linLayManager);
        recyclerCities.setHasFixedSize(true);

    }

    public void searchCities(View view) {
        String ciudadn = inputCity.getText().toString();
        if (!TextUtils.isEmpty(ciudadn)) {
            String url="http://apidev.accuweather.com/locations/v1/search?q="+ciudadn+"&apikey=hoArfRosT1215";

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

            BusquedaCiudades busquedaciu = getCities(response);
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



    private BusquedaCiudades getCities(String json) {
        String json2="{\"ResCiudades\":"+json+"}";

        Toast mensaje4 = Toast.makeText(getApplicationContext(),json2, Toast.LENGTH_SHORT);
        mensaje4.setGravity(Gravity.BOTTOM | Gravity.CENTER,0,0);
        mensaje4.show();
        Gson gson = new Gson();
        BusquedaCiudades busqueda = gson.fromJson(json,BusquedaCiudades.class);
        return busqueda;

    }
    private void mostrarCity(BusquedaCiudades busquedaciu) {
        List<Ciudad> ciudades =busquedaciu.getResCiudades();
        RecyclerAdaptCities adaptercities = new RecyclerAdaptCities(ciudades,getApplicationContext());
        recyclerCities.setAdapter(adaptercities);
    }

    private String prettyfyJSON(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);
        return gson.toJson(element);
    }
}
