package com.example.aaung.myroomapp;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WorldViewHolder> {

    private final LayoutInflater mInflater;
    private List<Word> mWords;

    public WordListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public WorldViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item,parent,false);
        return new WorldViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WorldViewHolder holder, int position) {
        if(mWords != null && mWords.size() > 0){
            Word current = mWords.get(position);
            holder.wordItemView.setText(current.getWord());
        }
//        else {
//            //cover the case of data not being ready yet.
//            holder.wordItemView.setText("No Word");
//        }
    }

    void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mWords != null){
            return mWords.size();
        }
        return 0;
    }

    public class WorldViewHolder extends RecyclerView.ViewHolder {

        private final TextView wordItemView;

        public WorldViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }
}
