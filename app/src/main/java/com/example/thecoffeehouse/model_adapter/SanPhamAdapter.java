package com.example.thecoffeehouse.model_adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.thecoffeehouse.R;

import java.util.List;

public class SanPhamAdapter extends ArrayAdapter<DoUong> {
    Activity context;
    int resource;
    List<DoUong> list;

    public SanPhamAdapter(@NonNull Activity context, int resource, List<DoUong> list) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public DoUong getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).getId();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View customView = inflater.inflate(this.resource, null);
        ImageView imghinh = customView.findViewById(R.id.imghinh);
        TextView txtten = customView.findViewById(R.id.txtten);
        TextView txtgia = customView.findViewById(R.id.txtgia);

        DoUong sp = getItem(position);
        String image = sp.getHinh();
        int resId = (context).getResources().getIdentifier(image, "drawable", (context).getPackageName());
        imghinh.setImageResource(resId);
        txtten.setText(sp.getTen());
        txtgia.setText(sp.getGia() + "đ");

        return customView;


    }
}