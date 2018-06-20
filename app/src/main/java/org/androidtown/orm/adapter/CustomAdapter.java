package org.androidtown.orm.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.androidtown.orm.Memo;
import org.androidtown.orm.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder> {

  List<Memo> list;

  public void setDataAndRefresh(List list) {
    this.list = list;
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
    return new Holder(v);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    Memo memo = list.get(position);
    holder.title.setText(memo.title);
    holder.author.setText(memo.author);
    holder.date.setText(String.valueOf(memo.timestamp));
    holder.memoObj = memo;
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  class Holder extends RecyclerView.ViewHolder {
    TextView title;
    TextView author;
    TextView date;
    Memo memoObj;

    public Holder(View v) {
      super(v);
      title = v.findViewById(R.id.itemTitle);
      author = v.findViewById(R.id.itemAuthor);
      date = v.findViewById(R.id.itemDate);
    }
  }

}
