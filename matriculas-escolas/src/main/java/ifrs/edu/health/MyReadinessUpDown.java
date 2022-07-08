package ifrs.edu.health;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

/*
 * Verificação de prontidão
 */
@Readiness
@ApplicationScoped
public class MyReadinessUpDown implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        int quantidadePendencias = 0;
        boolean temPendencias = quantidadePendencias > 0;
        HealthCheckResponseBuilder health = HealthCheckResponse.named("Verifica se está com pendências.").up();
        if (temPendencias) {
            health.down().withData("Pendencias: ", quantidadePendencias);
        }
        return health.build();
    }
}
