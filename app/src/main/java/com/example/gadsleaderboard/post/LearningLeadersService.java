package com.example.gadsleaderboard.post;

import com.example.gadsleaderboard.model.LearningLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearningLeadersService {
    @GET("api/hours")
    Call<List<LearningLeaders>> getLearningLeaders();
}
