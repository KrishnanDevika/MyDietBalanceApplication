package com.example.dietbalanceapplication.FAQRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietbalanceapplication.R;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private ArrayList<FAQ> faqs;

    public CustomRecyclerViewAdapter(ArrayList<FAQ> faqs) {
        this.faqs = faqs;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        FAQ faq = faqs.get(position);
        holder.question.setText(faq.getQuestion());
        holder.answer.setText(faq.getAnswer());
    }

    @Override
    public int getItemCount() {
        if(faqs != null){
            return faqs.size();
        }
        return 0;
    }
}

class CustomViewHolder extends RecyclerView.ViewHolder{
    protected TextView question;
    protected TextView answer;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        this.question = itemView.findViewById(R.id.question);
        this.answer = itemView.findViewById(R.id.answer);
    }
}
