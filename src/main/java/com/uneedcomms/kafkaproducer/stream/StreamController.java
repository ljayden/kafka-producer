package com.uneedcomms.kafkaproducer.stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/events", produces = MediaTypes.HAL_JSON_UTF8_VALUE)
public class StreamController {

    private StreamService streamService;
    private ObjectMapper objectMapper;

    public StreamController(StreamService streamService, ObjectMapper objectMapper) {
        this.streamService = streamService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public ResponseEntity createEvent(@RequestBody @NotEmpty Map<String, Object> contents, Errors errors) throws JsonProcessingException {
        if(errors.hasErrors()){ return ResponseEntity.badRequest().build(); }
        return ResponseEntity.ok(streamService.keyCheck(contents));
    }

}
