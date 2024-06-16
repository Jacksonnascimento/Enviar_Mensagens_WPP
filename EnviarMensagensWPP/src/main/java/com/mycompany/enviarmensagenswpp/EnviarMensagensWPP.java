/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.enviarmensagenswpp;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
/**
 *
 * @author jacks
 */
public class EnviarMensagensWPP {
    // Substitua estas constantes com suas credenciais da conta Twilio
    public static final String ACCOUNT_SID = "ACa5849e1048f4e20024b223697c315c6f";
    public static final String AUTH_TOKEN = "5df7403abe4ac797b25fad600b556257";
    int cont = 0;
   public void enviArMensagemViaTwilio(String destino, String mensagem){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Enviar uma mensagem de texto para um número do WhatsApp
       
        Message message = Message.creator(
                new PhoneNumber("whatsapp:+55" + destino),  // Número de destino
                new PhoneNumber("whatsapp:+14155238886"), // Número do Sandbox Twilio
                mensagem + "\n\nEste número não recebe mensagem!")
            .create();
        cont++;
        System.out.println("Mensagem " + cont + " enviada com SID: " + message.getSid());
        }
   
}
