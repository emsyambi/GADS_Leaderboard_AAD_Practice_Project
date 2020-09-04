package com.example.gadsleaderboard.post;

import com.example.gadsleaderboard.model.SkillIQ;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SkillIQService {
    @GET("/api/skilliq")
    Call<List<SkillIQ>> getSkillIQLeaders();
}
