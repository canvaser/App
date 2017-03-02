package com.siweisoft.nurse.ui.app.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.siweisoft.base.ui.adapter.AppPagerAdapter;
import com.siweisoft.base.ui.fragment.BaseFrg;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class AppsAdapter extends AppPagerAdapter {

    public AppsAdapter(FragmentManager fm, Context context, ArrayList<BaseFrg> fragments) {
        super(fm, context, fragments);
    }
}
