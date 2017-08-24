package com.raskae.examples.acheronjavasqlite.data.local;

import android.support.test.InstrumentationRegistry;

import com.raskae.examples.acheronjavasqlite.data.model.User;
import com.raskae.examples.acheronjavasqlite.data.remote.UserInteractor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by ptenni on 24/8/2017.
 */

public class UserInteractorTest {

    private final static User EXISTING_USER = new User(1, "pier", "1234", "ptenni@nisum.com");
    private final static User NEW_USER = new User(2, "alberto", "1234", "alberto@mail.com");

    private UserInteractor userInteractor;

    @Before
    public void setup() {
        userInteractor = new UserInteractor(InstrumentationRegistry.getTargetContext());
    }

    @After
    public void cleanUp() {
        userInteractor.deleteAllUsers();
    }

    @Test
    public void testPreConditions() {
        assertNotNull(userInteractor);
    }

    @Test
    public void registerUser_getUser() {



        assertNotNull(userInteractor.getUser(EXISTING_USER));
//        assertNotNull(userInteractor.getUser(NEW_USER));
    }
}
