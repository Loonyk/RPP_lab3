package com.example.rpp_lab3.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(entities = {Student.class}, version = 1)
@TypeConverters({TypeConverterDate.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract StudentDao getStudentDao();
    public abstract StudentTransaction getStudTransaction();
    private static AppDatabase database;

    public static AppDatabase getDatabase(Context context)
    {
        if(database==null)
        {
            database = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "databace")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }
}
