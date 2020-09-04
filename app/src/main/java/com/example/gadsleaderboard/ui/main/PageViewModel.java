package com.example.gadsleaderboard.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mTitle = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mTitle, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Contact not available in " + input;
        }
    });

    public void setIndex(int index) {
        mTitle.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void setIndex(String tag) {

    }
}