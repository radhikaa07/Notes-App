package com.example.contactsmanagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsmanagerapp.databinding.ContactsListItemBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactViewHolder> {


    private ArrayList<Contacts>contacts;

    public MyAdapter(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ContactsListItemBinding contactsListItemBinding=
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.contacts_list_item,
                        parent,
                        false
                );
        return new ContactViewHolder(contactsListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        Contacts currentContact = contacts.get(position);
        holder.contactListItemBinding.setContact(currentContact);

    }

    @Override
    public int getItemCount() {
        if(contacts!= null)return contacts.size();
        else return 0;
    }

    public void setContacts(ArrayList<Contacts> contacts) {
        this.contacts = contacts;

        notifyDataSetChanged();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{

        private ContactsListItemBinding contactListItemBinding;

        public ContactViewHolder(@NonNull  ContactsListItemBinding contactListItemBinding) {
            super(contactListItemBinding.getRoot());
            this.contactListItemBinding = contactListItemBinding;
        }
    }
}
