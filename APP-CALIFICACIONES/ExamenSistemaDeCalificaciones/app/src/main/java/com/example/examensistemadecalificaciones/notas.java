package com.example.examensistemadecalificaciones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class notas extends AppCompatActivity {

    private FirebaseFirestore db;
    TextView txtNota1;
    TextView txtNota2;
    TextView txttotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        db=FirebaseFirestore.getInstance();
        txtNota1 = (TextView) findViewById(R.id.txtnota1);
        txtNota2 = (TextView) findViewById(R.id.txtnota2);
        txttotal = (TextView) findViewById(R.id.txttotal);

        db.collection("prueba")
                .whereEqualTo("correo","andresgeo96@gmail.com")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            Usuarios usuarios = documentSnapshot.toObject(Usuarios.class);

                            String correo = usuarios.getCorreo();
                            String nota1 = usuarios.getNota1();
                            String nota2 = usuarios.getNota2();
                            String total = usuarios.getTotal();

                            if(correo.equals("andresgeo96@gmail.com")) {
                                txtNota1.setText(nota1);
                                txtNota2.setText(nota2);
                                txttotal.setText(total);

                            }else {

                            }
                        }
                    }
                });

    }


}
