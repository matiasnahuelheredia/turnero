package domainapp.dom.turnero.turnos;

import javax.jdo.annotations.IdentityType;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.services.i18n.TranslatableString;
@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class TurnoSecuencial {

	private int numeroDeTurno;
	private Empresa empresa;
	 @javax.jdo.annotations.Column(allowsNull="false")
	public int getNumeroDeTurno() {
		return numeroDeTurno;
	}
	public void setNumeroDeTurno(int numeroDeTurno) {
		this.numeroDeTurno = numeroDeTurno;
	}
	 @javax.jdo.annotations.Column(allowsNull="false")
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
    public TranslatableString title() {
        return TranslatableString.tr("Object: {name}", "name", this.getNumeroDeTurno());
    }
}
