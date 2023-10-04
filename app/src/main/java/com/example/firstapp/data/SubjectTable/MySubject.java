package com.example.firstapp.data.SubjectTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class MySubject
{
    @PrimaryKey(autoGenerate = true)
    public long key_id;
    public String title;
    public String Title;

    @Override
    public String toString() {
        return "MySubject{" +
                "key_id=" + key_id +
                ", title='" + title + '\'' +
                '}';
    }

    public void setTitle(String math) {
    }
}
