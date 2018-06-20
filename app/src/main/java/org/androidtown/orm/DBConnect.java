package org.androidtown.orm;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DBConnect extends OrmLiteSqliteOpenHelper {

  private static final String DBNAME = "memo.db";
  private static final int DEVISION = 1;

  public DBConnect(Context context) {
    super(context, DBNAME, null, DEVISION);
  }

  public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
    // create query
    try {
      TableUtils.createTable(connectionSource, Memo.class);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

  }

  private Dao<Memo, Integer> memoDao = null;
  public Dao<Memo, Integer> getMemoDao() throws SQLException {
    if (memoDao == null) {
      memoDao = getDao(Memo.class);
    }
    return memoDao;
  }
}
