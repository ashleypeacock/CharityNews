package com.charitynews.news.user;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charitynews.R;
import com.facebook.widget.LoginButton;

public class LoginFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login, null);
        LoginButton lb = (LoginButton) view.findViewById(R.id.authButton);

        return view;
    }
}
