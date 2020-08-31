package com.alexander.graduation.web.controller;

import com.alexander.graduation.model.*;
import com.alexander.graduation.repository.CrudDishRepository;
import com.alexander.graduation.repository.CrudRestaurantRepository;
import com.alexander.graduation.repository.CrudUserRepository;
import com.alexander.graduation.repository.CrudVoteRepository;
import com.alexander.graduation.util.SecurityUtil;
import com.alexander.graduation.util.exception.InvalidDateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/test")
public class Test {

    private LocalTime maxTime = LocalTime.of(11, 0);

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CrudUserRepository userRepository;

    private final CrudRestaurantRepository resRepository;

    private final CrudDishRepository dishRepository;

    private final CrudVoteRepository voteRepository;

    @Autowired
    public Test(CrudUserRepository repository,
                CrudRestaurantRepository resRepository,
                CrudDishRepository dishRepository, CrudVoteRepository voteRepository) {
        this.userRepository = repository;
        this.resRepository = resRepository;
        this.dishRepository = dishRepository;
        this.voteRepository = voteRepository;
    }

    @GetMapping("/{id}")
    public User hello(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/create")
    public void create(@RequestParam(value = "id", required = false) Long id,
                       @RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "email", required = false) String email,
                       @RequestParam(value = "password", required = false) String pass) {
        User user = new User(id, name, email, pass);
        userRepository.save(user);
    }

    @GetMapping("/res")
    public List<Restaurant> getAllRes(@RequestParam(required = false) LocalDate date) {
        return resRepository.findAll();
    }

    @PostMapping("/res")
    public void addRes(Restaurant restaurant) {
        logger.debug("create: id restaurant =" + resRepository.save(restaurant).getId());
    }

    @GetMapping("/res/{id}/dishes")
    public List<Dish> getAllDish(@PathVariable Long id) {
        List<Dish> dishes = dishRepository.findAllByRestaurantId(id);
        for (var dish : dishes) {
            logger.debug("id restaurant = " + dish.getRestaurantId());
        }
        return dishes;
    }

    @PostMapping("/res/{id}/dishes")
    public void addDish(@PathVariable Long id, Dish dish) {
        logger.debug("addDish:" + dish.toString());
        dish.setRestaurantId(id);
        dishRepository.save(dish);
    }

    @PostMapping("/vote")
    public void addVote(@RequestBody Vote vote) {//TODO
        vote.setUserId(SecurityUtil.getId());
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime voteTime = LocalDateTime.of(vote.getDate(), maxTime);
        //now.setHours(10);
        //now = now.minus(6, ChronoUnit.HOURS);
        logger.debug("now: " + now);
        logger.debug("vote: " + vote.getDate());
        logger.debug("before: " + now.isBefore(voteTime));
        if (now.isAfter(voteTime))
            throw new InvalidDateException("Voting is not available after " + voteTime);
        Vote vote1 = voteRepository.getByDateAndUserId(vote.getDate(), vote.getUserId());
        if (vote1 == null) {
            voteRepository.save(vote);
        } else {
            voteRepository.update(vote1.getDate(), vote.getRestaurantId(), vote1.getId());
        }
    }

    @GetMapping("/vote")
    public List<Vote> getAllVote() {
        return voteRepository.getAllByUserId(SecurityUtil.getId());
    }

    @GetMapping("/vote/result")
    public List<ResultVote> getResult(
            @RequestParam(required = false) LocalDate date) {
        Map<Long,Long> counting =  voteRepository
                .getAllByDate(date)
                .stream()
                .collect(Collectors.groupingBy(Vote::getRestaurantId,Collectors.counting()));
        List<ResultVote> result = new ArrayList<>();
        for(var current:counting.entrySet()){
            ResultVote resultVote = new ResultVote(current.getValue(),current.getKey(),date);
            result.add(resultVote);
        }
        return result;
    }
}
