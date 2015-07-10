package domainapp.dom.turnero.turnos;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.value.Blob;

import domainapp.dom.modules.simple.SimpleObject;

@DomainService(repositoryFor = Empresa.class)
@DomainServiceLayout(menuOrder = "20")
public class RepoEmpresa {

	
	
    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "1")
    public List<Empresa> listarTodas() {
        return container.allInstances(Empresa.class);
    }
    
    
    @MemberOrder(sequence = "1")
    public Empresa crearNuevaEmpresa(
            final @ParameterLayout(named="cuil") String cuil,
            final @ParameterLayout(named="Nombre") String nombre,
            final @ParameterLayout(named="Logo") Blob logo
            ) {
        final Empresa obj = container.newTransientInstance(Empresa.class);
        obj.setCuil(cuil);
        obj.setLogo(logo);
        obj.setNombre(nombre);
        container.persistIfNotAlready(obj);
        return obj;
    }

    
    
    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;
}
