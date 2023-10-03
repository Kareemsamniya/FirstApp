package com.example.firstapp.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Database;

import com.example.firstapp.data.myTasksTable.MyTask;
import com.example.firstapp.data.myTasksTable.MyTaskQuery;
import com.example.firstapp.data.useresTable.MyUser;
import com.example.firstapp.data.useresTable.MyUserQuery;

@Database(entities = {MyUser.class, MySubject.class, MyTask.class},version = 5)

public class AppDatabase {
    private static AppDatabase db;

    public abstract MyUserQuery getMyUserQuery();

    public abstract MySubjectQuery getMySubjectQuery();

    public abstract MyTaskQuery getMyTaskQuery();

    public static AppDatabase getDB(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context,
                            AppDatabase.class, "database-name")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return db;

    }
}