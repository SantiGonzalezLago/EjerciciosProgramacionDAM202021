package gal.teis.model.vaccines;

/**
 * <h2>IAuthorizable</h2>
 * 
 * Esta interfaz declara métodos para autorizar o rechazar un objeto
 * 
 * @author Santiago González Lago
 */
public interface IAuthorizable {

	/**
	 * @return Si el objeto ha sido autorizado
	 */
	public boolean authorize();

	/**
	 * @return Si el objeto ha sido rechazado
	 */
	public boolean reject();
}
