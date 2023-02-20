package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.itis.generators.Generator;
import ru.itis.models.jaxb.Lines;
import ru.itis.basic.TestBase;
import ru.itis.models.Line;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@RunWith(Parameterized.class)
public class A_AddLineTest extends TestBase {

    @Parameterized.Parameter
    public Line line;

    @Parameterized.Parameters(name = "Line")
    public static List<Line> linesFromXmlFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Lines.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Lines lines = (Lines) unmarshaller.unmarshal(new File(Generator.DIRECTORY + "/lines.xml"));
            return lines.getLines();
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Test
    public void addLineTest() {
        applicationManager.getWriterHelper().writeLine(line);
        Assert.assertEquals(line.getLine(), applicationManager.getReaderHelper().readLastLine().getLine());
    }


}
