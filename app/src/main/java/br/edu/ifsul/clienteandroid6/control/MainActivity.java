package br.edu.ifsul.clienteandroid6.control;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import br.edu.ifsul.clienteandroid6.R;
import br.edu.ifsul.clienteandroid6.adapter.ProjetoAdapter;
import br.edu.ifsul.clienteandroid6.dto.ProjetoSync;
import br.edu.ifsul.clienteandroid6.service.RetrofitSetup;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //associa um gerenciador de layout linear ao recycleView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //associa um tipo de animação ao recycleView
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Call<ProjetoSync> call = new RetrofitSetup().getProjetoService().getProjetos();
        call.enqueue(new Callback<ProjetoSync>() {
            @Override
            public void onResponse(Call<ProjetoSync> call, Response<ProjetoSync> response)
            {
                Log.d("PROJECTSBOX", "HELLO");
                ProjetoSync projetoSync = response.body();
                Log.d("TAG", "" + projetoSync.getProjetos());
                recyclerView.setAdapter(new ProjetoAdapter(MainActivity.this, projetoSync.getProjetos()));
            }

            @Override
            public void onFailure(Call<ProjetoSync> call, Throwable t)
            {

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
