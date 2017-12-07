package be.quatrefeuilles.webshop.documents;

public enum PageFormat {

    A4(297, 210),
    A3(420, 297),
    LETTER(279, 216);

    double height;
    double width;

    PageFormat(double height, double width) {
        this.height = height;
        this.width = width;
    }

}
