package com.example.rpp_lab3.AsyncTask;

import android.os.AsyncTask;

import com.example.rpp_lab3.MainActivity;
import com.example.rpp_lab3.db.AppDatabase;
import com.example.rpp_lab3.db.Student;

import java.sql.Date;
import java.util.List;

public class AsyncStudent extends AsyncTask<MainActivity, Void, Void> {

    private final static String[] studName = {
            "Тюрина Валерия Сергеевна",
            "Синицкий Валерий Юрьевич",
            "Карташова Валерия Валерьевна",
            "Сорочан Ирина Олеговна",
            "Абрамов Олег Александрович"
    };

    @Override
    protected Void doInBackground(MainActivity... mainActivities) {
        MainActivity mainAct = mainActivities[0];
        AppDatabase database = AppDatabase.getDatabase(mainAct);
        database.getStudentDao().deleteStudents();
        Student[] students = new Student[5];
        for(int i = 0; i < 5; i++){
            students[i] = new Student();
        }
        
        for (int i = 0; i < 5; i++){
            students[i].setFIO(studName[i]);
            students[i].setTime_add(new Date(System.currentTimeMillis()));
            database.getStudentDao().insertAll(students[i]);
        }

        return null;
    }

    public static String[] getStudName() {
        return studName;
    }

    @Override
    protected void onPostExecute(Void v)
    {

    }
}
