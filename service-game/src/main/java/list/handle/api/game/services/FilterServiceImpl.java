package list.handle.api.game.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterServiceImpl implements FilterService{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<String> getAllPlatforms(){
        return mongoTemplate.getCollection("games").distinct("platform", String.class).into(new ArrayList<String>());
    }

    @Override
    public List<String> getAllPegis(){
        return mongoTemplate.getCollection("games").distinct("pegi", String.class).into(new ArrayList<String>());
    }
}
