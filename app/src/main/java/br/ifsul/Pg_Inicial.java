package br.ifsul;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Pg_Inicial extends AppCompatActivity {

    Button addLivro;
    ListView listaLivro;

    ArrayList<String> listalivro = new ArrayList<>();
    ArrayAdapter<String> adapter;
    TextView total;
    int totalLivros=0;
    int totalPgs=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pg_inicial);

        listaLivro = findViewById(R.id.Lista);
        addLivro = findViewById(R.id.addLivro);
        total = findViewById(R.id.resultado3);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listalivro);
        listaLivro.setAdapter(adapter);
        addLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pg_Inicial.this, AddLivro.class);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int  requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if (resultCode == RESULT_OK && data != null){
//                System.out.println(data.getStringExtra("livro"));
                String livro = data.getStringExtra("livro");
                int pgs = data.getIntExtra("pgs", 0);

                listalivro.add("Nome do Livro: " + livro);
                listalivro.add("Numero de Paginas: " + pgs);

                totalLivros ++;
                totalPgs += pgs;

                total.setText(totalLivros + " Livros lidos, " + totalPgs + " páginas lidas");


                adapter.notifyDataSetChanged();
            }
        }
    }

}
