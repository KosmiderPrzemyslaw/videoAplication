package pl.kosmider.videoApp.api;

import org.springframework.web.bind.annotation.*;
import pl.kosmider.videoApp.entity.VideoCassette;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassetts")
public class VideoCasseteApi {
    private List<VideoCassette> videoCassettes;

    public VideoCasseteApi() {
        videoCassettes = new ArrayList<>();
        videoCassettes.add(new VideoCassette(1L, "Titanic", LocalDate.of(1990, 1, 1)));
        videoCassettes.add(new VideoCassette(2L, "Iniemamocni", LocalDate.of(1995, 2, 2)));
    }

    @GetMapping("/all")
    public List<VideoCassette> getAll() {
        return videoCassettes;
    }

    @GetMapping
    public VideoCassette getById(@RequestParam int index){

        Optional<VideoCassette> first = videoCassettes.stream().filter(element -> element.getId() == index).findFirst();
        return first.get();
    }

    @PostMapping
    public boolean addVideo(@RequestBody VideoCassette videoCassette){
        return videoCassettes.add(videoCassette);
    }

    @PutMapping
    public boolean updateVideo(@RequestBody VideoCassette videoCassette){
        return videoCassettes.add(videoCassette);
    }

    @DeleteMapping
    public boolean delete(@RequestParam int index) {
        return videoCassettes.removeIf(element -> element.getId() == index);
    }
}
