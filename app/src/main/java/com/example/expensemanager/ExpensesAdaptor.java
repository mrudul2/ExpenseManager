package com.example.expensemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExpensesAdaptor extends RecyclerView.Adapter<ExpensesAdaptor.myViewHolder> {
    private Context context;
    private OnItemsClick OnItemsClick;
    private List<ExpenseModel> expenseModelList;

    public ExpensesAdaptor(Context context, OnItemsClick OnItemsClick) {
        this.context = context;
        expenseModelList=new ArrayList<>();
        this.OnItemsClick = OnItemsClick;
    }
    public void add(ExpenseModel expenseModel){
        expenseModelList.add(expenseModel);
        notifyDataSetChanged();
    }

    public void clear(){
        expenseModelList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_row,parent,false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

            ExpenseModel expenseModel = expenseModelList.get(position);
            holder.note.setText(expenseModel.getNote());
            holder.category.setText(expenseModel.getCategory());
            holder.amount.setText(String.valueOf(expenseModel.getAmount()));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnItemsClick.onClick(expenseModel);
                }
            });
    }

    @Override
    public int getItemCount() {
        return expenseModelList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        private TextView note,category,date,amount;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            note=itemView.findViewById(R.id.note);
            category=itemView.findViewById(R.id.category);
            amount=itemView.findViewById(R.id.amount);
            date=itemView.findViewById(R.id.date);

        }
    }
}
