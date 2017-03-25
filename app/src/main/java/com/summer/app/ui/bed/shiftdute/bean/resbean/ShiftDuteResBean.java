package com.summer.app.ui.bed.shiftdute.bean.resbean;


import com.summer.lib.base.ui.bean.ResultResBean;

/**
 * Created by ${viwmox} on 2016-12-06.
 */
public class ShiftDuteResBean extends ResultResBean {

    private String id;

    private String user_id;

    private String 住院号;

    private String 内容;

    private String audio;

    private String create_time;

    private String displayname;

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String get住院号() {
        return 住院号;
    }

    public void set住院号(String 住院号) {
        this.住院号 = 住院号;
    }

    public String get内容() {
        return 内容;
    }

    public void set内容(String 内容) {
        this.内容 = 内容;
    }
}
