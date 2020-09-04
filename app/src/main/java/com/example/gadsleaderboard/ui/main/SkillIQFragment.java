package com.example.gadsleaderboard.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.adapter.IQAdapter;
import com.example.gadsleaderboard.model.SkillIQ;
import com.example.gadsleaderboard.post.RetrofitClient;
import com.example.gadsleaderboard.post.SkillIQService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SkillIQFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_skill_i_q, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        SkillIQService service = RetrofitClient.buildService(SkillIQService.class);
        Call<List<SkillIQ>> call = service.getSkillIQLeaders();

        call.enqueue(new Callback<List<SkillIQ>>() {
            @Override
            public void onResponse(Call<List<SkillIQ>> call, Response<List<SkillIQ>> response) {
                List<SkillIQ> list = response.body();
                IQAdapter viewHolder = new IQAdapter(list, getContext());
                recyclerView.setAdapter(viewHolder);
            }

            @Override
            public void onFailure(Call<List<SkillIQ>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }
        });






        return root;
    }
}