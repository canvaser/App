package com.siweisoft.util.media;

import android.media.MediaPlayer;
import android.media.MediaRecorder;

import java.io.File;
import java.io.IOException;

/**
 * Created by ${viwmox} on 2016-11-03.
 */
public class VoiceUtil {

    private static VoiceUtil instance;

    public static VoiceUtil getInstance(){
        if(instance == null){
            instance = new VoiceUtil();
        }
        return instance;
    }


    MediaPlayer mp;
    public void play(String path){
        if(mp!=null){
            if(mp.isPlaying()){
                mp.pause();
            }
            mp=null;
        }
        mp=new MediaPlayer();
        try {
            mp.setDataSource(path);
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pause(){
        if(mp!=null && mp.isPlaying()){
            mp.pause();
        }
    }

    public MediaRecorder startRecording(File recordFile) {
        MediaRecorder mediaRecorder = new MediaRecorder();
        // 判断，若当前文件已存在，则删除
        if (recordFile.exists()) {
            recordFile.delete();
        }
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        mediaRecorder.setOutputFile(recordFile.getAbsolutePath());

        try {
            // 准备好开始录音
            mediaRecorder.prepare();

            mediaRecorder.start();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mediaRecorder;
    }


    public void stopRecording(MediaRecorder mediaRecorder,File recordFile) {
        if (recordFile != null) {
            mediaRecorder.stop();
            mediaRecorder.release();
        }
    }

}
