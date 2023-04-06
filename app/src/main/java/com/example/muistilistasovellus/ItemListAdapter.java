package com.example.muistilistasovellus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListHolder>{

    private Context context;

    private ArrayList<Item> items = new ArrayList<>();

    public ItemListAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemListHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListHolder holder, int position) {
        holder.item.setText(items.get(position).getItem());
        holder.note.setText(items.get(position).getNotes());
        holder.txtModifyItem.setText(items.get(position).getItem());
        holder.txtModifyNote.setText(items.get(position).getNotes());

        holder.removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                Storage.getInstance().removeItem(items.get(pos).getItem());
                notifyItemRemoved(pos);
            }
        });

        holder.editItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                if(holder.txtModifyItem.getVisibility() == View.VISIBLE) {
                    Item item = Storage.getInstance().getItemById(pos);
                    item.setItem(String.valueOf(holder.txtModifyItem.getText()));
                    item.setNotes(String.valueOf(holder.txtModifyNote.getText()));
                    holder.txtModifyItem.setVisibility(View.GONE);
                    holder.txtModifyNote.setVisibility(View.GONE);
                    notifyDataSetChanged();
                }
                else {
                    holder.txtModifyItem.setVisibility(View.VISIBLE);
                    holder.txtModifyNote.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
