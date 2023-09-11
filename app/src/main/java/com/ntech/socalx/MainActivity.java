package com.ntech.socalx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button submitbtn;
    RelativeLayout addpost;
    ImageView closebtn,plusbtn;
    EditText postText,postimage;

    ListView listView;

    HashMap <String,String> hashMap;
    ArrayList <HashMap<String ,String >> arrayList = new ArrayList<>();


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///Them code here /////////////////////////
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);



        closebtn = findViewById(R.id.closebtn);
        submitbtn = findViewById(R.id.submitbtn);
        plusbtn = findViewById(R.id.piusbtn);
        addpost = findViewById(R.id.addpost);

        postText = findViewById(R.id.posteditText);
        postimage = findViewById(R.id.postimage);

        listView = findViewById(R.id.listview);





        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addpost.setVisibility(View.VISIBLE);

            }
        });


        closebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addpost.setVisibility(View.GONE);

            }
        });


        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String spostText = postText.getText().toString();
                String spostimage = postimage.getText().toString();



                hashMap = new HashMap<>();
                hashMap.put("hpostText",spostText);
                hashMap.put("hpostimage",spostimage);
                arrayList.add(hashMap);



                MyAdapter myAdapter = new MyAdapter();
                listView.setAdapter(myAdapter);

                postText.setText("");
                postimage.setText("");
                addpost.setVisibility(View.GONE);





            }
        });






    }
    public  class  MyAdapter extends BaseAdapter{

        TextView textView;
        ImageView imageView;

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("MissingInflatedId")
        @Override
        public View getView(int possoin, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View myview = layoutInflater.inflate(R.layout.post,null);

            textView = myview.findViewById(R.id.ppostText);
            imageView = myview.findViewById(R.id.ppostimage);

            HashMap <String,String> hashMap = arrayList.get(possoin);
            textView.setText(""+hashMap.get("hpostText"));
            String image = hashMap.get("hpostimage");

            if (hashMap.get("hpostimage").length()>0){
                imageView.setVisibility(View.VISIBLE);

                Picasso.get()
                        .load(hashMap.get("hpostimage"))
                        .placeholder(R.drawable.phot)
                        .error(R.drawable.error)
                        .into(imageView);





            }else {


            }



            return myview;
        }
    }



    public void thmu(){


    }
}