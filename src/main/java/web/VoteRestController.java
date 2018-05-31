package web;

import authorized.AuthorizedUser;
import model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.VoteService;

import java.net.URI;
import java.util.List;

/**
 * Created by RLuchinsky on 30.05.2018.
 */

@RestController
@RequestMapping(VoteRestController.VOTE_REST_URL)
public class VoteRestController {

    @Autowired
    private VoteService service;

    static final String VOTE_REST_URL = "/vote/{restId}";

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer getAll(@PathVariable("restId") int restId) {
        System.out.println("GET");
        return service.countByRestaurantId(restId);
    }


    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Vote> createWithLocation(@PathVariable("restId") int restId) {
        System.out.println("CREATE");
        Vote created = service.create(AuthorizedUser.id(), restId);

        System.out.println(created);


//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(uriOfNewResource);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/vote/" + restId + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping()
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete() {
        Integer userId = AuthorizedUser.id();
        service.delete(userId);
    }
}
