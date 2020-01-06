package com.xfhy.baselibrary;

/**
 * @author : xfhy
 * Create time : 2020/1/5 15:02
 * Description :
 */
public interface BaseView {

    void showLoading();

    void hideLoading();

    void showErrorMsg(String msg);

    boolean isViewDestroy();

}
