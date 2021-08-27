package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.databinding.FragmentBasicPayfriendsBinding;


public class BasicPayfriends extends Fragment {

    FragmentBasicPayfriendsBinding mFragmentBasicPayfriendsBinding;

    public BasicPayfriends() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentBasicPayfriendsBinding = FragmentBasicPayfriendsBinding.inflate(inflater,container,false);
        return mFragmentBasicPayfriendsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentBasicPayfriendsBinding.payfriendSubmitBtn.setOnClickListener(v-> executepayfriend());
    }

    private void executepayfriend() {
        if(mFragmentBasicPayfriendsBinding.payfriendAccountNo.getText().toString().trim().isEmpty() || mFragmentBasicPayfriendsBinding.payfriendAmount.getText().toString().trim().isEmpty()){
            mFragmentBasicPayfriendsBinding.payfriendErrorTxt.setText("All fields required");
        }else{
            doPayFriends();
        }
    }

    private void doPayFriends() {
        Toast.makeText(getContext(), "PayFriends", Toast.LENGTH_SHORT).show();
    }
}