package com.example.gadsleaderboard.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.adapter.LearningLeadersAdapter;
import com.example.gadsleaderboard.model.LearningLeaders;
import com.example.gadsleaderboard.post.LearningLeadersService;
import com.example.gadsleaderboard.post.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LearningLeadersFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        LearningLeadersService taskService = RetrofitClient.buildService(LearningLeadersService.class);
        Call<List<LearningLeaders>> call = taskService.getLearningLeaders();

        call.enqueue(new Callback<List<LearningLeaders>>() {
            @Override
            public void onResponse(Call<List<LearningLeaders>> call, Response<List<LearningLeaders>> response) {

                List<LearningLeaders> list = response.body();
                LearningLeadersAdapter viewHolder = new LearningLeadersAdapter(getContext(), list);
                recyclerView.setAdapter(viewHolder);
            }

            @Override
            public void onFailure(Call<List<LearningLeaders>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }
        });


        return root;
    }
}