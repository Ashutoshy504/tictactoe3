package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] winning={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activePlayer=0;
    boolean game=true;
    GridLayout gridLayout;
    TextView winnerText;
    Button playAgain;
     public void dropView (View view)
     {
         ImageView counter=(ImageView) view;
        // Log.i("Tag", counter.getTag().toString());
         int tappedCounter=Integer.parseInt(counter.getTag().toString());


       //
         if(gameState[tappedCounter]==2&&game) {
             gameState[tappedCounter]=activePlayer;
             counter.setTranslationY(-1500);
             if (activePlayer == 0) {
                 counter.setImageResource(R.drawable.yellow);
                 activePlayer = 1;
             } else {
                 counter.setImageResource(R.drawable.red);
                 activePlayer = 0;
             }
             counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
             for (int[] w : winning) {
                 String win = "";
                 if (gameState[w[0]] == gameState[w[1]] && gameState[w[1]] == gameState[w[2]] && gameState[w[0]] != 2) {
                game=false;
                     if (activePlayer == 1) {
                         win = "Yellow";
                     } else {
                         win = "Red";
                     }
                     Toast.makeText(this, win + " has won", Toast.LENGTH_SHORT).show();
                     winnerText.setText(win+" has won!");
                     winnerText.setVisibility(View.VISIBLE);
                     playAgain.setVisibility(View.VISIBLE);
                 }

             }
                   for(int i=0;i<gameState.length;++i)
                   {
                       if(gameState[i]==2)
                           break;
                       else if(i==8)
                       {      Toast.makeText(this,"TIE",Toast.LENGTH_SHORT).show();
                           winnerText.setText("TIE");
                           winnerText.setVisibility(View.VISIBLE);
                           playAgain.setVisibility(View.VISIBLE);
                           game=false;
                           break;
                       }
                       else
                           continue;
                   }

         }
     }
    public void playAg(View view)
    {
        winnerText.setVisibility(View.INVISIBLE);
        playAgain.setVisibility(View.INVISIBLE);
        for(int i=0;i<gridLayout.getChildCount();i++)
        {
            ImageView counter =(ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }
         for(int i=0;i<gameState.length;i++)
         {
             gameState[i]=2;
         }
         activePlayer=0;
         game=true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playAgain =(Button) findViewById(R.id.button2);
        winnerText=(TextView) findViewById(R.id.textView);
        gridLayout =(GridLayout) findViewById(R.id.gridLayout);
    }
}
