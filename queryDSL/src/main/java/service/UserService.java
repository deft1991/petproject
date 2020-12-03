package service;

import com.google.common.collect.Lists;
import entity.QUser;
import entity.User;
import entity.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    //ищем по возрасту, исключая границы
    public List<User> getByAgeExcluding(Integer minAge, Integer maxAge) {
        return Lists.newArrayList(repository.findAll(QUser.user.age.between(minAge, maxAge)));
    }

    //ищем по возрасту, включая границы
    public List<User> getByAgeIncluding(Integer minAge, Integer maxAge) {
        return Lists.newArrayList(repository.findAll(QUser.user.age.goe(minAge).and(QUser.user.age.loe(maxAge))));
    }

    //ищем по ID
    public User getById(Long id) {
        return repository.findOne(QUser.user.id.eq(id)).orElse(new User());
    }

    public User get(Long id) {
        return repository.findById(id).orElse(new User());
    }

    //ищем по группам
    public List<User> getByGroups(List<UserGroup> groups) {
        return Lists.newArrayList(repository.findAll(QUser.user.group.in(groups)));
    }

    //ищем по имени
    public List<User> get(String name) {
        return Lists.newArrayList(repository.findAll(QUser.user.name.ne(name)));
    }
}
