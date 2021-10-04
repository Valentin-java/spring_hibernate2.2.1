package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public User add(User user) {
      userDao.add(user);
      return user;
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public User getUserByModel(String model) {
      return userDao.getUserByModel(model);
   }

   @Transactional
   @Override
   public void cleanDb() {
      userDao.cleanDb();
   }

   @Transactional
   @Override
   public void removeUserById(long id) {
      userDao.removeUserById(id);
   }

}
