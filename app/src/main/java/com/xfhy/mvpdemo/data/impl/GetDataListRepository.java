package com.xfhy.mvpdemo.data.impl;

import com.xfhy.mvpdemo.data.bean.Today;
import com.xfhy.mvpdemo.data.interfaces.IGetDataListRepository;
import com.xfhy.mvpdemo.data.net.GetRequest;

import io.reactivex.Flowable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author : xfhy
 * Create time : 2020/1/5 16:28
 * Description :
 */
public class GetDataListRepository implements IGetDataListRepository {

    @Override
    public Flowable<Today> reqListDataFormNet(String entryParameters) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        GetRequest request = retrofit.create(GetRequest.class);
        return request.getTodayData();
    }
}
