package com.example.contactsmanagerapp;
import android.app.Application;
import android.os.Handler;

import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.logging.LogRecord;

public class Repository {

    private final ContactsDAO contactsDAO;
    ExecutorService executor;
    Handler handler;

    public Repository(Application application) {


        ContactDatabase contactDatabase= ContactDatabase.getInstance(application);
        this.contactsDAO = contactDatabase.getContactDAO();
        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());


    }

    public void addContact (Contacts contact){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactsDAO.insert(contact);

            }
        });


        }


    public void deleteContact (Contacts contact){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactsDAO.delete(contact);
            }
        });
    }

    public LiveData<List<Contacts>> getAllContacts(){
        return contactsDAO.getAllContacts();
    }
}
