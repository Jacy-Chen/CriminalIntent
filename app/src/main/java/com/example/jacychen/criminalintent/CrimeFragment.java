package com.example.jacychen.criminalintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by jacychen on 5/8/16.
 */
public class CrimeFragment extends Fragment{
    private int mItemNumber;
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    private static final String ARG_CRIME_ID = "crime_id";
    private static final String EXTRA_CRIME_ITEM_NUMBER = "com.jacychen.android.crimeIntent.crime_item_number";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mCrime = new Crime();
//        UUID crimeID = (UUID) getActivity().getIntent().getSerializableExtra(CriminalActivity.EXTRA_CRIME_ID);
        mItemNumber = -1;
        UUID crimeID = (UUID) getArguments().getSerializable(ARG_CRIME_ID);

        //目前是暴力搜索法,之后应该使用hashtable
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeID);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mTitleField = (EditText) v.findViewById((R.id.crime_title));
        mTitleField.setText(mCrime.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mItemNumber = CrimeLab.get(getActivity()).getItemNumber(mCrime.getId());
                returnResult();
            }
        });

        mDateButton = (Button) v.findViewById(R.id.crime_date);
        mDateButton.setText(mCrime.getDate().toString());
        mDateButton.setEnabled(false);

        mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
                mItemNumber = CrimeLab.get(getActivity()).getItemNumber(mCrime.getId());
                returnResult();
            }
        });

        returnResult();
        return v;
    }

    public static  CrimeFragment newInstance(UUID crimeID) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeID);

        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void returnResult(){
        Intent data = new Intent();
        data.putExtra(EXTRA_CRIME_ITEM_NUMBER, this.mItemNumber);
        if (this.mItemNumber == -1) {
            getActivity().setResult(Activity.RESULT_CANCELED, data);
        }
        else {
            getActivity().setResult(Activity.RESULT_OK, data);
        }
    }

    public static int getItemNumber(Intent data) {
        int itemNumber = data.getIntExtra(EXTRA_CRIME_ITEM_NUMBER, -1);
        return itemNumber;
    }
}
