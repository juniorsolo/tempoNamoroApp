package com.junior.tempodenamoro;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textCurrentTime = findViewById(R.id.current_time);
        this.mViewHolder.buttonNextBirthday = findViewById(R.id.button_next_birthday);

        this.mViewHolder.textCurrentTime.setText( this.findTimeDating() );


    }

    private String findTimeDating(){
        LocalDate dateDating = LocalDate.of(2017, Month.OCTOBER,20);
        LocalDate today = LocalDate.now();
        Period period = Period.between(dateDating, today);

        String years = period.getYears() > 1 ? period.getYears() + " anos " : period.getYears() + " ano ";
        String months = period.getMonths() > 1 ? period.getMonths() + " meses " : period.getMonths() + " mês e ";
        String days = period.getDays() > 1 ? period.getDays() + " dias " : period.getDays() + " dia";

        String msg = years + months + days;

        return msg;
    }
    private static class ViewHolder{
        TextView textCurrentTime;
        Button buttonNextBirthday;
    }
}
