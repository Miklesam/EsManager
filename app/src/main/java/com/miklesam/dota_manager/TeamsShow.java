package com.miklesam.dota_manager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.miklesam.dota_manager.TeamsInit.AllTeamsInit;

public class TeamsShow extends AppCompatActivity {
    ListView TeamslistView;
    ArrayList<Teams> ThisTeams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_show);

        TeamslistView = (ListView)findViewById(R.id.TeamList);
        ThisTeams=AllTeamsInit();
        final TeamsAdapter teamsAdapter=new TeamsAdapter();


        TeamslistView.setAdapter(teamsAdapter);


    }

    class TeamsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ThisTeams.size();
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

            convertView = getLayoutInflater().inflate(R.layout.teams_layout,null);

            ImageView imageView=(ImageView)convertView.findViewById(R.id.image);
            TextView textView = (TextView)convertView.findViewById(R.id.Titile);


            //imageView.setImageResource(CoreIMAGES[position]);
            //textView.setText(CoreNAMES[position]);
            //Price.setText(CorePriceMoney[position]);


            //imageView.setImageResource(ThisTeams.get(position).Flag);
            textView.setText(ThisTeams.get(position).teamname);
            imageView.setImageResource(ThisTeams.get(position).logo);
            //Price.setText(String.valueOf(Cores.get(position).Cost));






            return convertView;
        }
    }


}
