package org.androidtown.orm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.j256.ormlite.dao.Dao;

import org.androidtown.orm.adapter.CustomAdapter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  TextView id;
  EditText title;
  EditText memo;
  TextView author;
  TextView date;

  RecyclerView recyclerView;
  List<Memo> list;
  CustomAdapter adapter;

  DBConnect dbConnect;
  Dao<Memo, Integer> memoDao;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // 위젯과 코드를 연결
    init();
    listInit();
    dbConnect();
  }

  private void init() {
    id = findViewById(R.id.itemId);
    title = findViewById(R.id.itemTitle);
    memo = findViewById(R.id.itemMemo);
    author = findViewById(R.id.itemAuthor);
    date = findViewById(R.id.itemDate);
    recyclerView = findViewById(R.id.recycler);
  }

  private void listInit() {
    list = new ArrayList<>();
    adapter = new CustomAdapter();
    adapter.setDataAndRefresh(list);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
  }

  private void dbConnect() {
    dbConnect = new DBConnect(this);
    try {
      memoDao = dbConnect.getMemoDao();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void post(View v) {
    String t = title.getText().toString();
    String m = memo.getText().toString();
    String a = author.getText().toString();
    String d = date.toString();
    try {
      memoDao.create(new Memo(t, m, a, 100L));
      adapter.setDataAndRefresh(memoDao.queryForAll());
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
