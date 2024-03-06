package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video")
public class ApiController {
    private final Logger log = LoggerFactory.getLogger(ApiController.class);
    Map<Integer, Video> videos = new HashMap();
    int counter = 1;

    @GetMapping
    public List<Video> getVideos() {
        return new ArrayList<Video>(videos.values());
    }

    @GetMapping("/{id}")
    public Video getVideo(@PathVariable(name = "id") int id) {
        if (videos.keySet().contains(id))
            return videos.get(id);
        else
            return null;
    }

    @PostMapping
    public Video postVideo(@RequestBody Video video) {
        videos.put(counter, video);
        counter++;
        return video;
    }

    @PutMapping("/{id}")
    public Video putVideo(@PathVariable(name = "id") int id, @RequestBody Video video) {
        videos.replace(id, video);
        return video;
    }

    @DeleteMapping("/{id}")
    public Video deleteVideo(@PathVariable(name = "id") int id) {
        Video video = videos.get(id);
        videos.remove(id);
        return video;
    }
}
