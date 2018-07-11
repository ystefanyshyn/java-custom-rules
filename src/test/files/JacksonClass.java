import com.fasterxml.jackson.annotation.JsonIgnore;

class MyClass {

    @JsonIgnore private Long member; // Noncompliant

    MyClass(MyClass mc) { }

    int     foo1() { return 0; }

    @JsonIgnore    void    foo2(int value) { }
    int     foo3(int value) { return 0; }
    Object  foo4(int value) { return null; }
    MyClass foo5(MyClass value) {return null; }

    int     foo6(int value, String name) { return 0; }
    int     foo7(int ... values) { return 0;}
}