package com.example.didact.u3_dialogejercicio1;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvEstudios;

    TextView tvEstudiosres, tvNombrefinal, tvEdadfinal, tvEstudiosfinal;

    EditText etNombre;

    Spinner spAno;

    CheckBox cbAcepta;

    ArrayList<Estudiante> lista_estudiantes = new ArrayList<Estudiante>();

    int indice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbAcepta = (CheckBox)findViewById(R.id.cbAcepta);

        spAno = (Spinner)findViewById(R.id.spAno);

        String[] tipos={"2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002",
        "2001","2000","1999","1998","1997","1996","1995","1994","1993","1992","1991","1990","1989","1988","1987","1986","1985","1984","1983",
        "1982","1981","1980","1979","1978","1977","1976","1975","1974","1973","1972","1971","1970","1969","1968","1967","1966","1965","1964",
        "1963","1962","1961","1960","1959","1958","1957","1956","1955","1954","1953","1952","1951","1950"};
        ArrayAdapter<String> adaptadorAno = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,tipos);
        spAno.setAdapter(adaptadorAno);

        tvEstudiosres = (TextView)findViewById(R.id.tvEstudiosres);
        tvNombrefinal = (TextView)findViewById(R.id.tvNombrefinal);
        tvEdadfinal = (TextView)findViewById(R.id.tvEdadfinal);
        tvEstudiosfinal = (TextView)findViewById(R.id.tvEstudiosfinal);
        indice=-1;

        etNombre = (EditText)findViewById(R.id.etNombre);

        lvEstudios = (ListView)findViewById(R.id.lvEstudios);

        String [] estudios = {"ESO","Grado Medio","Grado Superior","Grado/Licenciatura"};

        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,estudios);

        lvEstudios.setAdapter(adaptador);

        lvEstudios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),"Has pulsado un item",Toast.LENGTH_LONG).show();

                String estudio_seleccionado = parent.getItemAtPosition(position).toString();
                tvEstudiosres.setText("Estudios: "+estudio_seleccionado);

            }
        });

        lvEstudios.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                String estudio_seleccionado = parent.getItemAtPosition(position).toString();
                tvEstudiosres.setText("Estudios:");

                Toast.makeText(getApplicationContext(), "Estudio borrado", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    public void clickComprobar (View view){

        String cajaNombre = etNombre.getText().toString();
        String spinnerAno = spAno.getSelectedItem().toString();
        String listaEstudios = tvEstudiosres.getText().toString();

        if (cbAcepta.isChecked()){

            if (cajaNombre.equals("") || spinnerAno.equals("") || listaEstudios.equals("Estudios:")){

                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogConfirmacion dialogo = new DialogConfirmacion();
                dialogo.show(fragmentManager, "Debes rellenar todos los campo");

            }else{

                int anoint = Integer.parseInt(spinnerAno);
                int ano2018 = 2018-anoint;
                if (ano2018<18){

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    DialogConfirmacion dialogo = new DialogConfirmacion();
                    dialogo.show(fragmentManager, "Debes ser mayor de edad");

                }else{



                    Estudiante j=new Estudiante(cajaNombre, anoint, listaEstudios);
                    lista_estudiantes.add(j);

                }

            }


        }else{

            dialogConfiramcion();

        }


    }

    public void clickAnterior(View view){
        if (indice>0) {
            indice--;
            cargarEstudiante();
        }else{
            FragmentManager fragmentManager = getSupportFragmentManager();
            DialogConfirmacion dialogo = new DialogConfirmacion();
            dialogo.show(fragmentManager, "Has llegado al principio");
            //si queremos que la lista vuelva a empezar una vez ha llegado al principio
            /*
            indice=lista_jugadores.size()-1;
            cargarJugador();
             */
        }
    }

    public void clickSiguiente(View view){
        if (indice<lista_estudiantes.size()-1) {
            indice++;
            cargarEstudiante();
        }else{
            FragmentManager fragmentManager = getSupportFragmentManager();
            DialogConfirmacion dialogo = new DialogConfirmacion();
            dialogo.show(fragmentManager, "Has llegado al final");
            //si queremos que la lista vuelva a empezar una vez ha llegado al final
            /*
            indice=0;
            cargarJugador();
             */
        }
    }


    private void cargarEstudiante(){

        Estudiante e = lista_estudiantes.get(indice);
        tvNombrefinal.setText("Nombre: "+e.getNombre());
        tvEdadfinal.setText("Edad: "+e.getEdad());
        tvEstudiosfinal.setText(e.getEstudios());

    }

    public void dialogConfiramcion(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogConfirmacion dialogo = new DialogConfirmacion();
        dialogo.show(fragmentManager, "Debes aceptar los términos");
    }



}
