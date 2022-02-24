package com.aldodwrzy.uasmobprog.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.aldodwrzy.uasmobprog.LoginActivity;
import com.aldodwrzy.uasmobprog.R;
import com.aldodwrzy.uasmobprog.databinding.FragmentHomeBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private FirebaseUser firebaseUser;
    private TextView textName;
    private Button btnlogout;
    private FirebaseAuth firebaseAuth;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnlogout = view.findViewById(R.id.btn_logout);
        textName = view.findViewById(R.id.name);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser!= null) {
            textName.setText(firebaseUser.getDisplayName());
        } else {
            textName.setText("Login gagal!");
        }

        btnlogout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getContext().getApplicationContext(), LoginActivity.class));
            Toast.makeText(getContext().getApplicationContext(), "Anda Telah Keluar!", Toast.LENGTH_SHORT).show();
            getActivity().finish();
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}