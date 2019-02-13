package com.example.girish.shopy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.girish.shopy.Data.Electronics;
import com.example.girish.shopy.Data.ElectronisLit;
import com.example.girish.shopy.R;
import com.example.girish.shopy.adapter.ProductAdapter;
import com.example.girish.shopy.api.RetrofitClient;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClothFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<ElectronisLit> electronisLits;

    private ProductAdapter productAdapter;

    private ShimmerFrameLayout mShimmerViewContainer;

    public ClothFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cloth, container, false);

        mShimmerViewContainer = view.findViewById(R.id.shimmer_view_container);

        recyclerView = view.findViewById(R.id.ele_RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<Electronics> call = RetrofitClient.getInstance().getApi().getAllClothing();

        call.enqueue(new Callback<Electronics>() {
            @Override
            public void onResponse(Call<Electronics> call, Response<Electronics> response) {
                if (response.isSuccessful()){
                    electronisLits = response.body().getProduct();
                    productAdapter = new ProductAdapter(getActivity(),electronisLits);
                    recyclerView.setAdapter(productAdapter);
                    mShimmerViewContainer.stopShimmerAnimation();
                    mShimmerViewContainer.setVisibility(View.GONE);
                }
                }


            @Override
            public void onFailure(Call<Electronics> call, Throwable t) {
                Toast.makeText(getActivity(),"Error = "+t,Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }

}
