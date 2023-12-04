package com.example.demo.domain;

interface Command {
    String execute(Context context, String parameters[]);
}
