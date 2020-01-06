package com.xfhy.baselibrary;

/**
 * @author : xfhy
 * Create time : 2020/1/5 15:03
 * Description :
 */
public interface IPresenter<T extends IBaseView> {

    void setView(T view);

    void onCreate();

    /**
     * 做一些初始化操作
     */
    void onStart();

    void onDestroy();

}
