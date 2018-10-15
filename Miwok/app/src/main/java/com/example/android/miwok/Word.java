package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a miwok translation of the word.
 */

public class Word {

        private int mImageResourceId;
        private String mDefaultTranslation;
        private String mMiwokTranslation;

    public Word(String mDefaultTranslation, String mMiwokTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mImageResourceId){
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceId = mImageResourceId;
    }

        public String getDefaultTranslation() {
            return mDefaultTranslation;
        }

        public String getMiwokTranslation() {
            return mMiwokTranslation;
        }
        public int getImageResourceId(){
            return mImageResourceId;
        }
}
