## 改良版的MVP架构设计

> 详细内容请看源码中BaseLibrary

### 1. Presenter 自动关联Activity or Fragment的生命周期

只需在BasePresenter中实现LifecycleObserver接口,利用Lifecycle注册生命周期观察者,然后就可以知道View的生命周期了.

### 2. View已经销毁时不会去执行View的任何方法

利用动态代理,每次使用View时都是使用代理,在代理里面判断View是否已经销毁,是否为null.

### 3. 封装Disposable容器,可以在onDestroy时自动解除订阅

在BasePresenter中封装了CompositeDisposable,方便自动解除订阅.
