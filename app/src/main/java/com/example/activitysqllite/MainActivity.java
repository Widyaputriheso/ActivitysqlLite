package com.example.activitysqllite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.activitysqllite.Adapter.TemanAdapter;
import com.example.activitysqllite.Database.DBController;
import com.example.activitysqllite.Database.Teman;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TemanAdapter adapter;
    private ArrayList<Teman> temanArrayList;


    private static final String TAG = MainActivity.class.getSimpleName();
    private static String url_select  = "http://10.0.2.2/umyTI/bacatemen.php";
    public  static final String TAG_ID = "id";
    public  static final String TAG_NAMA = "nama";
    public  static final String TAG_Telpon = "telpon";


    DBController controller = new DBController(this);
    String id,nm,tlp;
    private FloatingActionButton fab;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.floatingBtn);
        BacaData();
        adapter = new TemanAdapter(temanArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TemanBaru.class);
                startActivity(intent);
            }
        });

    }
    public void BacaData(){
        ArrayList<HashMap<String,String>> daftarTeman = controller.getAllTeman();
        temanArrayList = new ArrayList<>();
        //memindah dari hasil query kedalam teman
        for (int i=0;i<daftarTeman.size();i++){
           Teman teman = new Teman();

           teman.setId(daftarTeman.get(i).get("id").toString());
           teman.setNama(daftarTeman.get(i).get("nama").toString());
           teman.setTelpon(daftarTeman.get(i).get("telpon").toString());
           //pindahkan dari kedalam ArrayList teman di adapther
            temanArrayList.add(teman);

        }



    }
}
