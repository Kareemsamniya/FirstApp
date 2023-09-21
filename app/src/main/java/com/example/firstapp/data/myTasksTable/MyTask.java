package com.example.firstapp.data.myTasksTable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * فئة تمثل مهمة
 */
@Entity
public class MyTask
{
    @PrimaryKey(autoGenerate = true)//تحديد الصفة كمفتاح رئيسي والذي يُنتجح بشكل تلقائي
    /**
     *  رقم المهمة
     */
    public long keyid;
    /**
     * درجة الأهمية 1-5
     */
    public int importance;
    /**
     * نص المهمة
     */
    public String text;
    /**
     * زمن بناء المهمة
     */
    public lomg time;
    /**
     * هل تمت المهمة
     */
    public boolean isCompleted;
    /**
     * رقم موضوع المهمة
     */
    public long subjeId;
    /**
     * رقم المستعمل الذي لضاف امهمة
     */
    public long userId;

    @Override
    public String toString() {
        return "MyTask{" +
                "keyid=" + keyid +
                ", importance=" + importance +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", isCompleted=" + isCompleted +
                ", subjeId=" + subjeId +
                ", userId=" + userId +
                '}';
    }
}
