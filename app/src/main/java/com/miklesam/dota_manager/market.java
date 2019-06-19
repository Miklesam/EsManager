package com.miklesam.dota_manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.miklesam.dota_manager.PlayersInit.CorePlayers;
import static com.miklesam.dota_manager.PlayersInit.PlayersCoreInit;
import static com.miklesam.dota_manager.PlayersInit.PlayersSupportInit;
import static com.miklesam.dota_manager.PlayersInit.SupportPlayers;

public class market extends AppCompatActivity {
    Button Backtomain;
    ListView CorelistView;
    ListView SupportlistView;
    Button CoreChoose;
    Button SupportChoose;
    ArrayList<Players> Cores = new ArrayList<Players>();
    ArrayList<Players> Supports = new ArrayList<Players>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        CorelistView = (ListView)findViewById(R.id.CoreList);
        SupportlistView=(ListView)findViewById(R.id.SupportList);
        final Intent Tomainstate = new Intent(this, mainstate.class);
        Backtomain=findViewById(R.id.Backtomain);
        CoreChoose =findViewById(R.id.Core);
        SupportChoose =findViewById(R.id.Support);




        CorePlayers.clear();
        SupportPlayers.clear();
        Cores=PlayersCoreInit();
        Supports=PlayersSupportInit();
        SupportlistView.setVisibility(View.INVISIBLE);

        final CoreAdapter coreAdapter=new CoreAdapter();
        final suppoportAdapter cupppAdapter = new suppoportAdapter();
        CorelistView.setAdapter(coreAdapter);
        SupportlistView.setAdapter(cupppAdapter);

        Backtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(Tomainstate);



            }
        });

        SupportChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CorelistView.setVisibility(View.INVISIBLE);
                SupportlistView.setVisibility(View.VISIBLE);

            }
        });

        CoreChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CorelistView.setVisibility(View.VISIBLE);
                SupportlistView.setVisibility(View.INVISIBLE);

            }
        });



    }


    class CoreAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Cores.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView=(ImageView)convertView.findViewById(R.id.image);
            TextView textView = (TextView)convertView.findViewById(R.id.Titile);
            TextView Price = (TextView)convertView.findViewById(R.id.Price);

            //imageView.setImageResource(CoreIMAGES[position]);
            //textView.setText(CoreNAMES[position]);
            //Price.setText(CorePriceMoney[position]);


            imageView.setImageResource(Cores.get(position).Flag);
            textView.setText(Cores.get(position).Name);
            Price.setText(String.valueOf(Cores.get(position).Cost));






            return convertView;
        }
    }



    class suppoportAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Supports.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView=(ImageView)convertView.findViewById(R.id.image);
            TextView textView = (TextView)convertView.findViewById(R.id.Titile);
            TextView Price = (TextView)convertView.findViewById(R.id.Price);

            imageView.setImageResource(Supports.get(position).Flag);
            textView.setText(Supports.get(position).Name);
            Price.setText(String.valueOf(Supports.get(position).Cost));
            return convertView;
        }
    }




}
