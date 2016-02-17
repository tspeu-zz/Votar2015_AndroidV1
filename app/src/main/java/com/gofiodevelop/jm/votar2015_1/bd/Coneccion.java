package com.gofiodevelop.jm.votar2015_1.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JM_B on 26-Apr-15.
 */
public class Coneccion extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "partidos.db";
    public static final int DATABASE_VERSION = 1;


    public Coneccion (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crear la tabla Quotes
        db.execSQL(Datos.CREATE_PARTIDO_SCRIPT);
        //Insertar registros iniciales
        db.execSQL(Datos.INSERT_QUOTES_SCRIPT);

        /*  Nota: Usamos execSQL() ya que las sentencias son
            para uso interno y no estn relacionadas con entradas
            proporcionadas por los usuarios
        */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            /*  Anade los cambios que se realizarn en el esquema
                en tu proxima versin
             */
    }
}
