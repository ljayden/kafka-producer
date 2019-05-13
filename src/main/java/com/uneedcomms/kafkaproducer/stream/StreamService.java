package com.uneedcomms.kafkaproducer.stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uneedcomms.kafkaproducer.permission.Permissions;
import com.uneedcomms.kafkaproducer.permission.PermissionsRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class StreamService {

    private ObjectMapper objectMapper;
    private PermissionsRepository permissionsRepository;

    public StreamService(ObjectMapper objectMapper, PermissionsRepository permissionsRepository) {
        this.objectMapper = objectMapper;
        this.permissionsRepository = permissionsRepository;
    }

    public String keyCheck(Map<String, Object> contents) throws JsonProcessingException {
        if(contents.containsKey("key")) {
            String key = (String)contents.get("key");

            Optional<Permissions> findedPermission = permissionsRepository.findById(key);
            if(findedPermission.isPresent()) {
                // TODO.. appId로 topic 생성후 kafka로 던짐
                System.out.println("존재 함");
            } else {
                // TODO.. 존재하는 업체 없음.
            }

        }
        return objectMapper.writeValueAsString(contents);
    }
}
