package com.example.archek.ingroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.archek.ingroup.Model.Offer;
import com.squareup.picasso.Picasso;

public class ExpanseOffer extends MainActivity {

    private static final String EXTRA_OFFER_NAME = "EXTRA_OFFER_NAME";
    private static final String EXTRA_OFFER_DES = "EXTRA_OFFER_DES";
    private static final String EXTRA_OFFER_URL = "EXTRA_OFFER_URL";
    private static final String EXTRA_OFFER_LOGO = "EXTRA_OFFER_LOGO";

    public static Intent makeIntent(Context context, Offer offer){
        return new Intent( context,ExpanseOffer.class)
                .putExtra( ExpanseOffer.EXTRA_OFFER_NAME, offer.getName() )
                .putExtra( ExpanseOffer.EXTRA_OFFER_DES, offer.getDescFull() )
                .putExtra( ExpanseOffer.EXTRA_OFFER_URL, offer.getUrl() )
                .putExtra( ExpanseOffer.EXTRA_OFFER_LOGO, offer.getLogo() );
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.expanse_offer );

        Intent intent = getIntent();
        final String name = intent.getStringExtra( EXTRA_OFFER_NAME );
        final String description = intent.getStringExtra( EXTRA_OFFER_DES );
        final String urlText = intent.getStringExtra( EXTRA_OFFER_URL );
        final String logo = intent.getStringExtra( EXTRA_OFFER_LOGO );
        final Button btnBackExp = findViewById( R.id.btnBack );

        final ImageView ivLogoExp = findViewById( R.id.ivLogoExp );
        final TextView tvNameExp = findViewById( R.id.tvNameExp);
        final TextView tvFullDecExp = findViewById( R.id.tvFullDes);
        final WebView wvUrlExp = findViewById( R.id.wvUrlExp);
        final TextView tvUrlExp = findViewById( R.id.tvUrlExp );

        tvNameExp.setText( name );
        Picasso.get().load( logo).into( ivLogoExp );
        tvFullDecExp.setText( description );
        tvUrlExp.setText( urlText );
        tvUrlExp.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        wvUrlExp.loadUrl(urlText);
                    }
        } );

        btnBackExp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        } );
    }
}
