package com.example.arrayadapteri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;

public class omaAdapteri extends ArrayAdapter<Date>{

    private int line_layout;
    private int textviewid;
    private ArrayList<Date> lista;
    private LayoutInflater inflater;

    public omaAdapteri(@NonNull Context context, int resource, int textViewResourceId, @NonNull ArrayList<Date> objects) {
        super(context, resource, textViewResourceId, objects);

        line_layout = resource;
        textviewid = textViewResourceId;
        lista = objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(line_layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(lista.get(position).toString());

        // Delete button
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista.remove(position);
                notifyDataSetChanged();
            }
        });

        return super.getView(position, convertView, parent);
    }

    public class ViewHolder {
        private TextView textView;
        private Button button;

        public ViewHolder(View v){
            textView = v.findViewById(textviewid);
            button = v.findViewById(R.id.button2);
        }
    }
}
