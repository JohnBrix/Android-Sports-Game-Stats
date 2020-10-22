package com.game_stats.sports_game_stats.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.game_stats.sports_game_stats.R;
import com.game_stats.sports_game_stats.controller.VenuesController;
import com.game_stats.sports_game_stats.model.VenuesModel;

import java.util.List;

public class VenuesAdapter extends RecyclerView.Adapter<VenuesAdapter.ViewHolder> {
    private List<VenuesModel> venuesUtil;
    Context context;

    public VenuesAdapter(VenuesController context, List venuesUtil) {
        this.context = (Context) context;
        this.venuesUtil = venuesUtil;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_venues, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final VenuesModel venuesList = venuesUtil.get(position);

        holder.name.setText(venuesList.getName());
        holder.address.setText(venuesList.getAddress());

        holder.city.setText(venuesList.getCity());
        holder.zip.setText(venuesList.getZip());
        holder.country.setText(venuesList.getCountry());


    }


    @Override
    public int getItemCount()throws NullPointerException {
        return venuesUtil.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        //VARIABLE PARA MABASA
        public TextView name;
        public TextView address;
        public TextView city;
        public TextView zip;
        public TextView country;


        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address_venues);
            city = itemView.findViewById(R.id.city);
            zip = itemView.findViewById(R.id.zip);
            country = itemView.findViewById(R.id.country);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
}