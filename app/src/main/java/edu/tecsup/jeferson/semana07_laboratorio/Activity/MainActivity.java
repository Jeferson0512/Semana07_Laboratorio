package edu.tecsup.jeferson.semana07_laboratorio.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import edu.tecsup.jeferson.semana07_laboratorio.Adapter.PersonAdapter;
import edu.tecsup.jeferson.semana07_laboratorio.Model.Person;
import edu.tecsup.jeferson.semana07_laboratorio.R;
import edu.tecsup.jeferson.semana07_laboratorio.Repository.PersonRepository;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsList = (RecyclerView)findViewById(R.id.contacts_list);
        contactsList.setLayoutManager(new LinearLayoutManager(this));

        PersonAdapter personAdapter = new PersonAdapter();

        List<Person> persons = PersonRepository.getPersons();

        personAdapter.setPersons(persons);

        contactsList.setAdapter(personAdapter);
    }
}
