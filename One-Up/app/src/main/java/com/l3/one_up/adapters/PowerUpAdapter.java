package com.l3.one_up.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.l3.one_up.R;
import com.l3.one_up.model.PowerUp;

import java.util.ArrayList;

/**
 * Created by luzcamacho on 7/30/18.
 */

public class PowerUpAdapter extends RecyclerView.Adapter<PowerUpAdapter.ViewHolder> {
    private static String tag = "PowerUpAdapter";
    /* Our data set */
    ArrayList<PowerUp> userPowerUps;
    /* our context */
    Context context;

    public PowerUpAdapter(ArrayList<PowerUp> userPowerUps) {
        this.userPowerUps = userPowerUps;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View powerupViewer = inflater.inflate(R.layout.item_powerup, parent, false);
        ViewHolder viewHolder = new ViewHolder(powerupViewer);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PowerUp currPowerUp = userPowerUps.get(position);
        String sentBy = currPowerUp.getSentByUser().getUsername();
        String powerUpMessage = currPowerUp.getMessage();

        holder.tvPowerUpMessage.setText(powerUpMessage);
        holder.tvSentBy.setText(sentBy);
    }

    @Override
    public int getItemCount() {
        return userPowerUps.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvSentBy;
        public TextView tvPowerUpMessage;
        public Button btPowerUpClick;


        public ViewHolder(View itemView) {
            super(itemView);
            tvSentBy = itemView.findViewById(R.id.tvSentBy);
            tvPowerUpMessage = itemView.findViewById(R.id.tvPowerUpMessage);
            btPowerUpClick = itemView.findViewById(R.id.btRedeemPowerUp);
        }
    }
}
