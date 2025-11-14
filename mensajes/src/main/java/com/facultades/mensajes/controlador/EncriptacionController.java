package com.facultades.mensajes.controlador;

import com.facultades.mensajes.modelo.MensajeDTO;
import com.facultades.mensajes.servicio.IEncriptacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class EncriptacionController {

    @Value("${server.port}")
    int serverPort;

    @Autowired
    private IEncriptacionService encriptacionService;

    @GetMapping("/encriptar")
    public ResponseEntity<String> encriptar(@RequestParam String mensaje) throws Exception {

        return  ResponseEntity.ok(encriptacionService.encriptar(mensaje));
    }

    @GetMapping("/desencriptar")
    public ResponseEntity<String> desencriptar(@RequestParam String mensajeEncriptado) throws Exception {
        return  ResponseEntity.ok(encriptacionService.desencriptar(mensajeEncriptado));
    }

    @PostMapping("/desencriptarLista")
    public ResponseEntity<List<MensajeDTO>> desencriptarLista(@RequestBody List<MensajeDTO> listaMensajesEncriptadosDTO) throws Exception {
        System.out.println("----------estoy en el puerto: " + serverPort);
        return ResponseEntity.ok(encriptacionService.desencriptarLista(listaMensajesEncriptadosDTO));
    }
}
