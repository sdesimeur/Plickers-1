package com.plickers.android.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.plickers.android.R;
import com.plickers.android.data.Choice;
import com.plickers.android.data.Response;

import java.util.List;



public class ResponseListingAdapter extends ArrayAdapter<Response> {
    public ResponseListingAdapter(Context context, List<Response> resource) {
        super(context, R.layout.response_listing_row, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View row = inflater.inflate(R.layout.response_listing_row,parent,false);
        Response response = getItem(position);

        TextView studentTF = (TextView) row.findViewById(R.id.response_student);

        String studentString = response.getStudent();
        if(studentString.length()>28){
            studentString = studentString.substring(0,26)+"...";
        }

        studentTF.setText(studentString);

        TextView optionTF = (TextView) row.findViewById(R.id.response_choice);
        optionTF.setText(response.getAnswer());

        return row;
    }
}