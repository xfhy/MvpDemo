package com.xfhy.baselibrary;

/**
 * @author : xfhy
 * Create time : 2020/1/5 15:03
 * Description :
 */
public interface BasePresenter<T extends BaseView> {

    void setView(T view);

    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onRestart();

    void onDestroy();

}
