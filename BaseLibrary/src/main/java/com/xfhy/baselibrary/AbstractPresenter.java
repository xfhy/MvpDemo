package com.xfhy.baselibrary;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import androidx.annotation.Nullable;

/**
 * @author : xfhy
 * Create time : 2020/1/5 15:04
 * Description :
 */
public abstract class AbstractPresenter<T extends BaseView> implements BasePresenter<T> {

    private static final String TAG = "AbstractPresenter";
    protected T view;

    @Override
    public void setView(T view) {
        this.view = view;
        /*Class<?> anInterface = view.getClass().getInterfaces()[0];
        this.view = (T) Proxy.newProxyInstance(anInterface.getClassLoader(), new Class<?>[]{anInterface},
                new InvocationHandler() {

                    @Override
                    public @Nullable
                    Object invoke(Object proxy, Method method,
                                  @Nullable Object[] args) throws Throwable {
                        if (AbstractPresenter.this.view == null) {
                            Log.w(TAG, "view 为null 不执行方法");
                            return null;
                        }
                        Log.w(TAG, "执行方法");
                        return null;
                    }
                });*/
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
