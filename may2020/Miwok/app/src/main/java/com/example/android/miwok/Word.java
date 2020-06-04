package com.example.android.miwok;

public class Word {

    private String mMivokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId;
    private int mAudioResourceId;

    public Word(String defaultTranslation, String mivokTranslation, int audioResourceId){
        mMivokTranslation = mivokTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String mivokTranslation, int imageResourceId, int audioResourceId){
        mMivokTranslation = mivokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
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

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }
}
