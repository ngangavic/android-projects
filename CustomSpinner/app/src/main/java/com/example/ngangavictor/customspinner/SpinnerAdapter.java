package com.example.ngangavictor.customspinner;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<String> {
    private ArrayList mData;
    public Resources mResources;
    private LayoutInflater mInflater;


    public SpinnerAdapter(
            Activity activitySpinner,
            int textViewResourceId,
            ArrayList objects,
            Resources resLocal
    ) {
        super(activitySpinner, textViewResourceId, objects);

        mData = objects;
        mResources = resLocal;
        mInflater = (LayoutInflater) activitySpinner.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        View row = mInflater.inflate(R.layout.adapter_spinner, parent, false);
        TextView label = (TextView) row.findViewById(R.id.list_item);
        label.setText(mData.get(position).toString());

        //Set meta data here and later we can access these values from OnItemSelected Event Of Spinner
        row.setTag(R.string.meta_position, Integer.toString(position));
        row.setTag(R.string.meta_title, mData.get(position).toString());

        return row;
    }

}
