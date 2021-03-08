package fr.umontpellier.exercice1persistence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTexNom, editTextPrenom, editTextAge, editTextPhone, editTextId;
    private final static String NOM = "NOM", PRENOM = "PRENOM", AGE = "AGE", PHONE = "PHONE", ID_USER = "ID_USER" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        editTexNom = (EditText) findViewById(R.id.editext_nom);
        editTextPrenom = (EditText) findViewById(R.id.editext_prenom);
        editTextAge = (EditText) findViewById(R.id.editext_age);
        editTextPhone = (EditText) findViewById(R.id.editext_phone);
        editTextId = (EditText) findViewById(R.id.editext_id);

        editTextId.setText(getRandomNumber() + "");

        if(savedInstanceState != null) {
            if (savedInstanceState.containsKey(NOM)) {
                editTexNom.setText(savedInstanceState.getString(NOM).toString());
            }
            if (savedInstanceState.containsKey(PRENOM)) {
                editTexNom.setText(savedInstanceState.getString(PRENOM));
            }
            if (savedInstanceState.containsKey(AGE)) {
                editTexNom.setText(savedInstanceState.getString(AGE));
            }
            if (savedInstanceState.containsKey(PHONE)) {
                editTexNom.setText(savedInstanceState.getString(PHONE));
            }
            if (savedInstanceState.containsKey(ID_USER)) {
                editTextId.setText(savedInstanceState.getString(ID_USER));
            }

            Toast.makeText(getApplicationContext(), "L'etat de l'activité est restoré " + editTextId.getText().toString(), Toast.LENGTH_LONG).show();
            setContentView(R.layout.activity_main);
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(NOM, editTexNom.getText().toString());
        outState.putString(PRENOM, editTextPrenom.getText().toString());
        outState.putString(AGE, editTextAge.getText().toString());
        outState.putString(PHONE, editTextPhone.getText().toString());
        if (editTextId.getText().toString().equals("") == false)
        outState.putInt(ID_USER, Integer.parseInt(editTextId.getText().toString()));
        Toast.makeText(getApplicationContext(), "L'etat de l'activité est sauvegardé id " + editTextId.getText().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), "L'etat de l'activité est restoré " + editTextId.getText().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "L'etat de l'activité est detruit", Toast.LENGTH_LONG).show();
    }

    public static int getRandomNumber(){
        int x = (int) Math.random();
        return x;
    }
}