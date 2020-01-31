package com.danix.code.smell.example001;

import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;
/**
 * @author  danix
 */
public class CustomerTest {


    @Test
    public void shouldReturnName() {

        Customer customer = Mockito.mock(Customer.class);
        when(customer.getFullName()).thenReturn("Good");
        assertEquals("Good", customer.getFullName());

    }

}
