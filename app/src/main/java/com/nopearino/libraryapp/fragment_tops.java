package com.nopearino.libraryapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.nopearino.libraryapp.model.BookModel;
import com.nopearino.libraryapp.ui.loan.BookDetailsFragment;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_tops#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_tops extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_tops() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_tops.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_tops newInstance(String param1, String param2) {
        fragment_tops fragment = new fragment_tops();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tops, container, false);

        GridView gridview = (GridView) root.findViewById(R.id.gridview2);
        GridView gridview2 = (GridView) root.findViewById(R.id.gridview1);
        ArrayList<BookModel> bookList = new ArrayList<BookModel>();

        for(int i=0;i<3;i++)
            bookList.add(new BookModel("Book "+i,"Author","666133769420", R.drawable.book_example,"Description"));

        gridview.setAdapter(new GidViewAdapter(root.getContext(), bookList));
        gridview2.setAdapter(new GidViewAdapter(root.getContext(), bookList));



        return root;

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
                    ft = getFragmentManager().beginTransaction();
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