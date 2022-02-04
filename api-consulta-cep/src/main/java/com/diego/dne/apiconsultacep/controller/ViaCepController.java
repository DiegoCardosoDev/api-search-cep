package com.diego.dne.apiconsultacep.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.diego.dne.apiconsultacep.exeptions.CepNotfoundExeption;
import com.diego.dne.apiconsultacep.to.EnderecoTO;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Slf4j
@RestController
public class ViaCepController implements Serializable {

    private static final long serialVersionUID = 6046704732666502085L;


    @GetMapping(value="/getCep/{cep}")

    public Object doObterCep(@PathVariable(name = "cep") String cep) throws CepNotfoundExeption {

        
        EnderecoTO enderecoTO = null;
        try {
            RestTemplate restTemplate = new RestTemplate();


            String uri = "http://viacep.com.br/ws/{cep}/json/";


            Map<String, String> params = new HashMap<String, String>();
            params.put("cep", cep);


            enderecoTO = restTemplate.getForObject(uri, EnderecoTO.class, params);


            return new ResponseEntity<EnderecoTO>(enderecoTO, HttpStatus.OK);

        } catch (CepNotfoundExeption exception) {
            exception.getMessage();
            return new ResponseEntity<EnderecoTO>(enderecoTO, HttpStatus.NOT_FOUND);
        }


    }

}
