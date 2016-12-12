package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.vikas.com.jokesdisplayactivity.JokesDisplayActivity;
import android.vikas.com.jokesdisplayactivity.LibConstants;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener,JokesListener{

    AppCompatButton appCompatButton;
    ProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading joke of the day...");
        progressDialog.setTitle("Please wait");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        appCompatButton = (AppCompatButton)root.findViewById(R.id.btJokes);
        appCompatButton.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {
        progressDialog.show();
        String productFlavor = com.udacity.gradle.builditbigger.BuildConfig.VERSION_NAME;
        ExecuteBackendsCalls executeBackendsCalls = new ExecuteBackendsCalls();
        executeBackendsCalls.setOnDataListener(this);
        executeBackendsCalls.execute(new Pair<Context, String>(getActivity(), productFlavor));
    }

    @Override
    public void onDataAvailable(String data) {
        progressDialog.hide();
        Intent intent = new Intent(getActivity(), JokesDisplayActivity.class);
        intent.putExtra(LibConstants.JOKES_INTENT,data);
        startActivity(intent);

    }
}
