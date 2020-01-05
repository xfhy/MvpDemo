package com.xfhy.mvpdemo.data.interfaces;

import com.xfhy.mvpdemo.data.bean.Today;

import io.reactivex.Flowable;

public interface IGetDataListRepository {

    Flowable<Today> reqListDataFormNet(String entryParameters);
}
