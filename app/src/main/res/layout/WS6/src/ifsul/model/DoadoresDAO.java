package ifsul.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoadoresDAO extends BaseDAO {

	public List<Doador> getDoadores() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			String sql = "select * from doadores;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			List<Doador> doadores = new ArrayList<>();
			while (resultSet.next()) {

				doadores.add(resultsetToDoadores(resultSet));

			}
			return doadores;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();

			}
			if (resultSet != null) {
				resultSet.close();
			}
		}
	}

	public boolean save(Doador doadores) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = getConnection();
			String sql;

			if (doadores.getCd_usuario() == null) {
				sql = "insert into doadores" + "(username, email, senha, imagem, ativo, nome, status, cpf)"
						+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
			} else {
				sql = "update doadores"
						+ " set username=?, email=?, senha=?, imagem=?, ativo=?, nome=?, status=?, cpf=?"
						+ " where cd_usuario=? ;";
			}

			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, doadores.getUsername());
			preparedStatement.setString(2, doadores.getEmail());
			preparedStatement.setString(3, doadores.getSenha());
			preparedStatement.setString(4, doadores.getImagem());
			preparedStatement.setBoolean(5, doadores.getAtivo());
			preparedStatement.setString(6, doadores.getNome());
			preparedStatement.setString(7, doadores.getStatus());
			preparedStatement.setString(8, doadores.getCpf());

			if (doadores.getCd_usuario() != null) {
				preparedStatement.setLong(9, doadores.getCd_usuario());
			}

			int count = preparedStatement.executeUpdate();
			if (doadores.getCd_usuario() == null) {
				resultset = preparedStatement.getGeneratedKeys();
				if (resultset.next()) {
					doadores.setCd_usuario(resultset.getLong("cd_usuario"));
				}
			}

			return count > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (resultset != null) {
				resultset.close();
			}
		}
		return false;
	}

	public boolean delete(Long cd_usuario) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			String sql = "delete from doadores where cd_usuario = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, cd_usuario);
			int count = preparedStatement.executeUpdate();
			return count > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
		return false;
	}

	private Doador resultsetToDoadores(ResultSet resultSet) throws SQLException {
		Doador doador = new Doador();
		doador.setCd_usuario(resultSet.getLong("cd_usuario"));
		doador.setUsername(resultSet.getString("username"));
		doador.setEmail(resultSet.getString("email"));
		doador.setSenha(resultSet.getString("senha"));
		doador.setImagem(resultSet.getString("imagem"));
		doador.setAtivo(resultSet.getBoolean("ativo"));
		doador.setNome(resultSet.getString("nome"));
		doador.setStatus(resultSet.getString("status"));
		doador.setCpf(resultSet.getString("cpf"));
		return doador;
	}

	public static void main(String[] args) throws SQLException {
		// busca todos os registros na base de dados.
		DoadoresDAO doadoresDAO = new DoadoresDAO();

		List<Doador> doadores = doadoresDAO.getDoadores();
		System.out.println(doadores);

		// salva objeto carro
		Doador doador = new Doador();
		doador.setUsername("a");
		doador.setEmail("a");
		doador.setSenha("");
		doador.setImagem("");
		doador.setAtivo(true);
		doador.setNome("");
		doador.setStatus("luxo");
		doador.setCpf("luxo");

		doadoresDAO.save(doador);

		// delete
		// carroDAO.delete(51L);
		// carros = carroDAO.getCarros();
		// System.out.println(carros);

		// update
		doador = new Doador();
		doador.setUsername("a");
		doador.setEmail("a");
		doador.setSenha("");
		doador.setImagem("");
		doador.setAtivo(true);
		doador.setNome("");
		doador.setStatus("luxo");
		doador.setCpf("luxo");

		doadoresDAO.save(doador);
		System.out.println(doadoresDAO.getDoadores());

	}

}
