package com.example.sevencat.music_business.view.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sevencat.music_business.model.CHANNEL;
import com.example.sevencat.music_business.view.discory.DiscoryFragment;
import com.example.sevencat.music_business.view.friend.FriendFragment;
import com.example.sevencat.music_business.view.mine.MineFragment;
import com.example.sevencat.music_business.view.video.VideoFragment;

/**
 * 首页ViewPager的adapter
 */
public class HomePagerAdapter extends FragmentPagerAdapter {

    private CHANNEL[] mList;

    public HomePagerAdapter(FragmentManager fm, CHANNEL[] datas) {
        super(fm);
        this.mList = datas;
    }

    //初始化对应的fragment
    @Override
    public Fragment getItem(int i) {
        //亮点：根据id去初始化相应的fragment，可以避免当有很多fragment时在首页一次全部初始化完毕，导致进首页的时候很卡顿
        int type = mList[i].getValue();
        switch(type){
            case CHANNEL.MINE_ID:
                return MineFragment.newInstance();
            case CHANNEL.DISCORY_ID:
                return DiscoryFragment.newInstance();
            case CHANNEL.FRIEND_ID:
                return FriendFragment.newInstance();
            case CHANNEL.VIDEO_ID:
                return VideoFragment.newInstance();
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.length;
    }
}
