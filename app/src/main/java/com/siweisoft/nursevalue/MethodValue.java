package com.siweisoft.nursevalue;

import android.content.Context;
import android.os.Environment;

import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.SPUtil;
import com.siweisoft.ui.user.login.bean.DoLoginResBean;
import com.siweisoft.ui.user.login.bean.GetallregionbyuserResBean;

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

}
