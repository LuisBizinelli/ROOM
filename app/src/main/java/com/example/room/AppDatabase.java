package com.example.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Item.class},version = 1) //com mais entidades separamos por virgulas entidades estao entre *{}*
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDAO itemDAO();
    private  static AppDatabase INSTANCE;

    public static synchronized AppDatabase getInstance(Context ctx){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(ctx, AppDatabase.class, "compras-db")
                    .allowMainThreadQueries() //nao recomendado para aplicativos mais pesados
                    .fallbackToDestructiveMigration() // destroi todos os dados do usuario, nao recomendado, mais pra frete veremos a forma mais correta
                    .build();
        }
        return INSTANCE;
    }
}
