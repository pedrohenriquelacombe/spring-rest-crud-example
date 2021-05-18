package com.example.rest.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "${viacep.url}")
public interface ViaCepAPI {

    @GetMapping("/{cep}/json")
    ViaCepAddress search(@PathVariable String cep);

    @Getter
    @Setter
    class ViaCepAddress {
        private String cep;
        private String logradouro;
        private String complemento;
        private String bairro;
        private String localidade;
        private String uf;
    }

}
