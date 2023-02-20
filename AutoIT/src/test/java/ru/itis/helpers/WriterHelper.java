package ru.itis.helpers;

import org.openqa.selenium.By;
import ru.itis.ApplicationManager;
import ru.itis.basic.HelperBase;
import ru.itis.models.jaxb.Lines;
import ru.itis.models.Line;

public class WriterHelper extends HelperBase {

    private final ReaderHelper readerHelper;

    public WriterHelper(ApplicationManager applicationManager) {
        super(applicationManager);
        readerHelper = applicationManager.getReaderHelper();
    }

    public void writeLine(Line line) {
        String before = readerHelper.readAll();
        driver.findElement(By.id(EDITOR_CLASSNAME)).sendKeys(before + line.getLine() + "\n");
    }

    public void replace(int index, Line line) {
        Lines lines = readerHelper.readLines();
        clearAll();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lines.getLines().size(); i++) {
            if (i != index) stringBuilder.append(lines.getLines().get(i).getLine());
            else stringBuilder.append(line.getLine());
            stringBuilder.append("\n");
        }
        writeLine(new Line(stringBuilder.toString()));
    }

    public void delete(int index) {
        Lines lines = readerHelper.readLines();
        clearAll();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lines.getLines().size(); i++) {
            if (i != index) {
                stringBuilder.append(lines.getLines().get(i).getLine());
                stringBuilder.append("\n");
            }
        }
        writeLine(new Line(stringBuilder.toString()));
    }
}
