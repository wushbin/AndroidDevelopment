package com.example.android.miwok;

/**
 * Created by wushbin on 2/10/17.
 */

public class Word {
    private  static final int NO_IMAGE_PROVIDED = -1;
    private  static final int NO_MUSIC_PROVIDED = -1;
    private String englishTranslation;
    private String miwokTranslation;

    private int imageResourseId = NO_IMAGE_PROVIDED;
    private int musicResourseId = NO_MUSIC_PROVIDED;


    public Word(String english, String miwork, int imageId, int musicId) {
        englishTranslation = english;
        miwokTranslation = miwork;
        imageResourseId = imageId;
        musicResourseId = musicId;
    }

    public  Word(String english, String miwok,int musicId) {
        englishTranslation = english;
        miwokTranslation = miwok;
        musicResourseId = musicId;
    }

    public boolean hasImage() {
        return imageResourseId != NO_IMAGE_PROVIDED;
    }

    public String  getEnglishTranslation () {
        return englishTranslation;
    }

    public String  getMiwokTranslation () {
        return miwokTranslation;
    }

    public int getResourseId() {
        return imageResourseId;
    }

    public int getMusicResourseId() { return musicResourseId;}


}
