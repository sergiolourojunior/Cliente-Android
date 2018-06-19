package br.edu.ifsul.clienteandroid6.service;


import br.edu.ifsul.clienteandroid6.dto.ProjetoSync;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by ubuntu on 04/05/18.
 */

public interface ProjetoService {

    @GET("projetos")
    Call<ProjetoSync> getProjetos();
}
