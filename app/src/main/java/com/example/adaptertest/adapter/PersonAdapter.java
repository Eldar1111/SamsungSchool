package com.example.adaptertest.adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adaptertest.R;
import com.example.adaptertest.model.Person;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Person> people;
    private final LayoutInflater inflater;

    public PersonAdapter(List<Person> people, LayoutInflater inflater) {
        this.people = people;
        this.inflater = inflater;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivImg;
        private TextView tvName;

        private TextView tvMoney;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImg = itemView.findViewById(R.id.iv_img);
            tvName= itemView.findViewById(R.id.tv_name);
            tvMoney= itemView.findViewById(R.id.tv_money);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.person_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int id) {

        Person person = people.get(holder.getAdapterPosition());

        ((ViewHolder)holder).ivImg.setImageResource(person.getFlag_res());
        ((ViewHolder)holder).tvName.setText(person.getName());
        ((ViewHolder)holder).tvMoney.setText(person.getMoney());

        holder.itemView.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =  people.get(holder.getAdapterPosition()).getName();
                String url = "https://www.google.ru/search?q=" + name.replace(" ", "+");
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                ((ViewHolder) holder).ivImg.getContext().startActivity(i);
            }
        }
        );
    }

    @Override
    public int getItemCount() {
        return 100;
    }
}
