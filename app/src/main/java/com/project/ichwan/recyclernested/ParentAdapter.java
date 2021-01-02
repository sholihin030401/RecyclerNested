package com.project.ichwan.recyclernested;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.HolderItem> {

    RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    List<Parents> parentsList;

    public ParentAdapter(List<Parents> parentsList) {
        this.parentsList = parentsList;
    }

    @NonNull
    @Override
    public ParentAdapter.HolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_parent,parent,false);

        return new HolderItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentAdapter.HolderItem holder, int position) {
        holder.txtitles.setText(parentsList.get(position).getTxtitle());

        Parents parents = parentsList.get(position);

        LinearLayoutManager manager = new LinearLayoutManager(holder.rvsubmain.getContext(),LinearLayoutManager.VERTICAL,false);
        manager.setInitialPrefetchItemCount(parents.getListChild().size());
        ChildItemAdapter adapter = new ChildItemAdapter(parents.getListChild());
        holder.rvsubmain.setLayoutManager(manager);
        holder.rvsubmain.setAdapter(adapter);
        holder.rvsubmain.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return parentsList.size();
    }

    public class HolderItem extends RecyclerView.ViewHolder {

        TextView txtitles;
        RecyclerView rvsubmain;

        public HolderItem(@NonNull View itemView) {
            super(itemView);

            txtitles = itemView.findViewById(R.id.txtitle);

            rvsubmain = itemView.findViewById(R.id.recycler_submain);
        }
    }
}
