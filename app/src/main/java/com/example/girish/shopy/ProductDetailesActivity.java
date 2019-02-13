package com.example.girish.shopy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductDetailesActivity extends AppCompatActivity {

    TextView textViewName,textViewnameToolbar,textViewdes,textViewprise;
    ImageView productImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detailes);

        textViewName = findViewById(R.id.product_name);
        textViewdes = findViewById(R.id.product_des);
        textViewnameToolbar = findViewById(R.id.product_name_toolbar);
        textViewprise = findViewById(R.id.product_prise);
        productImage = findViewById(R.id.imageView);

        String url = getIntent().getExtras().getString("imangurl");
        String name = getIntent().getExtras().getString("productname");
        String des = getIntent().getExtras().getString("productdes");
        String prise = getIntent().getExtras().getString("productprise");

        textViewName.setText(name);
        textViewnameToolbar.setText(name);
        textViewprise.setText(prise);
        textViewdes.setText(des);
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.choth)
                .into(productImage);


    }
}
