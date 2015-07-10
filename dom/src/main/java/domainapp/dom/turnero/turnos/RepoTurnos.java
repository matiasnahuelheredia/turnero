package domainapp.dom.turnero.turnos;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.SemanticsOf;

@DomainService(repositoryFor = TurnoSecuencial.class)
@DomainServiceLayout(menuOrder = "50")
public class RepoTurnos {

    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "1")
    public List<TurnoSecuencial> listarTodos() {
        return container.allInstances(TurnoSecuencial.class);
    }
 
    
    @javax.inject.Inject
    private DomainObjectContainer container;
}
