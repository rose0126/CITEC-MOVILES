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
 * Created by Alice on 07/02/2016.
 */
public class RecyclerAdaptCities  extends RecyclerView.Adapter<RecyclerAdaptCities.ViewHolder>{

    List<Ciudad> ciudades;
    Context context;

    RecyclerAdaptCities( List<Ciudad> ciudades,Context context)
    {
        this.ciudades = ciudades;
        this.context = context;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView txtTitulo;

        TextView txtdetails;

        TextView txtll;
        ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.recycler);
            txtTitulo = (TextView)itemView.findViewById(R.id.cityname);
            txtdetails = (TextView)itemView.findViewById(R.id.cityplusnam);
            txtll = (TextView)itemView.findViewById(R.id.cityll);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent, false);
        ViewHolder pvh = new ViewHolder(v);
        return pvh;
    }
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtTitulo.setText(ciudades.get(position).getEnglishName());

    }

    @Override
    public int getItemCount() {
        return ciudades.size();
    }
}
