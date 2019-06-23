package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import static com.miklesam.dota_manager.YourTeam.GoldBalance;

public class Rewarded extends AppCompatActivity implements RewardedVideoAdListener {
    private RewardedVideoAd mRewardedVideoAd;
    TextView reward_text;
    private int get_revard;
    SharedPreferences mSettings;
    String GoldBalancesq;
    Button backsbut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewarded);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        backsbut=findViewById(R.id.backs);
        TextView reward_text=findViewById(R.id.reward_text);
        final Intent ToMain = new Intent(this, MainActivity.class);
        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        loadRewardedVideoAd();
        //reward_text.setText(String.valueOf(Points.point)+" points");
        if(mSettings.contains(GoldBalance)) {

            GoldBalancesq =mSettings.getString(GoldBalance, "0");
        }

        backsbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(ToMain);

            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView reward_text=findViewById(R.id.reward_text);
       // reward_text.setText(String.valueOf(Points.point)+" points");
    }

    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",
                new AdRequest.Builder().build());
    }


    @Override
    public void onRewarded(RewardItem reward) {
       // Points.point=Points.point+10;
        GoldBalancesq=String.valueOf(Integer.parseInt(GoldBalancesq)+1500);
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(GoldBalance, GoldBalancesq);
        editor.apply();

        Toast.makeText(this, "onRewarded! currency: " + reward.getType() + "  amount: " +
                reward.getAmount(), Toast.LENGTH_SHORT).show();




        // Reward the user.
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        Toast.makeText(this, "onRewardedVideoAdLeftApplication",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdClosed() {
        Toast.makeText(this, "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
        Toast.makeText(this, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        Toast.makeText(this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
        mRewardedVideoAd.show();
    }

    @Override
    public void onRewardedVideoAdOpened() {
        Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoStarted() {
        Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoCompleted() {
        Toast.makeText(this, "onRewardedVideoCompleted", Toast.LENGTH_SHORT).show();

    }
}


