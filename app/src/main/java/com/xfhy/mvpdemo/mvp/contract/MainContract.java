package com.xfhy.mvpdemo.mvp.contract;

import com.xfhy.baselibrary.BaseView;
import com.xfhy.baselibrary.IPresenter;

/**
 * @author : xfhy
 * Create time : 2020/1/5 15:18
 * Description :
 */
public interface MainContract {

    interface View extends BaseView {
        void showContent(String content);
    }

    interface Presenter extends IPresenter<View> {
        /**
         * 加载数据
         */
        void loadData();
    }

}
