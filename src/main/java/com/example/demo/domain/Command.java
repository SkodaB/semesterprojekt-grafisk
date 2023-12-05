package com.example.demo.domain;

interface Command {
    Message execute(Context context, Message parameters[]);
}
