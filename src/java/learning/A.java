package java.learning;

public class A implements C,B{
    public static void main(String[] args) {
        C obj = new A();
        obj.print();
    }

    @Override
    public void print() {

    }
}


interface B {
    void print();
}

interface C {
    void print();
}


