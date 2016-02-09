package com.example.veraj.aplicacionandroid;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by veraj on 16/01/2016.
 */
public class RecyclerAdaptador  extends RecyclerView.Adapter<RecyclerAdaptador.ViewHolder>{

    List<Pelicula> peliculas;
    Context context;

    RecyclerAdaptador(List<Pelicula> peliculas,Context context)
    {
        this.peliculas = peliculas;
        this.context = context;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView txtTitulo;
        ImageView imgPoster;

        ImageView photo;

        ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.recycler);
            txtTitulo = (TextView)itemView.findViewById(R.id.nameAuthor);
            imgPoster = (ImageView)itemView.findViewById(R.id.imagePhoto);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent, false);
        ViewHolder pvh = new ViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtTitulo.setText(peliculas.get(position).getTitle());

        if (peliculas.get(position).getPoster() != null) {
            Picasso.with(context).load(peliculas.get(position).getPoster()).into(holder.imgPoster);
        }
    }
    @Override
    public int getItemCount() {
        return peliculas.size();
    }
}
