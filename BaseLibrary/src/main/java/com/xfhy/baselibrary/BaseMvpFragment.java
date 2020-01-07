package com.xfhy.baselibrary;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author : xfhy
 * Create time : 2020/1/6 15:16
 * Description : fragment基类 mvp
 * <p>
 * 现在有了ViewPager2,不需要搞什么懒加载了
 */
public abstract class BaseMvpFragment<T extends IPresenter> extends Fragment implements IBaseView {

    protected T mPresenter;
    private boolean mFlagDestroyed = false;
    protected View mRootView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mPresenter = getPresenter();
        mPresenter.setView(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        return mRootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFlagDestroyed = true;
        mPresenter = null;
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

    @Override
    public boolean isViewDestroy() {
        return mFlagDestroyed;
    }

    /**
     * 初始化Presenter
     *
     * @return 返回真实的Presenter
     */
    protected abstract T getPresenter();

    /**
     * 布局id
     */
    public abstract int getLayoutId();
}
