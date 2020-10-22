package com.game_stats.sports_game_stats.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.game_stats.sports_game_stats.R;
import com.game_stats.sports_game_stats.controller.TeamGameStatsController;
import com.game_stats.sports_game_stats.model.TeamGameStatsModel;

import java.util.List;

public class TeamGameStatsAdapter extends RecyclerView.Adapter<TeamGameStatsAdapter.ViewHolder> {
    private List<TeamGameStatsModel> tgsUtil;
    Context context;

    public TeamGameStatsAdapter(TeamGameStatsController context, List tgsUtil) {
        this.context = (Context) context;
        this.tgsUtil = tgsUtil;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_team_game_stats_, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final TeamGameStatsModel tgsList = tgsUtil.get(position);

        holder.season.setText(String.valueOf(tgsList.getSeason() ));

        holder.team.setText(tgsList.getTeam() );
        holder.opponent.setText(tgsList.getOpponent() );
        holder.utc.setText(tgsList.getUpdatedUtc() );



    }


    @Override
    public int getItemCount()throws NullPointerException {
        return tgsUtil.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        //VARIABLE PARA MABASA
        public TextView season;
        public TextView team;
        public TextView opponent;
        public TextView utc;


        public ViewHolder(View itemView) {
            super(itemView);

            season = itemView.findViewById(R.id.season);
            team = itemView.findViewById(R.id.team);
            opponent = itemView.findViewById(R.id.opponent);

            utc = itemView.findViewById(R.id.utc);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
}