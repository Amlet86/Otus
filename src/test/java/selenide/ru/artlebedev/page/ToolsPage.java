package selenide.ru.artlebedev.page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ToolsPage {

    public MatrixPage chooseMatrixIdea() {
        $("#item-matrix").click();
        return page(MatrixPage.class);
    }

}
