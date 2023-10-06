package com.gloswitchcm237.tikitsupport.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gloswitchcm237.tikitsupport.models.Talk;

@Repository
public interface TalkRepositoy extends CrudRepository<Talk, Integer> {

}
