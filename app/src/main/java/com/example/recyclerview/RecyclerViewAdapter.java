package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;

public class RecyclerViewAdapter
        extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    //Variables
    private ArrayList<String> mTitleList;
    private ArrayList<String> mTextList;
    private LayoutInflater mInflater;
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> titleList, ArrayList<String> textList) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mTitleList = titleList;
        this.mTextList = textList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.layout_listitem,
                parent, false);
        return new ViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        String mCurrentTitle = mTitleList.get(position);
        String mCurrentText = mTextList.get(position);
        holder.titleItemView.setText(mCurrentTitle);
        holder.textItemView.setText(mCurrentText);
    }

    @Override
    public int getItemCount() {
        return mTitleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final String TAG = "RecyclerViewAdapter";
        public final TextView titleItemView;
        public final TextView textItemView;
        final RecyclerViewAdapter mAdapter;
        public ViewHolder(View itemView, RecyclerViewAdapter adapter) {
            super(itemView);

            Log.d(TAG, "ViewHolder: started constructor.");
            
            titleItemView = itemView.findViewById(R.id.recipeTitle);
            textItemView = itemView.findViewById(R.id.recipeText);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String element = mTitleList.get(mPosition);
            // Change to GalleryActivity view
            Intent showIng = new Intent(mContext, GalleryActivity.class);
            showIng.putExtra("recipeTitle", mTitleList.get(mPosition));
            showIng.putExtra("recipeText", mTextList.get(mPosition));
            mContext.startActivity(showIng);
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();

        }
    }

}
