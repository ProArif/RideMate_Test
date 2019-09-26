package com.myres.ariful.ridemate.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.myres.ariful.ridemate.R;
import com.myres.ariful.ridemate.api.ApiClient;
import com.myres.ariful.ridemate.api.ApiInterface;
import com.myres.ariful.ridemate.util.ClientList;
import com.myres.ariful.ridemate.util.ClientModel;
import com.myres.ariful.ridemate.util.ClientsAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Clients extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ClientsAdapter clientsAdapter;
    List<ClientModel> clients;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);

        initComponents();
        loadData();
    }

    private void initComponents() {

        recyclerView =findViewById(R.id.client_recykler);


    }

    private void loadData() {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<ClientList> call = apiService.getClients();
        call.enqueue(new Callback<ClientList>() {
            @Override
            public void onResponse(Call<ClientList> call, Response<ClientList> response) {
                clients = response.body().getClient();
                Log.d(TAG, "Number of movies received: "+clients.size());
                clientsAdapter =new ClientsAdapter(clients,R.layout.clients_item_layout,getApplicationContext());
                layoutManager =new LinearLayoutManager(getApplicationContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(clientsAdapter);
                clientsAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ClientList> call, Throwable t) {
                Log.e(TAG, t.toString());
                Log.d(TAG, "Failed");
            }
        });
    }

}
