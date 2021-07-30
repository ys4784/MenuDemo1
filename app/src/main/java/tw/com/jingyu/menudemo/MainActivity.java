package tw.com.jingyu.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //ctrl + o 快捷鍵(叫出可以override的方法)
    @Override
    //建立Menu
    public boolean onCreateOptionsMenu(Menu menu) {
        //載入Menu的layout
        getMenuInflater().inflate(R.menu.mymenu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    //功能觸發:點擊時會執行的敘述
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.setting:
                //如果setting被點擊，跳出Toast文字框(顯示在MainActivity , 顯示文字:設定資料 , 顯示時間:SHORT)
                Toast.makeText(MainActivity.this , "設定資料" , Toast.LENGTH_SHORT).show();
                break;

            case R.id.infoMe:
                //getApplicationContext 抓取執行中應用程式的Context(即MainActivity)
                //Toast.makeText(getApplicationContext(),"我的訊息",Toast.LENGTH_SHORT).show();

                //新增跳頁物件
                Intent intent = new Intent(MainActivity.this , MainActivity2.class);
                //執行跳頁
                startActivity(intent);

                break;

            case R.id.logOut:
                //Toast.makeText(getApplicationContext(),"確認登出",Toast.LENGTH_SHORT).show();

                logOut();

            break;

            default:
                //如果是預設，則return父類別的東西
                return super.onOptionsItemSelected(item);
        }
        //如果是其他case，則return true
        return true;
    }

    public void logOut(){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("確認登出")
                .setMessage("請問是否登出")
                .setCancelable(false);

        builder.setNegativeButton("否", (dialog, which) -> {
            Toast.makeText(getApplicationContext(),"取消登出",Toast.LENGTH_SHORT).show();
        });

        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"已登出",Toast.LENGTH_SHORT).show();
            }
        });



        builder.show();
    }


}