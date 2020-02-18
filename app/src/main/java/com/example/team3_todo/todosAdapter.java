package com.example.team3_todo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class todosAdapter extends RecyclerView.Adapter<todosAdapter.ToDoViewHolder> {

    Context context;
    ArrayList<todos> todos;

    public todosAdapter(Context c, ArrayList<todos> p) {
        context = c;
        todos = p;
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ToDoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_todo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        holder.title.setText(todos.get(position).getTitle());
        holder.description.setText(todos.get(position).getDescription());
        holder.date.setText(todos.get(position).getDate());

        final String getTitle = todos.get(position).getTitle();
        final String getDescription = todos.get(position).getDescription();
        final String getDate = todos.get(position).getDate();
        final String getKey = todos.get(position).getKey();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,EditToDoActivity.class);
                i.putExtra("title", getTitle);
                i.putExtra("description", getDescription);
                i.putExtra("date", getDate);
                i.putExtra("key", getKey);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    class ToDoViewHolder extends RecyclerView.ViewHolder {

        TextView title, description, date, key;

        public ToDoViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.date);
        }
    }

}
