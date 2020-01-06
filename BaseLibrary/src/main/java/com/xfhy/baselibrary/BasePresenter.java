package com.xfhy.baselibrary;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author : xfhy
 * Create time : 2020/1/5 15:04
 * Description : 基类Presenter
 */
public abstract class BasePresenter<T extends IBaseView> implements IPresenter<T>, InvocationHandler, LifecycleObserver {

    private static final String TAG = "AbstractPresenter";
    private T mView;
    protected T mViewProxy;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public void setView(T view) {
        this.mView = view;

        //将 LifecycleObserver 注册给 LifecycleOwner 后 @OnLifecycleEvent 才可以正常使用
        //注册观察者
        if (mView != null && mView instanceof LifecycleOwner) {
            ((LifecycleOwner) mView).getLifecycle().addObserver(this);
        }

        //找到View的接口 是继承BaseView的
        Class<?>[] interfaces = view.getClass().getInterfaces();
        boolean findIt = false;
        for (Class<?> anInterface : interfaces) {
            Class<?>[] anInterfaceInterfaces = anInterface.getInterfaces();
            for (Class<?> anInterfaceInterface : anInterfaceInterfaces) {
                if (IBaseView.class == anInterfaceInterface) {
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
            mViewProxy = (T) Proxy.newProxyInstance(IBaseView.class.getClassLoader(), new Class[]{IBaseView.class}, this);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    @Override
    public void onCreate() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    @Override
    public void onStart() {
        Log.w(TAG, "BasePresenter onStart: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    @Override
    public void onDestroy() {
        Log.w(TAG, "BasePresenter onDestroy: ");
        mView = null;
        mCompositeDisposable.clear();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy(LifecycleOwner owner) {
        Log.w(TAG, "BasePresenter removeObserver: ");
        owner.getLifecycle().removeObserver(this);
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
