package com.example.examensistemadecalificaciones;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


public class UsuariosAdapter extends FirestoreRecyclerAdapter<Usuarios,UsuariosAdapter.ViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public UsuariosAdapter(@NonNull FirestoreRecyclerOptions<Usuarios> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Usuarios usuarios) {
        holder.textViewCorreo.setText(usuarios.getCorreo());
        holder.textViewNombres.setText(usuarios.getNombre());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notas,viewGroup,false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewCorreo;
        TextView textViewNombres;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCorreo = itemView.findViewById(R.id.textViewCorreo);
            textViewNombres = itemView.findViewById(R.id.textViewNombre);
        }
    }

    public void validar(){

    }

}
