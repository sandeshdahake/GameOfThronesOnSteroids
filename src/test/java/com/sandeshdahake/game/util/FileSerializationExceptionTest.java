package com.sandeshdahake.game.util;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author sandeshDahake
 */
public class FileSerializationExceptionTest {
    @Test
    public void should_returnFileSerializationExceptionMessage_when_getMessageCalled() {
        FileSerializationException fileSerializationException = new FileSerializationException(new Throwable());

        Assertions.assertThat(fileSerializationException.getMessage()).isEqualTo(MessagesUtil.FILE_WRITE_EXCEPTION);
    }

}