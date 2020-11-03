package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class clientes extends AppCompatActivity {
    private EditText edcodigo,ednombre,edsalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        edcodigo =(EditText)findViewById(R.id.edit_codigo);
        ednombre =(EditText)findViewById(R.id.edit_nombre);
        edsalario  =(EditText)findViewById(R.id.edit_salario);
    }

    // M etos  para permitir guardar productos en mi base de datos
    public void Anadircliente(View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase(); // Permite la sobreescritura en mi base de datos.


        if (!edcodigo.getText().toString().isEmpty()) {

            // .. añades el producto

            ContentValues registro = new ContentValues();

            registro.put("codigo", edcodigo.getText().toString());
            registro.put("nombre", ednombre.getText().toString());
            registro.put("salario", edsalario.getText().toString());

            bd.insert("clientes", null, registro);
            bd.close();


            Toast.makeText(this, "Has guardado un cliente.", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "Debe rellenar los campos .", Toast.LENGTH_SHORT).show();
        }
    }
    public void MostrarCliente(View v){
        AdminSQLiteOpenHelper  admin = new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase db=  admin.getWritableDatabase();

        String codigo= edcodigo.getText().toString();

        if(!codigo.isEmpty()) {
            Cursor fila = db.rawQuery("SELECT nombre, salario FROM clientes WHERE codigo=" + codigo, null);

            if (fila.moveToFirst()) {
                ednombre.setText(fila.getString(0));
                edsalario.setText(fila.getString(1));

            } else {
                Toast.makeText(this, "No hay campo en la tabla", Toast.LENGTH_SHORT).show();
            }
        }else
        {
            Toast.makeText(this,"No hay cliente asociado al codigo", Toast.LENGTH_SHORT).show();
        }
    }



    public void EliminarCliente(View v){

        AdminSQLiteOpenHelper  admin = new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase db=  admin.getWritableDatabase();

        String codigo= edcodigo.getText().toString();
        db.delete("clientes","codigo="+codigo,null);
        db.close();
        Toast.makeText(this,"Has eliminado un cliente.",Toast.LENGTH_SHORT).show();
    }
    public void ActualizarCliente(View v){
        AdminSQLiteOpenHelper  admin = new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase db=  admin.getWritableDatabase();
        String codigo= edcodigo.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo",edcodigo.getText().toString());
        cont.put("nombre",ednombre.getText().toString());
        cont.put("salario",edsalario.getText().toString());

        if(!codigo.isEmpty())
        {
            db.update("clientes", cont,"codigo="+codigo,null);

            Toast.makeText(this,"Has actualizado un campo",Toast.LENGTH_SHORT ).show();

        }


    }

}