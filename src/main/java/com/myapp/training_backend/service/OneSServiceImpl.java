package com.myapp.training_backend.service;

import com.myapp.training_backend.dto.request.OneSRequestDto;
import com.myapp.training_backend.dto.response.OneSResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class OneSServiceImpl implements OneSService{

    @Value("${1S_EXTERNAL_URL}")
    private String apiUrl;

    @Value("${1S_EXTERNAL_USERNAME}")
    private String apiUsername;

    @Value("${1S_EXTERNAL_PASSWORD}")
    private String apiPassword;

    private static final Logger logger = LoggerFactory.getLogger(OneSServiceImpl.class);

    @Override
    public boolean transferDataTo1s(OneSRequestDto oneSRequestDto) {
        RestTemplate restTemplate = new RestTemplate();

        OneSResponseDto oneSResponseDto = new OneSResponseDto(
                "Заявка на организацию обучения рабочих и РСС отдела/цеха " + oneSRequestDto.department(),
                oneSRequestDto.author(),
                "Глинщик Алла Геннадьевна",
                oneSRequestDto.fileName(),
                oneSRequestDto.fileData(),
                true
        );

        logger.info("Sending request to {}", apiUrl);
        // Заголовки
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String auth = apiUsername + ":" + apiPassword;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        headers.set("Authorization", "Basic " + encodedAuth);

        HttpEntity<OneSResponseDto> entity = new HttpEntity<>(oneSResponseDto, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, entity, String.class);
            logger.info("Received response: {}", response.getStatusCode());
            return response.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            logger.error("Error : {}", String.valueOf(e));
            return false;
        }
    }
}
