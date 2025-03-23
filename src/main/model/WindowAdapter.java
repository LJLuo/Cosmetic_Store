package model;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

// Represents a window adapter for StoreGUI main frame
public abstract class WindowAdapter extends Object implements WindowListener, WindowStateListener, WindowFocusListener {

    public WindowAdapter() {

    }

    // Invoked when window is activated
    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    // Invoked when window is closed
    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    // Invoked when window is in the process of bring closed
    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    // Invoked when window is de-activated
    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    // Invoked when window is de-iconified
    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    // Invoked when window is iconified
    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    // Invoked when window is opened
    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    // Invoked when window state is changed
    @Override
    public void windowStateChanged(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    // Invoked when window is set to be the focused window
    @Override
    public void windowGainedFocus(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    // Invoked when window is no longer the focused window
    @Override
    public void windowLostFocus(WindowEvent e) {
        // TODO Auto-generated method stub

    }

}
