package com.nopearino.libraryapp.ui.loan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nopearino.libraryapp.MainActivity;
import com.nopearino.libraryapp.R;
import com.nopearino.libraryapp.databinding.FragmentLoanBinding;
import com.nopearino.libraryapp.model.BookModel;

import java.util.ArrayList;

public class LoanFragment extends Fragment {

    private FragmentLoanBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LoanViewModel homeViewModel =
                new ViewModelProvider(this).get(LoanViewModel.class);

        binding = FragmentLoanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        GridView gridview = (GridView) root.findViewById(R.id.gridview);
        ArrayList<BookModel> bookList = new ArrayList<BookModel>();

        for(int i=0;i<100;i++)
            bookList.add(new BookModel("Book "+i,"Author","666133769420", R.drawable.book_example,"Description"));

        gridview.setAdapter(new GidViewAdapter(root.getContext(), bookList));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private class GidViewAdapter extends ArrayAdapter<BookModel> {

        public GidViewAdapter(@NonNull Context context, ArrayList<BookModel> courseModelArrayList) {
            super(context, 0, courseModelArrayList);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View listitemView = convertView;
            if (listitemView == null) {
                // Layout Inflater inflates each item to be displayed in GridView.
                listitemView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_book, parent, false);
            }

            BookModel book = getItem(position);
            TextView courseTV = listitemView.findViewById(R.id.book_title);
            ImageView courseIV = listitemView.findViewById(R.id.book_img);

            courseTV.setText(book.getTitle());
            courseIV.setImageResource(book.getCover());
            listitemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), book.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });

            return listitemView;
        }
    }
}