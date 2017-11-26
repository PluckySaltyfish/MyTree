package com.example.plucky.mytree;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class task_fragment extends Fragment implements TaskAdapter.MyItemLongClickListener,TaskAdapter.MyItemClickListerner {
    private List<Task> taskList = new ArrayList<>();
    private FloatingActionButton mAddFAB,mResourceFAB,mTaskFAB;
    private int ListCount;
    private  RecyclerView recyclerView;
    private AddTaskDialog mdialog;
    private TaskAdapter adapter;
    private LinearLayoutManager layoutManager;
    @SuppressLint("ClickableViewAccessibility")
    @Nullable

    private static final String TAG = "task_fragment";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View v = inflater.inflate(R.layout.task_fragment, container, false);

        recyclerView =(RecyclerView)v.findViewById(R.id.recycler_view);

        mResourceFAB=(FloatingActionButton)v.findViewById(R.id.resource_fab);
        mTaskFAB=(FloatingActionButton)v.findViewById(R.id.task_fab);
        mAddFAB=(FloatingActionButton)v.findViewById(R.id.add_fab);

        mTaskFAB.setVisibility(View.INVISIBLE);
        mResourceFAB.setVisibility(View.INVISIBLE);
        mTaskFAB.setEnabled(false);
        mResourceFAB.setEnabled(false);


//        recyclerView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//
//                mTaskFAB.setVisibility(View.INVISIBLE);
//                mResourceFAB.setVisibility(View.INVISIBLE);
//                mTaskFAB.setEnabled(false);
//                mResourceFAB.setEnabled(false);
//                return false;
//            }
//        });

        layoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        UpdateUI();

        mAddFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListCount =adapter.getItemCount();
                mTaskFAB.setVisibility(View.VISIBLE);
                mResourceFAB.setVisibility(View.VISIBLE);
                mTaskFAB.setEnabled(true);
                mTaskFAB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         mdialog= new AddTaskDialog(getActivity(), R.style.dialog, new AddTaskDialog.OnCloseListener() {

                            public void onClick(Dialog dialog, boolean confirm) {
                                if(confirm){
                                    Toast.makeText(getActivity(),"hahaha",Toast.LENGTH_SHORT).show();
                                    taskList.add(mdialog.getTask());
                                    UpdateUI();
                                    dialog.dismiss();


                                }

                            }
                        },ListCount);
                        mdialog.show();
                    }
                });
                mResourceFAB.setEnabled(true);
                mResourceFAB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getActivity(),"resource",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }


    private void getTasks(){
        for (int i = 0; i < 5 ; i=i+2) {
            Task task1 = new Task("我很帅很帅很帅我很帅" +
                    "很帅很帅我很帅很帅很帅我很帅很帅很帅我很帅" +
                    "很帅很帅我很帅很帅很帅我我很帅很帅很帅我很" +
                    "帅很帅很帅我很帅很帅很帅我很帅很帅很帅我很" +
                    "帅很帅很帅" +
                    "很帅很帅很帅",i);
            Task task2 = new Task("我很美很美我很美很美我很" +
                    "美很美我很美很美我很美很美我很美很美我很美很美我很美" +
                    "很美我很美很美我很美很" +
                    "美我很美很美我很美很美我很美很美",i+1);
            taskList.add(task1);
            taskList.add(task2);
        }
    }

    private void UpdateUI(){


        if (adapter == null) {
            getTasks();
            adapter = new TaskAdapter(taskList);
            adapter.setOnItemLongClickListener(this);
            adapter.setOnItemClickListener(this);
            recyclerView.setAdapter(adapter);
        } else {
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemLongClick(View view,int position){
        Toast.makeText(getActivity(),"LongClick "+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(),"Click "+position,Toast.LENGTH_SHORT).show();
        mTaskFAB.setVisibility(View.INVISIBLE);
        mResourceFAB.setVisibility(View.INVISIBLE);
        mTaskFAB.setEnabled(false);
        mResourceFAB.setEnabled(false);
    }
}
