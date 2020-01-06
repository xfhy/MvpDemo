package com.xfhy.baselibrary;

/**
 * @author : xfhy
 * Create time : 2020/1/5 15:03
 * Description :
 */
public interface IPresenter<T extends IBaseView> {

    /**
     * 初始化View
     *
     * @param view 抽象View
     */
    void setView(T view);

    /**
     * onCreate时会被调用
     */
    void onCreate();

    /**
     * 做一些初始化操作
     */
    void onStart();

    /**
     * onDestroy时会被调用,做一些清理工作
     */
    void onDestroy();

}
