package com.xfhy.mvpdemo.data;

import com.xfhy.mvpdemo.data.bean.Today;
import com.xfhy.mvpdemo.data.impl.GetDataListRepository;
import com.xfhy.mvpdemo.data.interfaces.IGetDataListRepository;

import io.reactivex.Flowable;

/**
 * @author : xfhy
 * Create time : 2020/1/5 16:13
 * Description :
 */
public class DataManager {

    private DataManager() {
    }

    public static DataManager getInstance() {
        return SingleHolder.INSTANCE;
    }

    public Flowable<Today> reqListDataFormNet(String entryParameters) {
        IGetDataListRepository repository = new GetDataListRepository();
        return repository.reqListDataFormNet(entryParameters);
    }

    private static class SingleHolder {
        private static final DataManager INSTANCE = new DataManager();
    }

}
