package com.example.flowers;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class SearchActivity extends AppCompatActivity {

    FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference details=db.collection("Users");
    private SearchAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        db.collection("Users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
               for (QueryDocumentSnapshot documentSnapshot:task.getResult()){
                   Log.d("palanik321","hii"+documentSnapshot.getData());
               }
            }
        });
        Query query=details.orderBy("Block",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<User> options=new FirestoreRecyclerOptions.Builder<User>()
                .setQuery(query,User.class)
                .build();
        adapter=new SearchAdapter(options);
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        Log.d("sssss","sssss"+query);


        setupRecyclerview();
    }

    private void setupRecyclerview() {
        /*Query query=details.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (QueryDocumentSnapshot documentSnapshot:task.getResult()){
                    User user=documentSnapshot.toObject(User.class);

                }
            }
        });*/

        Query query=details.orderBy("block",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<User> options=new FirestoreRecyclerOptions.Builder<User>()
              .setQuery(query,User.class)
               .build();
        adapter=new SearchAdapter(options);
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
       adapter.startListening();
    }

    @Override
    protected void onStop() {

        super.onStop();
       adapter.stopListening();
    }
}
