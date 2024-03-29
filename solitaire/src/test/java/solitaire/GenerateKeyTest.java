package solitaire;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GenerateKeyTest
{
    private int jokerA = 53;
    private int jokerB = 54;

    @Test
    public void emptyMessageShouldGenerateNoKey()
    {
        String message = "";
        int[] deckOfCards = new int[54];
        Key generateKey = new Key(deckOfCards);

        String expectedGeneratedKey = "";
        String actualGeneratedKey = generateKey.mGenerate(message);

        assertEquals(expectedGeneratedKey, actualGeneratedKey);
    }

    @Test
    public void generateKeyFunctionShouldHaveDeckOf54Cards()
    {
        int[] deckOfCards = new int[54];
        Key generateKey = new Key(deckOfCards);

        int[] expectedDeckOfCards = new int[54];
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void generatedDeckOfCardsShouldBeConveretedToNumbers()
    {
        int[] deckOfCards = mCreateDeckOfCards();
        Key generateKey = new Key(deckOfCards);

        int[] expectedDeckOfCards = deckOfCards;
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void moveJokerAoneCardDownCaseWhereJokerAisAtTheBottom()
    {
        int[] deckOfCards = new int[54]; 
        deckOfCards[53] = 1;
        deckOfCards[52] = 2;
        deckOfCards[51] = 3;
        deckOfCards[2] = 52;
        deckOfCards[1] = jokerB;
        deckOfCards[0] = jokerA;
        Key generateKey = new Key(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[53] = jokerA;
        newDeckOfCards[52] = 1;
        newDeckOfCards[51] = 2;
        newDeckOfCards[50] = 3;
        newDeckOfCards[1] = 52;
        newDeckOfCards[0] = jokerB;

        int[] expectedDeckOfCards = newDeckOfCards;
        generateKey.mMoveJokerA();
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void moveJokerAoneCardDownCaseWhereJokerAisNotAtTheBottom()
    {
        int[] deckOfCards = new int[54]; 
        deckOfCards[53] = 1;
        deckOfCards[52] = 2;
        deckOfCards[51] = 3;
        deckOfCards[2] = 52;
        deckOfCards[1] = jokerA;
        deckOfCards[0] = jokerB;
        Key generateKey = new Key(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[53] = 1;
        newDeckOfCards[52] = 2;
        newDeckOfCards[51] = 3;
        newDeckOfCards[2] = 52;
        newDeckOfCards[1] = jokerB;
        newDeckOfCards[0] = jokerA;

        int[] expectedDeckOfCards = newDeckOfCards;
        generateKey.mMoveJokerA();
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void moveJokerBtwoCardsDownCaseWhereJokerIsInBottomPositions()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[53] = 1;
        deckOfCards[52] = 2;
        deckOfCards[51] = 3;
        deckOfCards[2] = 52;
        deckOfCards[1] = jokerB;
        deckOfCards[0] = jokerA;
        Key generateKey = new Key(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[53] = 1;
        newDeckOfCards[52] = jokerB;
        newDeckOfCards[51] = 2;
        newDeckOfCards[50] = 3;
        newDeckOfCards[1] = 52;
        newDeckOfCards[0] = jokerA;

        int[] expectedDeckOfCards = newDeckOfCards;
        generateKey.mMoveJokerB();
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }
    

    @Test
    public void moveJokerBtwoCardsDownCaseWhereJokerIsNotInBottomPositions()
    {
        int jokerB = 54;
        int[] deckOfCards = new int[54];
        deckOfCards[53] = 1;
        deckOfCards[52] = 2;
        deckOfCards[5] = 49;
        deckOfCards[4] = jokerB;
        deckOfCards[3] = 50;
        deckOfCards[2] = 51;
        deckOfCards[1] = 52;
        deckOfCards[0] = jokerA;
        Key generateKey = new Key(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[53] = 1;
        newDeckOfCards[52] = 2;
        newDeckOfCards[5] = 49;
        newDeckOfCards[4] = 50;
        newDeckOfCards[3] = 51;
        newDeckOfCards[2] = 52;
        newDeckOfCards[1] = jokerB;
        newDeckOfCards[0] = jokerA;

        int[] expectedDeckOfCards = newDeckOfCards;
        generateKey.mMoveJokerB();
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void trippleCutCaseWhenJokerAisLower()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[53] = 1;
        deckOfCards[52] = jokerB;
        deckOfCards[51] = 2;
        deckOfCards[50] = 3;
        deckOfCards[1] = 52;
        deckOfCards[0] = jokerA;
        Key generateKey = new Key(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[53] = jokerB;
        newDeckOfCards[52] = 2;
        newDeckOfCards[51] = 3;
        newDeckOfCards[2] = 52;
        newDeckOfCards[1] = jokerA;
        newDeckOfCards[0] = 1;

        int[] expectedDeckOfCards = newDeckOfCards;
        generateKey.mTrippleCut();
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void trippleCutCaseWhenJokerBisLower()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[53] = 1;
        deckOfCards[52] = jokerA;
        deckOfCards[51] = 2;
        deckOfCards[50] = 3;
        deckOfCards[1] = 52;
        deckOfCards[0] = jokerB;
        Key generateKey = new Key(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[53] = jokerA;
        newDeckOfCards[52] = 2;
        newDeckOfCards[51] = 3;
        newDeckOfCards[2] = 52;
        newDeckOfCards[1] = jokerB;
        newDeckOfCards[0] = 1;

        int[] expectedDeckOfCards = newDeckOfCards;
        generateKey.mTrippleCut();
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void trippleCutCaseWhenJokerBandJokerAareBetween()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[53] = 2;
        deckOfCards[52] = 4;
        deckOfCards[51] = 6;
        deckOfCards[50] = jokerB;
        deckOfCards[49] = 5;
        deckOfCards[48] = 8;
        deckOfCards[4] = 7;
        deckOfCards[3] = 1;
        deckOfCards[2] = jokerA;
        deckOfCards[1] = 3;
        deckOfCards[0] = 9;

        Key generateKey = new Key(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[53] = 3;
        newDeckOfCards[52] = 9;
        newDeckOfCards[51] = jokerB;
        newDeckOfCards[50] = 5;
        newDeckOfCards[49] = 8;
        newDeckOfCards[5] = 7;
        newDeckOfCards[4] = 1;
        newDeckOfCards[3] = jokerA;
        newDeckOfCards[2] = 2;
        newDeckOfCards[1] = 4;
        newDeckOfCards[0] = 6;

        int[] expectedDeckOfCards = newDeckOfCards;
        generateKey.mTrippleCut();
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void countCutWhenBottomCardIsOne()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[53] = jokerB;
        deckOfCards[52] = 2;
        deckOfCards[51] = 3;
        deckOfCards[50] = 4;
        deckOfCards[2] = 52;
        deckOfCards[1] = jokerA;
        deckOfCards[0] = 1;
        Key generateKey = new Key(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[53] = 2;
        newDeckOfCards[52] = 3;
        newDeckOfCards[51] = 4;
        newDeckOfCards[3] = 52;
        newDeckOfCards[2] = jokerA;
        newDeckOfCards[1] = jokerB;
        newDeckOfCards[0] = 1;

        int[] expectedDeckOfCards = newDeckOfCards;
        generateKey.mCountCut();
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    
    public void countCutWhenBottomCardIsNine()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[53] = 7;
        deckOfCards[50] = 2;
        deckOfCards[45] = 4;
        deckOfCards[44] = 5;
        deckOfCards[43] = 14;
        deckOfCards[2] = 6;
        deckOfCards[1] = 8;
        deckOfCards[0] = 9;
        Key generateKey = new Key(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[53] = 5;
        newDeckOfCards[52] = 14;
        newDeckOfCards[11] = 6;
        newDeckOfCards[10] = 8;
        newDeckOfCards[9] = 7;
        newDeckOfCards[6] = 2;
        newDeckOfCards[1] = 4;
        newDeckOfCards[0] = 9;

        int[] expectedDeckOfCards = newDeckOfCards;
        generateKey.mCountCut();
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void countOffCardsFromTopBasingOnTopCardToGetValueOfFinalCard()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[53] = 2;
        deckOfCards[52] = 3;
        deckOfCards[51] = 4;
        deckOfCards[3] = 52;
        deckOfCards[2] = jokerA;
        deckOfCards[1] = jokerB;
        deckOfCards[0] = 1;
        Key generateKey = new Key(deckOfCards);

        int expectedCardValue = 4;
        generateKey.mOutPutCardInNumbers();
        int actualCardValue = generateKey.cardToConvert;

        assertEquals(expectedCardValue, actualCardValue);
    }

    @Test
    public void numberShouldReturnAstringValue()
    {
        int[] deckOfCards = new int[54];
        Key generateKey = new Key(deckOfCards);

        String expectedValue = "A";
        generateKey.cardValue();
        String actualValue = generateKey.cardValue();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void generateKeyShouldReturnKeyWhenMessagePassed()
    {
        int[] deckOfCards = mCreateDeckOfCards();
        Key generateKey = new Key(deckOfCards);
        String message = "a";

        String expectedKeyGenerated = "D";
        String actualKeyGenereated = generateKey.mGenerate(message);

        assertEquals(expectedKeyGenerated, actualKeyGenereated);
    }

    private int[] mCreateDeckOfCards() 
    {
        int[] deck = new int[54];
        int j = 54;
        for (int i = 0; i < deck.length; i++) 
        {
            deck[i] = j;
            j--;
        }
        return deck;
    }
}