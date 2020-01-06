package com.xfhy.baselibrary;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 * @author : xfhy
 * Create time : 2020/1/5 15:05
 * Description : 基类Activity
 */
public abstract class BaseMvpActivity<T extends BasePresenter> extends FragmentActivity implements BaseView {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = getPresenter();
        mPresenter.setView(this);
        mPresenter.onCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mPresenter.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErrorMsg(String msg) {

    }

    /**
     * 初始化Presenter
     */
    public abstract T getPresenter();
}
