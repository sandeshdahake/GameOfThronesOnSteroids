package com.sandeshdahake.game.util;

import org.assertj.core.api.Assertions;
import org.junit.Test;


/**
 * @author sandeshDahake
 */
public class FileDeserializationExceptionTest {
    @Test
    public void should_returnFileDeserializationExceptionMessage_when_getMessageCalled() throws Exception {
        FileDeserializationException fileDeserializationException = new FileDeserializationException(new Throwable());

        Assertions.assertThat(fileDeserializationException.getMessage()).isEqualTo(MessagesUtil.FILE_READ_EXCEPTION);
    }

}