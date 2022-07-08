package ifrs.edu.health;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

/*
 * Verificação de vivacidade
 */
@Liveness
@ApplicationScoped
public class MyLivenessCheckTime implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("Application UP").up().withData("Tempo de Resposta em milessegundos", 100)
                .build();
    }
}
