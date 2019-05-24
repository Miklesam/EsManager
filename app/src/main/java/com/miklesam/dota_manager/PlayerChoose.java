package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.StaticPosition1;
import static com.miklesam.dota_manager.YourTeam.StaticPosition2;
import static com.miklesam.dota_manager.YourTeam.StaticPosition3;
import static com.miklesam.dota_manager.YourTeam.StaticPosition4;
import static com.miklesam.dota_manager.YourTeam.StaticPosition5;

public class PlayerChoose extends AppCompatActivity {


    String CoreNAMES[]={"Ramzes","NoOne","9pasha","Daxak","Afoninje","AfterLife",
            "Crystallize","Magical","Blizzy","Silent","Cooman","nongrata",
            "dream'","Kodos","Maden","illidan","G","633",
            "Palantimos","Pikachu","chshrct","Something","Something","Something",
            "Something","Something","Something"};

    String CorePriceMoney[]={"1000","1000","1000","1000","1000","1000",
            "1000","1000","1000","1000","1000","1000",
            "Something","Something","Something","Something","Something","Something",
            "Something","Something","Something","Something","Something","Something",
            "Something","Something","Something"};


    int[] CoreIMAGES={R.drawable.russia4020,R.drawable.ukraine4020,R.drawable.russia4020,
            R.drawable.russia4020,R.drawable.russia4020,R.drawable.russia4020,R.drawable.ukraine4020,
            R.drawable.ukraine4020,R.drawable.kirgistan4020,R.drawable.russia4020,R.drawable.russia4020,
            R.drawable.russia4020,R.drawable.kirgistan4020,R.drawable.russia4020,R.drawable.russia4020,
            R.drawable.russia4020,R.drawable.russia4020,
            R.drawable.russia4020,R.drawable.belarus4020,R.drawable.ukraine4020,R.drawable.belarus4020,
            R.drawable.russia4020,R.drawable.russia4020,R.drawable.russia4020,R.drawable.russia4020,
            R.drawable.russia4020,R.drawable.russia4020};


    String SupportNAMES[]={"Solo","Rodjer","Fng","Immersion","SoNNeikO","Zayac",
            "Lil","NoFear","sayuw","KingR","velheor","Vanskor",
            "Bignum","BLACKARXANGEL","Something","Something","Something","Something",
            "Something","Something","Something","Something","Something","Something",
            "Something","Something","Something"};

    String SupportPriceMoney[]={"1000","1000","1000","1000","1000","1000",
            "1000","1000","1000","1000","1000","1000",
            "1000","1000","1000","1000","1000","1000",
            "Something","Something","Something","Something","Something","Something",
            "Something","Something","Something"};


    int[] SupportIMAGES={R.drawable.russia4020,R.drawable.russia4020,R.drawable.belarus4020,
            R.drawable.russia4020,R.drawable.russia4020,R.drawable.kirgistan4020,R.drawable.ukraine4020,
            R.drawable.russia4020,R.drawable.russia4020,R.drawable.russia4020,R.drawable.russia4020,
            R.drawable.russia4020,R.drawable.ukraine4020,R.drawable.kazahstan4020,R.drawable.russia4020,
            R.drawable.russia4020,R.drawable.russia4020,
            R.drawable.russia4020,R.drawable.russia4020,R.drawable.russia4020,R.drawable.russia4020,
            R.drawable.russia4020,R.drawable.russia4020,R.drawable.russia4020,R.drawable.russia4020,
            R.drawable.russia4020,R.drawable.russia4020};






    ListView CorelistView;
    ListView SupportlistView;
    Button CoreChoose;
    Button SupportChoose;
    LinearLayout PlayerInformation;
    TextView PlayerNickName;
    TextView PlayerDiscription;
    ImageView FlagIma;
    TextView GoldbalancePole;

    TextView position1;
    TextView position2;
    TextView position3;
    TextView position4;
    TextView position5;

    Button Buy_Yes;
    Button Buy_No;
    Button Pos1;
    Button Pos2;
    Button Pos3;
    Button Back;
    String balancegold;
    SharedPreferences mSettings;

    boolean team[]=new boolean[5];

    boolean CorePick;
    boolean SupportPick;
    boolean sup_pick;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_player_choose);
        final Button NextStage = findViewById(R.id.NextStage);
        CoreChoose =findViewById(R.id.Core);
        SupportChoose =findViewById(R.id.Support);
        PlayerInformation=findViewById(R.id.PlayerInfo);
        FlagIma=findViewById(R.id.FlagImage);
        PlayerNickName=findViewById(R.id.Nickname);
        PlayerDiscription=findViewById(R.id.Description);
        Buy_Yes=findViewById(R.id.Buy_Yes);
        Buy_No=findViewById(R.id.Buy_No);
        Pos1=findViewById(R.id.Pos1);
        Pos2=findViewById(R.id.Pos2);
        Pos3=findViewById(R.id.Pos3);
        Back=findViewById(R.id.Back);
        GoldbalancePole=findViewById(R.id.Goldbalance);
        balancegold=GoldBalance;
        GoldbalancePole.setText("Золото "+balancegold);

        position1=findViewById(R.id.position1);
        position2=findViewById(R.id.position2);
        position3=findViewById(R.id.position3);
        position4=findViewById(R.id.position4);
        position5=findViewById(R.id.position5);


        final Intent Tomainstate = new Intent(this, mainstate.class);

        CorelistView = (ListView)findViewById(R.id.CoreList);
        SupportlistView=(ListView)findViewById(R.id.SupportList);

        SupportlistView.setVisibility(View.INVISIBLE);

        CustomAdapter customAdapter=new CustomAdapter();
        SupportAdapter mysupAdapter=new SupportAdapter();
        CorelistView.setAdapter(customAdapter);
        SupportlistView.setAdapter(mysupAdapter);

        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);



        CorelistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CorePick=true;
                CorelistView.setVisibility(View.INVISIBLE);
                CoreChoose.setVisibility(View.INVISIBLE);
                SupportChoose.setVisibility(View.INVISIBLE);
                PlayerInformation.setVisibility(View.VISIBLE);
                PlayerNickName.setText(CoreNAMES[position]);
                PlayerDiscription.setText(CorePriceMoney[position]);
                FlagIma.setImageResource(CoreIMAGES[position]);

            }
        });


        SupportlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SupportPick=true;
                SupportlistView.setVisibility(View.INVISIBLE);
                CoreChoose.setVisibility(View.INVISIBLE);
                SupportChoose.setVisibility(View.INVISIBLE);
                PlayerInformation.setVisibility(View.VISIBLE);
                PlayerNickName.setText(SupportNAMES[position]);
                PlayerDiscription.setText(SupportPriceMoney[position]);
                FlagIma.setImageResource(SupportIMAGES[position]);

            }
        });







        NextStage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(GoldBalance, balancegold);
                editor.putString(StaticPosition1, (String) position1.getText());
                editor.putString(StaticPosition2, (String) position2.getText());
                editor.putString(StaticPosition3, (String) position3.getText());
                editor.putString(StaticPosition4, (String) position4.getText());
                editor.putString(StaticPosition5, (String) position5.getText());

                editor.apply();

         Tomainstate.putExtra("Position1",position1.getText());
                Tomainstate.putExtra("Position2",position2.getText());
                Tomainstate.putExtra("Position3",position3.getText());
                Tomainstate.putExtra("Position4",position4.getText());
                Tomainstate.putExtra("Position5",position5.getText());
           startActivity(Tomainstate);

            }
        });


        Buy_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CorelistView.setVisibility(View.VISIBLE);
                CoreChoose.setVisibility(View.VISIBLE);
                SupportChoose.setVisibility(View.VISIBLE);
                PlayerInformation.setVisibility(View.INVISIBLE);
                SupportPick=false;
                CorePick=false;


            }
        });


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CorelistView.setVisibility(View.VISIBLE);
                CoreChoose.setVisibility(View.VISIBLE);
                SupportChoose.setVisibility(View.VISIBLE);
                PlayerInformation.setVisibility(View.INVISIBLE);
                SupportPick=false;
                CorePick=false;
                Pos1.setVisibility(View.INVISIBLE);
                Pos2.setVisibility(View.INVISIBLE);
                Pos3.setVisibility(View.INVISIBLE);
                Back.setVisibility(View.INVISIBLE);
                Buy_Yes.setVisibility(View.VISIBLE);
                Buy_No.setVisibility(View.VISIBLE);

                if (sup_pick==true)
                {
                    sup_pick=false;
                    Pos2.setText("Позиция 2");
                    Pos3.setText("Позиция 3");
                }




            }
        });


        Buy_Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CorelistView.setVisibility(View.VISIBLE);
                //CoreChoose.setVisibility(View.VISIBLE);
                //SupportChoose.setVisibility(View.VISIBLE);
                //PlayerInformation.setVisibility(View.INVISIBLE);
                //balancegold=String.valueOf(Integer.parseInt(balancegold)-1000);
                //GoldbalancePole.setText("Золото "+balancegold);

                if(CorePick==true)
                {
                    Pos1.setVisibility(View.VISIBLE);
                    Pos2.setVisibility(View.VISIBLE);
                    Pos3.setVisibility(View.VISIBLE);
                    Back.setVisibility(View.VISIBLE);

                    Buy_Yes.setVisibility(View.INVISIBLE);
                    Buy_No.setVisibility(View.INVISIBLE);

                }
                else if (SupportPick==true)
                {
                    sup_pick=true;
                    Pos2.setText("Позиция 4");
                    Pos2.setVisibility(View.VISIBLE);

                    Pos3.setText("Позиция 5");
                    Pos3.setVisibility(View.VISIBLE);
                    Back.setVisibility(View.VISIBLE);

                    Buy_Yes.setVisibility(View.INVISIBLE);
                    Buy_No.setVisibility(View.INVISIBLE);

                }



            }
        });


        Pos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (team[0]==false)
                {
                    position1.setText(PlayerNickName.getText());
                    balancegold= String.valueOf(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerDiscription.getText()));
                    GoldbalancePole.setText("Золото "+balancegold);
                    team[0]=true;
                    CorelistView.setVisibility(View.VISIBLE);
                    CoreChoose.setVisibility(View.VISIBLE);
                    SupportChoose.setVisibility(View.VISIBLE);
                    PlayerInformation.setVisibility(View.INVISIBLE);
                    Back.setVisibility(View.INVISIBLE);


                    Pos1.setVisibility(View.INVISIBLE);
                    Pos2.setVisibility(View.INVISIBLE);
                    Pos3.setVisibility(View.INVISIBLE);
                    Buy_Yes.setVisibility(View.VISIBLE);
                    Buy_No.setVisibility(View.VISIBLE);
                    SupportPick=false;
                    CorePick=false;

                    if((team[0]&team[1]&team[2]&team[3]&team[4])==true)
                    {
                       NextStage.setVisibility(View.VISIBLE);
                    }
                }

                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Позиция Занята", Toast.LENGTH_SHORT);
                    toast.show();
                }



            }
        });

        Pos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sup_pick==true)
                {

                    if(team[3]==false)
                    {
                        position4.setText(PlayerNickName.getText());
                        team[3]=true;
                        balancegold= String.valueOf(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerDiscription.getText()));
                        GoldbalancePole.setText("Золото "+balancegold);
                        CorelistView.setVisibility(View.VISIBLE);
                        CoreChoose.setVisibility(View.VISIBLE);
                        SupportChoose.setVisibility(View.VISIBLE);
                        PlayerInformation.setVisibility(View.INVISIBLE);
                        Pos2.setText("Позиция 2");
                        Pos3.setText("Позиция 3");
                        sup_pick=false;
                        Back.setVisibility(View.INVISIBLE);
                        Pos1.setVisibility(View.INVISIBLE);
                        Pos2.setVisibility(View.INVISIBLE);
                        Pos3.setVisibility(View.INVISIBLE);
                        Buy_Yes.setVisibility(View.VISIBLE);
                        Buy_No.setVisibility(View.VISIBLE);
                        SupportPick=false;
                        CorePick=false;
                        if((team[0]&team[1]&team[2]&team[3]&team[4])==true)
                        {
                            NextStage.setVisibility(View.VISIBLE);
                        }
                    }
                    else
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Позиция Занята", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                }
                else
                {


                    if (team[1]==false)
                    {
                        position2.setText(PlayerNickName.getText());
                        team[1]=true;
                        CorelistView.setVisibility(View.VISIBLE);
                        CoreChoose.setVisibility(View.VISIBLE);
                        SupportChoose.setVisibility(View.VISIBLE);
                        PlayerInformation.setVisibility(View.INVISIBLE);
                        Back.setVisibility(View.INVISIBLE);
                        balancegold= String.valueOf(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerDiscription.getText()));
                        GoldbalancePole.setText("Золото "+balancegold);

                        Pos1.setVisibility(View.INVISIBLE);
                        Pos2.setVisibility(View.INVISIBLE);
                        Pos3.setVisibility(View.INVISIBLE);
                        Buy_Yes.setVisibility(View.VISIBLE);
                        Buy_No.setVisibility(View.VISIBLE);
                        SupportPick=false;
                        CorePick=false;
                        if((team[0]&team[1]&team[2]&team[3]&team[4])==true)
                        {
                            NextStage.setVisibility(View.VISIBLE);
                        }
                    }

                    else
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Позиция Занята", Toast.LENGTH_SHORT);
                        toast.show();
                    }




                }



            }
        });


        Pos3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sup_pick==true)
                {

                    if(team[4]==false)
                    {
                        position5.setText(PlayerNickName.getText());
                        team[4]=true;
                        CorelistView.setVisibility(View.VISIBLE);
                        CoreChoose.setVisibility(View.VISIBLE);
                        SupportChoose.setVisibility(View.VISIBLE);
                        PlayerInformation.setVisibility(View.INVISIBLE);
                        Pos2.setText("Позиция 2");
                        Pos3.setText("Позиция 3");
                        sup_pick=false;
                        balancegold= String.valueOf(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerDiscription.getText()));
                        GoldbalancePole.setText("Золото "+balancegold);
                        Back.setVisibility(View.INVISIBLE);
                        Pos1.setVisibility(View.INVISIBLE);
                        Pos2.setVisibility(View.INVISIBLE);
                        Pos3.setVisibility(View.INVISIBLE);
                        Buy_Yes.setVisibility(View.VISIBLE);
                        Buy_No.setVisibility(View.VISIBLE);
                        SupportPick=false;
                        CorePick=false;
                        if((team[0]&team[1]&team[2]&team[3]&team[4])==true)
                        {
                            NextStage.setVisibility(View.VISIBLE);
                        }
                    }
                    else
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Позиция Занята", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                }
                else
                {


                    if (team[2]==false)
                    {
                        position3.setText(PlayerNickName.getText());
                        team[2]=true;
                        CorelistView.setVisibility(View.VISIBLE);
                        CoreChoose.setVisibility(View.VISIBLE);
                        SupportChoose.setVisibility(View.VISIBLE);
                        PlayerInformation.setVisibility(View.INVISIBLE);
                        Back.setVisibility(View.INVISIBLE);
                        balancegold= String.valueOf(Integer.parseInt(balancegold)- Integer.parseInt((String) PlayerDiscription.getText()));
                        GoldbalancePole.setText("Золото "+balancegold);

                        Pos1.setVisibility(View.INVISIBLE);
                        Pos2.setVisibility(View.INVISIBLE);
                        Pos3.setVisibility(View.INVISIBLE);
                        Buy_Yes.setVisibility(View.VISIBLE);
                        Buy_No.setVisibility(View.VISIBLE);
                        SupportPick=false;
                        CorePick=false;
                        if((team[0]&team[1]&team[2]&team[3]&team[4])==true)
                        {
                            NextStage.setVisibility(View.VISIBLE);
                        }
                    }

                    else
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Позиция Занята", Toast.LENGTH_SHORT);
                        toast.show();
                    }




                }



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


    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return CoreNAMES.length;
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

            imageView.setImageResource(CoreIMAGES[position]);
            textView.setText(CoreNAMES[position]);
            Price.setText(CorePriceMoney[position]);
            return convertView;
        }
    }








    class SupportAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return SupportNAMES.length;
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

            imageView.setImageResource(SupportIMAGES[position]);
            textView.setText(SupportNAMES[position]);
            Price.setText(SupportPriceMoney[position]);
            return convertView;
        }
    }





}
