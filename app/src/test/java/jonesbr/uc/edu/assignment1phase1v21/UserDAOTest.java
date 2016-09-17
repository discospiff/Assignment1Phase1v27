package jonesbr.uc.edu.assignment1phase1v21;

/**
 * Created by jonesb on 5/18/2015.
 */

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import edu.uc.dao.IUserDAO;
import edu.uc.dto.User;

public class UserDAOTest extends TestCase {

    IUserDAO userDAO;

    @Override
    @Before
    protected void setUp() throws Exception {
        // TODO Auto-generated method stub
        super.setUp();
        userDAO = new UserProviderStub();
    }

    /**
     * Test scenarios:
     * 	Method fetchAll:
     * 	Should return a HashMap<String, User> with a single User object:
     * 	key: String "Caz"
     * 	value: User object with userName = "Caz", firstName = "Caz", lastName = "Dolowicz", and other attributes populated with your choice of values.
     */
    @Test
    public void testFetchAll() {
        HashMap<String, User> allUsers = userDAO.fetchAll();
        User caz = allUsers.get("Caz");
        assertNotNull(caz);
        assertEquals(caz.getFirstName(), "Caz");
        assertEquals(caz.getLastName(), "Dolowicz");
        assertEquals(caz.getUsername(), "Caz");
    }

    /**
     * Test these scenarios:
     * Method fetch:
     * 	Should create and return a new User object if the username is Caz.  See attribues above.
     * 	Should throw an exception in other circumstances.  This exception should contain a message.
     */
    @Test
    public void testFetch() {

        try {
            User caz = userDAO.fetch("Caz");
            assertEquals(caz.getFirstName(), "Caz");
            assertEquals(caz.getLastName(), "Dolowicz");
            assertEquals(caz.getUsername(), "Caz");
        } catch (Exception e) {
            fail("Should not throw Exception");
        }

        try {
            userDAO.fetch("Bugsy");
            fail("Should have thrown exception for invalid username");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Test scenarios:
     * Method save:
     * 	should process normally if username and password are completed.
     * 	should throw an exception if username and password  are blank or null.  The exception must have a message – don’t leave it with an empty constructor!
     */
    @Test
    public void testSave() {
        User validUser = new User();
        validUser.setFirstName("Caz");
        validUser.setLastName("Dolowicz");
        validUser.setUsername("Caz");
        validUser.setPassword("Cha5e5Cars");
        try {
            userDAO.save(validUser);
        } catch (Exception e) {
            fail("Should not throw Exception for valid user");
        }

        User invalidUser = new User();
        try {
            userDAO.save(invalidUser);
            fail("Should have thrown exception for saving invalid username");
        } catch (Exception e) {
        }
    }
}