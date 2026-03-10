package org.atyeti.java.scenarioBasedQuestion.collection;

import java.util.ArrayList;
import java.util.List;

public class AlphabetNum {
    List<Character> characters = new ArrayList<>();
    private boolean printCharacter=true;
public AlphabetNum() {
    for (char character = 'A'; character <= 'Z'; character++) {
        characters.add(character);
    }
}
    public synchronized void printAlphabet() throws InterruptedException {

for (char c:characters)
{
    while(!printCharacter) {
        wait();
    }
    System.out.print(c);
    printCharacter=false;
    notify();
        }

    }


    public synchronized  void printNumbers() throws InterruptedException
    {
        for(int i=1;i<=26;i++)
        {
            while(printCharacter) {
                wait();
            }


            System.out.print(i);

            printCharacter=true;
            notify();
        }
    }
}
