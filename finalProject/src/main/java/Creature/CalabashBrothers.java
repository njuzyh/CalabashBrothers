package Creature;

import Field.BattleField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CalabashBrothers {
    private ArrayList<CalabashBoy> SevenBrothers;
    public CalabashBrothers(int []num, BattleField field)
    {
        SevenBrothers = new ArrayList<CalabashBoy>();
        for(int i = 0; i < num.length; i++)
        {
            SevenBrothers.add(new CalabashBoy(getColor(num[i]), field));
        }
    }
    public CalabashBrothers(int []num)
    {
        SevenBrothers = new ArrayList<CalabashBoy>();
        for(int i = 0; i < num.length; i++)
        {
            SevenBrothers.add(new CalabashBoy(getColor(num[i])));
        }
    }
    public Color getColor(int index)
    {
        switch (index)
        {
            case 1:
                return Color.Red;
            case 2:
                return Color.Orange;
            case 3:
                return Color.Yellow;
            case 4:
                return Color.Green;
            case 5:
                return Color.Cyan;
            case 6:
                return Color.Blue;
            case 7:
                return Color.Purple;
            default:
                return Color.Red;
        }
    }
    /*class SortByOrder implements Comparator {
        public int compare(Object o1, Object o2) {
            CalabashBoy s1 = (CalabashBoy) o1;
            CalabashBoy s2 = (CalabashBoy) o2;
            if (s1.CompareOrder(s2) > 0)
                return 1;
            else if(s1.CompareOrder(s2) == 0)
                return 0;
            else
                return -1;
        }
    }*/
    public void CalabashBoySort()
    {
        Collections.sort(SevenBrothers, (Comparator<CalabashBoy>) (s1, s2) -> {
                if (s1.CompareOrder(s2) > 0) {
                    return 1;
                }
                else if(s1.CompareOrder(s2) == 0)
                    return 0;
                else
                    return -1;
        });
    }
    public void CountOff()
    {
        for(int i = 0; i < 7; i++)
        {
            System.out.println(SevenBrothers.get(i).getName());
        }
    }
    public CalabashBoy getCalabashBoy(int i)
    {
        return SevenBrothers.get(i);
    }
    public void setSevenBrothers(ArrayList<CalabashBoy> brothers)
    {
        SevenBrothers = brothers;
    }
    public ArrayList<CalabashBoy> getSevenBrothers()
    {
        return SevenBrothers;
    }
    public boolean isAllDead()
    {
        for(CalabashBoy x:SevenBrothers)
        {
            if(x.isAlive())
                return false;
        }
        return true;
    }
    /*public void BubbleSort()
    {
        for(int i = 0; i < SevenBrothers.length - 1; i++)
        {
            for(int j = i + 1; j < SevenBrothers.length; j++)
            {
                if(SevenBrothers[i].CompareOrder(SevenBrothers[j]) > 0)
                {
                    System.out.println(SevenBrothers[i].getName() + "：" + SevenBrothers[i].getOrder() + " -> " + SevenBrothers[j].getOrder());
                    CalabashBoy temp = SevenBrothers[j];
                    SevenBrothers[j] = SevenBrothers[i];
                    SevenBrothers[i] = temp;
                }
            }
        }
    }
    private void QuickSort(int left,int right)
    {
        int i, j;
        if(left > right)
            return;
        CalabashBoy temp = SevenBrothers[left]; //temp中存的就是基准数
        i = left;
        j = right;
        while(i != j)
        {
            //顺序很重要，要先从右边开始找
            while(SevenBrothers[j].CompareColor(temp) >= 0  && i < j)
                j--;
            //再找右边的
            while(SevenBrothers[i].CompareColor(temp) <= 0  && i < j)
                i++;
            //交换两个数在数组中的位置
            if(i < j)
            {
                System.out.println(SevenBrothers[i].getName() + "：" + SevenBrothers[i].getOrder() + " -> " + SevenBrothers[j].getOrder());
                CalabashBoy tmp = SevenBrothers[j];
                SevenBrothers[j] = SevenBrothers[i];
                SevenBrothers[i] = tmp;
            }
        }
        //最终将基准数归位
        SevenBrothers[left] = SevenBrothers[i];
        SevenBrothers[i] = temp;

        QuickSort(left,i-1);//继续处理左边的，这里是一个递归的过程
        QuickSort(i + 1,right);//继续处理右边的 ，这里是一个递归的过程
    }
    public static void main(String []args)
    {
        int []array = {7, 6, 5, 1, 2, 4, 3};
        Creature.CalabashBrothers Brothers = new Creature.CalabashBrothers(array);
        Brothers.BubbleSort();
        Brothers.CountOff();
        int []newarray = {7, 6, 5, 1, 2, 4, 3};
        Creature.CalabashBrothers NewBrothers = new Creature.CalabashBrothers(newarray);
        NewBrothers.QuickSort(0, 6);
        NewBrothers.ColorOff();
    }*/
}
