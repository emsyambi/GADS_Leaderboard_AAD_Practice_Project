package com.example.gadsleaderboard;

import android.content.Intent;
import android.os.Bundle;

import com.example.gadsleaderboard.adapter.SectionsPagerAdapter;
import com.example.gadsleaderboard.ui.main.LearningLeadersFragment;
import com.example.gadsleaderboard.ui.main.SkillIQFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBar);

        Button submit = appBarLayout.findViewById(R.id.button_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Submission.class);
                startActivity(intent);
            }
        });

        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LearningLeadersFragment(), getString(R.string.tab_1));
        adapter.addFragment(new SkillIQFragment(), getString(R.string.tab_2));


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}