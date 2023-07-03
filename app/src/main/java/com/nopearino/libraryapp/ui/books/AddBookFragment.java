package com.nopearino.libraryapp.ui.books;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.nopearino.libraryapp.databinding.FragmentAddBookBinding;

public class AddBookFragment extends Fragment {

    FragmentAddBookBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddBookBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.spinner.setSelection(0);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ETextAutor.setText("");
                binding.ETextISBN.setText("");
                binding.ETextTitulo.setText("");
                binding.spinner.setSelection(0);
                Toast toast = Toast.makeText(getContext(), "Livro adicionado", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        return root;

    }
}