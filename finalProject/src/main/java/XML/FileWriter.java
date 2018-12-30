package XML;

import Creature.*;
import Field.BattleField;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;

public class FileWriter extends XMLFormat{
    private Document document;
    private Element root;
    private File file;
    public FileWriter(File recordfile) {
        super();
        document = DocumentHelper.createDocument();
        root = document.addElement(title);
        file = recordfile;
    }

    public void initalRecord(BattleField battleField)
    {
        int i = 1;
        for (Creature x:battleField.getAllcreatures()) {
            Element characterElement = root.addElement(character + i);
            i++;
            characterElement.addAttribute(cname, x.getName());
            characterElement.addAttribute(initialpositionX, String.valueOf(x.getX()));
            characterElement.addAttribute(initialpositionY, String.valueOf(x.getY()));
        }   
    }

    public void addRecord(BattleField battleField, int n)
    {
        int i = 1;
        for (Creature x:battleField.getAllcreatures()) {
            Element roundElement = root.element(character + i).addElement(round + n);
            i++;
            roundElement.addAttribute(state, String.valueOf(x.isAlive()));
            roundElement.addAttribute(positionX, String.valueOf(x.getX()));
            roundElement.addAttribute(positionY, String.valueOf(x.getY()));
            if(x.isFighting())
            {
                Element opponentElement = roundElement.addElement(fighting);
                opponentElement.addAttribute(opponent, x.getOpponent().getName());
                opponentElement.addAttribute(opponentPositionX, String.valueOf(x.getOpponent().getX()));
                opponentElement.addAttribute(opponentPositionY, String.valueOf(x.getOpponent().getY()));
            }
        }
        WriteRecord();
    }

    public void WriteRecord() {
        try {
            XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint());
            FileOutputStream fos = new FileOutputStream(file);
            writer.setOutputStream(fos);
            writer.write(document);
            //System.out.println("对战过程保存至“" + file + "”");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
