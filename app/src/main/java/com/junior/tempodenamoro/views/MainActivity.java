package com.junior.tempodenamoro.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.junior.tempodenamoro.R;
import com.junior.tempodenamoro.util.ExtractTimeFromPeriod;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    private LocalDate dateDating = LocalDate.of(2017, Month.OCTOBER, 20);
    private DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textCurrentTime = findViewById(R.id.current_time);
        this.mViewHolder.buttonNextBirthday = findViewById(R.id.button_next_birthday);
        this.mViewHolder.dateBeginDating = findViewById(R.id.text_begin_dating);
        this.mViewHolder.buttonNextBirthday.setOnClickListener(this);
        this.mViewHolder.textCurrentTime.setText( this.findTimeDating() + " juntos..." );
        this.mViewHolder.dateBeginDating.setText(dtformatter.format(dateDating));

    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_next_birthday){
            Intent intentNextBirthday = new Intent(this,NextBirthdayActivity.class);
            startActivity(intentNextBirthday);
        }
    }
    private String findTimeDating() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(dateDating, today);
        return ExtractTimeFromPeriod.extract(period);
    }

    private static class ViewHolder{
        TextView textCurrentTime;
        Button buttonNextBirthday;
        TextView dateBeginDating;
    }
}
