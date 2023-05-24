package com.nopearino.libraryapp.ui.multimedia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nopearino.libraryapp.databinding.FragmentMultimediaBinding;

public class MultimediaFragment extends Fragment {

    private FragmentMultimediaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MultimediaViewModel notificationsViewModel =
                new ViewModelProvider(this).get(MultimediaViewModel.class);

        binding = FragmentMultimediaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}