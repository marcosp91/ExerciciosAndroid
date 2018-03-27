package com.sisnet.univali.br.testegaleria;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.github.chrisbanes.photoview.PhotoView;

public class FullImageActivy extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        ImageAdapter adapter = new ImageAdapter((this));

        //ImageView imageView = (ImageView) findViewById(R.id.imageView);
        PhotoView photoView = (PhotoView) findViewById(R.id.imageView);
        photoView.setImageResource(adapter.images[position]);

        View backView = this.getWindow().getDecorView();
        backView.setBackgroundColor(android.R.color.background_dark);
    }

    public void alertaExcluir(View view){
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Excluindo");
        alertDialog.setMessage("Deseja mesmo excluir?");
        alertDialog.show();

    }
}
