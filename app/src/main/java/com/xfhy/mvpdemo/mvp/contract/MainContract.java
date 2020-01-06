package com.xfhy.mvpdemo.mvp.contract;

import com.xfhy.baselibrary.IBaseView;
import com.xfhy.baselibrary.IPresenter;

/**
 * @author : xfhy
 * Create time : 2020/1/5 15:18
 * Description :
 */
public interface MainContract {

    interface View extends IBaseView {
        void showContent(String content);
    }

    interface Presenter extends IPresenter<View> {
        /**
         * 加载数据
         */
        void loadData();
    }

}
