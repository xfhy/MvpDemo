package com.xfhy.mvpdemo.data;

/**
 * @author : xfhy
 * Create time : 2020/1/5 16:26
 * Description :
 */
public interface DataResponse<T> {

    /**
     * 加载中
     */
    void onLoading();

    /**
     * 请求数据成功
     *
     * @param t 需要回调的数据
     */
    void onSuccess(T t);

    /**
     * 请求数据失败
     *
     * @param errorMessage 错误信息
     */
    void onError(String errorMessage);

}
