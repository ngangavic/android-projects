package com.example.ngangavictor.expandablerecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.ngangavictor.expandablerecyclerview.Adapter.MyAdapter;
import com.example.ngangavictor.expandablerecyclerview.models.TitleChild;
import com.example.ngangavictor.expandablerecyclerview.models.TitleCreator;
import com.example.ngangavictor.expandablerecyclerview.models.TitleParent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter(this,initData());
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);

        recyclerView.setAdapter(adapter);
    }

    private List<ParentObject> initData() {
        TitleCreator titleCreator = TitleCreator.get(this);
        List<TitleParent> titleParents = titleCreator.getAll();
        List<ParentObject> parentObjects = new ArrayList<>();
        for (TitleParent titleParent:titleParents){
            List<Object> childList = new ArrayList<>();
            childList.add(new TitleChild("Add to contacts","Send message"));
            titleParent.setChildObjectList(childList);
            parentObjects.add(titleParent);
        }
        return parentObjects;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }
}
