package edu.tecsup.jeferson.semana07_laboratorio.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.tecsup.jeferson.semana07_laboratorio.Model.Person;
import edu.tecsup.jeferson.semana07_laboratorio.R;

/**
 * Created by Alumno on 10/2/2017.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>{

    //obtiene la referencia de la data /*la que tiene todos los datos tiene el repository*/
    private List<Person> persons;

    public PersonAdapter() {
        this.persons = new ArrayList<>();
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    //como vas a inflar la vista
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    //enlazar la vista con la data
    //se ejecuta segun los elementos que contengas
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        //nos da acceso alos elementos como iagen correo
        Person person = this.persons.get(position);

        viewHolder.fullname.setText(person.getFullname());
        viewHolder.email.setText(person.getEmail());


        Context context = viewHolder.itemView.getContext();
        int idRes = context.getResources().getIdentifier(person.getPicture(), "drawable", context.getPackageName());
        viewHolder.picture.setImageResource(idRes);
    }

    //como vas a calcular la cantidad de elementos
    //Se ejecuta contastantemente
    @Override
    public int getItemCount() {
        return this.persons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView picture;
        public TextView fullname;
        public TextView email;

        public ViewHolder(View itemView) { //el itemView es el item_Contac.xml
            super(itemView);

            picture = (ImageView)itemView.findViewById(R.id.picture_image);
            fullname = (TextView)itemView.findViewById(R.id.fullname_text);
            email = (TextView)itemView.findViewById(R.id.email_text);
        }
    }
}
