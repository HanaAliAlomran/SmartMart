package com.example.smartmart;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Bundle;

public class startAct extends AppCompatActivity {
    Button btn_download;
    ProgressBar pb;
    TextView tv_progress;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btn_download=findViewById(R.id.button);
        pb= findViewById(R.id.progressBar);
        tv_progress= findViewById(R.id.textView);
        btn_download.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MyTask t1= new MyTask();
                t1.execute();
            }
        } );
    }
    class MyTask extends AsyncTask<String, Integer, Void>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            pb.setVisibility(View.GONE);
            tv_progress.setVisibility(View.GONE);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            super.onProgressUpdate(values);
            pb.incrementProgressBy(10);
            tv_progress.setText(pb.getProgress()+ "/" + 100);
        }

        @Override
        protected Void doInBackground(String... strings) {
            for (int i = 0; i < 10; i++){
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                publishProgress();
                Intent intent = new Intent(getBaseContext(), HomePage.class);
                startActivity(intent);
            }
            return null;
        }
    }

    private int getProgress() {
        return 0;
    }

    private void incrementProgressBy(int i) {
    }

    private void setVisibility(int gone) {
    }
}
