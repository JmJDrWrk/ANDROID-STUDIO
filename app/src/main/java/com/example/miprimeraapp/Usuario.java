package com.example.miprimeraapp;

import java.util.ArrayList;

public class Usuario {
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private int codigo;
    private String name;
    private String email;
    private String language;
    private String age;
    private String pass;

    public Usuario(String name, String surname, String language, String age) {
        this.name = name;
        this.email = surname;
        this.language = language;
        this.age = age;

    }
    public Usuario(int codigo, String name, String surname, String language, String age, String pass) {
        this.codigo = codigo;
        this.name = name;
        this.email = surname;
        this.language = language;
        this.age = age;
        this.pass = pass;
    }

    private static int lastContactId = 0;

    public static ArrayList<Usuario> addUser(String user_data){
        //ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        System.out.println("item: " + user_data);
        String[] splitter = user_data.split(",");
        String name = splitter[0];
        String surname = splitter[1];
        String lang = splitter[2];
        String age = splitter[3];
        System.out.println("name: " + name + "\nsurname: " + surname + "\nlang: " + lang + "\nage:" + age);
        usuarios.add(new Usuario(""+name,surname+"",lang+"", ""+age));
        return usuarios;
    }


    public static ArrayList<Usuario> createContactsList(int numContacts) {
        //ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        for (int i = 1; i <= numContacts; i++) {
            System.out.println("created user: " + i);
            String[] usuarios_datos = new String[] {
                    "Jaime,Roman Gil,ESP,20",
                    "Damian,Ponte Otero,GAL,19",
                    "Gabriel,Roldán Trillo,ESP,20",
                    "Javier,Ceballos,ENG,19",
                    "Rico,Suspenso PSP,ESP,32",
                    "Jose Antonio,Ruca lopez,ESP,35"
            };

            System.out.println("item: " + usuarios_datos[i]);
            String[] splitter = usuarios_datos[i].split(",");
            String name = splitter[0];
            String surname = splitter[1];
            String lang = splitter[2];
            String age = splitter[3];
            System.out.println("name: " + name + "\nsurname: " + surname + "\nlang: " + lang + "\nage:" + age);
            usuarios.add(new Usuario(""+name,surname+"",lang+"", ""+age));
            //usuarios.add(new Usuario("Person " + ++lastContactId,"roman","ESP", ""+20));
        }

        return usuarios;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLanguage() {
        return language;
    }

    public String getAge() {
        return age;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
