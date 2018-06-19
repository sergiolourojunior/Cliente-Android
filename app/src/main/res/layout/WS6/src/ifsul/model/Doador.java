package ifsul.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;


public class Doador implements Serializable {
	
		private static final long serialVersionUID = 1L;
	
		private Long cd_usuario;
		private String username;
		private String email;
		private String senha;
		private String imagem;
		private Boolean ativo;
		private String nome;
		private String status;
		private String cpf;

			
		public Doador() {
			
		}

		

		public Long getCd_usuario() {
			return cd_usuario;
		}



		public void setCd_usuario(Long cd_usuario) {
			this.cd_usuario = cd_usuario;
		}



		public String getUsername() {
			return username;
		}



		public void setUsername(String username) {
			this.username = username;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public String getSenha() {
			return senha;
		}



		public void setSenha(String senha) {
			this.senha = senha;
		}



		public String getImagem() {
			return imagem;
		}



		public void setImagem(String imagem) {
			this.imagem = imagem;
		}



		public Boolean getAtivo() {
			return ativo;
		}



		public void setAtivo(Boolean ativo) {
			this.ativo = ativo;
		}



		public String getNome() {
			return nome;
		}



		public void setNome(String nome) {
			this.nome = nome;
		}



		public String getStatus() {
			return status;
		}



		public void setStatus(String status) {
			this.status = status;
		}



		public String getCpf() {
			return cpf;
		}



		public void setCpf(String cpf) {
			this.cpf = cpf;
		}


		@Override
		public String toString() {
			return "Doadores [cd_usuario=" + cd_usuario + ", username=" + username + ", email=" + email + ", senha=" + senha
					+ ", imagem=" + imagem + ", ativo=" + ativo + ", nome=" + nome + ", status="
					+ status + ", cpf=" + cpf +"\"]\n";
		}
	
	
}
