package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText heightEditText = findViewById(R.id.heightEditText);
        EditText weightEditText = findViewById(R.id.weightEditText);
        TextView resultTextView = findViewById(R.id.resultTextView);
        Button calculateButton = findViewById(R.id.calculateButton);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String heightStr = heightEditText.getText().toString();
                String weightStr = weightEditText.getText().toString();


                if (!heightStr.isEmpty() && !weightStr.isEmpty()) {

                    float height = Float.parseFloat(heightStr);
                    float weight = Float.parseFloat(weightStr);
                    float bmi = weight / (height * height);


                    DecimalFormat df = new DecimalFormat("0.00");
                    String bmiStr = df.format(bmi);


                    resultTextView.setText("您的BMI值是：" + bmiStr);
                    if (bmi < 18.5) {
                        resultTextView.append("\n您的体重过轻，建议增加营养。");
                    } else if (bmi < 24) {
                        resultTextView.append("\n您的体重正常，继续保持。");
                    } else if (bmi < 28) {
                        resultTextView.append("\n您的体重过重，建议控制饮食。");
                    } else {
                        resultTextView.append("\n您的体重肥胖，建议加强锻炼。");
                    }
                } else {
                    resultTextView.setText("请输入有效的身高和体重数据。");
                }
            }
        });
    }
}

