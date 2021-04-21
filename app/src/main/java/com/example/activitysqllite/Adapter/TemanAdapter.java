package com.example.activitysqllite.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.activitysqllite.Database.Teman;
import com.example.activitysqllite.R;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.TemanViewHolder> {
    private ArrayList<Teman> listdata;

    public TemanAdapter(ArrayList<Teman> listdata) {
        this.listdata = listdata;
    }

    @Override
    public TemanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_teman,parent,false);
        return new TemanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemanViewHolder holder, int position) {
        String nm,tlp;

        nm = listdata.get(position).getNama();
        tlp =listdata.get(position).getTelpon();

        holder.namaTxt.setText(nm);
        holder.telponTxt.setText(tlp);

    }

    @Override
    public int getItemCount() {
        return (listdata !=null)?listdata.size() : 0 ;
    }

    public class TemanViewHolder extends RecyclerView.ViewHolder {
        private CardView Cardku ;
        private TextView namaTxt,telponTxt;
        public TemanViewHolder(View view) {
            super(view);
            Cardku = (CardView) view.findViewById(R.id.kartuku);
                    namaTxt = (TextView) view.findViewById(R.id.textTelpon);
                    telponTxt = (TextView) view.findViewById(R.id.textTelpon);
        }
    }
}
