package com.nopearino.libraryapp.ui.multimedia;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MultimediaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MultimediaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}