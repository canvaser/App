package com.siweisoft.lib.util.thread;

import android.os.AsyncTask;

import com.siweisoft.lib.base.ui.interf.OnLoadingInterf;

/**
 * Created by ${viwmox} on 2017-02-20.
 */

public class ThreadUtil {

    public static void run(final OnLoadingInterf listener){
        new AsyncTask<String, String, Void>() {

            @Override
            protected Void doInBackground(String... params) {
                listener.onStarLoading(null);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                listener.onStopLoading(null);
            }
        }.execute();
    }
}
