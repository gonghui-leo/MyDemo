package com.gonghui.mydemo;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyViewModel extends ViewModel {
    private MutableLiveData<User> users;

    public LiveData<User> getUsers() {
        if (users == null) {
            users = new MutableLiveData<>();
            loadUsers();
        }
        return users;
    }

    public void setUsers(String name){
//        users.getValue().setName(name);
//        users.postValue(new User(name) );
        users.setValue(new User(name) );
    }

    private void loadUsers() {
        // Do an asynchronous operation to fetch users.
        users.setValue(new User("111111111111"));
    }
}