package com.example.awtsample;


//FYI, the ' * ' means 'match all', we import all the classes, interfaces and static objects from the java.awt package. Can be dangerous, but yaknow
// java.awt.event is a different package though
import java.awt.*;//awt : abstract window toolkit. We know, thanks to this, that it provides everything necessary to create a GUI
import java.awt.event.WindowAdapter;//All the infrastructure code to, say, write a window manager, is already in these packages provided by Java
import java.awt.event.WindowEvent;

//pressing Ctrl and hovering over expressions helps us get information on the relevant packages, for example.
//when hovering over package names, you can click and navigate to it in External Libraries

public class MyWindow extends Frame {

    public MyWindow(String title) {
        super(title);
        setSize(500, 140);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font sansSerifLarge = new Font("SansSerif", Font.BOLD, 18);
        Font sansSerifSmall = new Font("SansSerif", Font.BOLD, 12);
        g.setFont(sansSerifLarge);
        g.drawString("The Complete Java Developer Course", 60, 60);
        g.setFont(sansSerifSmall);
        g.drawString("by Tim Buchalka", 60, 100);
    }
}
