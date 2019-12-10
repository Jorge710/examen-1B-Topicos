package com.example.examensistemadecalificaciones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Snapshot;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.security.CodeSigner;

public class Login extends AppCompatActivity {

    private EditText usuario;
    private EditText password;
    public static boolean entro = false;

    //private DatabaseReference mDatabase;
    FirebaseFirestore db;
    Button btnAcceder;
    static boolean indicador = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=FirebaseFirestore.getInstance();
        btnAcceder = (Button) findViewById(R.id.ingresar);
        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });

        usuario = (EditText)findViewById(R.id.editText3);
        password = (EditText)findViewById(R.id.editText4);
    }


    public void validar() {
        try {

            String usu = usuario.getText().toString();
            String pass = password.getText().toString();

            if(!usu.isEmpty() && !pass.isEmpty()){
                solicitarDatosFirebase(usu,pass);
            }else{
                Toast t = Toast.makeText(this, "LLENE TODOS LOS CAMPOS", Toast.LENGTH_SHORT);
                t.show();
            }

        } catch (Exception e) {
            Toast t = Toast.makeText(this, "ERROR ", Toast.LENGTH_SHORT);
            t.show();
        }

    }

    public void registro(View view){
        Intent i = new Intent(this,registro.class);
        startActivity(i);
    }

    public void vistaPrincipal(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }


    public void solicitarDatosFirebase(final String usu, final String pass) {
        db.collection("prueba")
                .whereEqualTo("correo",usu)
                .whereEqualTo("password",pass)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            Usuarios usuarios = documentSnapshot.toObject(Usuarios.class);

                            String correo = usuarios.getCorreo();
                            String password = usuarios.getPassword();
                            if(correo.equals(usu) && pass.equals(password)) {
                                indicador = true;
                                Intent llamar = new Intent(Login.this, MainActivity.class);
                                llamar.putExtra("correo",usu);
                                startActivity(llamar);
                                finish();
                            }else{
                                Toast t = Toast.makeText(Login.this, "USUARIO O CONTRASEÑA INCORRECTA ", Toast.LENGTH_SHORT);
                                t.show();
                            }
                        }
                    }
                });

    }

}
