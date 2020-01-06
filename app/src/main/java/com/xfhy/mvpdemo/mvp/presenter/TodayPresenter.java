package com.xfhy.mvpdemo.mvp.presenter;

import android.util.Log;

import com.xfhy.baselibrary.BasePresenter;
import com.xfhy.mvpdemo.mvp.model.TodayModel;
import com.xfhy.mvpdemo.mvp.model.bean.Today;
import com.xfhy.mvpdemo.mvp.contract.MainContract;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * @author : xfhy
 * Create time : 2020/1/5 15:20
 * Description :
 */
public class TodayPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private static final String TAG = "MainPresenter";
    private TodayModel mDataManager = new TodayModel();

    @Override
    public void loadData() {

        Flowable<Today> todayFlowable = mDataManager.reqListDataFormNet("");
        mViewProxy.showLoading();
        Disposable subscribe =
                todayFlowable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(today -> {
                            mViewProxy.hideLoading();
                            Log.w(TAG, "accept: " + today.toString());
                            mViewProxy.showContent(today.toString());
                        }, throwable -> {
                            mViewProxy.hideLoading();
                            mViewProxy.showErrorMsg(throwable.getMessage());
                        });
        addDisposable(subscribe);

        Disposable subscribe1 = Flowable.interval(1, TimeUnit.SECONDS).take(100).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(time -> {
                    mViewProxy.hideLoading();
                    Log.w(TAG, "loadData: 延时");
                }, throwable -> {
                    mViewProxy.hideLoading();
                    mViewProxy.showErrorMsg(throwable.getMessage());
                });
        addDisposable(subscribe1);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w(TAG, "onDestroy: ");
    }
}
