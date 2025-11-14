package com.facultades.mensajes.servicio;
import com.facultades.mensajes.modelo.MensajeDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class EncriptacionService implements  IEncriptacionService{
    @Value("${ALGORITMO}")
    private  String ALGORITHM = "";
    @Value("${SECRETKEY}")
    private  String SECRET_KEY = "";

    @Override
    public String encriptar(String mensaje) throws Exception {
        // Se crea una clave secreta de tipo SecretKeySpec a partir de la clave definida en SECRET_KEY.
        // Esta clave es convertida a bytes y se utiliza junto con el algoritmo AES para el cifrado.
        // 'ALGORITHM' es la constante que contiene el nombre del algoritmo, en este caso "AES".
        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);

        // Se crea un objeto Cipher que es el encargado de realizar las operaciones de cifrado y descifrado.
        // 'getInstance(ALGORITHM)' obtiene un objeto Cipher que usa el algoritmo AES.
        Cipher cipher = Cipher.getInstance(ALGORITHM);

        // Se inicializa el objeto Cipher para realizar el cifrado (ENCRYPT_MODE) utilizando la clave secreta.
        // Esto prepara el cifrador para que pueda procesar el mensaje y cifrarlo.
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);


        // Se encripta el mensaje recibido en texto plano.
        // El mensaje se convierte a un arreglo de bytes con 'message.getBytes()' y luego se pasa al método 'doFinal'
        // del objeto Cipher para cifrar el mensaje.
        byte[] encryptedBytes = cipher.doFinal(mensaje.getBytes());

        // El resultado cifrado se convierte a una cadena de texto en Base64 para poder ser transmitido de manera segura.
        // Base64 codifica los bytes en una cadena de caracteres imprimibles (para evitar caracteres binarios ilegibles).
        return Base64.getEncoder().encodeToString(encryptedBytes);

    }

    @Override
    public String desencriptar( String encryptedMessage) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        // Decodifica el mensaje cifrado de Base64 a un arreglo de bytes.
        // Luego, usa el objeto 'cipher' en modo DESCIFRADO (DECRYPT_MODE) para descifrar los bytes.
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));

        // Convierte los bytes descifrados en una cadena de texto original y la retorna como resultado.
        return new String(decryptedBytes);
    }

    @Override
    public List<MensajeDTO> desencriptarLista(List<MensajeDTO> mensajesEncriptadosDTO) throws Exception {
        for (MensajeDTO mensajeEncriptado:mensajesEncriptadosDTO){
            String mensajeDesencriptado = this.desencriptar(mensajeEncriptado.getContenido());
            mensajeEncriptado.setContenido(mensajeDesencriptado);
        }

        return mensajesEncriptadosDTO;
    }
}
