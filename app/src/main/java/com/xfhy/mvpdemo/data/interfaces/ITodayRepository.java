package com.xfhy.mvpdemo.data.interfaces;

import com.xfhy.mvpdemo.mvp.model.bean.Today;

import io.reactivex.Flowable;

public interface ITodayRepository {

    Flowable<Today> reqListDataFormNet(String entryParameters);
}
