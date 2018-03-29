package com.example.pdbsflhr22.shareride;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import java.text.DateFormat;
import java.util.Calendar;

public class AddRide extends AppCompatActivity {
    DateFormat formatDateTime = DateFormat.getDateTimeInstance();
    Calendar datetime = Calendar.getInstance();
    private TextView text;
    private Button btn_date;
    private Button btn_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_ride_activity);
        text =(TextView) findViewById(R.id.txt_datetime);
        btn_date = (Button) findViewById(R.id.btndate);
        btn_time = (Button) findViewById(R.id.btntime);

        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTime();

            }
        });
        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDate();

            }
        });
        updateTextALbel();

    }
    private void updateDate(){
        new DatePickerDialog(this,d,datetime.get(Calendar.YEAR),datetime.get(Calendar.MONTH),datetime.get(Calendar.DAY_OF_MONTH)).show();
    }
    private void updateTime(){
        new TimePickerDialog(this,t,datetime.get(Calendar.HOUR_OF_DAY),datetime.get(Calendar.MINUTE),true).show();
    }
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthofYear, int dayofmonth) {
            datetime.set(Calendar.YEAR,year);
            datetime.set(Calendar.MONTH,monthofYear);
            datetime.set(Calendar.DAY_OF_MONTH,dayofmonth);
            updateTextALbel();
        }
    };
    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourofday, int minute) {

            datetime.set(Calendar.HOUR_OF_DAY,hourofday);
            datetime.set(Calendar.MINUTE,minute);
            updateTextALbel();
        }
    };
    private void updateTextALbel(){
        text.setText(formatDateTime.format(datetime.getTime()));
    }
}
