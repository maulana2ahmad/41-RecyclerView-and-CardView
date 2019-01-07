package com.mractiveiddev.recyclerview;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> people;
    ItemClicked activity;

    //list view can in a click
    public interface ItemClicked
    {
        void onItemClicked (int indext);
    }

    public PersonAdapter (Context context, ArrayList<Person> list)
    {
        people = list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView ivPref;
        TextView tvName, tvUsername;

        public ViewHolder(final View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            ivPref = itemView.findViewById(R.id.ivPref);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    activity.onItemClicked(people.indexOf((Person) view.getTag()));
                }
            });
        }
    }

    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonAdapter.ViewHolder viewHolder, int i) {

        viewHolder.itemView.setTag(people.get(i));

        viewHolder.tvName.setText(people.get(i).getName());
        viewHolder.tvUsername.setText(people.get(i).getUsername());

        if (people.get(i).getPreference().equals("bus"))
        {
            viewHolder.ivPref.setImageResource(R.drawable.bus);
        }
        else
        {
            viewHolder.ivPref.setImageResource(R.drawable.plane);
        }
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
