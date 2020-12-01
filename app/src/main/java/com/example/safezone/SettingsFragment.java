package com.example.safezone;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class SettingsFragment extends Fragment {
    Button buttonAddGroup;
    Button buttonAddMessage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return true;
            }
        });

        //ARRAY LIST CONTACT GROUPS
        ArrayList<String> recipientGroups = new ArrayList<>();
        recipientGroups.add("Roommates");
        recipientGroups.add("Family");

        //ARRAY LIST MASS TEXT
        ArrayList<String> messageTemplates = new ArrayList<>();
        messageTemplates.add("Sorry, That last text was sent by accident.");
        messageTemplates.add("I'm 5 minutes from my destination.");
        messageTemplates.add("I'm safe.");

        //MANAGE RECIPIENTS

        //View Group(s) spinner
        Spinner spinnerGroup = (Spinner) view.findViewById(R.id.spinnerViewGroups);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapterGroup =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, recipientGroups);
        // Specify the layout to use when the list of choices appears
        adapterGroup.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerGroup.setAdapter(adapterGroup);

        //get content from edit text and add to groups
        //EditText newGroupEditText = (EditText) getView().findViewById(R.id.editTextNameNewGroup);
        //String newGroup = newGroupEditText.getText().toString();

        //add to spinner on button click
        buttonAddGroup = getView().findViewById(R.id.buttonAddGroup);
        buttonAddGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText newGroupEditText = (EditText) getView().findViewById(R.id.editTextNameNewGroup);
                String newGroup = newGroupEditText.getText().toString();
                if(newGroup.equals("") == true){
                    newGroupEditText.setText("");
                }
                else {
                    recipientGroups.add(newGroup);
                    newGroupEditText.setText("");
                    Toast.makeText(view.getContext(), "Group Added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //MASS TEXT SETTINGS
        Spinner spinnerMassText = view.findViewById(R.id.spinnerViewMessages);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapterMessages =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, messageTemplates);
        // Specify the layout to use when the list of choices appears
        adapterMessages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerMassText.setAdapter(adapterMessages);

        //get content from edit text and add to groups
        //EditText newGroupEditText = (EditText) getView().findViewById(R.id.editTextNameNewGroup);
        //String newGroup = newGroupEditText.getText().toString();

        //add to spinner on button click
        buttonAddMessage = getView().findViewById(R.id.buttonAddMessage);
        buttonAddMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText newMessageEditText = (EditText) getView().findViewById(R.id.editTextNewMessage);
                String newMessage = newMessageEditText.getText().toString();
                if(newMessage.equals("")== true){
                    newMessageEditText.setText("");
                }
                else {
                    messageTemplates.add(newMessage);
                    newMessageEditText.setText("");
                    Toast.makeText(view.getContext(), "Message Added", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //initialize spinner entries
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, recipientGroups);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


    }

}
