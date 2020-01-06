package com.xfhy.baselibrary;

/**
 * @author : xfhy
 * Create time : 2020/1/5 15:02
 * Description : 所有View的抽象
 */
public interface IBaseView {

    /**
     * 展示loading
     */
    default void showLoading() {
    }

    /**
     * 隐藏loading
     */
    default void hideLoading() {
    }

    /**
     * 展示错误信息
     *
     * @param msg 错误信息
     */
    default void showErrorMsg(String msg) {
    }

    /**
     * View是否已经销毁
     *
     * @return view是否销毁
     */
    boolean isViewDestroy();

}
