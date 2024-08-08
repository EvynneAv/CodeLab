package com.example.androidlab.recycleViewExample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidlab.R;

import java.util.List;

public class AdapterRv extends RecyclerView.Adapter<AdapterRv.MyViewHolder>{
    private List<Time> times;


    public AdapterRv(List<Time> times){
        this.times = times;
    }

    @NonNull
    @Override
    public AdapterRv.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_example_recyclerview,parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        Time time = times.get(position);
        holder.nome.setText(time.getNome());
        String emblemaName = time.getEmblema();
        int emblemaId = context.getResources().getIdentifier(emblemaName, "drawable", context.getPackageName());

        if (emblemaId != 0) {
            holder.emblema.setImageDrawable(context.getDrawable(emblemaId));
        } else {
            // Define uma imagem padrão caso o recurso não seja encontrado
            holder.emblema.setImageDrawable(context.getDrawable(R.drawable.ic_launcher_foreground));
        }
//        String emblemaName = time.getEmblema();
//        int emblemaId = context.getResources().getIdentifier(emblemaName, "drawable", context.getPackageName());
//        holder.emblema.setImageDrawable(context.getDrawable(emblemaId));

    }

    @Override
    public int getItemCount() {
        return times.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nome;
        ImageView emblema;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.tv_nomeTime);
            emblema = itemView.findViewById(R.id.iv_emblema);


        }
    }
}

