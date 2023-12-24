import configuration.JPAUtil;
import dao.AddressDao;
import dao.UserDao;
import entities.Address;
import entities.User;

import jakarta.persistence.EntityManager;

public class Application {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        UserDao userDao = new UserDao(entityManager);
        AddressDao addressDao = new AddressDao(entityManager);

        User user = new User();
        user.setName("Alvi");
        user.setEmail("Alvi@123.com");

        userDao.save(user);



        Address address = new Address();
        address.setPlace("Pakistan");
        address.setPhoneNumber("9200000000000");
        addressDao.save(address);


        User user1 = userDao.findUserById(user.getId());


        user1.setAddress(address);

        userDao.update(user1);


        entityManager.close();
    }
}
