package com.example.plucky.mytree;


public class Task {
    private String content;
    private int taskID;

    public Task(String content, int taskID) {
        this.content = content;
        this.taskID = taskID;
    }


    public String getContent() {
        return content;
    }

    public int getTaskID() {
        return taskID;
    }
}
