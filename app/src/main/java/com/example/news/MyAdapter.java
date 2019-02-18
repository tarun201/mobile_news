package com.example.news;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.nio.InvalidMarkException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<listItem> listItems;
    private Context context;

    public MyAdapter(List<listItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

//    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_layout,viewGroup,false);
        context = viewGroup.getContext();

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        final listItem lisitem = listItems.get(position);

        viewHolder.textViewHead.setText(lisitem.getHead());

        viewHolder.textViewSource.setText("Source: "+lisitem.getSource());

        String dtStart = lisitem.getDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            Date date = format.parse(dtStart);
            String myString = DateFormat.getDateInstance(DateFormat.LONG).format(date);
            viewHolder.textViewDate.setText(myString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        final String url = lisitem.getUrl();
        final String source = lisitem.getSource();

        Picasso.get().load(lisitem.getImageUrl()).into(viewHolder.imageView);

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,ViewNewsActivity.class);
                i.putExtra("url",url);
                i.putExtra("source",source);
                context.startActivity(i);
//                Toast.makeText(context,"You are at position "+url,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public TextView textViewDate;
        public TextView textViewSource;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = (TextView)itemView.findViewById(R.id.textViewHead);
            textViewDate = (TextView)itemView.findViewById(R.id.textViewDate);
            textViewSource = (TextView)itemView.findViewById(R.id.textViewSource);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.linearLayout);
        }
    }
}
