package com.example.ngangavictor.expandablerecyclerview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.ngangavictor.expandablerecyclerview.R;
import com.example.ngangavictor.expandablerecyclerview.ViewHolders.TitleChildViewHolder;
import com.example.ngangavictor.expandablerecyclerview.ViewHolders.TitleParentViewHolder;
import com.example.ngangavictor.expandablerecyclerview.models.TitleChild;
import com.example.ngangavictor.expandablerecyclerview.models.TitleParent;

import java.util.List;

public class MyAdapter extends ExpandableRecyclerAdapter<TitleParentViewHolder, TitleChildViewHolder> {
    LayoutInflater inflater;

    public MyAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public TitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.list_parent,viewGroup,false);
        return new TitleParentViewHolder(view);
    }

    @Override
    public TitleChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.layout_child,viewGroup,false);
        return new TitleChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(TitleParentViewHolder titleParentViewHolder, int i, Object o) {
        TitleParent titleParent =(TitleParent)o;
        titleParentViewHolder._textView.setText(titleParent.getTitle());

    }

    @Override
    public void onBindChildViewHolder(TitleChildViewHolder titleChildViewHolder, int i, Object o) {
        TitleChild titleChild = (TitleChild)o;
        titleChildViewHolder.option1.setText(titleChild.getOption1());
        titleChildViewHolder.option2.setText(titleChild.getOption2());

    }
}
