package com.example.hsmicrofinance.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsmicrofinance.R;
import com.example.hsmicrofinance.databinding.FragmentPasswordChangeBinding;


public class PasswordChange extends Fragment {
FragmentPasswordChangeBinding mFragmentPasswordChangeBinding;

    private NavController mNavController;

    public PasswordChange() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentPasswordChangeBinding = FragmentPasswordChangeBinding.inflate(inflater,container,false);
        return mFragmentPasswordChangeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(view);

        mFragmentPasswordChangeBinding.updatePasswordChangepage.setOnClickListener(v->mNavController.navigate(R.id.action_passwordChange_to_updateSecurityCode));
    }
}