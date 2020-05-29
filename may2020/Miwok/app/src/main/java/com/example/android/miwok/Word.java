package com.example.android.miwok;

public class Word {

    private String mMivokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId;

    public Word(String defaultTranslation, String mivokTranslation){
        mMivokTranslation = mivokTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    public Word(String defaultTranslation, String mivokTranslation, int imageResourceId){
        mMivokTranslation = mivokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
    }

    public String getmMivokTranslation() {
        return mMivokTranslation;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getmImageId() {
        return mImageResourceId;
    }
}
