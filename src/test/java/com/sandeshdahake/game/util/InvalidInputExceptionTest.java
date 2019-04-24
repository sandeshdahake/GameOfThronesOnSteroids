package com.sandeshdahake.game.util;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author sandeshDahake
 */
public class InvalidInputExceptionTest {
    @Test
    public void should_returnInvalidInputExceptionMessage_when_getMessageCalled() throws Exception {
        InvalidInputException invalidInputException = new InvalidInputException();

        Assertions.assertThat(invalidInputException.getMessage()).isEqualTo(MessagesUtil.INVALID_INPUT);
    }

}