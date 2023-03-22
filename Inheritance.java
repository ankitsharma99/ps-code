
class First {
    First () {
        System.out.println("Called First Constructor");
    }
}

class Second extends First{
    Second () {
        System.out.println("Called Second Constructor");
    }
}

class Third extends Second{
    Third () {
        System.out.println("Called Third Constructor");
    }
}


class Fourth extends Third{
    Fourth() {
        System.out.println("Called Fourth Constructor");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        new Fourth();
    }
}
