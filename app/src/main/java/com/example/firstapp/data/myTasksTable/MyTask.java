package com.example.firstapp.data.myTasksTable;

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
     * نص قصير
     */
    public String ShortTitle;
    /**
     * زمن بناء المهمة
     */
    public long time;
    /**
     * هل تمت المهمة
     */
    public boolean isCompleted;
    /**
     * رقم موضوع المهمة
     */
    public long subjId;
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
                ", ShortTitle='" + ShortTitle + '\'' +
                ", time=" + time +
                ", isCompleted=" + isCompleted +
                ", subjeId=" + subjId +
                ", userId='" + userId + '\'' +
                '}';
    }

    public long getKeyid() {
        return keyid;
    }

    public void setKeyid(long keyid) {
        this.keyid = keyid;
    }
}
