package com.deft.udemy.solid;

/**
 * @author Sergey Golitsyn
 * created on 12.10.2021
 */
public class InterfaceSegregation {

    /*
    Чтобы ехать на велосипеде надо:
        - крутить педали
        - держать равновесие
        - звонить в звоночек
     */
    interface RideBicycle {
        void pedal();

        void keepBalance();

        void ringTheBell();
    }

    //У крутого трюкового велика нет звоночка
    class StuntBicycle implements RideBicycle {

        @Override
        public void pedal() {
            //что-то делается
        }

        @Override
        public void keepBalance() {
            //что-то делается
        }

        @Override
        public void ringTheBell() {
            //ну нет звоночка...
            throw new RuntimeException("Not implemented");
        }
    }

    //Выделяем базовый функционал
    interface RideBicycleOk {
        void pedal();

        void keepBalance();
    }

    //Правильный вариант:

    //Доп. функции выносит в отдельный интерфейс
    interface RingingBicycle {
        void ringTheBell();
    }
}
