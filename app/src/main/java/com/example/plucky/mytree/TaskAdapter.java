package com.example.plucky.mytree;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{
    private List<Task> mTasksList;
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView status;
        TextView task_content;
        public ViewHolder(View view) {
            super(view);
            status = (TextView) view.findViewById(R.id.status_text);
            task_content = (TextView) view.findViewById(R.id.taskText);

        } }
    public TaskAdapter(List<Task> tasksList) {
        mTasksList=tasksList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()) .inflate(R.layout.task_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Task task = mTasksList.get(position);
        holder.status.setText("2017-11-08 09:14:04");
        holder.task_content.setText(task.getContent());
    }
    @Override
    public int getItemCount() {
        return mTasksList.size();
    }

}
