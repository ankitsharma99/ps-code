package firstsession.designpatterns.creational;

interface ThemeFactory {
    Button createButton();
    TextField createTextField();
    Label createLabel();
}

class DarkThemeFactory implements ThemeFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public TextField createTextField() {
        return new DarkTextField();
    }

    @Override
    public Label createLabel() {
        return new DarkLabel();
    }
}

class LightThemeFactory implements ThemeFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public TextField createTextField() {
        return new LightTextField();
    }

    @Override
    public Label createLabel() {
        return new LightLabel();
    }
}

// Define the abstract product interface
interface Button {
    void render();
}

interface TextField {
    void render();
}

interface Label {
    void render();
}

// Define concrete product classes that implement the abstract product interface
class DarkButton implements Button {
    @Override
    public void render() {
        // Render a dark-colored button
        System.out.println("Dark colored button rendered");
    }
}

class LightButton implements Button {
    @Override
    public void render() {
        // Render a light-colored button
        System.out.println("Light colored button rendered");
    }
}

class DarkTextField implements TextField {
    @Override
    public void render() {
        // Render a dark-colored text field
        System.out.println("Dark colored text field rendered");
    }
}

class LightTextField implements TextField {
    @Override
    public void render() {
        // Render a light-colored text field
        System.out.println("Light colored text field rendered");
    }
}

class DarkLabel implements Label {
    @Override
    public void render() {
        // Render a dark-colored label
        System.out.println("Dark color label rendered");
    }
}

class LightLabel implements Label {
    @Override
    public void render() {
        // Render a light-colored label
        System.out.println("Light color label rendered");
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        ThemeFactory themeFactory = new DarkThemeFactory();
        themeFactory.createButton().render();
        themeFactory.createLabel().render();
        themeFactory.createTextField().render();

        ThemeFactory lightThemeFactory = new LightThemeFactory();
        lightThemeFactory.createTextField().render();
        lightThemeFactory.createButton().render();
        lightThemeFactory.createLabel().render();
    }
}
