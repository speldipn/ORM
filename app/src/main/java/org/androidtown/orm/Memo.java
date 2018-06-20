package org.androidtown.orm;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="memo")
public class Memo {
  @DatabaseField(generatedId = true)
  public int id;

  @DatabaseField
  public String title;

  @DatabaseField
  public String memo;

  @DatabaseField
  public String author;

  @DatabaseField
  public long timestamp;

  public Memo() {
    // 실제 사용은 없더라도, ORM 라이브러리에서 필요
  }

  public Memo(String title, String memo, String author, long timestamp) {
    this.title = title;
    this.memo = memo;
    this.author = author;
    this.timestamp = timestamp;
  }
}
