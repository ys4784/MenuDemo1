package tw.com.jingyu.menudemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private Button endBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        endBtn = findViewById(R.id.endBtn);
        endBtn.setOnClickListener(v -> {
            finish();//關閉此頁
        });
    }
}