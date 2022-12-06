package com.example.attendanceusingfacerecognition.Fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.attendanceusingfacerecognition.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.TimeZone;

public class DateFragment extends Fragment {
    TextView text_date;
    Calendar myCalendar;
    String date="",batch_selected="";
    Spinner batch;
    String[] batch_array ={"Select Batch","CSE 4th yr","CSE 3rd yr","CSE 2nd yr"};
    Button submit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_datefragment, container, false);
        text_date=view.findViewById(R.id.date);
        batch=view.findViewById(R.id.spinnerBatch);
        submit=view.findViewById(R.id.btn);
        myCalendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
        text_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item, batch_array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        batch.setAdapter(adapter);
        batch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                batch_selected=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(batch_selected.equals("Select Batch")){
                    batch.requestFocus();
                    Toast.makeText(getActivity(),"Please select Batch",Toast.LENGTH_SHORT).show();
                }
                else if(date.equals("")){
                    Toast.makeText(getActivity(),"Please select a Date",Toast.LENGTH_SHORT).show();
                }
                else{
                    Fragment fragment = new StudentListFragment();
                    FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });

        return view;
    }
    private void updateLabel() {
        DateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");

        date1.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
        String time1 = date1.format(myCalendar.getTime());
        date = time1;
        text_date.setText(date);
    }
}
