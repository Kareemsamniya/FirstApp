package com.example.firstapp.data.SubjectTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.firstapp.data.useresTable.MyUser;

import java.util.List;

/**
 * واجهة تحوي عمليات / استعمالات على قاعدة البيانات
 */
@Dao // لتحديد ان الواجهة تحوي استعلامات على قاعدة بيانات
public interface MySubjectQuery
{
    @Query("SELECT * FROM MySubject")
    List<MySubject> getAll();
    @Insert
    void insertAll(MySubject mySubjects);

    @Delete
    void delete(MySubject mySubject);

    @Query("Delete From MyUser WHERE keyid=:id ")
    void delete(int id);

    @Insert
    void insert(MySubject mySubject);
    @Update
    void update(MyUser...values);
}