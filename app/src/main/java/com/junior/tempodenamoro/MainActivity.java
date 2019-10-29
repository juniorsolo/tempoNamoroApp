package com.junior.tempodenamoro;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textCurrentTime = findViewById(R.id.current_time);
        this.mViewHolder.buttonNextBirthday = findViewById(R.id.button_next_birthday);

        this.mViewHolder.textCurrentTime.setText("");

        this.findTimeDating();
    }

    private void findTimeDating(){



    }
    private static class ViewHolder{
        TextView textCurrentTime;
        Button buttonNextBirthday;
    }
}
