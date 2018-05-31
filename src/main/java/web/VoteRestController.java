package web;

import authorized.AuthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.VoteService;


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
    public void addVote(@PathVariable("restId") int restId) {
         service.create(AuthorizedUser.id(), restId);

    }

    @DeleteMapping()
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete() {
        Integer userId = AuthorizedUser.id();
        service.delete(userId);
    }
}
