package com.example.civilwars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0:iron 1:america 2:empty

    int[] gameState= {2,2,2,2,2,2,2,2,2};

    int[][] winningPositions  = {{0,1,2},{3,4,5},{6,7,8} , {0,3,6} ,{1,4,7} , {2,5,8}, {0,4,8} ,{2,4,6}} ;


    int activePlayer=0;

    boolean gameActive=true;

     public void dropIn (View view) {

         ImageView counter = (ImageView) view;

         int tappedCounter = Integer.parseInt(counter.getTag().toString());

         gameState[tappedCounter]=activePlayer;

         counter.setTranslationY(-1500);

         if (activePlayer == 0) {

                 counter.setImageResource(R.drawable.iron);

                 activePlayer = 1;
             } else {

                 counter.setImageResource(R.drawable.america);

                 activePlayer = 0;
             }


             counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

             for (int[] winningPosition : winningPositions) {
                 if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[2]] != 2) {


                     Toast.makeText(this, "has won", Toast.LENGTH_SHORT).show();
                 }
             }

         }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

