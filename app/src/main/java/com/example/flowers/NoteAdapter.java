package com.example.flowers;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

import java.io.Serializable;
import java.util.List;

public class NoteAdapter extends FirestoreRecyclerAdapter<User, NoteAdapter.NoteHolder> {
    private Context context;
    private List<User> users;


   /* public userlist(Context context,List<User> users){
        super();
        this.context=context;
        this.users=users;


    }*/

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See
     * {@link FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public NoteAdapter(FirestoreRecyclerOptions<User> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull  NoteHolder holder, int position,@NonNull User model) {
        holder.Block1.setText(model.getBlock());
        holder.Name1.setText(model.getName());

    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewtype) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_items,
                viewGroup,false);

        return new NoteHolder(v);
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        TextView Block1;
        TextView Name1;


        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            Block1=itemView.findViewById(R.id.txtblock);
            Name1=itemView.findViewById(R.id.txtname);




        }
    }


}
