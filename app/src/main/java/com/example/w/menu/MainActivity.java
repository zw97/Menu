package com.example.w.menu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements PopupMenu.OnMenuItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //注册上下文菜单

        TextView textView=(TextView)findViewById(R.id.textview);
        registerForContextMenu(textView);


    }

    //扩充菜单资源，将XML文件转换为可编程对象

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //当系统选择一个菜单项时，系统调用该函数
    //用来处理菜单单击事件

    public boolean onOptionItemSelected(MenuItem item){
        int id=item.getItemId();
        switch(id){

            //菜单选项
            case R.id.action_settings:
                Toast.makeText(this,"settings",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_another:
                Toast.makeText(this,"another",Toast.LENGTH_SHORT).show();
                break;
            //上下文菜单

            case R.id.actions_name:
                Toast.makeText(this,"name",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_age:
                Toast.makeText(this, "age", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    //当注册后的界面元素收到长按事件后，系统调用该函数创建菜单


    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_content,menu);
    }




    //当用户单击弹出菜单选项，调用该方法


    public boolean onMenuItemClick(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case R.id.action_dream:
                Toast.makeText(this,"dream",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_reality:
                Toast.makeText(this,"reality",Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }

    //将监听器注册到菜单上

    public void showPopup(View v){
        PopupMenu popup=new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_popup);
        popup.show();
    }


}
