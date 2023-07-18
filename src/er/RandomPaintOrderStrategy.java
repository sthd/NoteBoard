package er;


import java.util.*;
import java.util.stream.*;
/**
 * A Strategy that update the BillaBoard by random order for ColorGenerator strategy design pattern
 *
 */
public class RandomPaintOrderStrategy implements PanelPaintOrderStrategy{

    /*
     * Abstraction function
     * RandomPaintOrderStrategy is
     * this is part of Strategy ColorGenerate design pattern
     * which will random element of the billaboard
     * randomIntArray is the the order of
     * all the indexes of the billboard in shuffeled order
     * and detemines the random order of the next element
     * it the location in randomIntarray
     */

    /*
     * Rep invariant:
     * randomIntsArray Size is 36, each element is unique (no duplicates)
     * and it>=0 and it <36
     * randomIntsArray includes only ints
     *
     */
    private List<Integer> randomIntsArray = IntStream.range(0, 36).boxed().collect(Collectors.toList());;
    int it=0;

    /**
     * @modifies this
     * @effects will return the next random index
     */
    @Override
    public int getNextPanel() {
        checkRep();
        if(0 == it) {
//			randomIntsArray =  IntStream.range(0, 36).boxed().collect(Collectors.toList());
            Collections.shuffle(randomIntsArray);
        }

        int next =  randomIntsArray.get(it);
        it = (it+1)%(randomIntsArray.size());
        checkRep();
        return next;
    }

    private void checkRep() {
        Set<Integer> set = new HashSet<>(randomIntsArray);
        assert set.size()==36;
        assert it>=0 && it<36;
    }
}



