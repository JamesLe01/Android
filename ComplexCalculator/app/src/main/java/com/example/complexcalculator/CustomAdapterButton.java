package com.example.complexcalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapterButton extends ArrayAdapter<String> {

    ButtonOnClickInterface buttonOnClickInterface;
    public CustomAdapterButton(@NonNull Context context, int resource, @NonNull List<String> objects, ButtonOnClickInterface buttonOnClickInterface) {
        super(context, resource, objects);
        this.buttonOnClickInterface = buttonOnClickInterface;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Button rowView = (Button) convertView;
        if (rowView == null) {
            rowView = (Button) LayoutInflater.from(getContext()).inflate(R.layout.button_listview, parent, false);
            ViewHolder h = new ViewHolder();
            h.btn = rowView;
            h.str = getItem(position);
            rowView.setTag(h);
        }
        ViewHolder h = (ViewHolder) rowView.getTag();
        h.btn.setText(getItem(position));
        h.btn.setOnClickListener(v -> buttonOnClickInterface.Control(getItem(position)));

        return rowView;

    }

    static class ViewHolder {
        String str;
        Button btn;
    }
}
