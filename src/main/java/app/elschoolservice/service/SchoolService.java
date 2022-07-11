package app.elschoolservice.service;

import app.elschoolservice.configuration.ElschoolServiceConfig;
import app.elschoolservice.utils.ObjectToUrlEncodedConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Service
public class SchoolService {
    private final RestTemplate restTemplate;
    private final ElschoolServiceConfig config;

    public SchoolService(RestTemplate restTemplate, ElschoolServiceConfig config) {
        this.restTemplate = restTemplate;
        this.config = config;
    }

    public void getLogon() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(buildParameters(), headers);
        //HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(null, headers);

        /*ObjectMapper mapper = new ObjectMapper();
        restTemplate.getMessageConverters().add(new ObjectToUrlEncodedConverter(mapper));*/

        String uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(config.getUrl())
                .queryParams(null)
                .build()
                .toString();

        //ResponseEntity<Void> response = restTemplate.postForEntity(uriComponents, request, Void.class);
        ResponseEntity response = restTemplate.postForObject(uriComponents, request, ResponseEntity.class);
        System.out.println(response);
    }

    private MultiValueMap<String, Object> buildParameters() {
        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<>();
        parameters.add("login", config.getLogin());
        parameters.add("password", config.getPassword());
        return parameters;
    }
}
