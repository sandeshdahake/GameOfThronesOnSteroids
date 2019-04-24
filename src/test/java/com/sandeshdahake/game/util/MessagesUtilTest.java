package com.sandeshdahake.game.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author sandeshDahake
 */
public class MessagesUtilTest {
    @Test
    public void when_message_passed_should_match(){
        Assert.assertEquals("Invalid Input, try again...",MessagesUtil.INVALID_INPUT);
    }

}