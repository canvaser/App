package com.siweisoft.nurse.ui.user.login.bean;

import com.siweisoft.base.ui.bean.BaseBean;
import com.siweisoft.network.bean.req.BaseReqBean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class DoLoginResBean extends BaseBean{

    Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data extends BaseBean{

        private UserResBean user;

        private VoipResBean voip;

        private AppResBean app;

        private SettingResBean setting;

        private ArrayList<String> nurseType;




        public AppResBean getApp() {
            return app;
        }

        public void setApp(AppResBean app) {
            this.app = app;
        }

        public ArrayList<String> getNurseType() {
            return nurseType;
        }

        public void setNurseType(ArrayList<String> nurseType) {
            this.nurseType = nurseType;
        }

        public SettingResBean getSetting() {
            return setting;
        }

        public void setSetting(SettingResBean setting) {
            this.setting = setting;
        }

        public UserResBean getUser() {
            return user;
        }

        public void setUser(UserResBean user) {
            this.user = user;
        }

        public VoipResBean getVoip() {
            return voip;
        }

        public void setVoip(VoipResBean voip) {
            this.voip = voip;
        }
    }



}
