package com.example.ngangavictor.myschoolapp2.Helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.ngangavictor.myschoolapp2.BuildConfig;
import com.example.ngangavictor.myschoolapp2.Fragments.FragmentContent;
import com.example.ngangavictor.myschoolapp2.Interface.NavigationManager;
import com.example.ngangavictor.myschoolapp2.MainActivity;
import com.example.ngangavictor.myschoolapp2.R;

public class FragmentNavigationManager implements NavigationManager{
    private static FragmentNavigationManager mInstance;
    private FragmentManager fragmentManager;
    private MainActivity mainActivity2;

    public static FragmentNavigationManager getmInstance(MainActivity mainActivity){
        if (mInstance == null)
            mInstance = new FragmentNavigationManager();
             mInstance.configure(mainActivity);
        return mInstance;
    }

    private void configure(MainActivity mainActivity) {
        mainActivity2 = mainActivity;
        fragmentManager = mainActivity.getSupportFragmentManager();
    }

    @Override
    public void showFragment(String title) {

        showFragment(FragmentContent.newInstance(title),false);
    }

    private void showFragment(Fragment fragmentContent, boolean allowStateLoss) {
        FragmentManager fm = fragmentManager;
        FragmentTransaction ft = fm.beginTransaction().replace(R.id.recyclerView, fragmentContent);
        ft.addToBackStack(null);
        if (allowStateLoss || !BuildConfig.DEBUG)
            ft.commitAllowingStateLoss();
        else
            ft.commit();
            fm.executePendingTransactions();
    }


}
