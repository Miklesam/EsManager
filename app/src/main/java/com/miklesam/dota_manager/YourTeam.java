package com.miklesam.dota_manager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class YourTeam extends AppCompatActivity {
    public static final String APP_PREFERENCES_NAME = "TeamName";
    public static final String GoldBalance = "50000";
    public static final String StaticPosition1 = "pos1";
    public static final String StaticPosition2 = "pos2";
    public static final String StaticPosition3 = "pos3";
    public static final String StaticPosition4 = "pos4";
    public static final String StaticPosition5 = "pos5";
    public static final String XPstatic= "xpstatic";
    public static final String Day= "daystatic";
    public static final String Month= "monthstatic";
    public static final String Year= "yearstatic";
    public static final String Mode= "modestatic";

    public static final String OpenTeam1= "open1";
    public static final String OpenTeam2= "open2";
    public static final String OpenTeam3= "open3";
    public static final String OpenTeam4= "open4";
    public static final String OpenTeam5= "open5";
    public static final String OpenTeam6= "open6";
    public static final String OpenTeam7= "open7";

    public static final String OpenScore1= "openscore1";
    public static final String OpenScore2= "openscore2";
    public static final String OpenScore3= "openscore3";
    public static final String OpenScore4= "openscore4";

    public static final String OpenScore5= "openscore5";
    public static final String OpenScore6= "openscore6";
    public static final String OpenScore7= "openscore7";
    public static final String OpenScore8= "openscore8";

    public static final String OpenQuaterFinals= "openquater";
    public static final String OpenSemiFinals= "opensemi";
    public static final String OpenFinals= "openfinals";

    public static final String QuaterWin= "QuaterWin";
    public static final String SemiWin= "SemiWin";
    public static final String FinalsWin= "FinalsWin";

    public static final String OpenScore9= "openscore9";
    public static final String OpenScore10= "openscore10";
    public static final String OpenScore11= "openscore11";
    public static final String OpenScore12= "openscore12";

    public static final String OpenQualiWinner= "OpenQualiWinner";


    public static final String ClosedSeries= "ClosedSeries";

    public static final String Closedwin= "Closedwin";
    public static final String Closedlose= "Closedlose";

    public static final String CloseWin8= "CloseWin8";
    public static final String CloseWin7= "CloseWin7";
    public static final String CloseWin6= "CloseWin6";
    public static final String CloseWin5= "CloseWin5";
    public static final String CloseWin4= "CloseWin4";
    public static final String CloseWin3= "CloseWin3";
    public static final String CloseWin2= "CloseWin2";
    public static final String CloseWin1= "CloseWin1";

    public static final String CloseLose8= "CloseLose8";
    public static final String CloseLose7= "CloseLose7";
    public static final String CloseLose6= "CloseLose6";
    public static final String CloseLose5= "CloseLose5";
    public static final String CloseLose4= "CloseLose4";
    public static final String CloseLose3= "CloseLose3";
    public static final String CloseLose2= "CloseLose2";
    public static final String CloseLose1= "CloseLose1";

    public static final String ExtraLaining= "ExtraLaining";
    public static final String ExtraFarming= "ExtraFarming";
    public static final String ExtraFighting= "ExtraFighting";
    public static final String ExtraLate= "ExtraLate";
    public static final String OpenShaffle= "OpenShaffle";
    public static final String CloseShaffle= "CloseShaffle";


    public static final String CloseTeam1= "close1";
    public static final String CloseTeam2= "close2";
    public static final String CloseTeam3= "close3";
    public static final String CloseTeam4= "close4";
    public static final String CloseTeam5= "close5";
    public static final String CloseTeam6= "close6";
    public static final String CloseTeam7= "close7";

    public static final String TeamPlayoff1= "TeamPlayoff1";
    public static final String TeamPlayoff2= "TeamPlayoff2";
    public static final String TeamPlayoff3= "TeamPlayoff3";
    public static final String TeamPlayoff4= "TeamPlayoff4";


    public static final String ClosedPlayofStage= "ClosedPlayofStage";
    public static final String Fans= "Fans";

    public static final String ClosePlayoff1= "ClosePlayoff1";
    public static final String ClosePlayoff2= "ClosePlayoff2";
    public static final String ClosePlayoff3= "ClosePlayoff3";
    public static final String ClosePlayoff4= "ClosePlayoff4";

    public static final String ClosePlayoff5= "ClosePlayoff5";
    public static final String ClosePlayoff6= "ClosePlayoff6";
    public static final String ClosePlayoff7= "ClosePlayoff7";
    public static final String ClosePlayoff8= "ClosePlayoff8";

    public static final String ClosePlayoff9= "ClosePlayoff9";
    public static final String ClosePlayoff10= "ClosePlayoff10";
    public static final String ClosePlayoff11= "ClosePlayoff11";
    public static final String ClosePlayoff12= "ClosePlayoff12";

    public static final String CloseScore1= "CloseScore1";
    public static final String CloseScore2= "CloseScore2";
    public static final String CloseScore3= "CloseScore3";
    public static final String CloseScore4= "CloseScore4";

    public static final String CloseScore5= "CloseScore5";
    public static final String CloseScore6= "CloseScore6";
    public static final String CloseScore7= "CloseScore7";
    public static final String CloseScore8= "CloseScore8";

    public static final String CloseScore9= "CloseScore9";
    public static final String CloseScore10= "CloseScore10";
    public static final String CloseScore11= "CloseScore11";
    public static final String CloseScore12= "CloseScore12";


    public static final String Series1Win= "Series1Win";
    public static final String Series2Win= "Series2Win";
    public static final String Series3Win= "Series3Win";
    public static final String Series4Win= "Series4Win";
    public static final String Series5Win= "Series5Win";
    public static final String Series6Win= "Series6Win";
    public static final String Series7Win= "Series7Win";
    public static final String Language= "russian";
    public static final String MinorQual= "russian";





    TextView money;
    TextView fans;
    TextView cont;
    TextView infoText;

    SharedPreferences mSettings;
    int languageshare;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_your_team);
        final Intent ChoosePlayer = new Intent(this, PlayerChoose.class);
        final TextView TeamTag=findViewById(R.id.TeamTag);
        TextView Gold=findViewById(R.id.gold);
        ImageView toPlayerChoose = findViewById(R.id.toPlayerChoose);
        mSettings = getSharedPreferences(APP_PREFERENCES_NAME , Context.MODE_PRIVATE);
        mSettings = getSharedPreferences(GoldBalance , Context.MODE_PRIVATE);

        infoText=findViewById(R.id.infoText);
        money=findViewById(R.id.money);
        fans=findViewById(R.id.fans);
        cont=findViewById(R.id.cont);

        final String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("Name");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("Name");
        }


        if(mSettings.contains(Language)) {
            languageshare=Integer.parseInt(mSettings.getString(Language, "0"));
        }
        if(languageshare==2)
        {
            TeamTag.setText("Welcome\n: "+newString);
            Gold.setText("You have only 50,000 rubles\n"+
                    "Recruit players and manage the team\n"+
                    "position 1-3 : Core\n"+
                    "position 4-5: Support");
            infoText.setText("The game has 2 main characteristics");
            money.setText("2.Money");
            fans.setText("1.Fans");
            cont.setText("Every gaming day you are charged an additional amount equal to (number of fans)/100."+"\n"+
                    "Money can be spent on the purchase of players."+"\n"+
                    "You can sell players for half the price."+"\n"+
                    "Every day, apart from competitive ones, you can train, \n" +
                    "they can be both command and individual." +
                    "To train and participate in competitions you must be in full roster. If a player " +
                    "during individual pursuits is streaming, there is an increase in fans, in other cases there is an increase XP, as with team training." +
                    "Earned XP can be spent on improving team performance:"+"\n"+
                    "1.Laining"+"\n"+
                    "2.Farm"+"\n"+
                    "3.Fighting"+"\n"+
                    "4.LateGame"+"\n"+
                    "These characteristics affect the calculation of the battlefield."+"\n"+
                    "The battle calculation is divided into 3 stages:"+"\n"+
                    "1.Laining Stage"+"\n"+
                    "2.Middlegame"+"\n"+
                    "3.Lategame"+"\n"+
                    "Then the winner is displayed."+"\n"+
                    "The tournament variety is not great, and includes only open and closed qualifications in minor and major."+"\n"+
                    "Wishes, suggestions and complaints, please write to my mail:"+"\n"+
                    "mikle.samarkin@gmail.com"
            );


        }
        else
        {
            TeamTag.setText("Добро пожаловать\n: "+newString);
            Gold.setText("У Вас есть 50,000 рублей\n"+
                    "Наймите игроков и управляйте командой\n"+
                    "Позиция 1-3 : Core\n"+
                    "Позиция 4-5: Support");
            infoText.setText("В игре есть имеются 2 основные характеристики:");
            money.setText("2.Деньги");
            fans.setText("1.Фанаты");
            cont.setText("Каждый игровой день Вам начисляется дополнительная сумма, равная (количество фанатов)/100."+"\n"+
                    "Деньги можно тратить на покупку игроков."+"\n"+
                    "Продавать игроков можно за пол цены."+"\n"+
                    "Каждый день кроме соревновательных можно проводить тренировки, они могут быть как командные, так и индивидуальные." +
                    "Тренироваться и учавствовать в соревнованиях можно только в полном составе. Если игрок " +
                    "во время тндивидуальных занятий стримит, идет прирост фанатов, в других случаях идет прирост XP, так же как и при командных тренировках." +
                    "Заработанную XP можно тратить на улучшение характеристик команды:"+"\n"+
                    "1.Laining"+"\n"+
                    "2.Farm"+"\n"+
                    "3.Fighting"+"\n"+
                    "4.LateGame"+"\n"+
                    "Эти характеристики влияют на расчет боя."+"\n"+
                    "Расчет сражения делится на 3 этапа:"+"\n"+
                    "1.Стадия лайнинга"+"\n"+
                    "2.Миддлегейм"+"\n"+
                    "3.Лейтгейм"+"\n"+
                    "После чего выводится победитель."+"\n"+
                    "Турнирное разнообразие не велико, и включает в себя только открытые и закрытые квалификации на минор и на мажор."+"\n"+
                    "Пожелания, предложения а также жалобы, пожалуйста, пишите на мою почту"+"\n"+
                    "mikle.samarkin@gmail.com");


        }





        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(GoldBalance, "50000");
        editor.putString(APP_PREFERENCES_NAME, null);
        editor.putString(Fans, "0");
        editor.apply();





        toPlayerChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChoosePlayer.putExtra("TeamName",newString);
                startActivity(ChoosePlayer);

            }
        });




    }
}
