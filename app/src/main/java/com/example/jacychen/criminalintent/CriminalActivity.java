package com.example.jacychen.criminalintent;

import android.support.v4.app.Fragment;

public class CriminalActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
