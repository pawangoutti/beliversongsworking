package com.pawan.beliverssongs;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {
    TextView t1, t2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Pawan_t", "onCreate: " + this.getClass().getSimpleName());

        setContentView(R.layout.activity_details);
        t1 = findViewById(R.id.nameholder);
        t2 = findViewById(R.id.emailholder);
        //b1=findViewById(R.id.btnback);
        t2.setMovementMethod(new ScrollingMovementMethod());

        t1.setText(getIntent().getStringExtra("utitle").toString());
        // t2.setText(getIntent().getStringExtra("usong").toString());
        String ss = getIntent().getStringExtra("usong").toString();
        String s2 = ss.replaceAll("\\\\n", "\n");

        t2.setText(s2);


        /*
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

        */

    }

    @Override
    protected void onDestroy() {
        Log.d("Pawan_t", "onDestroy: " + this.getClass().getSimpleName());
        super.onDestroy();
    }
}