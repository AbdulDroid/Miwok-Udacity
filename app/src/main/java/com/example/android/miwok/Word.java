package com.example.android.miwok;

/**
 * Created by Abdulkarim on 3/12/2017.
 */

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private static final int NO_IMAGE_PROVIDED=-1;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mMediaResourceId;

    public Word(String defaultTranslation, String miwokTranslation){

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
    }
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int mediaResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mMediaResourceId = mediaResourceId;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public int getmImageResourceId(){
        return mImageResourceId;
    }
    public int getmMediaResourceId(){
        return mMediaResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mMediaResourceId=" + mMediaResourceId +
                '}';
    }
}
