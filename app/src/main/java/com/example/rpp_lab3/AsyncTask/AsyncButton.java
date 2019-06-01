package com.example.rpp_lab3.AsyncTask;

import android.os.AsyncTask;

import com.example.rpp_lab3.MainActivity;
import com.example.rpp_lab3.db.AppDatabase;
import com.example.rpp_lab3.db.Student;

import java.util.List;

public class AsyncButton extends AsyncTask<MainActivity, Void, Void> {

    @Override
    protected Void doInBackground(MainActivity... mainActivities) {
        MainActivity mainAct = mainActivities[0];
        AppDatabase database = AppDatabase.getDatabase(mainAct);

        switch (mainAct.getChoiceBtn()) {
            case 1:
                List<Student> list = database.getStudentDao().getAllStudent();
                mainAct.openScndAct(list);
                break;
            case 2:
                Student student = new Student();
                student.setFIO(AsyncStudent.getStudName()[(int) (Math.random() * 5)]);
                student.setTime_add(new java.sql.Date(System.currentTimeMillis()));
                database.getStudentDao().insertAll(student);
                break;
            case 3:
                database.getStudTransaction().ChangeToIvan();
                break;
        }
        return null;
    }
}