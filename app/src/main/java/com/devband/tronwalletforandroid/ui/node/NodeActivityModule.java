package com.devband.tronwalletforandroid.ui.node;

import com.devband.tronwalletforandroid.tron.Tron;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public abstract class NodeActivityModule {

    @Binds
    public abstract NodeView view(NodeActivity nodeActivity);

    @Provides
    static NodePresenter provideNodePresenter(NodeView view, Tron tron) {
        return new NodePresenter(view, tron, Schedulers.io(), AndroidSchedulers.mainThread());
    }
}
