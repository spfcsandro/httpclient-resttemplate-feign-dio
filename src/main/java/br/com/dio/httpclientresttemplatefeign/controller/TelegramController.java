package br.com.dio.httpclientresttemplatefeign.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.dio.httpclientresttemplatefeign.dto.MessageSend;
import br.com.dio.httpclientresttemplatefeign.dto.ResultBotTelegramList;
import br.com.dio.httpclientresttemplatefeign.service.Telegram;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/telegram")
public class TelegramController {

    private Telegram telegram;
    private ObjectMapper objectMapper;

    public TelegramController(Telegram soldadoService, ObjectMapper objectMapper) {
        this.telegram = soldadoService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public ResponseEntity criarSoldado(@RequestBody MessageSend messageRequest) {
        System.out.println("Entrou no post");
        telegram.enviarMensagem(messageRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<ResultBotTelegramList> buscarSoldados() {
        ResultBotTelegramList getUpdatesResultBotTelegram = telegram.buscarAtualizacao();
        return ResponseEntity.ok(getUpdatesResultBotTelegram);
    }
}
