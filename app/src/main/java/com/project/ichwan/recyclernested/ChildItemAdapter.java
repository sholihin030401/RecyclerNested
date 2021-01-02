package com.project.ichwan.recyclernested;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChildItemAdapter extends RecyclerView.Adapter<ChildItemAdapter.HolderSubitem> {

    ArrayList<Childs> list;

    public ChildItemAdapter(ArrayList<Childs> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ChildItemAdapter.HolderSubitem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_child,parent,false);

        return new HolderSubitem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildItemAdapter.HolderSubitem holder, int position) {
        holder.txsubtitle.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        //java.lang.NullPointerException: Attempt to invoke virtual method 'int java.util.ArrayList.size()' on a null object reference
        return list.size();
    }

    public class HolderSubitem extends RecyclerView.ViewHolder {

        TextView txsubtitle;

        public HolderSubitem(@NonNull View itemView) {
            super(itemView);

            txsubtitle = itemView.findViewById(R.id.txsubtitle);
        }
    }
}
