package com.example.mymvvmproject.View.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymvvmproject.R;


import com.example.mymvvmproject.Service.Model.ProductModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BlogListAdapter extends RecyclerView.Adapter<BlogListAdapter.MyViewHolder>{


    private Context mContext;
    private List<ProductModel> mList;

    public BlogListAdapter(Context mContext, List<ProductModel> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.blog_item, parent, false);



        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.title.setText(mList.get(position).getTitle().toString());
        holder.description.setText(mList.get(position).getDescription().toString());
        Picasso.get().load(mList.get(position).getThumbnail()).into(holder.imageView);



    }

    @Override
    public int getItemCount() {

//        Log.d("myLog", "getItemCount: "+mList.size());
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title, description;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }


}
