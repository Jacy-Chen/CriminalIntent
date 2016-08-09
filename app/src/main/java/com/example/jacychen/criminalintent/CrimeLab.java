package com.example.jacychen.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by jacychen on 5/8/16.
 */

//数据Model生成器
public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;


    public static CrimeLab get(Context context) {
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context){
        //only itself can create the new object
        //cannot create outside the class
        mCrimes = new ArrayList<>();

        //create 100 boring objs
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i%2 == 0);
            mCrimes.add(crime);
        }

    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        //根据UUID拿到数据详情
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }

    public int getItemNumber(UUID id){
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return mCrimes.indexOf(crime);
            }
        }
        return -1;
    }

}
