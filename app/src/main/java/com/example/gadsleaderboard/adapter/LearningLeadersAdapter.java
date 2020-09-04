package com.example.gadsleaderboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.model.LearningLeaders;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.MyviewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    List<LearningLeaders> list;

    public LearningLeadersAdapter(Context c, List<LearningLeaders> list) {
        this.context = c;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LearningLeadersAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.learning_leaders_child, parent, false);
        return new MyviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LearningLeadersAdapter.MyviewHolder holder, int position) {
        LearningLeaders leadersModel = list.get(position);
        holder.names.setText(leadersModel.getName());
        holder.hours.setText(String.valueOf(leadersModel.getHours()) + " learning hours, ");
        holder.country.setText(leadersModel.getCountry() + ".");
        Picasso.get().load(leadersModel.getBadgeUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView names, hours, country;
        ImageView imageView;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            names = itemView.findViewById(R.id.names);
            hours = itemView.findViewById(R.id.hours);
            country = itemView.findViewById(R.id.country);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
