package com.nopearino.libraryapp.ui.loan;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.nopearino.libraryapp.R;
import com.nopearino.libraryapp.databinding.FragmentLoanBinding;
import com.nopearino.libraryapp.model.BookModel;

import java.util.ArrayList;

public class LoanFragment extends Fragment {

    private FragmentLoanBinding binding;
    private Button btn_home;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

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
        private FragmentTransaction ft;

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
            TextView bookTitle = listitemView.findViewById(R.id.book_title);
            ImageView bookCover = listitemView.findViewById(R.id.book_img);

            bookTitle.setText(book.getTitle());
            bookCover.setImageResource(book.getCover());
            listitemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ft = getParentFragmentManager().beginTransaction();
                    BookDetailsFragment bookDetailsFragment = new BookDetailsFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("book", book);
                    bookDetailsFragment.setArguments(bundle);
                    ft.add(R.id.nav_host_fragment_activity_main, bookDetailsFragment, "BookDetails");
                    ft.addToBackStack("LoanFragment");
                    ft.commit();
                }
            });

            return listitemView;



        }
    }
}