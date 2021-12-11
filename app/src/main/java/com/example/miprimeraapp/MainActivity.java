package com.example.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private Object MainActivity = this;
    private SQL sqltool;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
    }




    //login_layout.xml login button
    public void login(View view){
        //check if user and password are correct

        //The correct user and password
        String valid_user = "admin";
        String valid_pass = "liceo";

        //edit text objects
        EditText input_user = (EditText) findViewById(R.id.input_user);
        EditText input_pass = (EditText) findViewById(R.id.input_pass);

        //Casting (CharSequence)-->(String) && edit objects content
        String input_user_str = input_user.getText().toString();
        String input_pass_str = input_pass.getText().toString();

        //check if correct
        if(input_user_str.equals(valid_user) && input_pass_str.equals(valid_pass)){
            System.out.println("user and password are correct");
            //go to second view
            setContentView(R.layout.userlist_layout);

            //DATABSE PART
            sqltool = new SQL(this, "UsuariosDB", null, 1);
            db = sqltool.getWritableDatabase();
            sqltool.deletereg(db);
            sqltool.insertesample(db);

            //make example inserts

            //REYCLER VIEW PART
            ArrayList<Usuario> usuarios2 = null;
            ArrayList<Usuario> usuarios;

            //super.onCreate(savedInstanceState);
            setContentView(R.layout.userlist_layout);

            // Lookup the recyclerview in activity layout
            RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvUsers);

            // Initialize contacts
            usuarios = Usuario.createContactsList(5);
           ////MAKE CONSULTA
           Cursor c = sqltool.getReadableDatabase().rawQuery("SELECT codigo, email, pass, idioma, edad , nombre FROM Usuarios", null);


           //COÑO
            System.out.println("TAMAÑOOOOOOOO. " + c.getCount());
                if (c.moveToFirst()) {
                    //Recorremos el cursor hasta que no haya más registros
                    do {
                        System.out.println("user added correctly");
                        int id = c.getInt(0);
                        String email = c.getString(1);
                        String pass = c.getString(2);
                        String idioma = c.getString(3);
                        String edad = c.getString(4);
                        String nombre = c.getString(5);
                        usuarios.add(new Usuario(id, nombre, email, idioma, edad, pass));
                    } while (c.moveToNext());
                }

            // Create adapter passing in the sample user data
            UsuarioAdapter adapter = new UsuarioAdapter(usuarios);
            // Attach the adapter to the recyclerview to populate items
            rvContacts.setAdapter(adapter);
            // Set layout manager to position the items
            rvContacts.setLayoutManager(new LinearLayoutManager(this));



        }else{
            //showing error text
            System.out.println("Error: password or user invalid");
        }

    }


    //userlist_layout.xml new user button
    public void edit(View view){
        System.out.println("Editar informacion de usuario: " + "usuario.getNombre()");
    }
    public void addNewUser(View view){
        System.out.println("adding new user");
        setContentView(R.layout.newuser_layout);


    }
    public void comprobar(View view){
        System.out.println("Evento lanzado");
    }
    public void addCurrentUser(View view){
        System.out.println("acepted");
        EditText email = (EditText) findViewById(R.id.emailtxt);
        EditText pass = (EditText) findViewById(R.id.passtxt);
        EditText age = (EditText) findViewById(R.id.agettxt);
        EditText name = (EditText) findViewById(R.id.userNametxt);

        String u_email = email.getText().toString();
        String u_pass = pass.getText().toString();
        String u_age = age.getText().toString();
        String u_name = name.getText().toString();

        Spinner lang = (Spinner) findViewById(R.id.idiomaSpinner);
        String u_lang = lang.getSelectedItem().toString();

        //System.out.println("u_email: " + u_email + "\nu_pass: " + u_pass + "\nu_age: "< + u_age + "\nu_name: " + u_name);
        setContentView(R.layout.userlist_layout);

        ArrayList<Usuario> usuarios = Usuario.addUser(u_email + "," + u_name + "," + u_lang + "," + u_age);
        ArrayList<Usuario> usuarios2 = new ArrayList<Usuario>();
        String INSERT_SAMPLE_USER = "INSERT INTO Usuarios (codigo, email, pass, idioma, edad, nombre) VALUES ('%s','%s','%s','%s','%s','%s')";

        usuarios.add(new Usuario(100,"admin@","culobu","ENG","20","0000"));

        UsuarioAdapter adapter = new UsuarioAdapter(usuarios);
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvUsers);

        sqltool.insertarUsuario(db, usuarios.get(usuarios.size()-1));



        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);

        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));


    }



    public void deleteSelectedUser(View view){
        //get selected from recycler view
        System.out.println("SELECTED USER IS: " + "NONE IDEA");
    }
}

//visited websites
/*
Reclycler View
https://guides.codepath.com/android/using-the-recyclerview

Xml comments
https://www.tutorialspoint.com/xml/xml_comments.htm



 */