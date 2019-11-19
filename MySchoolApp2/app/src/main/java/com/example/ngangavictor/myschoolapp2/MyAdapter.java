package com.example.ngangavictor.myschoolapp2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    //private static final int CODE_GET_REQUEST = 1024;
   // private static final int CODE_POST_REQUEST = 1025;

    private List<ListItem> listItems;
    private Context context;
    //private static final String URL_INSERT = "http://192.168.43.17/www.android.com/recyclerView/insertData.php";
    //192.168.72.254

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ListItem listItem = listItems.get(position);
        holder.tvEnglish.setText(listItem.getEnglish());
        holder.tvKiswahili.setText(listItem.getKiswahili());
        holder.tvMathematics.setText(listItem.getMathematics());
        holder.tvScience.setText(listItem.getScience());
        holder.tvSSre.setText(listItem.getSsre());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvEnglish;
        public TextView tvKiswahili;
        public TextView tvMathematics;
        public TextView tvScience;
        public TextView tvSSre;
        //public LinearLayout linearLayout;

        public ViewHolder(final View itemView) {
            super(itemView);
            tvEnglish = (TextView) itemView.findViewById(R.id.tvEnglish);
            tvKiswahili = (TextView) itemView.findViewById(R.id.tvKiswahili);
            tvMathematics = (TextView) itemView.findViewById(R.id.tvMathematics);
            tvScience = (TextView) itemView.findViewById(R.id.tvScience);
            tvSSre = (TextView) itemView.findViewById(R.id.tvSSre);
           // linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);

        }
    }

}