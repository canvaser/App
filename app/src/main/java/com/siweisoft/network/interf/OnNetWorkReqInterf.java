package com.siweisoft.network.interf;


import com.siweisoft.network.bean.req.BaseReqBean;
import com.siweisoft.network.bean.res.BaseResBean;

import org.json.JSONObject;

/**
 * Created by ${viwmox} on 2016-04-27.
 */
public interface OnNetWorkReqInterf{


    /**正在发起网络请求*/
    public boolean onNetWorkReqStart(String reqjson, String tag);
    /**网络请求完成*/
    public void onNetWorkReqFinish(boolean haveData, String url,BaseResBean baseResBean);
    /**网络请求获取数据结果*/
    public void onNetWorkResult(boolean success,Object o);


}
