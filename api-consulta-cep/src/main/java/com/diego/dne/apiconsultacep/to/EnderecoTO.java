package com.diego.dne.apiconsultacep.to;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class EnderecoTO implements Serializable {

    private static final long serialVersionUID = 7309680245862563917L;

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;



}
