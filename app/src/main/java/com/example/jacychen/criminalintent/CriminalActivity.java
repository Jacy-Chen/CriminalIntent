package com.example.jacychen.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;

import java.util.UUID;


//Activity Holder for Crime Fragment, 子类
public class CriminalActivity extends SingleFragmentActivity {

    private static final String EXTRA_CRIME_ID = "com.jacychen.android.criminalintent.crime_id";

    @Override
    protected Fragment createFragment() {
        UUID crimeID = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeID);
    }

    //创建intent返回
    public static Intent newIntent(Context packageContext, UUID crimeID) {
        Intent intent = new Intent(packageContext, CriminalActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeID);
        return intent;
    }
}
