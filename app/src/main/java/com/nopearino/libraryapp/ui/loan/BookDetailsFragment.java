package com.nopearino.libraryapp.ui.loan;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.nopearino.libraryapp.databinding.FragmentBookDetailsBinding;
import com.nopearino.libraryapp.model.BookModel;

public class BookDetailsFragment extends Fragment {
    BookModel book;
    FragmentBookDetailsBinding binding;
    BookDetailsFragment bookDetailsFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookDetailsFragment = this;
        Log.d("BookDetailsFragment", "getArguments: " + getArguments());
        if (getArguments() != null) {
            Bundle bundle = this.getArguments();
            Log.d("BookDetailsFragment", "onCreate: " + bundle.getSerializable("book"));
            this.book = (BookModel) bundle.getSerializable("book");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBookDetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.EDTextNomeBook.setText(book.getTitle());
        binding.EDTextIsbn.setText(book.getIsbn());
        binding.EDTextAuthor.setText(book.getAuthor());

        binding.btnRequisitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "Requisitado", Toast.LENGTH_SHORT);
                toast.show();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.remove(bookDetailsFragment).commit();
            }
        });

        return root;
    }
}