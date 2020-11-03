package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import static android.widget.Toast.*;
import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progress;
    private Button btn;
    private EditText edit,edit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = (ProgressBar)findViewById(R.id.pro);
        btn = (Button)findViewById(R.id.bt);
        edit = (EditText)findViewById(R.id.nom);
        edit1 = (EditText)findViewById(R.id.con);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Task().execute(); // ejecuta mi tarea asíncrona.
            }
        });


        progress.setVisibility(View.INVISIBLE); // desaparece el elemento.
    }

    // Tarea Asíncrona.

    class Task extends AsyncTask<String, Void, String> {

        @Override  // Vamos a darle la configuración inicial a la tarea
        protected void onPreExecute() {

            progress.setVisibility(View.VISIBLE);
        }


        @Override // vamos a emplear el proceso o tarea pesada en segundo plano.
        protected String doInBackground(String... strings) {

            for(int i = 1; i < 10; i++)
            {
                try {
                    Thread.sleep(1000);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }


        @Override // finalizamos la tarea
        protected void onPostExecute(String s) {

            progress.setVisibility(View.INVISIBLE);
            if (edit.getText().toString().equals("ANDROID") && edit1.getText().toString().equals("123")) {
                Intent i = new Intent(getBaseContext(), home_act.class);
                startActivity(i);
            } else if (edit.getText().toString().equals("android") && edit1.getText().toString().equals("123")) {
                Intent i = new Intent(getBaseContext(), home_act.class);
                startActivity(i);
            }else {
                Context context = getApplicationContext();
                CharSequence text = "Intentar De Nuevo Contaseña O Usuario Invalid";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }

    }

}