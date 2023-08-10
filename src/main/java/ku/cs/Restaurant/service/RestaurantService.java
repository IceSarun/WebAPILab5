package ku.cs.Restaurant.service;

import ku.cs.Restaurant.entity.Restaurant;
import ku.cs.Restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository repository;

    public List<Restaurant> getAll(){
        return  repository.findAll();

    }
    public  Restaurant getRestaurantByID(UUID id){
        return repository.findById(id).get();
    }
    public Restaurant update (Restaurant requestBody){
        UUID id = requestBody.getId();
        Restaurant record = repository.findById(id).get();
        record.setName(requestBody.getName());
        record.setLocation(requestBody.getLocation());
        record .setRating(requestBody.getRating());
        record = repository.save(record);
        return record;
    }

    public Restaurant delete (UUID id){
        Restaurant record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }
    public Restaurant getRestaurantByName(String name){
        return repository.findByName(name);

    }

    public List<Restaurant> getRestaurantByLocation(String location) {
        return repository.findByLocation(location);
    }

    public Restaurant create(Restaurant restaurant){
        return repository.save(restaurant);
    }
}
