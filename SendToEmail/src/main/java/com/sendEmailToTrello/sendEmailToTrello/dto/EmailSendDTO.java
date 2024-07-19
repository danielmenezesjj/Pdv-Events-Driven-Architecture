package com.sendEmailToTrello.sendEmailToTrello.dto;


import lombok.Getter;
import lombok.Setter;


public record EmailSendDTO(String destinatario, String assunto, String conteudo) {
}
