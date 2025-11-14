package com.facultades.mensajes.servicio;

import com.facultades.mensajes.modelo.MensajeDTO;

import java.util.List;

public interface IEncriptacionService {

     String encriptar(String mensaje) throws Exception;
     public String desencriptar( String encryptedMessage) throws Exception;
     public List<MensajeDTO> desencriptarLista(List<MensajeDTO> mensajesEncriptados) throws Exception;
}
