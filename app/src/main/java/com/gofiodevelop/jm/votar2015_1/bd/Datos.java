package com.gofiodevelop.jm.votar2015_1.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by JM_B on 26-Apr-15.
 */
public class Datos {

    //Metainformacion de la base de datos
    public static final String PARTIDO_TABLE_NAME = "partidos";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";



    //Campos de la tabla Quotes
    public static class ColumnQuotes{
        public static final String ID_PARTIDO = BaseColumns._ID;
        public static final String Nombre_PARTIDO = "nombre";
        public static final String REPRESENTANTE_PARDTIDO = "representante";
        public static final String PROGRAMA_PARTIDO = "programa";

    }

    //Script de Creacin de la tabla Quotes
    public static final String CREATE_PARTIDO_SCRIPT =
            "create table "+PARTIDO_TABLE_NAME+"(" +
                    ColumnQuotes.ID_PARTIDO+" "+INT_TYPE+" primary key autoincrement," +
                    ColumnQuotes.Nombre_PARTIDO+" "+STRING_TYPE+" not null," +
                    ColumnQuotes.REPRESENTANTE_PARDTIDO+" "+STRING_TYPE+" not null," +
                    ColumnQuotes.PROGRAMA_PARTIDO+" "+STRING_TYPE+" not null)";

    //Scripts de insercin por defecto
    public static final String INSERT_QUOTES_SCRIPT = "insert into "+ PARTIDO_TABLE_NAME+" values(" +
"null," + "\"Partido Popular\"," + "\"Aristteles\","+"\"Espaa necesita el cambio. Los espaoles estamos padeciendo una crisis\n" + "sin precedentes.\")," +
"(null," + "\"PSOE\"," + "\"Jorge Luis Borges\"," +"\"El primer programa del nuevo partido potico fue aprobado en una asamblea de 40 personas, el 20 de julio de ese mismo ao.\")," +
"(null," + "\"PODEMOS\"," + "\"Albert Einstein\"," + "\"Recuperar la economa, construir la democracia,Conquistar la libertad.Conquistar la igualdad. Recuperar la fraternidad.\")," +
"(null," + "\"CIUDADANOS\"," + "\"Benjamin Franklin\","+"\"Ciudadanos se origina en la plataforma Ciudadanos de Catalunya, impulsada por prestigiosos intelectuales catalanes\")," +
"(null," + "\"IZQUIERDA UNIDA\"," + "\"Mahatma Gandhi\","+"\"Izquierda Unida es un Movimiento Poltico y Social, que se conforma en una organizacin jurdica y polticamente soberana\")";


    //Variables para manipulacin de datos
    private Coneccion openHelper;
    private SQLiteDatabase database;

    public Datos(Context con) {
        //Creando una instancia hacia la base de datos
        openHelper = new Coneccion(con);
        database = openHelper.getWritableDatabase();
    }

    /*
    public Coneccion open()
    {
        database = openHelper.getWritableDatabase();
        return this;
    }
    */

    public void saveDatosRow(String nombreP,String representanteP, String programaP){
        //Nuestro contenedor de valores
        ContentValues values = new ContentValues();

        //Seteando body y author
        values.put(Datos.ColumnQuotes.Nombre_PARTIDO,nombreP);
        values.put(Datos.ColumnQuotes.REPRESENTANTE_PARDTIDO,representanteP);
        values.put(Datos.ColumnQuotes.PROGRAMA_PARTIDO,programaP);

        //Insertando en la base de datos
        database.insert(PARTIDO_TABLE_NAME,null,values);
    }

    public Cursor getAllQuotes(){
        //Seleccionamos todas las filas de la tabla Quotes
        return database.rawQuery(
                "select * from " + PARTIDO_TABLE_NAME, null);
    }

   /* public Cursor getOneQuotes(int cod){

        return database.rawQuery(
                "select * from " + PARTIDO_TABLE_NAME + "where " + ColumnQuotes.ID_PARTIDO +"= "+ cod, null);
    }

    */
    //---closes the database---
    public void close()
    {
        openHelper.close();
    }


    public Cursor getDatos(long rowId)
    {
        Cursor mCursor =
                database.query(true, PARTIDO_TABLE_NAME, new String[]
                                {ColumnQuotes.ID_PARTIDO,
ColumnQuotes.Nombre_PARTIDO,ColumnQuotes.REPRESENTANTE_PARDTIDO,ColumnQuotes.PROGRAMA_PARTIDO}, ColumnQuotes.ID_PARTIDO + "=" + ColumnQuotes.ID_PARTIDO, null,
            null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

        public String[] datosBase(Cursor c){

            String[] datosTodos ={c.getString(0),c.getString(1),c.getString(2)};

            return datosTodos;
        }





}
