package com.example.firstapp.data.SubjectTable;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.firstapp.data.useresTable.MyUser;

import java.util.List;

import androidx.room.Query;


public interface MySubjectQuery
{
    @Query("SELECT * FROM MyUser")
    List<MyUser> getAll();
    @Insert
    void insertAll(MySubject users);

    @Delete
    void delete(MySubject user);

    @Query("Delete From MyUser WHERE keyid=:id ")
    void delete(int id);

    @Insert
    void insert(MyUser myUser);
    @Update
    void update(MyUser...values);
}
