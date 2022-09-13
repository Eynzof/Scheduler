package com.eynzo.scheduler.controllers;


import com.eynzo.scheduler.models.Speaker;
import com.eynzo.scheduler.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return speakerRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker create(@RequestBody Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        speakerRepository.deleteById(id);
    }

    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        Speaker existingSpeaker = speakerRepository.getOne(id);
//        不拷贝主键
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");

        return speakerRepository.saveAndFlush(existingSpeaker);
    }

}
