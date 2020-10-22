package com.game_stats.sports_game_stats.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.game_stats.sports_game_stats.R;
import com.game_stats.sports_game_stats.controller.TeamController;
import com.game_stats.sports_game_stats.model.TeamModel;

import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    private List<TeamModel> leaguesUtil;
    Context context;
    public TeamAdapter(TeamController context, List leaguesUtil) {
        this.context = (Context) context;
        this.leaguesUtil = leaguesUtil;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_team, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
         TeamModel leagueList = leaguesUtil.get(position);
        //display all
        //logo
        if (leagueList.getWikipediaLogoUrl() == null ) {
            holder.wikiLogo.setImageResource(R.drawable.ic_broken_image);
        }
        else if(leagueList.getWikipediaLogoUrl().isEmpty()){
            holder.wikiLogo.setImageResource(R.drawable.ic_broken_image);
        }
        else {
            Picasso.get().load(leagueList.getWikipediaLogoUrl()).into(holder.wikiLogo);
        }
        //area name
        if (leagueList.getAreaName()== null ) {
            holder.areaName.setText("Null");
        }
        else if(leagueList.getAreaName().isEmpty()){
            holder.areaName.setText("Null");
        }
        else {
            holder.areaName.setText(leagueList.getAreaName());
        }
        //full name anti crash
        if (leagueList.getFullName()== null ) {
            holder.fullName.setText("Null");
        }
        else if(leagueList.getFullName().isEmpty()){
            holder.fullName.setText("Null");
        }
        else {
            holder.fullName.setText(leagueList.getFullName());
        }
        //city anti crash
        if (leagueList.getCity()== null ) {
            holder.city.setText("Null");
        }
        else if(leagueList.getCity().isEmpty()){
            holder.city.setText("Null");
        }
        else {
            holder.city.setText(leagueList.getCity());
        }
        //address anti crash
        if (leagueList.getAddress()== null ) {
            holder.address.setText("Null");
        }
        else if(leagueList.getAddress().isEmpty()) {
            holder.address.setText("Null");
        }
        else {
            holder.address.setText(leagueList.getAddress());
        }
        //venueName anti crash
        if (leagueList.getVenueName()== null ) {
            holder.venueName.setText("Null");
        }
        else if(leagueList.getVenueName().isEmpty()) {
            holder.venueName.setText("Null");
        }
        else {
            holder.venueName.setText(leagueList.getVenueName());
        }
        //phone anti crash
        if (leagueList.getPhone()== null ) {
            holder.phone.setText("Null");
        }
        else if(leagueList.getPhone().isEmpty()) {
            holder.phone.setText("Null");
        }
        else {
            holder.phone.setText(leagueList.getPhone());
        }
        //zip anti crash
        if (leagueList.getZip()== null ) {
            holder.zip.setText("Null");
        }
        else if(leagueList.getZip().isEmpty()) {
            holder.zip.setText("Null");
        }
        else {
            holder.zip.setText(leagueList.getZip());
        }
        //website anti crash
        if (leagueList.getWebsite()== null ) {
            holder.website.setText("Null");
        }
        else if(leagueList.getWebsite().isEmpty()) {
            holder.website.setText("Null");
        }
        else {
            holder.website.setText(leagueList.getWebsite());
        }





//        GlideToVectorYou.justLoadImage((Activity) context, Uri.parse(leagueList.getWikipediaLogoUrl()),holder.wikiLogo);

    }


    @Override
    public int getItemCount()throws NullPointerException {
        return leaguesUtil.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        //VARIABLE PARA MABASA
        public TextView areaName;
        public TextView fullName;
        public TextView city;
        public TextView address;
        public TextView venueName;
        public TextView phone;
        public TextView zip;
        public TextView website;

        public ImageView wikiLogo;


        public ViewHolder(View itemView) {
            super(itemView);
            areaName = itemView.findViewById(R.id.area_name);
            fullName = itemView.findViewById(R.id.full_name);
            city = itemView.findViewById(R.id.city);
            address = itemView.findViewById(R.id.address);

            venueName = itemView.findViewById(R.id.venue_name);
            phone = itemView.findViewById(R.id.phone);
            zip = itemView.findViewById(R.id.zip);
            website = itemView.findViewById(R.id.website);
            wikiLogo = itemView.findViewById(R.id.wikipeadia_logo);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
}