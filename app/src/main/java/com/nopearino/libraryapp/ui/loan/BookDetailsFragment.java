package com.nopearino.libraryapp.ui.loan;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.nopearino.libraryapp.databinding.FragmentBookDetailsBinding;
import com.nopearino.libraryapp.model.BookModel;

import java.util.Calendar;

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
        binding.idBtnPickDateStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                binding.idTVSelectedDateStart.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }
        });

        binding.idBtnPickDateEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                binding.idTVSelectedDateEnd.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }
        });

        binding.btnRequisitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //verify if the dates are valid
                if (binding.idTVSelectedDateStart.getText().toString().equals("Data de Início") || binding.idTVSelectedDateEnd.getText().toString().equals("Data de Fim")) {
                    Toast toast = Toast.makeText(getContext(), "Selecione as datas", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                //verify if the inicial date is before the final date
                String[] dateStart = binding.idTVSelectedDateStart.getText().toString().split("-");
                String[] dateEnd = binding.idTVSelectedDateEnd.getText().toString().split("-");
                if(dateStart.length != 3 || dateEnd.length != 3){
                    Toast toast = Toast.makeText(getContext(), "Selecione as datas", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }else{
                    if (Integer.parseInt(dateStart[2]) > Integer.parseInt(dateEnd[2])) {
                        Toast toast = Toast.makeText(getContext(), "Data de Início não pode ser depois da Data de Fim", Toast.LENGTH_SHORT);
                        toast.show();
                        return;
                    } else if (Integer.parseInt(dateStart[2]) == Integer.parseInt(dateEnd[2])) {
                        if (Integer.parseInt(dateStart[1]) > Integer.parseInt(dateEnd[1])) {
                            Toast toast = Toast.makeText(getContext(), "Data de Início não pode ser depois da Data de Fim", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        } else if (Integer.parseInt(dateStart[1]) == Integer.parseInt(dateEnd[1])) {
                            if (Integer.parseInt(dateStart[0]) > Integer.parseInt(dateEnd[0])) {
                                Toast toast = Toast.makeText(getContext(), "Data de Início não pode ser depois da Data de Fim", Toast.LENGTH_SHORT);
                                toast.show();
                                return;
                            }
                        }
                    }
                }

                Toast toast = Toast.makeText(getContext(), "Requisitado", Toast.LENGTH_SHORT);
                toast.show();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.remove(bookDetailsFragment).commit();
            }
        });

        return root;
    }
}