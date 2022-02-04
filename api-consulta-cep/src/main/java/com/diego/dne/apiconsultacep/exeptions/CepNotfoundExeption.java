package com.diego.dne.apiconsultacep.exeptions;

public class CepNotfoundExeption extends RuntimeException{

    public CepNotfoundExeption(String s){
        super(s);
    }
}
