package com.nopearino.libraryapp.ui.multimedia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ETextAutor.setText("");
                binding.ETextDescription.setText("");
                binding.ETextTitulo.setText("");
                Toast toast = Toast.makeText(getContext(), "Multimedia adicionado", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}