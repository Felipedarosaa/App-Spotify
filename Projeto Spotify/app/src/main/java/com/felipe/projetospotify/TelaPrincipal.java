package com.felipe.projetospotify;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class TelaPrincipal extends AppCompatActivity {


    private TextView nomeUsuario,emailUsuario;
    private Button deslogar;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuarioID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telaprincipal);

        // Removendo a barra de cima
        getSupportActionBar().hide();

            IniciarComponentes();

            deslogar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(TelaPrincipal.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(TelaPrincipal.this, "Você saiu", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        protected void onStart() {
            super.onStart();

            String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
            usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();

            DocumentReference docuementReference = db.collection("Usuarios").document(usuarioID);
            docuementReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                    if (documentSnapshot != null) {
                        nomeUsuario.setText(documentSnapshot.getString("nome"));
                        emailUsuario.setText(email);
                    }
                }
            });
        }

        private void IniciarComponentes() {
            nomeUsuario = findViewById(R.id.textNomeUsuario);
            emailUsuario = findViewById(R.id.textEmailUsuario);
            deslogar = findViewById(R.id.deslogar);
        }



}