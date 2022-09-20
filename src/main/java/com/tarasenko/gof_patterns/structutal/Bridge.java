package com.tarasenko.gof_patterns.structutal;


abstract class AbstractWindow{
    public abstract void  createWindow();
    public abstract void closeWindow();
}


class LinuxWindow extends AbstractWindow {

    @Override
    public void createWindow() {
        System.out.println("Creating a Linux window");
    }

    @Override
    public void closeWindow() {
        System.out.println("Closing a Linux window");
    }
}


class MacOsWindow extends AbstractWindow {

    @Override
    public void createWindow() {
        System.out.println("Creating a MacOs window");
    }

    @Override
    public void closeWindow() {
        System.out.println("Closing a MacOs window");
    }
}



abstract class ProgramWindow {
    protected AbstractWindow window;

    public ProgramWindow(AbstractWindow window) {
        this.window = window;
    }

    public abstract void showWindow();
}

class saveWindow extends ProgramWindow {

    public saveWindow(AbstractWindow window) {
        super(window);
    }

    @Override
    public void showWindow() {
        window.createWindow();
        window.closeWindow();
    }
}


class openWindow extends ProgramWindow {

    public openWindow(AbstractWindow window) {
        super(window);
    }

    @Override
    public void showWindow() {
        window.createWindow();
        window.closeWindow();
    }
}





public class Bridge {
    public static void main(String[] args) {
        AbstractWindow linuxWindow = new LinuxWindow();
        ProgramWindow programWindow = new saveWindow(linuxWindow);
        programWindow.showWindow();

    }
}
