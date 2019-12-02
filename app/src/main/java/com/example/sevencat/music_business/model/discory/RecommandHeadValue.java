package com.example.sevencat.music_business.model.discory;

import com.example.sevencat.music_business.model.BaseModel;

import java.util.ArrayList;

public class RecommandHeadValue extends BaseModel {

    public ArrayList<String> ads;
    public ArrayList<RecommandMiddleValue> middle;
    public ArrayList<RecommandFooterValue> footer;
}
