package org.sagebionetworks.bridge.json;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonGenerator;
import org.joda.time.LocalDate;
import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;

public class LocalDateToStringSerializerTest {
    @Test
    public void test() throws Exception {
        // mock JsonGenerator
        JsonGenerator mockJGen = mock(JsonGenerator.class);

        // execute and validate
        new LocalDateToStringSerializer().serialize(new LocalDate(2014, 2, 12), mockJGen, null);
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
        verify(mockJGen).writeString(arg.capture());
        assertEquals(arg.getValue(), "2014-02-12");
    }
}
