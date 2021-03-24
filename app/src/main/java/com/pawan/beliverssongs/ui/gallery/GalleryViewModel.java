package com.pawan.beliverssongs.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Send Your Song request on: pawangavti@gmail.com");
    }

    public LiveData<String> getText() {
        return mText;
    }
}