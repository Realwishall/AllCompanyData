package com.erdr.atmanirbhar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterRecylerView extends RecyclerView.Adapter<AdapterRecylerView.BatchViewHolder> {

    Context mCtx;
    List<ListRecyclerInView> batchtlist;
    //I am adding extra


    public AdapterRecylerView(Context mCtx, List<ListRecyclerInView> batchtlist) {
        this.mCtx = mCtx;
        this.batchtlist = batchtlist;
    }

    @NonNull
    @Override
    public BatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.layout_recylerview,parent,false);

        BatchViewHolder BatchViewHolder = new BatchViewHolder(view);
        return BatchViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BatchViewHolder holder, int position) {

        ListRecyclerInView Batchdata;
        Batchdata = batchtlist.get(position);
        holder.NameOfCompany.setText(Batchdata.getNameOfCompany());
        Picasso.get()
                .load(Batchdata.getLogoOfCompany())
                .placeholder(R.drawable.ss)
                .error(R.drawable.ss)
                .into(holder.myimg);
        String myIndia = "INDIA:"+Batchdata.getIndiaName();
        holder.IndiaText.setText(myIndia);
        String myChina = "CHINA:"+Batchdata.getChinaName();
        holder.dateText.setText(myChina);

    }

    @Override
    public int getItemCount() {

        return batchtlist.size();
    }

    class BatchViewHolder extends RecyclerView.ViewHolder {

        TextView NameOfCompany;
        ImageView myimg;
        TextView dateText;
        TextView IndiaText;
        public BatchViewHolder(@NonNull View itemView) {
            super(itemView);
            NameOfCompany = itemView.findViewById(R.id.NameOfCompany);
            myimg = itemView.findViewById(R.id.myimg);
            dateText = itemView.findViewById(R.id.dateText);
            IndiaText  = itemView.findViewById(R.id.IndiaText);
        }
    }

}
