package ifrs.edu.healh;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

/*
 * Verificação de vivacidade
 */
@Liveness
@ApplicationScoped
public class MyLivenessCheckUp implements HealthCheck {

    /* Testa se a aplicação está saudável */
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("Aplication UP").up().build();
    }
}
