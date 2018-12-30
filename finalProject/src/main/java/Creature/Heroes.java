package Creature;

import Field.BattleField;
import Field.BattleMap;
import Formation.*;

import java.util.ArrayList;
import java.util.Random;

public class Heroes implements Queueup{
    private CalabashBrothers SevenBrothers;
    private Grandpa grandpa;
    private int num;
    private Random rand = new Random();
    private int arr[] = {1, 2, 3, 4, 5, 6, 7};
    private BattleField field;
    public Heroes(BattleField field)
    {
        num = 8;
        this.field = field;
        RamdonQueue();
        grandpa = new Grandpa(10, 0, field);
    }
    public ArrayList<CalabashBoy> getCalabashBrothers() {
        return SevenBrothers.getSevenBrothers();
    }
    public CalabashBoy getCalabashBoy(int i)
    {
        if(i >= 0 && i <= 6)
            return SevenBrothers.getCalabashBoy(i);
        else
            return null;
    }
    public Grandpa getGrandfather() {
        return grandpa;
    }
    public void swap(int[]a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void shuffle(int[] arr) {
        int length = arr.length;
        for (int i = length; i > 0; i--) {
            int randInd = rand.nextInt(i);
            swap(arr, randInd, i - 1);
        }
    }
    public void RamdonQueue()
    {
        shuffle(arr);
        SevenBrothers = new CalabashBrothers(arr, field);
    }
    public void setFormation(Formation formation)
    {
        ArrayList<CalabashBoy> tempbrothers = SevenBrothers.getSevenBrothers();
        formation.showFormation(tempbrothers, 0);
        SevenBrothers.setSevenBrothers(tempbrothers);
    }
    public void show(BattleMap space)
    {
        if(grandpa.isAlive())
            space.setBattleCreature(grandpa.getX(), grandpa.getY(), grandpa);
        for(int i = 0; i < 7; i++)
        {
            CalabashBoy temp = SevenBrothers.getCalabashBoy(i);
            if(temp.isAlive())
                space.setBattleCreature(temp.getX(), temp.getY(), temp);
        }
    }
    public boolean isAllDead()
    {
        return SevenBrothers.isAllDead() && !grandpa.isAlive();
    }
}
