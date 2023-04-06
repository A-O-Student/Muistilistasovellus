package com.example.muistilistasovellus;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemListHolder extends RecyclerView.ViewHolder {

    TextView item, note;
    ImageView removeItem, editItem;

    EditText txtModifyItem, txtModifyNote;

    public ItemListHolder(@NonNull View itemView) {
        super(itemView);
        item = itemView.findViewById(R.id.txtItem);
        note = itemView.findViewById(R.id.txtNote);

        removeItem = itemView.findViewById(R.id.removeItem);
        editItem = itemView.findViewById(R.id.editItem);
        txtModifyItem = itemView.findViewById(R.id.txtModifyItem);
        txtModifyNote = itemView.findViewById(R.id.txtModifyNote);

    }
}
