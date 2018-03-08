package com.example.pdbsflhr22.shareride.common;

import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by pdbsflhr22 on 2/17/2018.
 */

public class utils {

    public static void hideNshowCard(CardView mCard){

        if(mCard.getVisibility()== View.GONE)
            mCard.setVisibility(View.VISIBLE);
        else
            mCard.setVisibility(View.GONE);
    }
}
