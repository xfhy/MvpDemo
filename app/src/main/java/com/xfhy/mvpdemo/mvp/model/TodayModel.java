package com.xfhy.mvpdemo.mvp.model;

import com.xfhy.mvpdemo.mvp.model.bean.Today;
import com.xfhy.mvpdemo.data.impl.TodayRepository;
import com.xfhy.mvpdemo.data.interfaces.ITodayRepository;

import io.reactivex.Flowable;

/**
 * @author : xfhy
 * Create time : 2020/1/5 16:13
 * Description :
 */
public class TodayModel {

    public Flowable<Today> reqListDataFormNet(String entryParameters) {
        ITodayRepository repository = new TodayRepository();
        return repository.reqListDataFormNet(entryParameters);
    }

}
