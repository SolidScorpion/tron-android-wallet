package com.devband.tronwalletforandroid.ui.vote;

import com.devband.tronwalletforandroid.ui.mvp.IView;

public interface VoteView extends IView {

    void showLoadingDialog();

    void showServerError();
}