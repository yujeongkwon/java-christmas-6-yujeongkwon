package christmas.domain;

import java.util.List;

public enum Menu {
    APPETIZER("애피타이저", List.of(
            new Food("양송이수프", 6000),
            new Food("타파스", 5500),
            new Food("시저샐러드", 8000)
    )),
    MAIN("메인", List.of(
            new Food("티본스테이크", 55000),
            new Food("바비큐립", 54000),
            new Food("해산물파스타", 35000),
            new Food("크리스마스파스타", 25000)
    )),
    DESSERT("디저트", List.of(
            new Food("초코케이크", 15000),
            new Food("아이스크림", 5000)
    )),
    BEVERAGE("음료", List.of(
            new Food("제로콜라", 3000),
            new Food("레드와인", 60000),
            new Food("샴페인", 25000)
    ));

    private String categoryName;
    private List<Food> foods;

    Menu(String categoryName, List<Food> foods) {
        this.categoryName = categoryName;
        this.foods = foods;
    }


}
