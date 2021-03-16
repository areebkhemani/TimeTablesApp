package com.example.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timeTableContainer;

    public void generateTable(int timesTableNumber){
        ArrayList<String> arrayList=new ArrayList<String>();
        for (int j = 1; j<=10; j++)
        {
            arrayList.add(Integer.toString(timesTableNumber * j));
        }

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList );
        timeTableContainer.setAdapter(arrayAdapter);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timeTableSeek = findViewById(R.id.timesTableSeekBar);
         timeTableContainer = findViewById(R.id.timesTableListView);

        timeTableSeek.setMax(20);
        timeTableSeek.setProgress(10);

        timeTableSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNumber;
                if (i<min){
                    timesTableNumber = min;
                    timeTableSeek.setProgress(min);
                    generateTable(timesTableNumber);
                }
                else{
                    timesTableNumber = i;
                }
                Log.i("SeekBar value: ", Integer.toString(timesTableNumber));

            generateTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}