package com.siweisoft.base.ui.bean;

import java.io.Serializable;

/**
 * Created by ${viwmox} on 2016-04-28.
 */
public class BaseResultResBean implements Serializable{

    private int total;

    private int pageCount;

    private int start;

    private int currentPageIndex;

    private int lastPageIndex;

    private int pageSize;

    private int nextPageIndex;

    private int prePageIndex;

    private int pageIndex;

    private int firstPageIndex;

    public BaseResultResBean() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(int currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public int getLastPageIndex() {
        return lastPageIndex;
    }

    public void setLastPageIndex(int lastPageIndex) {
        this.lastPageIndex = lastPageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNextPageIndex() {
        return nextPageIndex;
    }

    public void setNextPageIndex(int nextPageIndex) {
        this.nextPageIndex = nextPageIndex;
    }

    public int getPrePageIndex() {
        return prePageIndex;
    }

    public void setPrePageIndex(int prePageIndex) {
        this.prePageIndex = prePageIndex;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getFirstPageIndex() {
        return firstPageIndex;
    }

    public void setFirstPageIndex(int firstPageIndex) {
        this.firstPageIndex = firstPageIndex;
    }
}
