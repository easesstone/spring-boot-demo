package com.sydney.dream.repository;

import com.sydney.dream.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
//    List<Person> findByNameAandAndAddress(String name, String adress);
//
//    @Query(value = "select * from Person p where p.name =:name", nativeQuery = true)
//    List<Person> findByName1(@Param("name") String name);
//    @Query(value = "select * from #(#entityName) u where u.name=?1", nativeQuery = true)
//    List<Person> findByName2(String name);
//
//    List<Person> findByName3(String name);
    List<Person> findAll();
    Person getOne(Long id);
    Person save(Person person);
    void deleteById(Long id);

}
