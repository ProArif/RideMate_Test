package com.myres.ariful.ridemate.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myres.ariful.ridemate.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ClientsAdapter extends RecyclerView.Adapter<ClientsAdapter.ClientViewHolder>{

    private List<ClientModel> cleints;
    private int rowLayout;
    private Context context;

    public ClientsAdapter(List<ClientModel> cleints, int clients_item_layout, Context applicationContext) {
        this.cleints =cleints;
        this.context=applicationContext;
        this.rowLayout=clients_item_layout;
    }

    @NonNull
    @Override
    public ClientsAdapter.ClientViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ClientsAdapter.ClientViewHolder clientViewHolder, int position) {
        clientViewHolder.name.setText(cleints.get(position).getName());
        clientViewHolder.company.setText(cleints.get(position).getCompany());
        clientViewHolder.country.setText(cleints.get(position).getCountry());

        Glide.with(context).load(cleints.get(position).getLogo()).into(clientViewHolder.itemImage);

    }

    @Override
    public int getItemCount() {
        return cleints.size();
    }

    public static class ClientViewHolder extends RecyclerView.ViewHolder {
        CircleImageView itemImage;
        TextView name;
        TextView company;
        TextView country;
        ImageButton bt_toggle;
        View lyt_expand_text;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.imageItem);
            name= itemView.findViewById(R.id.itemTextName);
            company =itemView.findViewById(R.id.itemTextCompany);
            country=itemView.findViewById(R.id.itemTextCountry);

        }

    }

}
