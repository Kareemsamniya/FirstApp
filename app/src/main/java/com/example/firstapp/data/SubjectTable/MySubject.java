package com.example.firstapp.data.SubjectTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class MySubject
{
    @PrimaryKey(autoGenerate = true)
    public long key_id;
    public String Title;

    @Override
    public String toString() {
        return "MySubject{" +
                "key_id=" + key_id +
                ", Title='" + Title + '\'' +
                '}';
    }

    public long getKey_id() {
        return key_id;
    }

    public void setKey_id(long key_id) {
        this.key_id = key_id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
