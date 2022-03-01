package com.example.slau;

public class dateSave {
    float iter_x01;
    float iter_x02;
    float iter_x03;
    float seidel_x01;
    float seidel_x02;
    float seidel_x03;

    public dateSave(float iter_x01, float iter_x02, float iter_x03, float seidel_x01, float seidel_x02, float seidel_x03) {
        this.iter_x01 = iter_x01;
        this.iter_x02 = iter_x02;
        this.iter_x03 = iter_x03;
        this.seidel_x01 = seidel_x01;
        this.seidel_x02 = seidel_x02;
        this.seidel_x03 = seidel_x03;
    }

    public float getIter_x01() {
        return iter_x01;
    }

    public void setIter_x01(float iter_x01) {
        this.iter_x01 = iter_x01;
    }

    public float getIter_x02() {
        return iter_x02;
    }

    public void setIter_x02(float iter_x02) {
        this.iter_x02 = iter_x02;
    }

    public float getIter_x03() {
        return iter_x03;
    }

    public void setIter_x03(float iter_x03) {
        this.iter_x03 = iter_x03;
    }

    public float getSeidel_x01() {
        return seidel_x01;
    }

    public void setSeidel_x01(float seidel_x01) {
        this.seidel_x01 = seidel_x01;
    }

    public float getSeidel_x02() {
        return seidel_x02;
    }

    public void setSeidel_x02(float seidel_x02) {
        this.seidel_x02 = seidel_x02;
    }

    public float getSeidel_x03() {
        return seidel_x03;
    }

    public void setSeidel_x03(float seidel_x03) {
        this.seidel_x03 = seidel_x03;
    }
}
