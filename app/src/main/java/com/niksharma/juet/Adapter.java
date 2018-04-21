package com.niksharma.juet;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends ArrayAdapter<String>{
    int[] image;
    AppCompatActivity context;
    String[] adi_info;
    public Adapter(AppCompatActivity context,String[] data,int[] image,String[] adi_info)
    {
        super(context,R.layout.list_item,data);
        this.image=image;
        this.context=context;
        this.adi_info=adi_info;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View view =inflater.inflate(R.layout.list_item,null,true);
        ImageView img=view.findViewById(R.id.imageView3);
        TextView text1=view.findViewById(R.id.textView1);
        TextView text2=view.findViewById(R.id.textView2);
        img.setImageResource(image[position]);
        text1.setText(getItem(position));
        text2.setText(adi_info[position]);
        return view;

    }
}
