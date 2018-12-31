package XML;

import Creature.Creature;
import Field.BattleField;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileReader extends XMLFormat{
    private Document document;
    private Element root;
    public FileReader(File file) throws DocumentException {
        SAXReader reader = new SAXReader();
        document = reader.read(file);
        System.out.println("读取对战过程自“" + file + "”");
        // 获取根元素
        root = document.getRootElement();
    }

    public void initCreature(BattleField battleField)
    {
        List<?> characterList = root.elements();
        for (Object x:characterList) {
            Element character = (Element)x;
            String name = character.attributeValue(cname);
            for (Creature y:battleField.getAllcreatures()) {
                if(name.equals(y.getName()))
                {
                    int X = Integer.parseInt(character.attributeValue(initialpositionX));
                    int Y = Integer.parseInt(character.attributeValue(initialpositionY));
                    y.setPosition(X, Y);
                    y.setAlive(true);
                }
            }
        }
    }

    public int getRoundNum()
    {
        List<Element> roundElements = root.element(character + 1).elements();
        return roundElements.size();
    }

    public void setCharacter(Creature x, int order, int roundNum, BattleField battleField) {
        if(x.isAlive())
        {
            Element roundElement = root.element(character + order).element(round + roundNum);
            if(roundElement != null)
            {
                int X = Integer.parseInt(roundElement.attributeValue(positionX));
                int Y = Integer.parseInt(roundElement.attributeValue(positionY));
                boolean alive = roundElement.attributeValue(state).equals("true");
                //System.out.println(X + " " + Y + " " + alive);
                x.setPosition(X, Y);
                x.setAlive(alive);
                Element fightingElement = roundElement.element(fighting);
                if(fightingElement != null) {
                    if (!alive) {
                        x.die();
                        //battleField.clearUnit(x);
                    }
                }
            }
        }
    }
}
