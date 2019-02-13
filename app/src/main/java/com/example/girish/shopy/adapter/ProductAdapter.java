package com.example.girish.shopy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.girish.shopy.Data.ElectronisLit;
import com.example.girish.shopy.ProductDetailesActivity;
import com.example.girish.shopy.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private Context context;
    private List<ElectronisLit> electronisLits;

    public ProductAdapter(Context context, List<ElectronisLit> electronisLits) {
        this.context = context;
        this.electronisLits = electronisLits;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_view_items,viewGroup,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        final ElectronisLit electronisLit = electronisLits.get(i);

        productViewHolder.productName.setText(electronisLit.getProductName());
        productViewHolder.product_des.setText(electronisLit.getDes());
        productViewHolder.product_brand.setText(electronisLit.getBrandName());
        productViewHolder.product_prise.setText("₹ : "+electronisLit.getPrise());

        Picasso.get()
                .load(electronisLit.getImgUrl())
                .placeholder(R.drawable.placeholder)
                .into(productViewHolder.imageViewproduct);

        productViewHolder.imageViewproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,ProductDetailesActivity.class);
                i.putExtra("imangurl",electronisLit.getImgUrl());
                i.putExtra("productname",electronisLit.getProductName());
                i.putExtra("productdes",electronisLit.getDes());
                i.putExtra("productprise",electronisLit.getPrise());
                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return electronisLits.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView productName;
        TextView product_des;
        TextView product_brand;
        TextView product_prise;
        ImageView imageViewproduct;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.product_name);
            product_des = itemView.findViewById(R.id.product_des);
            product_brand = itemView.findViewById(R.id.product_brand);
            product_prise = itemView.findViewById(R.id.product_prise);
            imageViewproduct = itemView.findViewById(R.id.image_product);


        }
    }
}