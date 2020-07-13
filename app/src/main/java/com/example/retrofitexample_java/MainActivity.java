package com.example.retrofitexample_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TheAdapter Madapter;
    private RecyclerView MrecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create a handler for the RetrofitInstance interface
        GetData service = My_RetrofitClient.myRetrofitInstance().create(GetData.class);

        Call <List<MyUsers>> call = service.getMyUsers();

        //Execute the request asynchronously
        call.enqueue(new Callback<List<MyUsers>>() {
            @Override
            //Handle the successful response
            public void onResponse(Call<List<MyUsers>> call, Response<List<MyUsers>> response) {
                loadMyList(response.body());

            }

            @Override
            public void onFailure(Call<List<MyUsers>> call, Throwable t) {
                //If the request fails, then display the following toast
                Toast.makeText(MainActivity.this, "Unable to load to the List!!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void loadMyList(List<MyUsers> list) {
        //Get a reference to the RecyclerView and the Adapter.
        MrecyclerView =findViewById(R.id.the_recyclerview);
        Madapter = new TheAdapter(list);

        //set the RecyclerView to the LinearLayoutManager with default vertical orientation
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        MrecyclerView.setLayoutManager(layoutManager);

        //Set the Adapter to the RecyclerView
        MrecyclerView.setAdapter(Madapter);
    }
}