package com.plickers.android.data;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import java.util.ArrayList;

public class Choice extends DBObject{
    private String body;
    private boolean correct;

    @Override
    public void fromJson(JsonValue value) {
        super.fromJson(value);

        if(value==null || !value.isObject()) return;
        JsonObject choice = value.asObject();

        body = choice.getString("body",null);
        correct = choice.getBoolean("correct",false);
    }

    @Override
    public void toJson(JsonValue value) {

    }


    public String getBody() {
        return body;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
