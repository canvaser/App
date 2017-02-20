package com.siweisoft.lib.view.refreshlayout;


public interface  MaterialRefreshListener {
    public void onfinish();
    public abstract void onRefresh(MaterialRefreshLayout materialRefreshLayout);
    public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout);
}
