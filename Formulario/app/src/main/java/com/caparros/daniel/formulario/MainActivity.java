package com.caparros.daniel.formulario;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    static final int IDENTIFICADOR = 1;

    private TextInputEditText tietNombre,tietFecha, tietTelefono, tietEmail, tietDescripcion;
    private Button btnSiguiente,btnFecha;
    private int mAño,mMes, mDia;
    static final int DATE_DIALOG_ID=0;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tietNombre = (TextInputEditText) findViewById(R.id.tietNombre);
        tietFecha=(TextInputEditText) findViewById(R.id.tietFecha);
        tietTelefono = (TextInputEditText) findViewById(R.id.tietTelefono);
        tietEmail = (TextInputEditText) findViewById(R.id.tietEmail);
        tietDescripcion = (TextInputEditText) findViewById(R.id.tietDescripcion);
        btnSiguiente= (Button) findViewById(R.id.btnSiguiente);
        btnFecha=(Button) findViewById(R.id.btnFecha);

        btnFecha.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                showDialog(DATE_DIALOG_ID);
            }
        });

        final Calendar c=Calendar.getInstance();
        mAño=c.get(Calendar.YEAR);
        mMes=c.get(Calendar.MONTH);
        mDia=c.get(Calendar.DAY_OF_MONTH);
        updateDisplay();

    }


        private void updateDisplay(){

            tietFecha.setText(new StringBuilder()
                    .append(mDia).append("/").append(mMes+1)
                    .append("/").append(mAño));
        }


        private DatePickerDialog.OnDateSetListener
                mDateSetListener=new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view,
                                  int year, int month, int dayOfMonth) {


                mAño=year;
                mMes=month;
                mDia=dayOfMonth;
                updateDisplay();
            }
        };


            @RequiresApi(api = Build.VERSION_CODES.N)
            protected Dialog onCreateDialog (int id){

                switch (id){

                    case DATE_DIALOG_ID:
                        return new DatePickerDialog(this,
                                mDateSetListener,
                                mAño,mMes,mDia);

                       /* DatePickerDialog dialogDatePicker = new DatePickerDialog(this,mDateSetListener,
                                mAño,mMes,mDia);
                        dialogDatePicker.getDatePicker().setSpinnersShown(true);
                        dialogDatePicker.getDatePicker().setCalendarViewShown(false);
                        return dialogDatePicker;*/
                }
                return  null;
            }




            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void btnSiguiente_onClick(View v) {

               // Toast.makeText(getApplicationContext(),"hola"+año,Toast.LENGTH_LONG).show();


                Intent intent=new Intent(MainActivity.this, Mostrar_Datos.class);

                intent.putExtra("nombre",tietNombre.getText().toString());
                intent.putExtra("fecha",tietFecha.getText().toString());
                intent.putExtra("telefono",tietTelefono.getText().toString());
                intent.putExtra("email",tietEmail.getText().toString());
                intent.putExtra("descripcion",tietDescripcion.getText().toString());
                intent.putExtra("fecha",tietFecha.getText().toString());


            /*    // get the values for day of month , month and year from a date picker
                intent.putExtra("dia", dia); // get the selected day of the month
                intent.putExtra("mes", mes); // get the selected month
                intent.putExtra("año", año); // get the selected year*/

                startActivityForResult(intent, IDENTIFICADOR);

            }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            String nombre = data.getExtras().getString("nombre");
            String telefono = data.getExtras().getString("telefono");
            String email = data.getExtras().getString("email");
            String descripcion = data.getExtras().getString("descripcion");


        }
    }



}
