package com.example.ngangavictor.expandablerecyclerview.models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class TitleCreator  {
    static TitleCreator _titleCreator;
    List<TitleParent> _titleParents;

    public static TitleCreator get(Context context){
        if (_titleCreator==null)
            _titleCreator = new TitleCreator(context);
        return _titleCreator;
    }

    public TitleCreator(Context context) {
        _titleParents = new ArrayList<>();
        for (int i=1;i<=100;i++){
            TitleParent titleParent = new TitleParent(String.format("Caller #%id",i));
            _titleParents.add(titleParent);
        }
        //this._titleParents = _titleParents;
    }

    public List<TitleParent> getAll() {
        return _titleParents;
    }
}
