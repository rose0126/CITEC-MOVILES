package com.example.veraj.aplicacionandroid;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.List;

public class PeliculasAct extends AppCompatActivity {

    private EditText inputPelicula;
    private RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);
        prepareUI();
    }

    private void prepareUI() {
        inputPelicula = (EditText) findViewById(R.id.input_pelicula);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager linLayManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linLayManager);
        recycler.setHasFixedSize(true);

    }

    public void buscarPelicula(View view) {
        String titulo = inputPelicula.getText().toString();
        if (!TextUtils.isEmpty(titulo)) {
            String url="http://www.omdbapi.com/?s="+titulo+"&page=2&r=json";
            new LoadFilmTask().execute(url);
        }
    }


    private class LoadFilmTask extends AsyncTask<String, Long, String> {
        protected String doInBackground(String... urls) {
            try {
                return HttpRequest.get(urls[0]).accept("application/json")
                        .body();
            } catch (HttpRequest.HttpRequestException exception) {
                return null;
            }
        }

        protected void onPostExecute(String response) {
            Busqueda busqueda = getPeliculas(response);
            if(busqueda!=null){
                mostrarPelicula(busqueda);
            }
        }
    }

    private void mostrarPelicula(Busqueda busqueda) {
        List<Pelicula> peliculas =busqueda.getSearch();
        RecyclerAdaptador adapter = new RecyclerAdaptador(peliculas,getApplicationContext());
        recycler.setAdapter(adapter);
    }

    private Busqueda getPeliculas(String json) {

        Gson gson = new Gson();
        Busqueda busqueda = gson.fromJson(json,Busqueda.class);
        return busqueda;

    }

    private String prettyfyJSON(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);
        return gson.toJson(element);
    }
}
