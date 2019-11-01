package com.junior.tempodenamoro.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.junior.tempodenamoro.R;
import com.junior.tempodenamoro.util.ExtractTimeFromPeriod;
import com.junior.tempodenamoro.util.GeneratePhrase;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class NextBirthdayActivity extends AppCompatActivity {
    private ViewHolder mViewHolder = new ViewHolder();
    private LocalDate birthdayCurrent;
    private DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_birthday);

        mViewHolder.textTitle = findViewById(R.id.text_title);
        mViewHolder.infoBirthday = findViewById(R.id.text_infoBirthday);
        mViewHolder.nextBirthday = findViewById(R.id.text_nextBirthday);
        mViewHolder.noDia = findViewById(R.id.text_no_dia);
        mViewHolder.dia = findViewById(R.id.text_dia);
        mViewHolder.obs = findViewById(R.id.text_obs);

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.timeDownNextBirthday();
        this.writePhrase();
    }

    private void writePhrase(){
        mViewHolder.obs.setText(GeneratePhrase.Generate());
    }

    private void timeDownNextBirthday(){

        LocalDate today = LocalDate.now();
        birthdayCurrent = LocalDate.of(today.getYear(), Month.OCTOBER,20);

        if(today.isBefore(birthdayCurrent)){
            Period period = Period.between(today, birthdayCurrent);
            mViewHolder.nextBirthday.setText(ExtractTimeFromPeriod.extract(period));
            mViewHolder.dia.setText(dtformatter.format(birthdayCurrent));

        }else if(today.equals(birthdayCurrent)){
            mViewHolder.textTitle.setText("Parabéns");
            mViewHolder.infoBirthday.setText("");
            mViewHolder.nextBirthday.setText("É Hoje nosso Aniversário.");
            mViewHolder.dia.setText("Vamos comemorar...");
            mViewHolder.noDia.setText("");

        } else{
            birthdayCurrent = LocalDate.of(today.getYear()+1, Month.OCTOBER,20);
            Period period = Period.between(today , birthdayCurrent);
            mViewHolder.nextBirthday.setText(ExtractTimeFromPeriod.extract(period));
            mViewHolder.dia.setText(dtformatter.format(birthdayCurrent));
        }

    }

    private static class ViewHolder{
        TextView textTitle;
        TextView infoBirthday;
        TextView nextBirthday;
        TextView noDia;
        TextView dia;
        TextView obs;
    }
}
