package com.siweisoft.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.fragment.NullUIFragment;
import com.siweisoft.nurse.ui.home.fragment.DrawerLayoutFrag;

import java.util.ArrayList;

/**
 * fragment操作的工具类
 * Created by summer on 2016/4/16 0016 16:25.
 */
public class FragmentUtil {

    private static FragmentUtil instance;

    public static FragmentUtil getInstance(){
        if(instance==null){
            instance=new FragmentUtil();
        }
        return instance;
    }

    public void addToContaier(FragmentActivity activity,ArrayList<android.support.v4.app.Fragment> fragments,int resid){
        android.support.v4.app.FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        for(int i=0;i<fragments.size();i++){
            transaction.add(resid,fragments.get(i));
        }
        try {
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addToContaier(FragmentActivity activity,android.support.v4.app.Fragment fragment,int resid){
        android.support.v4.app.FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.anim_push_right_in,R.anim.anim_push_left_out);
        transaction.add(resid,fragment,fragment.getClass().getSimpleName());
        transaction.commit();
    }




    public void addToContaierWithOutAnim(FragmentActivity activity,android.support.v4.app.Fragment fragment,int resid){
        android.support.v4.app.FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(resid,fragment,fragment.getClass().getSimpleName());
        try {
            transaction.addToBackStack(fragment.getClass().getSimpleName());
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addToContaier(FragmentActivity activity,android.support.v4.app.Fragment thisf ,android.support.v4.app.Fragment nextf,int resid){
        android.support.v4.app.FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.anim_push_right_in,R.anim.anim_push_left_out);
        transaction.hide(thisf);
        transaction.add(resid,nextf,nextf.getClass().getSimpleName());
        transaction.commit();
    }

    public void addToContaier(FragmentActivity activity,android.support.v4.app.Fragment fragment,int resid,String tag){
        android.support.v4.app.FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.anim_push_left_in,R.anim.anim_push_right_out);
        transaction.add(resid,fragment,tag);
        try {
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeAll(FragmentActivity activity,int resid){
        android.support.v4.app.FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        NullUIFragment nullFragment = (NullUIFragment) NullUIFragment.instantiate(activity,NullUIFragment.class.getName());
        transaction.replace(resid,nullFragment);
        transaction.commit();
    }

    public void removeFrag(FragmentActivity activity,android.support.v4.app.Fragment thisf,String tag){
        android.support.v4.app.FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.anim_push_left_in,R.anim.anim_push_right_out);
        transaction.remove(thisf);
        if(activity.getSupportFragmentManager().findFragmentByTag(tag)!=null){
            transaction.show(activity.getSupportFragmentManager().findFragmentByTag(tag));
        }

        transaction.commit();
    }

    public void removeFrag(FragmentActivity activity, android.support.v4.app.Fragment thisf, String tag, Bundle bundle){
        android.support.v4.app.FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.anim_push_left_in,R.anim.anim_push_right_out);
        transaction.remove(thisf);
        if(activity.getSupportFragmentManager().findFragmentByTag(tag)!=null){
            if(activity.getSupportFragmentManager().findFragmentByTag(tag) instanceof DrawerLayoutFrag){
                DrawerLayoutFrag drawerLayoutFrag = (DrawerLayoutFrag) activity.getSupportFragmentManager().findFragmentByTag(tag);
                drawerLayoutFrag.onResult(bundle);
            }
            transaction.show(activity.getSupportFragmentManager().findFragmentByTag(tag));
        }

        transaction.commit();
    }



}
