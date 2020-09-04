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
import com.example.gadsleaderboard.model.SkillIQ;
import com.squareup.picasso.Picasso;

import java.util.List;

public class IQAdapter extends RecyclerView.Adapter<IQAdapter.MyviewHolder> {
    List<SkillIQ> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public IQAdapter(List<SkillIQ> list, Context c) {
        this.list = list;
        this.context = c;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public IQAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.skill_iq_child, parent, false);
        return new IQAdapter.MyviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull IQAdapter.MyviewHolder holder, int position) {
        SkillIQ model = list.get(position);
        holder.names.setText(model.getName());
        holder.score.setText(String.valueOf(model.getScore()) + " skill IQ Score, ");
        holder.country.setText(model.getCountry());
        Picasso.get().load(model.getBadgeUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView names, score, country;
        ImageView imageView;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            names = itemView.findViewById(R.id.names);
            score = itemView.findViewById(R.id.score);
            country = itemView.findViewById(R.id.country);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
