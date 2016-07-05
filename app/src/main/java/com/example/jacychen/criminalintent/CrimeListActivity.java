package com.example.jacychen.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by jacychen on 5/8/16.
 */
public class CrimeListActivity extends SingleFragmentActivity{


    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

}
