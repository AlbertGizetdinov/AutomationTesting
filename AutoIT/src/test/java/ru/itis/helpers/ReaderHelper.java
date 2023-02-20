package ru.itis.helpers;

import org.openqa.selenium.By;
import ru.itis.ApplicationManager;
import ru.itis.basic.HelperBase;
import ru.itis.models.jaxb.Lines;
import ru.itis.models.Line;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReaderHelper extends HelperBase {

    public ReaderHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public String readAll() {
        return driver.findElement(By.id(EDITOR_CLASSNAME)).getAttribute("Name");
    }

    public Lines readLines() {
        Lines lines = new Lines();
        lines.setLines(Arrays.stream(readAll().split("\n"))
                .filter(Objects::nonNull)
                .filter(x -> x.length() > 0)
                .map(Line::new)
                .collect(Collectors.toList()));
        return lines;
    }

    public Line readLastLine() {
        return readLines().getLines().get(readLines().getLines().size() - 1);
    }

    public Line readLine(int index) {
        return readLines().getLines().get(index);
    }

    public int count() {
        return readLines().getLines().size();
    }
}
