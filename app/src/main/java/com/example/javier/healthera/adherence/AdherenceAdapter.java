package com.example.javier.healthera.adherence;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.javier.healthera.R;
import com.example.javier.healthera.model.Generic;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Javier on 21/12/2017.
 */

public class AdherenceAdapter extends RecyclerView
        .Adapter<AdherenceAdapter
        .DataObjectHolder> {

    private Context mContext;
    private List<Generic> mResult;
    private static AdherenceAdapter.ClickListener sClickListener;

    static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        @BindView(R.id.adherence_item_textView)
        TextView mName;

        @BindView(R.id.adherence_item_time_textView)
        TextView mTime;

        @BindView(R.id.adherence_item_constraintLayout)
        ConstraintLayout mConstraintLayout;

        DataObjectHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mConstraintLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            sClickListener.onItemClick(getAdapterPosition(), v);
        }
    }
    public void setOnItemClickListener(AdherenceAdapter.ClickListener myClickListener) {
        this.sClickListener = myClickListener;
    }

    public AdherenceAdapter(Context context, List<Generic> example) {
        mContext = context;
        mResult = example;
    }

    @Override
    public AdherenceAdapter.DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adherence_item, parent, false);

        AdherenceAdapter.DataObjectHolder dataObjectHolder = new AdherenceAdapter.DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(AdherenceAdapter.DataObjectHolder holder, int position) {

        holder.mName.setText(mResult.get(position).getActionAndDose());
        holder.mTime.setText(mResult.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    interface ClickListener {
        void onItemClick(int position, View view);
    }
}
