package com.lweyn.sparkreader.ui;

import com.lweyn.sparkreader.Main;
import com.lweyn.sparkreader.Utils;
import com.lweyn.sparkreader.hooker.WindowHook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/**
 * Created by wareya on 2017/06/19.
 */
public class WindowHookUI
{
    public static void display()
    {
        JFrame frame = new JFrame("Select window");
        JPanel mainPanel = new JPanel();
        
        frame.setContentPane(mainPanel);
        mainPanel.setSize(500, 35);
        mainPanel.setPreferredSize(new Dimension(500, 35));
        frame.pack();
        
        JComboBox list = new JComboBox<>(WindowHook.hook.getAvailableWindows());
        
        JButton select = new JButton();
        select.setText("Select");
        select.addActionListener((ActionEvent e) ->
        {
            WindowHook.hook.setName((String)list.getSelectedItem());
            UI.stickToWindow = WindowHook.hook.getCoord();
            JMenuItem hookUIItem = (JMenuItem) Main.ui.menubar.getMenuItem("Connect", "Stick").getComponent();
            hookUIItem.setText("Stop sticking to window");//rename option
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        });
        list.setPreferredSize(new Dimension(380, 25));
        list.setSize(new Dimension(380, 25));
        select.setPreferredSize(new Dimension(90, 25));
        select.setSize(new Dimension(90, 25));
        
        mainPanel.add(list);
        mainPanel.add(select);

        Utils.centerWindow(frame);
        frame.setVisible(true);
    }
}