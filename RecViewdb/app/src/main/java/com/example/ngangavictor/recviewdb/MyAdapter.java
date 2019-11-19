package com.example.ngangavictor.recviewdb;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.view.View.GONE;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    private List<ListItem> listItems;
    private Context context;
    private static final String URL_INSERT = "http://192.168.43.17/www.android.com/recyclerView/insertData.php";
    //private static final String URL_INSERT = "http://192.168.72.254/www.android.com/recyclerView/insertData.php";
    //192.168.72.254
    //AlertDialog.Builder builder;
    ProgressBar progressBar;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ListItem listItem = listItems.get(position);
        holder.textViewHead.setText(listItem.getHead());
        holder.textViewDesc.setText(listItem.getDesc());
        Picasso.with(context).load(listItem.getImageUrl()).into(holder.imageView);
        /*holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"You clicked " + listItem.getHead(),Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder();
                alertDialogBuilder.setMessage("Are you sure you want to buy " + listItem.getHead() + " ? ");
                alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "You purchased " + listItem.getHead(), Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialogBuilder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(MainActivity.this, "You clicked NO", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });*/


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public ViewHolder(final View itemView) {
            super(itemView);
            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(itemView.getContext());
                    final String name = textViewHead.getText().toString().trim();
                    alertDialogBuilder.setMessage("Are you sure you want to buy " + name + " ? ");
                    alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            HashMap<String,String > params = new HashMap<>();
                            params.put("name", name);
                            PerformNetworkRequest request = new PerformNetworkRequest(URL_INSERT, params,CODE_POST_REQUEST);
                            request.execute();
                            Toast.makeText(context,"You purchased " +name,Toast.LENGTH_LONG).show();
                        }
                    });
                    alertDialogBuilder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Toast.makeText(context, "You clicked NO", Toast.LENGTH_SHORT).show();
                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            });


           /*itemView.setOnClickListener(new View.OnClickListener() {

                String name = textViewHead.getText().toString().trim();
                String name2 = textViewHead.getText().toString();
                //String name3 = itemView.getContext().
                @Override
                public void onClick(View v) {
                    //String name = textViewHead.getText().toString().trim();

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_INSERT, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(itemView.getContext());
                            final String name = textViewHead.getText().toString().trim();
                            //alertDialogBuilder.setMessage("Are you sure you want to buy " + textViewHead.getText() + " ? ");
                            alertDialogBuilder.setMessage("Are you sure you want to buy " + name + " ? ");
                            alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                        //String name = textViewHead.getText().toString().trim();
                                        //Map<String, String> Params = new HashMap<String, String>();
                                       //Params.put("name", name);
                                    //Toast.makeText(context,""+name,Toast.LENGTH_LONG).show();
                                    //RequestHandler.getmInstance(context).addToRequestQueue(Params);
                                    HashMap<String,String > params = new HashMap<>();
                                    params.put("name", name);


                                    PerformNetworkRequest request = new PerformNetworkRequest(URL_INSERT, params,CODE_POST_REQUEST);
                                    request.execute();
                                    Toast.makeText(context,""+name,Toast.LENGTH_LONG).show();

                                }

                            });
                            AlertDialog alertDialog = alertDialogBuilder.create();
                            alertDialog.show();

                        }

                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(context, "An error occurred", Toast.LENGTH_LONG).show();
                        }
                    });*//*{
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> Params = new HashMap<String, String>();
                            Params.put("name", name);
                            // Params.put("email",email);
                            return Params;


                        }

                    };*/
                    //Toast.makeText(context,""+name,Toast.LENGTH_LONG).show();
                   // RequestHandler.getmInstance(context).addToRequestQueue(stringRequest);
             //   }


           // });
        }
    }

    private class PerformNetworkRequest extends AsyncTask<Void , Void,String> {
        String url;
        HashMap<String ,String> params;
        int  requestCode;

        PerformNetworkRequest(String url, HashMap<String , String > params, int requestCode) {
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }
        @ Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progressBar.setVisibility(View.VISIBLE);
        }
        @ Override
        protected void onPostExecute(String  s) {
            super.onPostExecute(s);
//            progressBar.setVisibility(GONE);
            /*try {
                JSONObject object = new  JSONObject(s);
                if (!object.getBoolean("error")) {
                    Toast.makeText(context,object.getString("message"),Toast.LENGTH_LONG).show();
                    //refreshHeroList(object.getJSONArray("heroes"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }*/
        }

        @ Override
        protected String doInBackground(Void ... voids) {
            RequestHandler2 requestHandler2 = new  RequestHandler2();

            if (requestCode == CODE_POST_REQUEST)
                return requestHandler2.sendPostRequest(url, params);

            if (requestCode == CODE_GET_REQUEST)
                return requestHandler2.sendGetRequest(url);

            return null;
        }
    }

}

