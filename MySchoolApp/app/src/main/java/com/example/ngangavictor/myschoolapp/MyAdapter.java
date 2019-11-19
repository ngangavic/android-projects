package com.example.ngangavictor.myschoolapp;

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
    private List<ListItem> listItems2;
    private Context context;
    //private static final String URL_INSERT = "http://192.168.43.17/www.android.com/recyclerView/insertData.php";
    //192.168.72.254

    public MyAdapter(List<ListItem> items, List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.listItems2 = items;
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
        holder.tvChemistry.setText(listItem.getChemistry());
        holder.tvBiology.setText(listItem.getBiology());
        holder.tvPhysics.setText(listItem.getPhysics());
        holder.tvGeography.setText(listItem.getGeography());
        holder.tvHistory.setText(listItem.getHistory());
        holder.tvCre.setText(listItem.getCre());
        holder.tvAgriculture.setText(listItem.getAgriculture());
        holder.tvBusiness.setText(listItem.getBusiness());
        holder.tvTotal.setText(listItem.getTotal());

        final ListItem listItem1 = listItems2.get(position);
        holder.tvEnglish.setText(listItem1.getEnglish());
        holder.tvKiswahili.setText(listItem1.getKiswahili());
        holder.tvMathematics.setText(listItem1.getMathematics());
        holder.tvChemistry.setText(listItem1.getChemistry());
        holder.tvBiology.setText(listItem1.getBiology());
        holder.tvPhysics.setText(listItem1.getPhysics());
        holder.tvGeography.setText(listItem1.getGeography());
        holder.tvHistory.setText(listItem1.getHistory());
        holder.tvCre.setText(listItem1.getCre());
        holder.tvAgriculture.setText(listItem1.getAgriculture());
        holder.tvBusiness.setText(listItem1.getBusiness());
        holder.tvTotal.setText(listItem1.getTotal());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvEnglish;
        public TextView tvKiswahili;
        public TextView tvMathematics;
        public TextView tvChemistry;
        public TextView tvBiology;
        public TextView tvPhysics;
        public TextView tvGeography;
        public TextView tvHistory;
        public TextView tvCre;
        public TextView tvAgriculture;
        public TextView tvBusiness;
        public TextView tvTotal;

        public TextView tvEnglish2;
        public TextView tvKiswahili2;
        public TextView tvMathematics2;
        public TextView tvChemistry2;
        public TextView tvBiology2;
        public TextView tvPhysics2;
        public TextView tvGeography2;
        public TextView tvHistory2;
        public TextView tvCre2;
        public TextView tvAgriculture2;
        public TextView tvBusiness2;
        public TextView tvTotal2;
        //public LinearLayout linearLayout;

        public ViewHolder(final View itemView) {
            super(itemView);
            tvEnglish = (TextView) itemView.findViewById(R.id.tvEnglishT1);
            tvKiswahili = (TextView) itemView.findViewById(R.id.tvKiswahiliT1);
            tvMathematics = (TextView) itemView.findViewById(R.id.tvMathsT1);
            tvChemistry = (TextView) itemView.findViewById(R.id.tvChemistryT1);
            tvBiology = (TextView) itemView.findViewById(R.id.tvBiologyT1);
            tvPhysics = (TextView) itemView.findViewById(R.id.tvPhysicsT1);
            tvGeography = (TextView) itemView.findViewById(R.id.tvGeographyT1);
            tvHistory = (TextView) itemView.findViewById(R.id.tvHistoryT1);
            tvCre = (TextView) itemView.findViewById(R.id.tvCreT1);
            tvAgriculture = (TextView) itemView.findViewById(R.id.tvAgricultureT1);
            tvBusiness = (TextView) itemView.findViewById(R.id.tvBusinessT1);
            tvTotal = (TextView) itemView.findViewById(R.id.tvTotalT1);
           // linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);

            tvEnglish2 = (TextView) itemView.findViewById(R.id.tvEnglishT2);
            tvKiswahili2 = (TextView) itemView.findViewById(R.id.tvKiswahiliT2);
            tvMathematics2 = (TextView) itemView.findViewById(R.id.tvMathsT2);
            tvChemistry2 = (TextView) itemView.findViewById(R.id.tvChemistryT2);
            tvBiology2 = (TextView) itemView.findViewById(R.id.tvBiologyT2);
            tvPhysics2 = (TextView) itemView.findViewById(R.id.tvPhysicsT2);
            tvGeography2 = (TextView) itemView.findViewById(R.id.tvGeographyT2);
            tvHistory2 = (TextView) itemView.findViewById(R.id.tvHistoryT2);
            tvCre2 = (TextView) itemView.findViewById(R.id.tvCreT2);
            tvAgriculture2 = (TextView) itemView.findViewById(R.id.tvAgricultureT2);
            tvBusiness2 = (TextView) itemView.findViewById(R.id.tvBusinessT2);
            tvTotal2 = (TextView) itemView.findViewById(R.id.tvTotalT2);

        }
    }

}