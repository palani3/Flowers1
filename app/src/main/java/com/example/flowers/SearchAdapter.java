package com.example.flowers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class SearchAdapter extends FirestoreRecyclerAdapter<User,SearchAdapter.SearchHolder> {
    Context context;

    public SearchAdapter(FirestoreRecyclerOptions<User> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(SearchHolder holder, int position, User model) {
        holder.BlockText.setText(String.valueOf(model.getBlock()));
        holder.NameText.setText(String.valueOf(model.getName()));

    }

    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_items,viewGroup,false);
        context =viewGroup.getContext();
        return new SearchHolder(v);
    }

    class SearchHolder extends RecyclerView.ViewHolder{
        TextView BlockText;
        TextView NameText;


        public SearchHolder(@NonNull View itemView) {
            super(itemView);
            BlockText=itemView.findViewById(R.id.txtblock);
            NameText=itemView.findViewById(R.id.txtname);

        }
    }
}
