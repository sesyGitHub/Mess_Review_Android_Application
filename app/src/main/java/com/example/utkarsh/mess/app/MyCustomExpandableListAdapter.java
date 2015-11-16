package com.example.utkarsh.mess.app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Utkarsh on 26-Jul-15.
 */
public  class MyCustomExpandableListAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<String> mListDataHeader;
    private HashMap<String, List<String>> mListDataChild;
    ExpandableListView elv;
    private static int lastExpandedGroupPosition;
int childposition=1;
    public MyCustomExpandableListAdapter(Context context, List<String> listDataHeader, ExpandableListView expListView) {
        mContext = context;
        mListDataHeader = listDataHeader;

        elv = expListView;
        Log.i("************","constuutor");

    }

    @Override
    public int getGroupCount() {
        Log.i("************",""+this.mListDataHeader.size());
        return this.mListDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition)
    { Log.i("************"," getChildrenCountr");
        return 1;
        //this.mListDataChild.get(this.mListDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {

        Log.i("************"," getGroup");return this.mListDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition)
    {Log.i("************"," getChild");
        return null;
    }


    @Override
    public long getGroupId(int groupPosition) {
        Log.i("************","getGroupId");
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        Log.i("********","getChildid");
        return 0;
    }


    @Override
    public boolean hasStableIds() {
        Log.i("********"," hasStableIds()");
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
Log.i("***GROUP***",(String) getGroup(groupPosition ));
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group, null);
        }

          TextView lblListHeader = (TextView) convertView.findViewById(R.id.lblListHeader);
        //  lblListHeader.setTypeface(null, Typeface.BOLD);
          lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        Log.i("*************","getChildView");
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.rating_bar, null);
        }
        RatingBar rbLastChild = (RatingBar) convertView.findViewById(R.id.ratingBar);
        rbLastChild.setTag(childPosition);
        rbLastChild.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {


                if (fromUser) {
                    ratingBar.setRating(rating);
                } else {
                    ratingBar.setRating(0);
                }

            }

        });

//      rbLastChild.setRating(childRating);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        Log.i("***********","ischildselectable");
        return true;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        Log.i("***********","ongroupexpanded");
        if (groupPosition != lastExpandedGroupPosition) {
            elv.collapseGroup(lastExpandedGroupPosition);
        }

        super.onGroupExpanded(groupPosition);
        lastExpandedGroupPosition = groupPosition;
    }


}
