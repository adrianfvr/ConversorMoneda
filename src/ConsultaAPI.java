import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConsultaAPI {
    // Atributos
    private String API_KEY = "0350f74ee80aa12de05aa976";
    private String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY;
    private HttpClient client;

    // Constructor
    public ConsultaAPI() {
        this.client = HttpClient.newHttpClient();
    }

    // Metodos
    public boolean verificarMoneda(String moneda) {
        try {
            URI direccion = URI.create(BASE_URL + "/codes");
            HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonResponse = new Gson().fromJson(response.body(), JsonObject.class);
            if (!jsonResponse.get("result").getAsString().equals("success")) return false;

            for (var item : jsonResponse.getAsJsonArray("supported_codes")) {
                if (item.getAsJsonArray().get(0).getAsString().equalsIgnoreCase(moneda)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al verificar el codigo de moneda: " + e.getMessage());
        }
        return false;
    }

    public double convertir(String monedaOrigen, String monedaDestion, double cantidad) {
        try {
            URI direccion = URI.create(BASE_URL + "/pair/" + monedaOrigen + "/" + monedaDestion + "/" + cantidad);
            HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonResponse = new Gson().fromJson(response.body(), JsonObject.class);
            if (!jsonResponse.get("result").getAsString().equals("success")) return -1;
            return jsonResponse.get("conversion_result").getAsDouble();
        } catch (Exception e ) {
            System.out.println("Ocurrio un error al convertir la cantidad: " + e.getMessage());
            return -1;
        }
    }

    public void obtenerTasaCambio(String monedaBase) {
        try {
            URI direccion = URI.create(BASE_URL + "/latest/" + monedaBase);
            HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonResponse = new Gson().fromJson(response.body(), JsonObject.class);
            if (!jsonResponse.get("result").getAsString().equals("success")) {
                System.out.println("Error al obtener tasa de Cambio");
                return;
            };
            JsonObject tasas = jsonResponse.getAsJsonObject("conversion_rates");
            System.out.println("Tasas de cambio para " + monedaBase + ":");
            tasas.entrySet().forEach(item -> System.out.println(item.getKey() + ": " + item.getValue()));
        } catch (Exception e ) {
            System.out.println("Ocurrio un error al generar la Tasa de Cambio: " + e.getMessage());
        }
    }
}
