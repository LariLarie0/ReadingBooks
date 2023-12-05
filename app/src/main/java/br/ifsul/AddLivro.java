package br.ifsul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddLivro extends AppCompatActivity {

    Button botao2;
    Button botaoVolta;
    EditText nome;
    EditText pg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_livro);

        botao2 = findViewById(R.id.Add2);
        botaoVolta = findViewById(R.id.bntVolta);

        nome = findViewById(R.id.Nome);
        pg = findViewById(R.id.N_Pg);


        botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String livro = nome.getText().toString();
                String paginasStr = pg.getText().toString();

                if (TextUtils.isEmpty(livro) || TextUtils.isEmpty(paginasStr)) {
                    Toast.makeText(AddLivro.this, "Coloque as informações do Livro", Toast.LENGTH_SHORT).show();
                } else {
                    int paginas = Integer.parseInt(paginasStr);

                    Intent a = new Intent();
                    a.putExtra("livro", livro);
                    a.putExtra("pgs", paginas);
                    setResult(RESULT_OK, a);
                    finish();
                }
            }
        });

        botaoVolta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}