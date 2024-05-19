package com.example.demo.API;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Configurable
public class API{
    public List<Object> webclient(String uri)
    {
        RestTemplate restTemplate = new RestTemplate();
        Object[] result = restTemplate.getForObject(uri,Object[].class);
        return Arrays.asList(result);
    }

}
