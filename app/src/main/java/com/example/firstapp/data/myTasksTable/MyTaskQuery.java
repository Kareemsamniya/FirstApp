package com.example.firstapp.data.myTasksTable;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao    // واجهة استعلامات على جدول معطيات
public interface MyTaskQuery
{
    @Query("SELECT * FROM MyTask")
    List<MyTask> getAllTasks();
    @Insert
    void insertTask(MyTask...t); //ثلث نقاط تعني ادخال مجموعة
}
