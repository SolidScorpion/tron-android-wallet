package com.devband.tronwalletforandroid.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

import com.devband.tronwalletforandroid.database.dao.AccountDao;
import com.devband.tronwalletforandroid.database.dao.WalletDao;
import com.devband.tronwalletforandroid.database.model.AccountModel;
import com.devband.tronwalletforandroid.database.model.WalletModel;

@Database(entities = {
        WalletModel.class,
        AccountModel.class
}, version = AppDatabase.VERSION, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    static final int VERSION = 2;

    public abstract AccountDao accountDao();
    public abstract WalletDao walletDao();

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE account ADD COLUMN address TEXT");
        }
    };
}