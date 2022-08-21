package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText firstName,secondName;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName=findViewById(R.id.firstName);
        secondName=findViewById(R.id.secondName);
        save=findViewById(R.id.saveToDB);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "RoomDB").allowMainThreadQueries().build();
                UserDao userDao = db.userDao();
                userDao.insert(new User(2,firstName.getText().toString(),secondName.getText().toString()));
                firstName.setText("");
                secondName.setText("");


            }
        });


    }
}