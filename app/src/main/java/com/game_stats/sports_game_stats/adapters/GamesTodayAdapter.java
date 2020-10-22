package com.game_stats.sports_game_stats.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.game_stats.sports_game_stats.R;
import com.game_stats.sports_game_stats.controller.GamesTodayController;
import com.game_stats.sports_game_stats.model.GamesTodayModel;

import java.util.List;

public class GamesTodayAdapter extends RecyclerView.Adapter<GamesTodayAdapter.ViewHolder> {
    private List<GamesTodayModel> gtsUtil;
    Context context;

    public GamesTodayAdapter(GamesTodayController context, List gtsUtil) {
        this.context = (Context) context;
        this.gtsUtil = gtsUtil;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_games_today, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final GamesTodayModel gtsList = gtsUtil.get(position);

        holder.status.setText(gtsList.getStatus());

        holder.hteam.setText(gtsList.getHomeTeamName());
        holder.hTeamScore.setText(String.valueOf(gtsList.homeTeamScore));
        holder.aTeam.setText(gtsList.getAwayTeamName());
        holder.aTeamScore.setText(String.valueOf(gtsList.awayTeamScore));

    }


    @Override
    public int getItemCount()throws NullPointerException {
        return gtsUtil.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        //VARIABLE PARA MABASA
        public TextView status;
        public TextView hteam;
        public TextView hTeamScore;
        public TextView aTeam;
        public TextView aTeamScore;


        public ViewHolder(View itemView) {
            super(itemView);

            status = itemView.findViewById(R.id.status);
            hteam = itemView.findViewById(R.id.hteam);
            hTeamScore = itemView.findViewById(R.id.hscore);
            aTeam = itemView.findViewById(R.id.ateam);
            aTeamScore = itemView.findViewById(R.id.acore);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
}