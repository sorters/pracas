package transaction;
import com.pracas.domain.controller.CtrlDataFactory;
import com.pracas.domain.controller.ICtrlUsuariRegistrat;

public class TxLogin {
	/**/
	private String userN;
	private String passwd;
	
	public void executar() {
		ICtrlUsuariRegistrat icur = CtrlDataFactory.getInstance().getCtrlUsuariRegistrat();
		icur.getUsuariRegistrat(userN);
	}

	public String getUserN() {
		return userN;
	}

	public void setUserN(String userN) {
		this.userN = userN;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
