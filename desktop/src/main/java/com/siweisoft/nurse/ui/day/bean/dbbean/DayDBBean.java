package com.siweisoft.nurse.ui.day.bean.dbbean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.siweisoft.base.ui.bean.dbbean.BaseDbBean;

/**
 * Created by ${viwmox} on 2017-01-06.
 */
@DatabaseTable(tableName = "table_day")
public class DayDBBean extends BaseDbBean {

    public static final String START_TIME = "startTime";
    @DatabaseField(columnName = START_TIME)
    private long startTime;

    public static final String END_TIME = "endTime";
    @DatabaseField(columnName = END_TIME)
    private long endTime;

    public static final String CENTENT_TXT = "contentTxt";
    @DatabaseField(columnName = CENTENT_TXT)
    private String contentTxt;

    public static final String PLAY_MUSIC = "playMusic";
    @DatabaseField(columnName = PLAY_MUSIC)
    private boolean playMusic;

    public static final String MUSIC_URL = "musicUrl";
    @DatabaseField(columnName = MUSIC_URL)
    private String musicUrl;

    public DayDBBean(long startTime, long endTime, String contentTxt) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.contentTxt = contentTxt;
    }

    public DayDBBean(long startTime, long endTime, String contentTxt, String musicUrl, boolean playMusic) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.contentTxt = contentTxt;
        this.musicUrl = musicUrl;
        this.playMusic = playMusic;
    }

    public DayDBBean() {
    }

    public String getContentTxt() {
        return contentTxt;
    }

    public void setContentTxt(String contentTxt) {
        this.contentTxt = contentTxt;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public boolean isPlayMusic() {
        return playMusic;
    }

    public void setPlayMusic(boolean playMusic) {
        this.playMusic = playMusic;
    }

    @Override
    public String toString() {
        return "DayDBBean{" +
                "contentTxt='" + contentTxt + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", playMusic=" + playMusic +
                ", musicUrl='" + musicUrl + '\'' +
                '}';
    }
}
