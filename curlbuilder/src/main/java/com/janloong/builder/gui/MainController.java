package com.janloong.builder.gui;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import javafx.animation.Transition;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import javax.annotation.PostConstruct;

/**
 * @author Janloong
 * @create 2017-12-14 11:48
 **/
public class MainController {

    public JFXHamburger titleBurger;
    public StackPane titleBurgerContainer;
    public JFXDrawer drawer;


    @PostConstruct
    public void init(){
        drawer.setOnDrawerOpening(e->{
            System.out.println("打开了啊");
           final Transition animation = titleBurger.getAnimation();
            animation.setRate(1);
            animation.play();

        });
    }

    public void caa(MouseEvent mouseEvent) {

    }
}
