package com.example.aaung.myroomapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insert(Word word);

    @Query("DELETE from word_table")
    void deleteAll();

    /**to manage and get the updated data**/
    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWorlds();
}
