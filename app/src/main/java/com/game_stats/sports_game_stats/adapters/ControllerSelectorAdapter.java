package com.game_stats.sports_game_stats.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.game_stats.sports_game_stats.R;
import com.game_stats.sports_game_stats.controller.GamesTodayController;
import com.game_stats.sports_game_stats.controller.OnSwipeTouchListener;
import com.game_stats.sports_game_stats.controller.TeamController;
import com.game_stats.sports_game_stats.controller.TeamGameStatsController;
import com.game_stats.sports_game_stats.controller.VenuesController;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.HashMap;

public class ControllerSelectorAdapter extends RecyclerView.Adapter<ControllerSelectorAdapter.ViewHolder>{
    Context context;
    HashMap<Integer, Integer> items;
    int i = 1;
    public ControllerSelectorAdapter(Context context, HashMap<Integer, Integer> items) {

        this.context = context;
        this.items = new HashMap<>(items);
    }

    @NonNull
    @Override
    public ControllerSelectorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_games_today, parent, false);
        return new ControllerSelectorAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ControllerSelectorAdapter.ViewHolder holder, int position) {
        holder.front.setImageResource(this.items.get(i));
        holder.easyFlipView.setOnTouchListener(new OnSwipeTouchListener(context) {
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();

                    if (i == 4) {
                    i = 1;
                } else {
                    i++;
                }
                holder.front.setImageResource(items.get(i));
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                if (i == 1) {
                    i = 4;
                } else {
                    i--;
                }
                holder.front.setImageResource(items.get(i));
            }
        });



    }


    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView front;
        public ImageView back;
        public EasyFlipView easyFlipView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            back = itemView.findViewById(R.id.back_swipe);
            front = itemView.findViewById(R.id.front_swipe);
            easyFlipView = itemView.findViewById(R.id.easyFlipView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(i == 1){
                        Intent myIntent = new Intent(context, TeamGameStatsController.class); //Open new Activity
                        context.startActivity(myIntent);
                    }else  if(i == 2){
                        Intent myIntent = new Intent(context, GamesTodayController.class); //Open new Activity
                        context.startActivity(myIntent);
                    }else if(i == 3){
                        Intent myIntent = new Intent(context, TeamController.class); //Open new Activity
                        context.startActivity(myIntent);
                    }else if(i == 4){
                        Intent myIntent = new Intent(context, VenuesController.class); //Open new Activity
                        context.startActivity(myIntent);
                    }
                }
            });
        }
    }
}
