package com.example.demo.domain;

interface Command {
    boolean execute(Context context, String parameters[]);
}
