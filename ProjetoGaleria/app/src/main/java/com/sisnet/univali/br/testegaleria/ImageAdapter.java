package com.sisnet.univali.br.testegaleria;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter{

    private Context contex;

    public Integer[] images = {
        R.drawable.surf_1, R.drawable.surf_2,
            R.drawable.surf_3, R.drawable.surf_4,
            R.drawable.surf_5, R.drawable.surf_6,
            R.drawable.surf_7, R.drawable.surf_8,
            R.drawable.surf_9, R.drawable.surf_10,
            R.drawable.surf_11, R.drawable.surf_12,
            R.drawable.surf_13, R.drawable.surf_14

    };

    public ImageAdapter(Context c){
        contex = c;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(contex);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(imageView.getScaleType().CENTER_INSIDE);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(240,240));
        return imageView;
    }
}
