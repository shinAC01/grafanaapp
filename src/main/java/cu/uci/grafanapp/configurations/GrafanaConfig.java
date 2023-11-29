package cu.uci.grafanapp.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GrafanaConfig {

    @Value("${grafana.api.url}")
    private String grafanaApiUrl;

    @Value("${grafana.api.key}")
    private String grafanaApiKey;

    public ResponseEntity<String> obtenerDatosDeGrafana() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(grafanaApiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                grafanaApiUrl,
                HttpMethod.GET,
                entity,
                String.class
        );

        return response;
    }
}
