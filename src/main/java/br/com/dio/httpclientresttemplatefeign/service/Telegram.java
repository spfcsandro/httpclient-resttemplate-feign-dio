package br.com.dio.httpclientresttemplatefeign.service;

import br.com.dio.httpclientresttemplatefeign.client.FeingClient;
import br.com.dio.httpclientresttemplatefeign.client.JavaHttpClient;
import br.com.dio.httpclientresttemplatefeign.client.RestTemplateClient;
import br.com.dio.httpclientresttemplatefeign.dto.MessageSend;
import br.com.dio.httpclientresttemplatefeign.dto.ResultBotTelegram;
import br.com.dio.httpclientresttemplatefeign.dto.ResultBotTelegramList;
import org.springframework.stereotype.Service;

@Service
public class Telegram {
    private RestTemplateClient restTemplateClient;
    private FeingClient feingClient;
    private JavaHttpClient javaHttpClient;

    public Telegram(RestTemplateClient restTemplateClient, FeingClient feingClient, JavaHttpClient javaHttpClient) {
        this.restTemplateClient = restTemplateClient;
        this.feingClient = feingClient;
        this.javaHttpClient = javaHttpClient;
    }

    public void enviarMensagem(MessageSend mensagem) {
        //HTTP CLIENT
        ResultBotTelegram resultBotTelegramResponseEntity = javaHttpClient.enviarMensagem(mensagem);

        //RestTemplate
        restTemplateClient.enviarMensagem(mensagem);

        //FeingClient
        ResultBotTelegram resultBotTelegram = feingClient.enviarMensagem1(mensagem);
    }

    public ResultBotTelegramList buscarAtualizacao() {
        //HTTP CLIENT
        ResultBotTelegramList resultBotTelegramList = javaHttpClient.buscarAtualizacao();

        //RestTemplate
        ResultBotTelegramList resultBotTelegramList1 = restTemplateClient.buscarAtualizacao();

        //FeingClient
        feingClient.buscaratualizacao();
        return resultBotTelegramList;
    }
}
