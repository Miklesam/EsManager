package com.miklesam.dota_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import static com.miklesam.dota_manager.YourTeam.GoldBalance;
import static com.miklesam.dota_manager.YourTeam.Language;

public class infos extends AppCompatActivity {

    TextView infoText;
    int languageshare;
    boolean lock;
    TextView money;
    TextView fans;
    TextView cont;
    SharedPreferences mSettings;

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
        setContentView(R.layout.activity_infos);

        infoText=findViewById(R.id.infoText);
        money=findViewById(R.id.money);
        fans=findViewById(R.id.fans);
        cont=findViewById(R.id.cont);
        mSettings = getSharedPreferences(GoldBalance, Context.MODE_PRIVATE);
        if(mSettings.contains(Language)) {
            languageshare=Integer.parseInt(mSettings.getString(Language, "0"));
        }
        if(languageshare==2)
        {
            infoText.setText("The game has 2 main characteristics");
            money.setText("2.Money");
            fans.setText("1.Fans");
            cont.setText("Every gaming day you are charged an additional amount equal to (number of fans)/50."+"\n"+
                    "Also you can get money at shop"+"\n"+
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
                    "The tournament variety is not great, and includes only two open and one closed qualifications to minor."+"\n"+
                    "And Minors. If you didn't qualify to Minors, you will play in Some Cup."+"\n"+
                    "Wishes, suggestions and complaints, please write to my mail:"+"\n"+
                    "mikle.samarkin@gmail.com"
            );

        }
        else
        {
            infoText.setText("В игре есть имеются 2 основные характеристики:");
            money.setText("2.Деньги");
            fans.setText("1.Фанаты");
            cont.setText("Каждый игровой день Вам начисляется дополнительная сумма, равная (количество фанатов)/50."+"\n"+
                    "Также деньги можно получить в магазине."+"\n"+
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
                    "Турнирное разнообразие не велико, и включает в себя только две открытые и одну закрытую квалификацию на минор."+"\n"+
                    "И Миноры, если вы не отобрались на минор Вы приглашены на Some Cup."+"\n"+
                    "Пожелания, предложения а также жалобы, пожалуйста, пишите на мою почту:"+"\n"+
                    "mikle.samarkin@gmail.com"
            );
        }

    }
}
