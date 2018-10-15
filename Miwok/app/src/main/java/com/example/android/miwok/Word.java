package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a miwok translation of the word.
 */

public class Word {

        private String mDefaultTranslation;
        private String mMiwokTranslation;

    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

        public String getDefaultTranslation() {
            return mDefaultTranslation;
        }

        public String getMiwokTranslation() {
            return mMiwokTranslation;
        }

}
