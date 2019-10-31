package com.junior.tempodenamoro.views;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.junior.tempodenamoro.R;
import com.junior.tempodenamoro.util.ExtractTimeFromPeriod;
import com.junior.tempodenamoro.util.GeneratePhrases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class NextDatingActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private LocalDate birthdayCurrent;
    private DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_dating);

        mViewHolder.nextBirthday = findViewById(R.id.text_nextBirthday);
        mViewHolder.noDia = findViewById(R.id.text_dia);
        mViewHolder.obs = findViewById(R.id.text_obs);

        //this.writePhrase();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.timeDownNextBirthday();
        this.writePhrase();
    }

    private void writePhrase(){
        mViewHolder.obs.setText(GeneratePhrases.Generate());
    }

    private void timeDownNextBirthday(){

        LocalDate today = LocalDate.now();
        birthdayCurrent = LocalDate.of(today.getYear(), Month.OCTOBER,20);

        if(today.isBefore(birthdayCurrent)){
            Period period = Period.between(today, birthdayCurrent);
            mViewHolder.nextBirthday.setText(ExtractTimeFromPeriod.extract(period));
            mViewHolder.noDia.setText(dtformatter.format(birthdayCurrent));

        }else{
            birthdayCurrent = LocalDate.of(today.getYear()+1, Month.OCTOBER,20);
            Period period = Period.between(today , birthdayCurrent);
            mViewHolder.nextBirthday.setText(ExtractTimeFromPeriod.extract(period));
            mViewHolder.noDia.setText(dtformatter.format(birthdayCurrent));
        }

    }

    private static class ViewHolder{
        TextView nextBirthday;
        TextView noDia;
        TextView obs;
    }

}
