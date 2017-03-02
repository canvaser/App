package com.siweisoft.util.sip;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.sip.SipAudioCall;
import android.net.sip.SipException;
import android.net.sip.SipManager;
import android.net.sip.SipProfile;
import android.net.sip.SipRegistrationListener;
import android.preference.PreferenceManager;

import com.example.android.sip.IncomingCallReceiver;
import com.siweisoft.util.LogUtil;
import com.siweisoft.util.ToastUtil;

import java.text.ParseException;

/**
 * Created by ${viwmox} on 2016-12-20.
 */

public class SipUtil {

    public static SipManager manager = null;
    public SipProfile me = null;
    public SipAudioCall call = null;
    public IncomingCallReceiver callReceiver;
    private String username;
    private String domain;
    private String password;

    public void initializeManager(Context context, String username, String domain, String password, SipRegistrationListener sipRegistrationListener) {
        if (manager == null) {
            manager = SipManager.newInstance(context);
        }
        if (manager == null) {
            ToastUtil.getInstance().show(context, "你的设备不支持sip协议");
        }
        this.username = username;
        this.password = password;
        this.domain = domain;
        initializeLocalProfile(context, sipRegistrationListener);
    }


    public void initializeLocalProfile(Context context, SipRegistrationListener sipRegistrationListener) {
        if (manager == null) {
            return;
        }
        if (me != null) {
            closeLocalProfile();
        }
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        if (username.length() == 0 || domain.length() == 0 || password.length() == 0) {
            return;
        }
        try {
            SipProfile.Builder builder = new SipProfile.Builder(username, domain);
            builder.setPassword(password);
            me = builder.build();
            Intent i = new Intent();
            i.setAction("android.SipDemo.INCOMING_CALL");
            PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, Intent.FILL_IN_DATA);
            manager.open(me, pi, sipRegistrationListener);
        } catch (ParseException pe) {

        } catch (SipException se) {

        }
    }

    public void callSomeBody(String sipAddress) {

        try {
            if (call != null) {
                call.endCall();
                call.close();
            }
            call = manager.makeAudioCall(me.getUriString(), "sip:" + sipAddress + "@192.168.1.168", new SipAudioCall.Listener() {
                @Override
                public void onCallEstablished(SipAudioCall call) {
                    call.startAudio();
                    call.setSpeakerMode(true);
                    call.toggleMute();
                    LogUtil.E("onCallEstablished");
                }

                @Override
                public void onCallEnded(SipAudioCall call) {
                    LogUtil.E("onCallEnded");
                }
            }, 30);
            LogUtil.E(me.getUriString() + "  sip:" + sipAddress + "@192.168.1.168");

        } catch (Exception e) {
            LogUtil.E("" + e.getMessage());
            if (me != null) {
                try {
                    manager.close(me.getUriString());
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
            if (call != null) {
                call.close();
            }
        }
    }


    public void closeLocalProfile() {
        if (manager == null) {
            return;
        }
        try {
            if (me != null) {
                manager.close(me.getUriString());
            }
        } catch (Exception ee) {

        }
    }


    public void close() {
        if (call != null) {
            try {
                call.endCall();
            } catch (SipException se) {
                LogUtil.E("WalkieTalkieActivity/onOptionsItemSelected",
                        "Error ending call." + se);
            }
            call.close();
        }
        if (manager == null) {
            return;
        }
        try {
            if (me != null) {
                manager.close(me.getUriString());
            }
        } catch (Exception ee) {

        }

    }

    public SipManager getManager() {
        return manager;
    }

    public SipAudioCall getCall() {
        return call;
    }

    public void setCall(SipAudioCall call) {
        this.call = call;
    }
}
