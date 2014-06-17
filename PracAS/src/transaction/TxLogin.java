package transaction;
import com.pracas.domain.controller.DataFactory;
import com.pracas.domain.controller.ICtrlUsuariRegistrat;
import com.pracas.domain.model.UsuariRegistrat;
import com.pracas.exceptions.UsernameNotExistsException;
import com.pracas.exceptions.WrongPasswordException;

public class TxLogin {
	/* wat */
	private String userN;
	private String passwd;
	
	public TxLogin(String userN, String passwd) {
		super();
		this.userN = userN;
		this.passwd = passwd;
	}

	public void executar() throws UsernameNotExistsException, WrongPasswordException {
		ICtrlUsuariRegistrat icur = DataFactory.getInstance().getCtrlUsuariRegistrat();
		UsuariRegistrat usuari = icur.getUsuariRegistrat(userN);
		if (!usuari.checkPassword(passwd)) {
			throw new WrongPasswordException();
		}
	}
	
}
