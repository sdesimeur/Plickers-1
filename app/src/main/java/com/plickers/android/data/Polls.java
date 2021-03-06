package com.plickers.android.data;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Root of the structure of date. It holds a {@link List} of polls.
 * This structure resembles the architecture of the JSON.
 */
public class Polls implements Serializable {

    List<Poll> polls = new ArrayList<>(0);

    @Override
    public void fromJson(JsonValue value) {

        //Make sure an array was passed
        if(value==null || !value.isArray()) return;

        JsonArray pollsJson = value.asArray();

        //Add the list with the polls in the json array
        polls = new ArrayList<>(pollsJson.size());
        for(JsonValue pollJson:pollsJson){
            Poll poll = new Poll();
            poll.fromJson(pollJson);
            polls.add(poll);
        }
    }

    @Override
    public void toJson(JsonValue value) {
    }

    public List<Poll> getPolls() {
        return polls;
    }

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }

    public void setPolls(Poll ... polls) {
        this.polls = new ArrayList<>(Arrays.asList(polls));
    }
}
