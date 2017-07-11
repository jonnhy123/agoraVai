package interfaces;
import java.util.List;
import classes.Numeros;
public interface Banco {
	
	public void salvar(Object bean);
	public void update(Object bean);
	public void deletar(int id);
	public Object getById(int id);
	public List<Object> getAll();
	 
}
