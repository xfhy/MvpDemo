package com.xfhy.mvpdemo.data.net;

import com.xfhy.mvpdemo.data.bean.Today;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * @author : xfhy
 * Create time : 2020/1/5 16:37
 * Description :
 */
public interface GetRequest {

    //http://gank.io/api/today

    @GET("api/today")
    Flowable<Today> getTodayData();

}
