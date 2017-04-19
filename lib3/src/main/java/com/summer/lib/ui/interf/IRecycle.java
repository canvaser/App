package com.summer.lib.ui.interf;

//by summer on 2017-03-30.

import android.support.v7.widget.RecyclerView;

public interface IRecycle {

    public void init(RecyclerView recyclerView);

    public void loadData(RecyclerView recyclerView);

    public void refreshData(RecyclerView recyclerView);
}
