package com.summer.network;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.summer.constant.ValueConstant;
import com.summer.network.bean.req.BaseReqBean;
import com.summer.constant.UrlConstant;
import com.summer.network.bean.res.BaseResBean;
import com.summer.network.interf.OnNetWorkReqInterf;
import com.summer.network.requst.MyObjectRequest;
import com.summer.network.requst.MyStringRequest;
import com.summer.util.LogUtil;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${viwmox} on 2016-04-26.
 */
public class NetWork {

    private static NetWork instance;

    private static Gson gson = new Gson();

    private static RequestQueue mQueue;


    private NetWork() {

    }

    public static NetWork getInstance(Context context) {
        if (instance == null) {
            instance = new NetWork();
            mQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return instance;
    }

    public void init(String url) {
        UrlConstant.URI = url;
    }

    /**
     * @param tag
     */
    public void cancle(Context tag) {
        mQueue.cancelAll(tag);
    }


    /**
     * @param context
     * @param model
     * @param reqBean
     * @param reqInterf
     */
    public void doHttpRequset(final Context context, final String model, final BaseReqBean reqBean, final OnNetWorkReqInterf reqInterf) {
        JsonObjectRequest jsonObjectRequest = null;
        LogUtil.E(UrlConstant.URI + model);
        final String jsonstr = gson.toJson(reqBean);
        LogUtil.E(jsonstr);
        if (!reqInterf.onNetWorkReqStart(UrlConstant.URI + model, jsonstr)) {
            BaseResBean res = new BaseResBean();
            res.setErrorCode(ValueConstant.ERROR_CODE_NET_NO_CONNETCT);
            res.setErrorMessage(ValueConstant.ERROR_STR_NET_NO_CONNETCT);
            reqInterf.onNetWorkReqFinish(false, UrlConstant.URI + model, res);
            return;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, UrlConstant.URI + model,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response == null) {
                            BaseResBean res = new BaseResBean();
                            res.setErrorCode(ValueConstant.ERROR_CODE_RES_NULL);
                            res.setErrorMessage(ValueConstant.ERROR_STR_RES_NULL);
                            reqInterf.onNetWorkReqFinish(false, UrlConstant.URI + model, res);
                        } else {
                            BaseResBean baseResBean = gson.fromJson(response.toString(), BaseResBean.class);
                            reqInterf.onNetWorkReqFinish(true, UrlConstant.URI + model, baseResBean);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                BaseResBean baseResBean = new BaseResBean();
                baseResBean.setErrorCode(ValueConstant.ERROR_CODE_VOLLEY_FAIL);
                baseResBean.setErrorMessage(error.getMessage() == null ? "" : error.getMessage());
                reqInterf.onNetWorkReqFinish(false, UrlConstant.URI + model, baseResBean);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map = (Map<String, String>) gson.fromJson(jsonstr, map.getClass());
                return map;
            }
        };
        stringRequest.setTag(context.getClass().getName());
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(15000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        stringRequest.setShouldCache(true);
        mQueue.add(stringRequest);
    }

    /**
     * @param context
     * @param model
     * @param reqBean
     * @param reqInterf
     */
    public void doHttpRequsetWithSession(final Context context, final String model, final BaseReqBean reqBean, final OnNetWorkReqInterf reqInterf) {
        JsonObjectRequest jsonObjectRequest = null;
        LogUtil.E(UrlConstant.URI + model);
        final String jsonstr = gson.toJson(reqBean);
        LogUtil.E(jsonstr);
        if (!reqInterf.onNetWorkReqStart(UrlConstant.URI + model, jsonstr)) {
            BaseResBean res = new BaseResBean();
            res.setErrorCode(ValueConstant.ERROR_CODE_NET_NO_CONNETCT);
            res.setErrorMessage(ValueConstant.ERROR_STR_NET_NO_CONNETCT);
            res.setData(jsonstr);
            reqInterf.onNetWorkReqFinish(false, UrlConstant.URI + model, res);
            return;
        }
        Request stringRequest = null;
        stringRequest = new MyStringRequest(Request.Method.POST, UrlConstant.URI + model,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response == null) {
                            BaseResBean res = new BaseResBean();
                            res.setErrorCode(ValueConstant.ERROR_CODE_RES_NULL);
                            res.setErrorMessage(ValueConstant.ERROR_STR_RES_NULL);
                            reqInterf.onNetWorkReqFinish(false, UrlConstant.URI + model, res);
                        } else {
                            BaseResBean baseResBean = gson.fromJson(response.toString(), BaseResBean.class);
                            reqInterf.onNetWorkReqFinish(true, UrlConstant.URI + model, baseResBean);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                BaseResBean baseResBean = new BaseResBean();
                baseResBean.setErrorCode(ValueConstant.ERROR_CODE_VOLLEY_FAIL);
                baseResBean.setErrorMessage(error.getMessage() == null ? "" : error.getMessage());
                reqInterf.onNetWorkReqFinish(false, UrlConstant.URI + model, baseResBean);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map = (Map<String, String>) gson.fromJson(jsonstr, map.getClass());
                return map;
            }
        };
        stringRequest.setTag(context.getClass().getName());
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(15000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        stringRequest.setShouldCache(true);
        mQueue.add(stringRequest);
    }


    public void doHttpRequsetWithSession(final Context context, final String url, final String req, final OnNetWorkReqInterf reqInterf) {
        LogUtil.E(req);
        Request stringRequest = null;
        stringRequest = new MyStringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response == null) {
                            BaseResBean res = new BaseResBean();
                            res.setErrorCode(ValueConstant.ERROR_CODE_RES_NULL);
                            res.setErrorMessage(ValueConstant.ERROR_STR_RES_NULL);
                            reqInterf.onNetWorkReqFinish(false, url, res);
                        } else {
                            BaseResBean baseResBean = gson.fromJson(response.toString(), BaseResBean.class);
                            reqInterf.onNetWorkReqFinish(true, url, baseResBean);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                BaseResBean baseResBean = new BaseResBean();
                baseResBean.setErrorCode(ValueConstant.ERROR_CODE_VOLLEY_FAIL);
                baseResBean.setErrorMessage(error.getMessage() == null ? "" : error.getMessage());
                reqInterf.onNetWorkReqFinish(false, url, baseResBean);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map = (Map<String, String>) gson.fromJson(req, map.getClass());
                return map;
            }
        };
        stringRequest.setTag(context.getClass().getName());
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(15000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        stringRequest.setShouldCache(true);
        mQueue.add(stringRequest);
    }


    /**
     * @param context
     * @param model
     * @param reqBean
     * @param reqInterf
     */
    public void doObjectHttpRequsetWithSession(final Context context, final String model, final BaseReqBean reqBean, final OnNetWorkReqInterf reqInterf) {
        JsonObjectRequest jsonObjectRequest = null;
        LogUtil.E(UrlConstant.URI + model);
        final String jsonstr = gson.toJson(reqBean);
        LogUtil.E(jsonstr);
        if (!reqInterf.onNetWorkReqStart(UrlConstant.URI + model, jsonstr)) {
            BaseResBean res = new BaseResBean();
            res.setErrorCode(ValueConstant.ERROR_CODE_NET_NO_CONNETCT);
            res.setErrorMessage(ValueConstant.ERROR_STR_NET_NO_CONNETCT);
            reqInterf.onNetWorkReqFinish(false, UrlConstant.URI + model, res);
            return;
        }
        Request stringRequest = null;


        try {
            stringRequest = new MyObjectRequest(Request.Method.POST, UrlConstant.URI + model, new JSONObject(jsonstr),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            if (response == null) {
                                BaseResBean res = new BaseResBean();
                                res.setErrorCode(ValueConstant.ERROR_CODE_RES_NULL);
                                res.setErrorMessage(ValueConstant.ERROR_STR_RES_NULL);
                                reqInterf.onNetWorkReqFinish(false, UrlConstant.URI + model, res);
                            } else {
                                BaseResBean baseResBean = gson.fromJson(response.toString(), BaseResBean.class);
                                reqInterf.onNetWorkReqFinish(true, UrlConstant.URI + model, baseResBean);
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            BaseResBean baseResBean = new BaseResBean();
                            baseResBean.setErrorCode(ValueConstant.ERROR_CODE_VOLLEY_FAIL);
                            baseResBean.setErrorMessage(error.getMessage() == null ? "" : error.getMessage());
                            reqInterf.onNetWorkReqFinish(false, UrlConstant.URI + model, baseResBean);
                        }
                    }) {
//                @Override
//                public Map<String, String> getHeaders()throws AuthFailureError{
//                    Map<String, String> headers = new HashMap<String, String>();
//                    headers.put("Charset", "UTF-8");
//                    headers.put("Content-Type", "application/json");
//                    return headers;
//                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }

        stringRequest.setTag(context.getClass().getName());
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(15000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        stringRequest.setShouldCache(true);
        mQueue.add(stringRequest);
    }


}
