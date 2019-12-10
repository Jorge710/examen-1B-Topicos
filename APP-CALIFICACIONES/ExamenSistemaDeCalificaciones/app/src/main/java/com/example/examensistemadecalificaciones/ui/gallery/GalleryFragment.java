package com.example.examensistemadecalificaciones.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examensistemadecalificaciones.R;
import com.example.examensistemadecalificaciones.Usuarios;
import com.example.examensistemadecalificaciones.UsuariosAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class GalleryFragment extends Fragment {

    private FirebaseFirestore db;
    TextView txtNota1;
    TextView txtNota2;
    TextView txttotal;

    private View vista;
    RecyclerView recyclerViewUsuarios;
    UsuariosAdapter usuariosAdapter;
    FirebaseFirestore mFirestor;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        vista = inflater.inflate(R.layout.fragment_notas,container, false);
        recyclerViewUsuarios = (RecyclerView) vista.findViewById(R.id.recycleWiew);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(getContext()));
        mFirestor = FirebaseFirestore.getInstance();
        //lanzar la consulta
        Query query = mFirestor.collection("prueba");
        FirestoreRecyclerOptions<Usuarios> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Usuarios>()
                .setQuery(query, Usuarios.class).build();

        usuariosAdapter = new UsuariosAdapter(firestoreRecyclerOptions);
        usuariosAdapter.notifyDataSetChanged();
        recyclerViewUsuarios.setAdapter(usuariosAdapter);
        return vista;
    }

    //metodo de ciclo de vida para que empiese a mostrar los usuarios
    @Override
    public void onStart() {
        super.onStart();
        usuariosAdapter.startListening();
    }

    //la aplicacion si esta en pausa no este simepre consultando

    @Override
    public void onStop() {
        super.onStop();
        usuariosAdapter.stopListening();
    }
}