package cursoDAgil.dao.cliente;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.mappers.ClienteMapper;

@Named
public class ClienteDaoImpl implements ClienteDao, Serializable {

	private static final long serialVersionUID = 2258246685723751527L;	
	SqlSession sqlSession;	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Cliente> listarTodosClientes() {
		List<Cliente> list = null;
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			list = clienteMapper.listarTodosClientes();
			for(Cliente c:list){
				System.out.println("Id: " + c.getId());
				System.out.println("Nombre: " + c.getNombre());
				System.out.println("Apellido" + c.getApellido());
				System.out.println("Email" + c.getEmail());
				System.out.println("Sexo" + c.getSexo());
				System.out.println("Id Direccion" + c.getIddireccion() );
				System.out.println("Calle" + c.getDireccion().getCalle() );
				System.out.println("Número" + c.getDireccion().getNumero());
				System.out.println("Colonia" + c.getDireccion().getColonia() );
				System.out.println("Ciudad" + c.getDireccion().getCiudad());
				System.out.println("País" + c.getDireccion().getPais());
				System.out.println("Código Postal" + c.getDireccion().getCodigoPostal());
			}
			return list;
		}catch (Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}
}