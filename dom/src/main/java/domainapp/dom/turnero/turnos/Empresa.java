package domainapp.dom.turnero.turnos;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PrimaryKey;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.value.Blob;
@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.APPLICATION)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class Empresa {
	private String cuil;
	private String nombre;
	private Blob logo;
	@PrimaryKey
    @javax.jdo.annotations.Column(allowsNull="false", length = 40)
    @Property(
            editing = Editing.DISABLED
    )
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
	@javax.jdo.annotations.Column(allowsNull="false", length = 200)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@javax.jdo.annotations.Column(allowsNull="true")
	public Blob getLogo() {
		return logo;
	}
	public void setLogo(Blob logo) {
		this.logo = logo;
	}
	
	
    public TranslatableString title() {
        return TranslatableString.tr("Object: {name}", "name", this.getNombre());
    }
}
