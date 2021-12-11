package com.example.miprimeraapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQL extends  SQLiteOpenHelper{

    public SQLiteDatabase db;
    //SQL STATEMENTS
    String CREATE_USERS = "CREATE TABLE Usuarios (codigo INTEGER , email TEXT, pass TEXT, idioma TEXT, edad INTEGER ,nombre TEXT)";
    String DELETE_USERS_TABLE = "DROP TABLE IF EXISTS Usuarios";
    String DELETE_USERS_REGS = "DELETE FROM Usuarios";
    String INSERT_SAMPLE_USER = "INSERT INTO Usuarios (codigo, email, pass, idioma, edad, nombre) VALUES ('%s','%s','%s','%s','%s','%s')";
    public SQL(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
        System.out.println("SQL Class joined via constructor");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creando la tabla usuarios
        try {
            db.execSQL(CREATE_USERS);
            System.out.println("TABLE 'Usuarios': CREATED");

        }catch (Exception e){System.out.println("Error creating table Usuarios");}

    }

    public void insertarUsuario(SQLiteDatabase db, Usuario usuario){
        System.out.println("INSERTANDO USUARIO EJEMPLO");
        try {
            db.execSQL(String.format(INSERT_SAMPLE_USER,usuario.getCodigo(),usuario.getEmail(),usuario.getPass(),usuario.getLanguage(),usuario.getAge(),usuario.getName()));
            System.out.println("INSERTADO");
            this.db = db;
        }catch (Exception e){
            System.out.println("ERROR INSERTANDO");
            e.printStackTrace();
        }
    }


    public  void insertesample(SQLiteDatabase db){
        System.out.println("INSERTANDO USUARIO EJEMPLO");
        try {
            db.execSQL(String.format(INSERT_SAMPLE_USER,"100","admin@","0000","ENG","20","admin"));
            System.out.println("INSERTADO");
            this.db = db;
        }catch (Exception e){
            System.out.println("ERROR INSERTANDO");
            e.printStackTrace();
        }

    }


    public void deletereg(SQLiteDatabase db){
        System.out.println("DELETEANDO TODO");
        db.execSQL(DELETE_USERS_REGS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //chapuza
        try {
            db.execSQL(DELETE_USERS_TABLE);
            db.execSQL(CREATE_USERS);
            System.out.println("TABLE 'Usuarios': DELETED");
            System.out.println("TABLE 'Usuarios': CREATED AGAIN");

        }catch (Exception e){System.out.println("Error ON DELETE OR CREATE TABLE Usuarios");}

    }
}

