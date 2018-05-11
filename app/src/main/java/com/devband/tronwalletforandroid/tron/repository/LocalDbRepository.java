package com.devband.tronwalletforandroid.tron.repository;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.devband.tronwalletforandroid.database.AppDatabase;
import com.devband.tronwalletforandroid.database.dao.WalletDao;
import com.devband.tronwalletforandroid.database.model.WalletModel;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LocalDbRepository implements WalletRepository {

    private WalletDao mWalletDao;

    public LocalDbRepository(@NonNull Context context) {
        mWalletDao = AppDatabase.getDatabase(context).walletDao();
    }

    @Override
    public boolean storeWallet(@NonNull WalletModel walletModel) {
        Date now = Calendar.getInstance().getTime();
        walletModel.setCreated(now);

        mWalletDao.insert(walletModel);

        return true;
    }

    @Override
    public boolean updateWallet(@NonNull WalletModel walletModel) {
        Date now = Calendar.getInstance().getTime();
        walletModel.setUpdated(now);

        mWalletDao.update(walletModel);

        return true;
    }

    @Nullable
    @Override
    public WalletModel loadWallet(int index) {
        return mWalletDao.loadWalletById(index);
    }

    @Nullable
    @Override
    public List<WalletModel> loadAllWallets() {
        return null;
    }

    @Override
    public int countWallets() {
        return mWalletDao.countWallets();
    }
}
