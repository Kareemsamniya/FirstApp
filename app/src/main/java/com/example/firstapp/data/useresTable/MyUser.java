package com.example.firstapp.data.useresTable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.firstapp.data.SubjectTable.MySubject;
//Entity = Table =جدول
// عندما نريد ان تنعامل مع هذه الفئة كجدول معطيات

/**
 * فئة تمثل المستعمل
 */
@Entity
public class MyUser {
    @PrimaryKey(autoGenerate = true)// تحديد الصفة كمفتاح رئيسي والذي يُنتج بشكل اوتوماتيكي
    public long keyid;
    @ColumnInfo(name = "full_Name")// اعطاء اسم ديد للعامود-الصفة في الجدول
    public String fullName;
    public String email;// بحالة لم يتم اعطاء اسم للعامود يكون اسم الصفة هو اسم العامود
    public String phone;
    public String passw;

    @Override
    public String toString() {
        return "MyUser{" +
                "keyid=" + keyid +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", passw='" + passw + '\'' +
                '}';
    }

    public long getKeyid() {
        return keyid;
    }

    public void setKeyid(long keyid) {
        this.keyid = keyid;
    }
}
