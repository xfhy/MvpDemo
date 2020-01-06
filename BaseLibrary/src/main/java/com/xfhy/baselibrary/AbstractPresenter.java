package com.xfhy.baselibrary;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author : xfhy
 * Create time : 2020/1/5 15:04
 * Description :
 */
public abstract class AbstractPresenter<T extends BaseView> implements BasePresenter<T>, InvocationHandler {

    private static final String TAG = "AbstractPresenter";
    private T mView;
    protected T mViewProxy;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public void setView(T view) {
        this.mView = view;

        //找到View的接口 是继承BaseView的
        Class<?>[] interfaces = view.getClass().getInterfaces();
        boolean findIt = false;
        for (Class<?> anInterface : interfaces) {
            Class<?>[] anInterfaceInterfaces = anInterface.getInterfaces();
            for (Class<?> anInterfaceInterface : anInterfaceInterfaces) {
                if (BaseView.class == anInterfaceInterface) {
                    mViewProxy = (T) Proxy.newProxyInstance(anInterface.getClassLoader(), new Class[]{anInterface}, this);
                    findIt = true;
                    break;
                }
            }
            if (findIt) {
                break;
            }
        }
        if (mViewProxy == null) {
            mViewProxy = (T) Proxy.newProxyInstance(BaseView.class.getClassLoader(), new Class[]{BaseView.class}, this);
        }
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
        mView = null;
        mCompositeDisposable.clear();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (mView == null || method == null) {
            Log.w(TAG, "view 为null 不执行方法");
            return null;
        }
        if (mView.isViewDestroy()) {
            Log.w(TAG, "已经destroy了,不执行view方法");
            return null;
        }
        try {
            Log.w(TAG, "执行方法");
            return method.invoke(mView, args);
        } catch (IllegalAccessException | IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.getTargetException().printStackTrace();
        }
        return null;
    }

    protected void addDisposable(Disposable disposable) {
        if (disposable == null) {
            return;
        }
        mCompositeDisposable.add(disposable);
    }

}
