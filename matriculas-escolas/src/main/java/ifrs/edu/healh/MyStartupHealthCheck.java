package ifrs.edu.healh;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Startup;

/*
 * Verificação de integridade de inicialização
 */
@Startup
@ApplicationScoped
public class MyStartupHealthCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up("Startup health check.");
    }
}
