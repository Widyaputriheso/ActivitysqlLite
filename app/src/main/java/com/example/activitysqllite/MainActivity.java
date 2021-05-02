package com.example.activitysqllite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.activitysqllite.Adapter.TemanAdapter;
import com.example.activitysqllite.Database.DBController;
import com.example.activitysqllite.Database.Teman;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TemanAdapter adapter;
    private ArrayList<Teman> temanArrayList;
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

        fab.setOnClick

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
