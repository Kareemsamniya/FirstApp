package com.example.firstapp.data.myTasksTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * واجهة استعلاممات على جدول معطيات
 */
@Dao    // واجهة استعلامات على جدول معطيات
public interface MyTaskQuery
{
    /**
     * اعادة جميع معطيات جدول المهمات
     * @return قائمة من المهمات
     */
    @Query("SELECT * FROM MyTask")
    List<MyTask> getAllTasks();


    @Query("SELECT * FROM MyTask WHERE userID=:userId_p " +
            "ORDER BY time DESC")

            List<MyTask> getAllTasks(long userId_p);

    /**
     * استخراج جميع المهمات حسب المستعمل والتي لم تنتهي ومرتبة حسب الأهمية من 1-5 حسب DESC
     * @param userId_p
     * @param isCompleted_p
     * @return
     */
    @Query("SELECT * FROM MyTask WHERE userId=:userId_p AND isCompleted=:isCompleted_p " +
            "ORDER BY importance DESC")
    List<MyTask> getAllTaskOrderBy(long userId_p,boolean isCompleted_p);

    /**
     * ادخال مهمات
     * @param t مجموعة مهمات
     */
    @Insert
    void insertTask(MyTask...t); //ثلث نقاط تعني ادخال مجموعة

    /**
     * تعديل المهمات
     * @param task مجموعة مهمات للتعديل (التعديل ب المفتاح الرئيسي)
     */
    @Update
    void updateTask(MyTask... task);

    /**
     * حذف مهمة او مهمات
     * @param tasks حذف المهمات (حسب المفتاح الرئيسي)
     */
    @Delete
    void deleteTask(MyTask...tasks);

    @Query("DELETE FROM MyTask WHERE keyId=:id")
    void delTaskId(long id);

}