package com.summer.app.nursevalue;

import android.content.Context;
import android.os.Environment;

import com.summer.app.ui.user.login.bean.DoLoginResBean;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.SPUtil;
import com.summer.app.ui.user.login.bean.GetallregionbyuserResBean;

import java.io.File;
import java.io.IOException;

/**
 * Created by ${viwmox} on 2016-12-02.
 */
public class MethodValue {

    public static GetallregionbyuserResBean.Data getArea() {
        String area = SPUtil.getInstance().getStr(ValueConstant.AREA_INFO);
        if (area == null) {
            return null;
        }
        GetallregionbyuserResBean.Data data = GsonUtil.getInstance().fromJson(area, GetallregionbyuserResBean.Data.class);
        if (data == null) {
            return null;
        }
        return data;
    }

    public static DoLoginResBean getUserInfo(Context context) {
        String str = SPUtil.getInstance().init(context).getStr(ValueConstant.LOGIN_INFO);
        DoLoginResBean doLoginResBean = GsonUtil.getInstance().fromJson(str, DoLoginResBean.class);
        return doLoginResBean;
    }

    public static File getRecordFile(String name) {
        File file = new File(Environment.getExternalStorageDirectory(), "nurse");
        if (!file.exists()) {
            file.mkdirs();
        }
        File f = new File(file.getPath() + "/" + name);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return f;
    }

    public static String getRecordFile() {
        File file = new File(Environment.getExternalStorageDirectory(), "nurse");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public static String[] getMissionSortStrs() {
        DoLoginResBean loginResBean = GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(ValueConstant.LOGIN_INFO), DoLoginResBean.class);
        loginResBean.getData().getNurseType().add(0, "全部");
        return loginResBean.getData().getNurseType().toArray(new String[loginResBean.getData().getNurseType().size()]);
    }

}
