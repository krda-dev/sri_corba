package com.company;

import arytmetykaPackage.DzieleniePrzezZero;

public class ArytmetykaServant extends _arytmetykaImplBase  {

    private double s1;
    private double s2;
    private double wynik;

    @Override
    public double s1() {
        return this.s1;
    }

    @Override
    public void s1(double newS1) {
        this.s1 = newS1;
    }

    @Override
    public double s2() {
        return this.s2;
    }

    @Override
    public void s2(double newS2) {
        this.s2 = newS2;
    }

    @Override
    public double wynik() {
        return this.wynik;
    }

    @Override
    public void wynik(double newWynik) {
        this.wynik = newWynik;
    }

    @Override
    public void Suma() {
        this.wynik = this.s1 + this.s2;
    }

    @Override
    public void Roznica() {
        this.wynik = this.s1 - this.s2;
    }

    @Override
    public void Iloczyn() {
        this.wynik = this.s1 * this.s2;
    }

    @Override
    public void Iloraz() throws arytmetykaPackage.DzieleniePrzezZero {
        if(this.s2 == 0) {
            throw new DzieleniePrzezZero();
        }
        this.wynik = this.s1 / this.s2;
    }
}
