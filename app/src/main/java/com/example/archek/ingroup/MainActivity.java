package com.example.archek.ingroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.archek.ingroup.Model.ObjectResponse;
import com.example.archek.ingroup.Model.Offer;
import com.example.archek.ingroup.Net.OfferService;
import com.example.archek.ingroup.Net.RestApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AnyAdapter.Callback {

    AnyAdapter adapter = new AnyAdapter( this );//initiate variables
    TextView tvIdApi;
    TextView tvNameApp;
    TextView tvInfoApp;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        tvIdApi = findViewById( R.id.tvIdApi );
        tvNameApp = findViewById( R.id.tvNameApp );
        tvInfoApp = findViewById( R.id.tvInfoApi );
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);//instal recycler view, adapter, layout manager
        recyclerView.setAdapter(adapter);

        OfferService service = RestApi.createService(OfferService.class);//instal connect internet
        Call<ObjectResponse> call = service.getOffers(); //Call with models for REST - for json parsing

        if(call != null && call.isExecuted()) return;
        //noinspection ConstantConditions
        call.enqueue( new Callback<ObjectResponse>() {//start subtread for loading response from server
            @Override
            public void onResponse(Call<ObjectResponse> call, Response<ObjectResponse> response) {
                if (response.body() != null) {
                    ObjectResponse objectResponse = response.body();
                    tvIdApi.setText( Integer.toString(objectResponse.getId()) );//load head our list
                    tvNameApp.setText( objectResponse.getName() );
                    tvInfoApp.setText( objectResponse.getInfo() );
                    adapter.replaceAll( objectResponse.getOffers() );//load massive in adapter(recycler view)
                }
            }

            @Override
            public void onFailure(Call <ObjectResponse> call, Throwable t) {
                if(call.isCanceled()){
                    Toast.makeText( MainActivity.this, R.string.error, Toast.LENGTH_SHORT ).show();//message error

                }
            }
        } );

    }

    @Override
    public void onOfferClick(Offer offer){//onClicker for start 2nd activity
        Intent intent = ExpanseOffer.makeIntent(this, offer);
        startActivity( intent );
    }


}



