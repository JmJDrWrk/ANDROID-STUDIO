package com.example.miprimeraapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsuarioAdapter extends
        RecyclerView.Adapter<UsuarioAdapter.ViewHolder> {

    @NonNull
    @Override
    public UsuarioAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.user_on_list, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(UsuarioAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Usuario usuario = mUsers.get(position);

        // Set item views based on your views and data model

        TextView nameTxv = holder.nameTv;
        nameTxv.setText(usuario.getName());

        TextView surnameTxv = holder.emailTv;
        surnameTxv.setText(usuario.getEmail());

        TextView langTxv = holder.langTv;
        langTxv.setText(usuario.getLanguage());

        TextView ageTxv = holder.ageTv;
        ageTxv.setText(usuario.getAge());


        //Button button = holder.messageButton;
        //button.setText(usuario.isOnline() ? "Message" : "Offline");
        //button.setEnabled(usuario.isOnline());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mUsers.size();
    }
    // Store a member variable for the contacts
    private List<Usuario> mUsers;

    // Pass in the contact array into the constructor
    public UsuarioAdapter(List<Usuario> contacts) {
        mUsers = contacts;
    }
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTv;
        public TextView emailTv;
        public TextView langTv;
        public TextView ageTv;
       // public Button messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTv = (TextView) itemView.findViewById(R.id.name);
            emailTv = (TextView) itemView.findViewById(R.id.surname);
            langTv = (TextView) itemView.findViewById(R.id.lang);
            ageTv = (TextView) itemView.findViewById(R.id.age);


            //messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
}