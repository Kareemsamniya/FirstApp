package com.example.firstapp.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.firstapp.data.SubjectTable.MySubject;
import com.example.firstapp.data.SubjectTable.MySubjectQuery;
import com.example.firstapp.data.myTasksTable.MyTask;
import com.example.firstapp.data.myTasksTable.MyTaskQuery;
import com.example.firstapp.data.useresTable.MyUser;
import com.example.firstapp.data.useresTable.MyUserQuery;

/*
تعريف الجداول ورقم النسخة
version
عند احداث تغيير يخص جدول او جداول علينا تغيير رقم الأصدار ليتم بناء قاعدة البينات من جديد
 */
@Database(entities = {MyUser.class, MySubject.class, MyTask.class},version = 6)
/**
 * الفئة المسئولة عن بناء قاعدة البيانات لكل جداولها
 * وتوفر لنا كائن للتعامل مع قاعدة البيانات
 */
public abstract class AppDatabase extends RoomDatabase
{
    /**
     * كائن للتعامل مع قاعدة البيانات
     */
    private static AppDatabase db;

    /**
     * يعيد كائن لعمليات جدول المستعملين
     * @return
     */

    public abstract MyUserQuery getMyUserQuery();

    /**
     * يعيد كائن لعمليات جدول المواضيع
     * @return
     */

    public abstract MySubjectQuery getMySubjectQuery();

    /**
     * يعيد كائن لعمليات جدول المهمات
     * @return
     */

    public abstract MyTaskQuery getMyTaskQuery();

    /**
     * بناء قاعدة البيانات واعادة كائن يؤشر عليها
     * @param context
     * @return
     */

    /**
     *singilton(عند اعادة الكائن يعيده مرة واحدة)
     */
    public static AppDatabase getDB(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context,
                            AppDatabase.class, "database-name")//اسم
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return db;

    }
}