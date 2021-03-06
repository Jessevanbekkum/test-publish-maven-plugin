package com.xebia;

import com.xebia.internal.parser.TestSuite;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSuiteTest {

    @Test
    void shouldParseFile() throws IOException, JAXBException {

        try (FileInputStream adrFile = new FileInputStream(this.getClass().getResource("/TEST-com.xebia.ApplicationIT.xml").getFile())) {
            JAXBContext ctx = JAXBContext.newInstance(TestSuite.class);
            Unmarshaller um = ctx.createUnmarshaller();
            TestSuite rootElement = (TestSuite) um.unmarshal(adrFile);
            assertEquals(rootElement.getTestCases().size(), 2);
        }
    }
}