package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;

import static com.miklesam.dota_manager.YourTeam.Fans;
import static com.miklesam.dota_manager.YourTeam.GoldBalance;

public class Shop extends AppCompatActivity implements BillingProcessor.IBillingHandler {

    ImageView back_from_shopbut;
    ImageView rewardedBut;
    BillingProcessor bp;

    ImageView epic_bttn;
    ImageView rare_bttn;
    ImageView legendary_bttn;

    TextView Goldbalance;
    TextView Fansbalance;

    String Gold;
    String fansbalansed;

    SharedPreferences mSettings;
    boolean lock;


    @Override
    public void onResume() {
        super.onResume();
        if (lock==true)
        {
            Intent k = new Intent(this, MainActivity.class);
            startActivity(k);
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        lock=true;

    }
    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        bp=new BillingProcessor(this,getResources().getString(R.string.pub_key),this);
        bp.initialize();


        final Intent ToMain = new Intent(this, MainActivity.class);
        final Intent ToRewarded = new Intent(this, Rewarded.class);
        rewardedBut=findViewById(R.id.rewarded);
        back_from_shopbut=findViewById(R.id.back_from_shop);
        epic_bttn=findViewById(R.id.epic_bttn);
        rare_bttn=findViewById(R.id.rare_bttn);
        legendary_bttn=findViewById(R.id.legendary_bttn);
        Fansbalance=findViewById(R.id.Fansbalance);
        Goldbalance=findViewById(R.id.Goldbalance);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);

        if(mSettings.contains(GoldBalance)) {

            Gold =mSettings.getString(GoldBalance, "50000");

        }
        if(mSettings.contains(Fans)) {

            fansbalansed =mSettings.getString(Fans, "0");

        }

        Goldbalance.setText(Gold);
        Fansbalance.setText(fansbalansed);

        back_from_shopbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(ToMain);

            }
        });


        epic_bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bp.purchase(Shop.this,"purchase_epic");

            }
        });
        rare_bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bp.purchase(Shop.this,"purchase_some");

            }
        });
        legendary_bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bp.purchase(Shop.this,"purchase_legendary");

            }
        });



        rewardedBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(ToRewarded);

            }
        });



    }


    @Override
    public void onProductPurchased(@NonNull String productId, @Nullable TransactionDetails details) {
        Toast.makeText(getBaseContext(), "Product purchase"+productId, Toast.LENGTH_SHORT).show();
        SharedPreferences.Editor editor = mSettings.edit();
        if(productId.equals("purchase_epic"))
        {
            editor.putString(GoldBalance, String.valueOf(Integer.parseInt(Gold)+5000));
            editor.apply();
            Gold=String.valueOf(Integer.parseInt(Gold)+5000);
            Goldbalance.setText(Gold);
            bp.consumePurchase("purchase_epic");
        }else if(productId.equals("purchase_some"))
        {
            editor.putString(GoldBalance, String.valueOf(Integer.parseInt(Gold)+15000));
            Gold=String.valueOf(Integer.parseInt(Gold)+15000);
            Goldbalance.setText(Gold);
            editor.apply();
            bp.consumePurchase("purchase_some");
        }
        else if(productId.equals("purchase_legendary"))
        {
            editor.putString(GoldBalance, String.valueOf(Integer.parseInt(Gold)+30000));
            editor.apply();
            Gold=String.valueOf(Integer.parseInt(Gold)+30000);
            Goldbalance.setText(Gold);
            bp.consumePurchase("purchase_legendary");
        }

    }

    @Override
    public void onPurchaseHistoryRestored() {

    }

    @Override
    public void onBillingError(int errorCode, @Nullable Throwable error) {
        Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBillingInitialized() {

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(!bp.handleActivityResult(requestCode,resultCode,data))
        {
            super.onActivityResult(requestCode,resultCode,data);
        }
    }

}



