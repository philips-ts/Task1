package com.tarasenko.gof_patterns.structutal;


interface Component {
    void doAction();
}

class ComponentImpl implements Component {
    @Override
    public void doAction() {
        System.out.println("Component action.");
    }
}


abstract class ComponentDecorator implements Component {
    protected final Component component;

    public ComponentDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void doAction() {
        component.doAction();
    }

    public abstract void doAnotherAction();
}

class ComponentDecoratorImpl extends ComponentDecorator {
    public ComponentDecoratorImpl(Component component) {
        super(component);
    }

    @Override
    public void doAction() {
        component.doAction();
    }

    public void doAnotherAction() {
        System.out.println("Another action");
    }
}





public class Decorator {
    public static void main(String[] args) {
        Component component = new ComponentImpl();
        ComponentDecorator decorator = new ComponentDecoratorImpl(component);

        decorator.doAction();
        decorator.doAnotherAction();
    }

}
