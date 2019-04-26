package lambda;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {

        // ссылка на конструктор черз нотацию Classname::new
        // где ClassName не может быть абстрактным классом или интрефейсом
        ButtonFactory<Button> factory = Button::new;
        Button button1 = factory.set("Gray", "Cancel");
        Button button2 = factory.set("Gray", "Cancel");
        Button button3 = factory.set("Gray", "Cancel");
        Button button4 = factory.set("Gray", "Cancel");
        Button button5 = factory.set("Gray", "Cancel");


        System.out.println(button1);


        Consumer<Button> makeBtn = (button -> {
            button1.setColor("blue");
            button1.setValue("Reset");
        }
        );

        makeBtn.accept(button1);
        System.out.println(button1);






    }

}

interface ButtonFactory<T extends Button> {
    T set(String value, String color);
}


class Button {

    String color;
    String value;

    public Button(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Button{" +
                "color='" + color + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
