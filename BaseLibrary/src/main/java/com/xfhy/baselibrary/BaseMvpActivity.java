package com.xfhy.baselibrary;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 * @author : xfhy
 * Create time : 2020/1/5 15:05
 * Description :
 */
public abstract class BaseMvpActivity<T extends BasePresenter> extends FragmentActivity implements BaseView{

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = getPresenter();
        mPresenter.setView(this);
    }

    /**
     * 初始化Presenter
     */
    public abstract T getPresenter();
}
