package com.istarindia.tfylanguage;

/**
 * Created by akshay on 10/26/17.
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;

import com.istarindia.tfylanguage.complexobject.ConcreteItemPOJO;
import com.istarindia.tfylanguage.complexobject.LessonPOJO;
import com.istarindia.tfylanguage.pojo.Lesson;

import java.util.ArrayList;
import java.util.List;

public class CardFragmentPagerAdapter extends FragmentStatePagerAdapter implements CardAdapter {

    private List<CardFragment> mFragments;
    private List<ConcreteItemPOJO> lessons;
    private float mBaseElevation;

    public CardFragmentPagerAdapter(FragmentManager fm, float baseElevation, List<ConcreteItemPOJO> lessons) {
        super(fm);
        mFragments = new ArrayList<>();
        mBaseElevation = baseElevation;
        this.lessons = lessons;
        CardFragment card;
        for (ConcreteItemPOJO lesson : lessons) {
            if ((lesson.getType() != "") && ((lesson.getType().equalsIgnoreCase("LESSON_PRESENTATION")) || (lesson.getType().equalsIgnoreCase("PRESENTATION")))) {
                card = new CardFragment();
                Bundle args = new Bundle();
                args.putSerializable("lesson",lesson);
                card.setArguments(args);
                addCardFragment(card);
            }

        }
    }

    @Override
    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mFragments.get(position).getCardView();
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        mFragments.set(position, (CardFragment) fragment);
        return fragment;
    }

    public void addCardFragment(CardFragment fragment) {
        mFragments.add(fragment);
    }

}
