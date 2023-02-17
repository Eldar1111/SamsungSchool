package com.example.adaptertest.model;

import java.util.ArrayList;

public class Person {

        private int id;
        private String name;
        private int flag_res; // имя ресурса флага
        private String money; // состояние в строковом формате

        public Person(String name, String money, int flag_res) {
                this.flag_res = flag_res;
                this.money = money;
                this.name = name;
        }

        public int getId() {return id;}

        public String getName() {
                return name;
        }

        public int getFlag_res() {
                return flag_res;
        }

        public String getMoney() {
                return money;
        }

        public void setId(int id){this.id = id;}

        public void setName(String name) {
                this.name = name;
        }

        public void setFlag_res(int flag_res) {
                this.flag_res = flag_res;
        }

        public void setMoney(String money) {
                this.money = money;
        }
}
