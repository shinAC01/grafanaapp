package cu.uci.grafanapp.services;


import cu.uci.grafanapp.entity.GrafanaDashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GService {

    private final RestTemplate restTemplate;

    @Autowired
    public GService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void crearDashboardEnGrafana(GrafanaDashboard grafanaDashboard) {
        String grafanaApiUrl = "http://localhost:3000/api/dashboards/home"; // URL de la API de Grafana para crear dashboards
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Convierte el objeto Java a JSON
        HttpEntity<GrafanaDashboard> request = new HttpEntity<>(grafanaDashboard, headers);

        // Envia la solicitud POST a la API de Grafana
        restTemplate.postForObject(grafanaApiUrl, request, String.class);
    }
}
