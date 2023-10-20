package Day2_1;

import Day2_2.*;
import org.junit.jupiter.api.*;


public class RockPaperScissorTest {

    private final RockPaperScissor test = new RockPaperScissor();
    private final Hand rock = new Rock();
    private final Hand paper = new Paper();
    private final Hand scissor = new Scissor();

    @Test
    public void compareHandsTest() {
        assert (rock.compareHands(paper) == 0);
        assert (rock.compareHands(rock) == 3);
        assert (rock.compareHands(scissor) == 6);
        assert (paper.compareHands(scissor) == 0);
        assert (paper.compareHands(paper) == 3);
        assert (paper.compareHands(rock) == 6);
        assert (scissor.compareHands(rock) == 0);
        assert (scissor.compareHands(scissor) == 3);
        assert (scissor.compareHands(paper) == 6);

    }

    @Test
    public void readFileToListTest() {
        test.readFileToListInit();
        assert(test.getHandPlayerOne(0).isScissor());
        assert(!test.getHandPlayerOne(0).isRock());
        assert(!test.getHandPlayerOne(0).isPaper());
        assert(test.getHandPlayerOne(1).isRock());
        assert(!test.getHandPlayerOne(1).isPaper());
        assert(!test.getHandPlayerOne(1).isScissor());
        assert(test.getHandPlayerOne(2).isScissor());
        assert(!test.getHandPlayerOne(2).isRock());
        assert(!test.getHandPlayerOne(2).isPaper());
        assert(test.getHandPlayerTwo(0).isRock());
        assert(!test.getHandPlayerTwo(0).isPaper());
        assert(!test.getHandPlayerTwo(0).isScissor());
        assert(test.getHandPlayerTwo(1).isPaper());
        assert(!test.getHandPlayerTwo(1).isRock());
        assert(!test.getHandPlayerTwo(1).isScissor());
        assert(test.getHandPlayerTwo(2).isScissor());
        assert(!test.getHandPlayerTwo(2).isRock());
        assert(!test.getHandPlayerTwo(2).isPaper());


    }

}
