package com.example.plucky.mytree;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class task_fragment extends Fragment {
    private List<Task> taskList = new ArrayList<>();
    private FloatingActionButton mAddFAB,mResourceFAB,mTaskFAB;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.task_fragment, container, false);

        RecyclerView recyclerView =(RecyclerView)v.findViewById(R.id.recycler_view);

        mResourceFAB=(FloatingActionButton)v.findViewById(R.id.resource_fab);
        mTaskFAB=(FloatingActionButton)v.findViewById(R.id.task_fab);
        mAddFAB=(FloatingActionButton)v.findViewById(R.id.add_fab);

        mTaskFAB.setVisibility(View.INVISIBLE);
        mResourceFAB.setVisibility(View.INVISIBLE);
        mTaskFAB.setEnabled(false);
        mResourceFAB.setEnabled(false);


        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mTaskFAB.setVisibility(View.INVISIBLE);
                mResourceFAB.setVisibility(View.INVISIBLE);
                mTaskFAB.setEnabled(false);
                mResourceFAB.setEnabled(false);
                return false;
            }
        });



        mAddFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTaskFAB.setVisibility(View.VISIBLE);
                mResourceFAB.setVisibility(View.VISIBLE);
                mTaskFAB.setEnabled(true);
                mResourceFAB.setEnabled(true);
                mResourceFAB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getActivity(),"DESTROY",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        initTasks();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        TaskAdapter adapter = new TaskAdapter(taskList);
        recyclerView.setAdapter(adapter);
        return v;
    }



    private void initTasks(){
        for (int i = 0; i < 5 ; i++) {
            Task task1 = new Task("我很帅很帅很帅我很帅" +
                    "很帅很帅我很帅很帅很帅我很帅很帅很帅我很帅" +
                    "很帅很帅我很帅很帅很帅我我很帅很帅很帅我很" +
                    "帅很帅很帅我很帅很帅很帅我很帅很帅很帅我很" +
                    "帅很帅很帅" +
                    "很帅很帅很帅",i);
            Task task2 = new Task("我很美很美我很美很美我很" +
                    "美很美我很美很美我很美很美我很美很美我很美很美我很美" +
                    "很美我很美很美我很美很" +
                    "美我很美很美我很美很美我很美很美",i);
            taskList.add(task1);
            taskList.add(task2);
        }
    }


}
