package br.edu.ifsul.clienteandroid6.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import br.edu.ifsul.clienteandroid6.R;
import br.edu.ifsul.clienteandroid6.model.Projeto;

/**
 * Created by ubuntu on 18/05/18.
 */

public class ProjetoAdapter extends RecyclerView.Adapter<ProjetoAdapter.ProjetoViewHolder>
{
    private final Context context;
    private final List<Projeto> projetos;
    public ProjetoAdapter(Context context, List<Projeto> projetos)
    {
        this.context = context;
        this.projetos = projetos;
    }
    @Override
    public ProjetoAdapter.ProjetoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_projetos, parent, false);

        ProjetoViewHolder holder = new ProjetoViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ProjetoAdapter.ProjetoViewHolder holder, int position)
    {
        Projeto projeto = this.projetos.get(position);

        Log.d("PROJETO", "nome: " + projeto.getNome());

        holder.tvNome.setText(projeto.getNome());
        holder.imgView.setImageResource(R.mipmap.ic_launcher);
        holder.pgb.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return this.projetos != null ? this.projetos.size() : 0;
    }

    public class ProjetoViewHolder extends RecyclerView.ViewHolder {
        private ProgressBar pgb;
        private ImageView imgView;
        private TextView tvNome;
        public ProjetoViewHolder(View itemView)
        {
            super (itemView);
            tvNome = (TextView) itemView.findViewById(R.id.textView_card_adapter);
            imgView = (ImageView) itemView.findViewById(R.id.imageView_card_adaptercarro);
            pgb = (ProgressBar) itemView.findViewById(R.id.progressBar_card_adaptercarro);
        }
    }
}
