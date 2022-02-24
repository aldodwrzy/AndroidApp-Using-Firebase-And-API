package com.aldodwrzy.uasmobprog.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.aldodwrzy.uasmobprog.R;
import com.aldodwrzy.uasmobprog.databinding.FragmentNotificationsBinding;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationsFragment extends Fragment {

    TextView text, alamat;

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;
    private View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_notifications, container, false);
    text = view.findViewById(R.id.text);
    alamat = view.findViewById(R.id.alamat);

    getData();

        return view;
    }

    private void getData() {
        AndroidNetworking.get("https://dev.farizdotid.com/api/purwakarta/kuliner/1")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            text.setText(response.getString("nama"));
                            alamat.setText(response.getString("alamat"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}