package com.example.rpp_lab3.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insertAll(Student... students);

    @Query("SELECT * FROM Student")
    List<Student> getAllStudent();

    @Query("DELETE FROM Student")
    void deleteStudents();
}

