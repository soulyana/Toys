package me.soulyana.demo.repositories;

import me.soulyana.demo.models.Toy;
import org.springframework.data.repository.CrudRepository;

public interface ToyRepository extends CrudRepository<Toy, Long> {
}
