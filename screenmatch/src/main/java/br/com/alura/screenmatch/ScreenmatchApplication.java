package br.com.alura.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// System.out.println("Primeiro projeto Spring sem Web");
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obetrDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=c483023a");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
		// json = consumoApi.obetrDados("https://coffee.alexflipnote.dev/random.json");
		// System.out.println(json);
	}
}

/*É bom pensar nesse tipo de boa prática de separar a responsabilidade e deixar essa responsabilidade
 * de consumir API numa classe separada.
 */