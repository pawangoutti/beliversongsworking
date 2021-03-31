package com.pawan.beliverssongs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class SongShowHindi extends AppCompatActivity {
    RecyclerView recview;
    ArrayList<Model> datalist;
    FirebaseFirestore db;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Pawan_t", "onCreate: " +this.getClass().getSimpleName());

        setContentView(R.layout.activity_song_show_hindi);
        Toast.makeText(SongShowHindi.this, "Loading Songs Please Wait...", Toast.LENGTH_LONG).show();
        recview=(RecyclerView)findViewById(R.id.recviewh);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<>();
        adapter=new MyAdapter(datalist);
        recview.setAdapter(adapter);

        db=FirebaseFirestore.getInstance();

        db.collection("hindi_songs").orderBy("title").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            Model obj=d.toObject(Model.class);
                            datalist.add(obj);
                        }
                        layoutanimation(recview);
                        adapter.notifyDataSetChanged();
                    }
                });

    }

    void layoutanimation(RecyclerView recyclerView){
        Context context = recyclerView.getContext();
        LayoutAnimationController layoutAnimationController =
                AnimationUtils.loadLayoutAnimation(context,R.anim.layout_slide_right);

        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();

    }

    @Override
    protected void onDestroy() {
        Log.d("Pawan_t", "onDestroy: " +this.getClass().getSimpleName());
        super.onDestroy();
    }

}