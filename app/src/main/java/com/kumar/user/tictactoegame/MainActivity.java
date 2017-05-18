package com.kumar.user.tictactoegame;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buClick(View view) {
        Button buSelected= (Button) view;
        int CellID=0;
        switch ((buSelected.getId())){
            case R.id.but1:
                CellID=1;
                break;
            case R.id.but2:
                CellID=2;
                break;
            case R.id.but3:
                CellID=3;
                break;
            case R.id.but4:
                CellID=4;
                break;
            case R.id.but5:
                CellID=5;
                break;
            case R.id.but6:
                CellID=6;
                break;
            case R.id.but7:
                CellID=7;
                break;
            case R.id.but8:
                CellID=8;
                break;
            case R.id.but9:
                CellID=9;
                break;
        }
        playerGame(CellID,buSelected);
    }
    int activePlayer=1;//1 for first player and 2 for second player

    ArrayList<Integer> player1 = new ArrayList<>(); //hold player1 data
    ArrayList<Integer> player2=new ArrayList<>(); //hold player2 data
    void playerGame(int CellID,Button buSelected){
        Log.d("Player", String.valueOf(CellID));
        if (activePlayer==1) {
            buSelected.setText("X");
            buSelected.setBackgroundColor(Color.GREEN);
            player1.add(CellID);
            activePlayer=2;
        }
        else if (activePlayer==2){
            buSelected.setText("o");
            buSelected.setBackgroundColor(Color.LTGRAY);
            player2.add(CellID);
            activePlayer=1;
        }
        buSelected.setEnabled(false);
        checkWinner();
    }
    void checkWinner(){
        int Winner=-1;
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3) ){
            Winner =1;
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3) ){
            Winner =2;
        }
        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6) ){
            Winner =1;
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6) ){
            Winner =2;
        }
        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9) ){
            Winner =1;
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9) ){
            Winner =2;
        }
        //Col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7) ){
            Winner =1;
        }if (player2.contains(1) && player2.contains(4) && player2.contains(7) ){
            Winner =2;
        }
        //Col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8) ){
            Winner =1;
        }if (player2.contains(2) && player2.contains(5) && player2.contains(8) ){
            Winner =2;
        }
        //Col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9) ){
            Winner =1;
        }if (player2.contains(3) && player2.contains(6) && player2.contains(9) ){
            Winner =2;
        }

        if (Winner!=-1){
            if (Winner==1){
                Toast.makeText(this, "Player 1 is Winner", Toast.LENGTH_SHORT).show();
            }
            if (Winner==2){
                Toast.makeText(this, "Player 2 is Winner", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
