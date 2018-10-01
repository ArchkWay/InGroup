package com.example.archek.ingroup;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.archek.ingroup.Model.Offer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AnyAdapter extends RecyclerView.Adapter<AnyAdapter.ViewHolder> {

    private ArrayList<Offer> offers = new ArrayList <>(  );//initiate variables
    private final Callback callback;

    public AnyAdapter(Callback callback) {
        this.callback = callback;
    }

    public void replaceAll(List<Offer>  offerList) {//method for load data in adapter
        offers.clear();
        offers.addAll(offerList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item, parent, false);
        final ViewHolder holder = new ViewHolder( itemView );

        Button btnExp = itemView.findViewById( R.id.btnExp );//button expanse for start activity
        btnExp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Offer offer = offers.get(holder.getAdapterPosition());
                callback.onOfferClick( offer );
            }
        } );
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Offer offer = offers.get(position);//delete unenabled offers
        if(!offer.getEnabled()){
            holder.cv.removeAllViews();
        }

        holder.tvIdOffer.setText( offer.getId() );//instal data in views
        holder.tvNameOffer.setText( offer.getName() );
        holder.tvOfferDesMin.setText( offer.getDes() );
        Picasso.get().load(offer.getLogo()).into(holder.ivLogoOffer);
        holder.tvUrlOffer.setText( offer.getUrl() );
    }

    @Override
    public int getItemCount() {
        return offers.size();
    }//count total amount offers

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvIdOffer;//initiate views in ViewHolder
        TextView tvNameOffer;
        TextView tvOfferDesMin;
        ImageView ivLogoOffer;
        TextView tvUrlOffer;
        CardView cv;

        ViewHolder(View itemView) {
            super(itemView);
            tvIdOffer = itemView.findViewById( R.id.tvIdOffer );
            tvNameOffer = itemView.findViewById( R.id.tvNameOffer );
            tvOfferDesMin = itemView.findViewById( R.id.tvDesMinOffer );
            ivLogoOffer = itemView.findViewById( R.id.ivLogoOffer );
            tvUrlOffer = itemView.findViewById( R.id.tvUrlOffer );
            cv = itemView.findViewById( R.id.cv );
        }
    }

    public interface Callback{
        void onOfferClick(Offer offer);
    }
}
